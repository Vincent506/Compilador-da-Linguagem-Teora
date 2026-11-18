/*
 * analisador_semantico.hpp — Percorre a árvore do ANTLR (Visitor), preenche a
 * tabela de símbolos e verifica regras semânticas da Teora.
 *
 * Cada visitor de EXPRESSÃO devolve o Tipo da expressão (std::any contendo
 * Tipo). Os de comando devolvem nada de útil. Tipo::ERRO é "contagioso": uma
 * expressão que já deu erro não gera erros em cascata ao redor dela.
 */
#pragma once

#include <algorithm>
#include <any>
#include <set>
#include <string>
#include <unordered_set>
#include <vector>

#include "TeoraBaseVisitor.h"
#include "TeoraParser.h"
#include "antlr4-runtime.h"
#include "tabela_simbolos.hpp"

struct Diagnostico {
  enum class Nivel { ERRO, AVISO } nivel;
  std::string mensagem;
  size_t linha, coluna;
};

class AnalisadorSemantico : public TeoraBaseVisitor {
 public:
  void analisar(TeoraParser::ProgramaContext* raiz) {
    visitPrograma(raiz);
    avisarNaoUsados();  // escopo global
    std::stable_sort(diag_.begin(), diag_.end(),
                     [](const Diagnostico& a, const Diagnostico& b) {
                       return a.linha != b.linha ? a.linha < b.linha
                                                 : a.coluna < b.coluna;
                     });
  }

  const TabelaSimbolos& tabela() const { return tabela_; }
  const std::vector<Diagnostico>& diagnosticos() const { return diag_; }
  size_t numErros() const {
    return static_cast<size_t>(std::count_if(
        diag_.begin(), diag_.end(), [](const Diagnostico& d) {
          return d.nivel == Diagnostico::Nivel::ERRO;
        }));
  }

  // ------------------------------------------------------------------
  // Estrutura do programa
  // ------------------------------------------------------------------

  std::any visitPrograma(TeoraParser::ProgramaContext* ctx) override {
    // 1ª passada: declara todas as funções (permite usá-las antes da definição)
    for (auto* f : ctx->funcao()) declararFuncao(f);
    // 2ª passada: analisa tudo na ordem do arquivo
    return visitChildren(ctx);
  }

  std::any visitBlocoStart(TeoraParser::BlocoStartContext* ctx) override {
    std::string nome = "start";
    if (ctx->MAIN()) {
      nome = "start main";
      if (mainVisto_) erro(ctx, "'start main()' já foi definido");
      mainVisto_ = true;
    }
    visitarBloco(ctx->listaComandos(), nome);
    return {};
  }

  std::any visitFuncao(TeoraParser::FuncaoContext* ctx) override {
    const std::string nome = ctx->ID()->getText();
    tabela_.entrarEscopo("funcao " + nome);
    if (ctx->parametros()) {
      for (auto* p : ctx->parametros()->parametro()) {
        Tipo t = tipoDe(p->tipo());
        if (t == Tipo::VOID) {
          erro(p, "parametro '" + p->ID()->getText() + "' nao pode ser void");
          t = Tipo::ERRO;
        }
        Simbolo s;
        s.nome = p->ID()->getText();
        s.tipo = t;
        s.categoria = Categoria::PARAMETRO;
        s.inicializado = true;
        s.usado = true;  // parâmetro não usado não gera aviso
        preencherPos(s, p->ID());
        if (!tabela_.declarar(s))
          erro(p->ID(), "parametro '" + s.nome + "' duplicado");
      }
    }
    if (ctx->listaComandos()) visit(ctx->listaComandos());
    sairEscopo();
    return {};
  }

  // ------------------------------------------------------------------
  // Comandos
  // ------------------------------------------------------------------

  std::any visitDeclaracao(TeoraParser::DeclaracaoContext* ctx) override {
    Simbolo s;
    s.nome = ctx->ID()->getText();
    preencherPos(s, ctx->ID());

    if (ctx->ARRAY()) {
      s.tipo = Tipo::ARRAY;
    } else {
      s.tipo = tipoDe(ctx->tipo());
      if (ctx->expressao()) {
        // o inicializador é analisado ANTES de declarar: "int x = x + 1;" dá erro
        Tipo origem = tipoExpr(ctx->expressao());
        if (s.tipo != Tipo::VOID) verificarAtribuicao(s.tipo, origem, ctx->expressao());
        s.inicializado = true;
      }
      if (s.tipo == Tipo::VOID) {
        erro(ctx->ID(), "variavel '" + s.nome + "' nao pode ser do tipo void");
        s.tipo = Tipo::ERRO;
      }
    }

    if (!tabela_.declarar(s)) {
      Simbolo* anterior = tabela_.buscarLocal(s.nome);
      erro(ctx->ID(), "'" + s.nome + "' ja foi declarado neste escopo (L" +
                          std::to_string(anterior->linha) + ":C" +
                          std::to_string(anterior->coluna) + ")");
    }
    return {};
  }

  std::any visitAtribuicao(TeoraParser::AtribuicaoContext* ctx) override {
    Tipo rhs = tipoExpr(ctx->expressao());  // lado direito primeiro
    Simbolo* s = buscarVariavel(ctx->ID());
    if (!s) return {};

    if (ctx->ATRIB()) {
      verificarAtribuicao(s->tipo, rhs, ctx->expressao());
    } else {
      const bool soma = ctx->ATRIB_SUM() != nullptr;
      const std::string op = soma ? "+=" : "-=";
      s->usado = true;  // "x += 1" também lê x
      if (s->tipo != Tipo::ERRO && rhs != Tipo::ERRO) {
        const bool concatena = soma && s->tipo == Tipo::STRING &&
                               (rhs == Tipo::STRING || rhs == Tipo::CHAR);
        if (!concatena && !(numerico(s->tipo) && numerico(rhs)))
          erro(ctx, "operador '" + op + "' nao se aplica a '" +
                        nomeTipo(s->tipo) + "' e '" + nomeTipo(rhs) + "'");
        else if (!concatena)
          verificarAtribuicao(s->tipo, promover(s->tipo, rhs), ctx->expressao());
      }
    }
    s->inicializado = true;
    return {};
  }

  std::any visitComandoIf(TeoraParser::ComandoIfContext* ctx) override {
    exigirBool(ctx->expressao(), "if");
    for (auto* lc : ctx->listaComandos()) {
      const bool ehElse =
          ctx->ELSE() && lc->getStart()->getTokenIndex() >
                             ctx->ELSE()->getSymbol()->getTokenIndex();
      visitarBloco(lc, ehElse ? "else" : "if");
    }
    return {};
  }

  std::any visitComandoWhile(TeoraParser::ComandoWhileContext* ctx) override {
    if (ctx->DO()) {  // do { ... } while (cond);
      visitarBloco(ctx->listaComandos(), "do-while");
      exigirBool(ctx->expressao(), "do-while");
    } else {          // while (cond) { ... }
      exigirBool(ctx->expressao(), "while");
      visitarBloco(ctx->listaComandos(), "while");
    }
    return {};
  }

  std::any visitComandoFor(TeoraParser::ComandoForContext* ctx) override {
    tabela_.entrarEscopo("for");  // a variável do cabeçalho vive só dentro do for
    if (ctx->declaracao()) visit(ctx->declaracao());
    if (ctx->atribuicao()) visit(ctx->atribuicao());
    exigirBool(ctx->expressao(), "for");
    visit(ctx->incremento());
    visitarBloco(ctx->listaComandos(), "corpo do for");
    sairEscopo();
    return {};
  }

  std::any visitIncremento(TeoraParser::IncrementoContext* ctx) override {
    Simbolo* s = buscarVariavel(ctx->ID());
    if (!s) return {};
    s->usado = true;
    if (s->tipo != Tipo::ERRO && !numerico(s->tipo))
      erro(ctx->ID(), std::string("'") + (ctx->INCREMENT() ? "++" : "--") +
                          "' exige tipo numerico, mas '" + s->nome + "' e '" +
                          nomeTipo(s->tipo) + "'");
    return {};
  }

  std::any visitComandoSwitch(TeoraParser::ComandoSwitchContext* ctx) override {
    Simbolo* s = buscarVariavel(ctx->ID());
    Tipo tSwitch = Tipo::ERRO;
    if (s) {
      s->usado = true;
      tSwitch = s->tipo;
      if (tSwitch != Tipo::ERRO && tSwitch != Tipo::INT && tSwitch != Tipo::CHAR)
        erro(ctx->ID(), "switch exige int ou char, mas '" + s->nome + "' e '" +
                            nomeTipo(tSwitch) + "'");
    }

    std::set<std::string> vistos;
    for (auto* caso : ctx->casoBloco()) {
      std::string rotulo;
      if (caso->NUM()) {
        rotulo = caso->NUM()->getText();
        if (!vistos.insert(rotulo).second)
          erro(caso->NUM(), "valor '" + rotulo + "' duplicado no switch");
      } else if (caso->ID()) {
        rotulo = caso->ID()->getText();
        Simbolo* c = buscarVariavel(caso->ID());
        if (c) {
          c->usado = true;
          if (c->tipo != Tipo::ERRO && c->tipo != Tipo::INT && c->tipo != Tipo::CHAR)
            erro(caso->ID(), "rotulo de case deve ser int ou char");
        }
      }
      visitarBloco(caso->listaComandos(), "case " + rotulo);
    }
    if (ctx->defaultBloco())
      visitarBloco(ctx->defaultBloco()->listaComandos(), "default");
    return {};
  }

  std::any visitComandoTryCatch(TeoraParser::ComandoTryCatchContext* ctx) override {
    const size_t idxCatch = ctx->CATCH()->getSymbol()->getTokenIndex();
    for (auto* lc : ctx->listaComandos()) {
      if (lc->getStart()->getTokenIndex() < idxCatch) visitarBloco(lc, "try");
    }

    tabela_.entrarEscopo("catch");
    Simbolo e;
    e.nome = ctx->ID()->getText();
    e.tipo = Tipo::EXCECAO;
    e.categoria = Categoria::CAPTURA;
    e.inicializado = true;
    e.usado = true;
    preencherPos(e, ctx->ID());
    tabela_.declarar(e);
    for (auto* lc : ctx->listaComandos()) {
      if (lc->getStart()->getTokenIndex() > idxCatch) visit(lc);
    }
    sairEscopo();
    return {};
  }

  std::any visitComandoIO(TeoraParser::ComandoIOContext* ctx) override {
    if (ctx->OUTPUT()) {
      Tipo t = tipoExpr(ctx->expressao());
      if (t == Tipo::VOID) erro(ctx->expressao(), "output nao aceita expressao void");
    } else {  // input(ID)
      Simbolo* s = buscarVariavel(ctx->ID());
      if (s) {
        s->inicializado = true;
        if (s->tipo == Tipo::ARRAY || s->tipo == Tipo::EXCECAO)
          erro(ctx->ID(), "input nao pode ler para '" + s->nome + "'");
      }
    }
    return {};
  }

  // ------------------------------------------------------------------
  // Expressões: cada uma devolve o seu Tipo
  // ------------------------------------------------------------------

  std::any visitParExpr(TeoraParser::ParExprContext* ctx) override {
    return tipoExpr(ctx->expressao());
  }

  std::any visitIdExpr(TeoraParser::IdExprContext* ctx) override {
    Simbolo* s = buscarVariavel(ctx->ID());
    if (!s) return Tipo::ERRO;
    s->usado = true;
    return s->tipo;
  }

  std::any visitIncDecExpr(TeoraParser::IncDecExprContext* ctx) override {
    Simbolo* s = buscarVariavel(ctx->ID());
    if (!s) return Tipo::ERRO;
    s->usado = true;
    if (s->tipo != Tipo::ERRO && !numerico(s->tipo)) {
      erro(ctx->ID(), std::string("'") + (ctx->INCREMENT() ? "++" : "--") +
                          "' exige tipo numerico, mas '" + s->nome + "' e '" +
                          nomeTipo(s->tipo) + "'");
      return Tipo::ERRO;
    }
    return s->tipo;
  }

  std::any visitNumExpr(TeoraParser::NumExprContext*) override { return Tipo::INT; }
  std::any visitRealExpr(TeoraParser::RealExprContext*) override { return Tipo::DOUBLE; }
  std::any visitTrueExpr(TeoraParser::TrueExprContext*) override { return Tipo::BOOL; }
  std::any visitFalseExpr(TeoraParser::FalseExprContext*) override { return Tipo::BOOL; }

  std::any visitStringExpr(TeoraParser::StringExprContext* ctx) override {
    // 'a' (1 caractere) é char; qualquer outro tamanho é string.
    const std::string txt = ctx->STRING_LITERAL()->getText();  // inclui as aspas
    return txt.size() == 3 ? Tipo::CHAR : Tipo::STRING;
  }

  std::any visitMulExpr(TeoraParser::MulExprContext* ctx) override {
    Tipo l = tipoExpr(ctx->expressao(0));
    Tipo r = tipoExpr(ctx->expressao(1));
    const std::string op = ctx->children[1]->getText();

    if ((ctx->OP_DIV() || ctx->OP_MOD()) && ctx->expressao(1)->getText() == "0")
      erro(ctx->expressao(1), "divisao por zero");
    if (l == Tipo::ERRO || r == Tipo::ERRO) return Tipo::ERRO;

    if (ctx->OP_MOD()) {
      if (l == Tipo::INT && r == Tipo::INT) return Tipo::INT;
    } else if (numerico(l) && numerico(r)) {
      return promover(l, r);
    }
    erroOperador(ctx, op, l, r);
    return Tipo::ERRO;
  }

  std::any visitAddExpr(TeoraParser::AddExprContext* ctx) override {
    Tipo l = tipoExpr(ctx->expressao(0));
    Tipo r = tipoExpr(ctx->expressao(1));
    const std::string op = ctx->children[1]->getText();
    if (l == Tipo::ERRO || r == Tipo::ERRO) return Tipo::ERRO;

    if (numerico(l) && numerico(r)) return promover(l, r);
    if (ctx->OP_SUM() && (l == Tipo::STRING || r == Tipo::STRING) &&
        (l == Tipo::STRING || l == Tipo::CHAR) &&
        (r == Tipo::STRING || r == Tipo::CHAR))
      return Tipo::STRING;  // concatenação
    erroOperador(ctx, op, l, r);
    return Tipo::ERRO;
  }

  std::any visitRelExpr(TeoraParser::RelExprContext* ctx) override {
    Tipo l = tipoExpr(ctx->expressao(0));
    Tipo r = tipoExpr(ctx->expressao(1));
    const std::string op = ctx->children[1]->getText();
    if (l == Tipo::ERRO || r == Tipo::ERRO) return Tipo::BOOL;

    const bool igualdade = ctx->OP_EQ() || ctx->OP_NE();
    bool ok;
    if (igualdade)
      ok = atribuivel(l, r) || atribuivel(r, l);
    else
      ok = (numerico(l) || l == Tipo::CHAR) && (numerico(r) || r == Tipo::CHAR);
    if (!ok)
      erro(ctx, "nao e possivel comparar '" + std::string(nomeTipo(l)) +
                    "' com '" + nomeTipo(r) + "' usando '" + op + "'");
    return Tipo::BOOL;  // o resultado de uma comparação é sempre bool
  }

  std::any visitAndExpr(TeoraParser::AndExprContext* ctx) override {
    return logica(ctx, ctx->expressao(0), ctx->expressao(1), "&&");
  }
  std::any visitOrExpr(TeoraParser::OrExprContext* ctx) override {
    return logica(ctx, ctx->expressao(0), ctx->expressao(1), "||");
  }

 private:
  // ---- utilitários de tipo ------------------------------------------

  static bool numerico(Tipo t) {
    return t == Tipo::INT || t == Tipo::FLOAT || t == Tipo::DOUBLE;
  }

  static Tipo promover(Tipo a, Tipo b) {
    if (a == Tipo::DOUBLE || b == Tipo::DOUBLE) return Tipo::DOUBLE;
    if (a == Tipo::FLOAT || b == Tipo::FLOAT) return Tipo::FLOAT;
    return Tipo::INT;
  }

  // Um valor do tipo `origem` pode ser guardado em uma variável `destino`?
  // Aceita ampliação (int->float->double, char->int, char->string). Também
  // aceita double->float, para que "float c = 9.2;" funcione (9.2 é double).
  // Não aceita float/double -> int (perde a parte decimal).
  static bool atribuivel(Tipo destino, Tipo origem) {
    if (destino == Tipo::ERRO || origem == Tipo::ERRO) return true;
    if (destino == origem) return true;
    switch (destino) {
      case Tipo::FLOAT:
      case Tipo::DOUBLE: return numerico(origem) || origem == Tipo::CHAR;
      case Tipo::INT: return origem == Tipo::CHAR;
      case Tipo::STRING: return origem == Tipo::CHAR;
      default: return false;
    }
  }

  static Tipo tipoDe(TeoraParser::TipoContext* c) {
    if (c->INT()) return Tipo::INT;
    if (c->FLOAT()) return Tipo::FLOAT;
    if (c->DOUBLE()) return Tipo::DOUBLE;
    if (c->CHAR()) return Tipo::CHAR;
    if (c->STRING()) return Tipo::STRING;
    if (c->BOOL()) return Tipo::BOOL;
    return Tipo::VOID;
  }

  Tipo tipoExpr(TeoraParser::ExpressaoContext* e) {
    return std::any_cast<Tipo>(visit(e));
  }

  void verificarAtribuicao(Tipo destino, Tipo origem, antlr4::ParserRuleContext* onde) {
    if (atribuivel(destino, origem)) return;
    std::string msg = "nao e possivel atribuir '" + std::string(nomeTipo(origem)) +
                      "' a '" + nomeTipo(destino) + "'";
    if (numerico(origem) && origem != Tipo::INT && destino == Tipo::INT)
      msg += " (perderia a parte decimal)";
    erro(onde, msg);
  }

  void exigirBool(TeoraParser::ExpressaoContext* e, const std::string& onde) {
    Tipo t = tipoExpr(e);
    if (t != Tipo::BOOL && t != Tipo::ERRO)
      erro(e, "a condicao do '" + onde + "' deve ser bool, mas e '" +
                  nomeTipo(t) + "'");
  }

  std::any logica(antlr4::ParserRuleContext* ctx, TeoraParser::ExpressaoContext* a,
                  TeoraParser::ExpressaoContext* b, const std::string& op) {
    Tipo l = tipoExpr(a);
    Tipo r = tipoExpr(b);
    if (l != Tipo::ERRO && r != Tipo::ERRO && (l != Tipo::BOOL || r != Tipo::BOOL))
      erro(ctx, "operador '" + op + "' exige operandos bool, mas recebeu '" +
                    nomeTipo(l) + "' e '" + nomeTipo(r) + "'");
    return Tipo::BOOL;
  }

  void erroOperador(antlr4::ParserRuleContext* ctx, const std::string& op, Tipo l, Tipo r) {
    erro(ctx, "operador '" + op + "' nao se aplica a '" + nomeTipo(l) + "' e '" +
                  nomeTipo(r) + "'");
  }

  // ---- escopos e símbolos -------------------------------------------

  void visitarBloco(TeoraParser::ListaComandosContext* lc, const std::string& nome) {
    if (!lc) return;  // bloco vazio: nada a declarar
    tabela_.entrarEscopo(nome);
    visit(lc);
    sairEscopo();
  }

  // Ao sair de um escopo, avisa sobre variáveis que nunca foram lidas.
  void sairEscopo() {
    avisarNaoUsados();
    tabela_.sairEscopo();
  }

  void avisarNaoUsados() {
    for (const Simbolo& s : tabela_.escopoAtual().simbolos)
      if (s.categoria == Categoria::VARIAVEL && !s.usado && s.tipo != Tipo::ERRO)
        aviso(s.linha, s.coluna, "variavel '" + s.nome + "' declarada mas nunca usada");
  }

  Simbolo* buscarVariavel(antlr4::tree::TerminalNode* id) {
    Simbolo* s = tabela_.buscar(id->getText());
    if (!s) {
      erro(id, "'" + id->getText() + "' nao foi declarado");
      return nullptr;
    }
    if (s->categoria == Categoria::FUNCAO) {
      erro(id, "'" + s->nome + "' e uma funcao, nao uma variavel");
      return nullptr;
    }
    return s;
  }

  void declararFuncao(TeoraParser::FuncaoContext* f) {
    Simbolo s;
    s.nome = f->ID()->getText();
    s.tipo = tipoDe(f->tipo());
    s.categoria = Categoria::FUNCAO;
    s.inicializado = true;
    s.usado = true;
    preencherPos(s, f->ID());
    if (f->parametros())
      for (auto* p : f->parametros()->parametro()) s.parametros.push_back(tipoDe(p->tipo()));
    if (!tabela_.declarar(s)) {
      Simbolo* anterior = tabela_.buscarLocal(s.nome);
      erro(f->ID(), "'" + s.nome + "' ja foi declarado (L" +
                        std::to_string(anterior->linha) + ":C" +
                        std::to_string(anterior->coluna) + ")");
    }
  }

  // ---- diagnósticos --------------------------------------------------

  static void preencherPos(Simbolo& s, antlr4::tree::TerminalNode* n) {
    s.linha = n->getSymbol()->getLine();
    s.coluna = n->getSymbol()->getCharPositionInLine() + 1;
  }

  void erro(antlr4::tree::TerminalNode* n, const std::string& msg) {
    diag_.push_back({Diagnostico::Nivel::ERRO, msg, n->getSymbol()->getLine(),
                     n->getSymbol()->getCharPositionInLine() + 1});
  }
  void erro(antlr4::ParserRuleContext* c, const std::string& msg) {
    diag_.push_back({Diagnostico::Nivel::ERRO, msg, c->getStart()->getLine(),
                     c->getStart()->getCharPositionInLine() + 1});
  }
  void aviso(size_t linha, size_t coluna, const std::string& msg) {
    diag_.push_back({Diagnostico::Nivel::AVISO, msg, linha, coluna});
  }

  TabelaSimbolos tabela_;
  std::vector<Diagnostico> diag_;
  bool mainVisto_ = false;
};