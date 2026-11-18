/*
 * teora_lexer.hpp — Lexer da linguagem Teora (AFD + maior prefixo + reclassificação).
 * Header-only, C++17. Os nomes de TipoToken são IDÊNTICOS aos do Teora.g4.
 */
#pragma once

#include <array>
#include <fstream>
#include <iomanip>
#include <iostream>
#include <sstream>
#include <stdexcept>
#include <string>
#include <string_view>
#include <unordered_map>
#include <utility>
#include <vector>

// =====================================================================
// 1. TOKEN
// =====================================================================

// Lista ÚNICA dos tokens que existem no parser (usada pelo enum, por nome() e
// pelo adaptador do ANTLR). Para criar um token novo: adicione aqui e no .g4.
#define TEORA_TOKENS(X)                                                        \
  X(IF) X(ELSE) X(SWITCH) X(CASE) X(BREAK) X(RETURN) X(CONTINUE) X(START)      \
  X(END) X(MAIN) X(MODEL) X(FOR) X(DO) X(WHILE) X(VOID) X(INT) X(FLOAT)        \
  X(DOUBLE) X(CHAR) X(STRING) X(BOOL) X(ARRAY) X(TRY) X(CATCH) X(INPUT)        \
  X(OUTPUT) X(LIST) X(QUEUE) X(STACK) X(TREE) X(COMPLEX) X(RESULT)             \
  X(OPTION) X(MATCH) X(DEFAULT) X(TRUE) X(FALSE)                               \
  X(OP_EQ) X(OP_NE) X(OP_LE) X(OP_GE) X(ATRIB) X(MENOR) X(MAIOR)               \
  X(ATRIB_SUM) X(INCREMENT) X(DECREMENT) X(ATRIB_SUB) X(OP_AND) X(OP_OR)       \
  X(LAZY_AND) X(LAZY_OR) X(OP_SUM) X(OP_SUB) X(OP_MUL) X(OP_DIV) X(OP_MOD)     \
  X(PAR_ESQ) X(PAR_DIR) X(KEY_ESQ) X(KEY_DIR) X(SEMICOL) X(COMMA) X(COLON)     \
  X(ASP) X(ID) X(REAL) X(NUM) X(STRING_LITERAL)

enum class TipoToken {
#define X(n) n,
  TEORA_TOKENS(X)
#undef X
  COMENTARIO,  // reconhecido e descartado
  FIXO,        // tipo provisório: vira OP_xx / PAR_xx após reclassificação
  FIM          // fim de arquivo
};

inline const char* nome(TipoToken t) {
  switch (t) {
#define X(n) case TipoToken::n: return #n;
    TEORA_TOKENS(X)
#undef X
    case TipoToken::COMENTARIO: return "COMENTARIO";
    case TipoToken::FIXO: return "FIXO";
    case TipoToken::FIM: return "FIM";
  }
  return "?";
}

struct Token {
  TipoToken tipo = TipoToken::FIM;
  std::string valor;
  int linha = 0;
  int coluna = 0;
  size_t inicio = 0;  // deslocamento (em bytes) no texto de entrada
};

struct ErroLexico : std::runtime_error {
  using std::runtime_error::runtime_error;
};

// =====================================================================
// 2. AFD — tabela de transições (cresce dinamicamente, sem MAX_ESTADOS)
// =====================================================================

class AFD {
 public:
  static constexpr int SEM_TRANSICAO = -1;
  static constexpr int NUM_SIMBOLOS = 256;

  AFD() { novoEstado(); }  // estado 0 = inicial

  int novoEstado() {
    transicoes_.emplace_back();
    transicoes_.back().fill(SEM_TRANSICAO);
    finais_.push_back(false);
    return static_cast<int>(transicoes_.size()) - 1;
  }

  // para cada caractere de `simbolos`: origem --c--> destino
  void transicao(int origem, std::string_view simbolos, int destino) {
    for (char c : simbolos)
      transicoes_[origem][static_cast<unsigned char>(c)] = destino;
  }

  // origem --(qualquer caractere EXCETO os de `proibidos`)--> destino
  void transicaoExceto(int origem, std::string_view proibidos, int destino) {
    for (int c = 0; c < NUM_SIMBOLOS; ++c)
      if (proibidos.find(static_cast<char>(c)) == std::string_view::npos)
        transicoes_[origem][c] = destino;
  }

  int proximo(int estado, char c) const {
    return transicoes_[estado][static_cast<unsigned char>(c)];
  }

  void marcarFinal(int estado) { finais_[estado] = true; }

  // Tamanho do maior prefixo de `texto` aceito pelo AFD (0 = nenhum).
  // (No C original era -1 para "nenhum"; aqui 0 já significa "não casou",
  //  pois nenhum dos nossos AFDs aceita a palavra vazia.)
  size_t maiorPrefixo(std::string_view texto) const {
    int estado = 0;
    size_t ultimo = 0;
    for (size_t i = 0; i < texto.size(); ++i) {
      int prox = proximo(estado, texto[i]);
      if (prox == SEM_TRANSICAO) break;
      estado = prox;
      if (finais_[estado]) ultimo = i + 1;
    }
    return ultimo;
  }

 private:
  std::vector<std::array<int, NUM_SIMBOLOS>> transicoes_;
  std::vector<bool> finais_;
};

// =====================================================================
// 3. CONFIGURAÇÃO DA LINGUAGEM (edite só esta seção)
// =====================================================================

static const std::string LETRAS_ID =
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
static const std::string INICIAIS_ID = LETRAS_ID + "_";
static const std::string CONTINUACAO_ID = LETRAS_ID + "0123456789_";
static const std::string DIGITOS = "0123456789";

using Entrada = std::pair<std::string, TipoToken>;

static const std::vector<Entrada> PALAVRAS_RESERVADAS = {
    {"if", TipoToken::IF},         {"else", TipoToken::ELSE},
    {"switch", TipoToken::SWITCH}, {"case", TipoToken::CASE},
    {"break", TipoToken::BREAK},   {"return", TipoToken::RETURN},
    {"continue", TipoToken::CONTINUE}, {"start", TipoToken::START},
    {"end", TipoToken::END},       {"main", TipoToken::MAIN},
    {"model", TipoToken::MODEL},   {"for", TipoToken::FOR},
    {"do", TipoToken::DO},         {"while", TipoToken::WHILE},
    {"void", TipoToken::VOID},     {"int", TipoToken::INT},
    {"float", TipoToken::FLOAT},   {"double", TipoToken::DOUBLE},
    {"char", TipoToken::CHAR},     {"string", TipoToken::STRING},
    {"bool", TipoToken::BOOL},     {"array", TipoToken::ARRAY},
    {"try", TipoToken::TRY},       {"catch", TipoToken::CATCH},
    {"input", TipoToken::INPUT},   {"output", TipoToken::OUTPUT},
    {"list", TipoToken::LIST},     {"queue", TipoToken::QUEUE},
    {"stack", TipoToken::STACK},   {"tree", TipoToken::TREE},
    {"complex", TipoToken::COMPLEX}, {"result", TipoToken::RESULT},
    {"option", TipoToken::OPTION}, {"match", TipoToken::MATCH},
    {"default", TipoToken::DEFAULT}, {"true", TipoToken::TRUE},
    {"false", TipoToken::FALSE}};

static const std::vector<Entrada> FIXOS = {
    {"==", TipoToken::OP_EQ},     {"!=", TipoToken::OP_NE},
    {"<=", TipoToken::OP_LE},     {">=", TipoToken::OP_GE},
    {"=", TipoToken::ATRIB},      {"<", TipoToken::MENOR},
    {">", TipoToken::MAIOR},      {"+=", TipoToken::ATRIB_SUM},
    {"++", TipoToken::INCREMENT}, {"--", TipoToken::DECREMENT},
    {"-=", TipoToken::ATRIB_SUB}, {"&&", TipoToken::OP_AND},
    {"||", TipoToken::OP_OR},     {"&", TipoToken::LAZY_AND},
    {"|", TipoToken::LAZY_OR},    {"+", TipoToken::OP_SUM},
    {"-", TipoToken::OP_SUB},     {"*", TipoToken::OP_MUL},
    {"/", TipoToken::OP_DIV},     {"%", TipoToken::OP_MOD},
    {"(", TipoToken::PAR_ESQ},
    {")", TipoToken::PAR_DIR},    {"{", TipoToken::KEY_ESQ},
    {"}", TipoToken::KEY_DIR},    {";", TipoToken::SEMICOL},
    {",", TipoToken::COMMA},      {":", TipoToken::COLON},
    {"'", TipoToken::ASP}};

// =====================================================================
// 4. CONSTRUTORES DE AFDs
// =====================================================================

namespace construtor {

// Trie: reconhece qualquer um dos lexemas de `entradas`.
inline AFD conjuntoLiterais(const std::vector<Entrada>& entradas) {
  AFD afd;
  for (const auto& [lexema, tipo] : entradas) {
    (void)tipo;
    int atual = 0;
    for (char c : lexema) {
      int prox = afd.proximo(atual, c);
      if (prox == AFD::SEM_TRANSICAO) {
        prox = afd.novoEstado();
        afd.transicao(atual, std::string(1, c), prox);
      }
      atual = prox;
    }
    afd.marcarFinal(atual);
  }
  return afd;
}

// [INICIAIS_ID][CONTINUACAO_ID]*
inline AFD identificador() {
  AFD afd;
  int e1 = afd.novoEstado();
  afd.transicao(0, INICIAIS_ID, e1);
  afd.transicao(e1, CONTINUACAO_ID, e1);
  afd.marcarFinal(e1);
  return afd;
}

// [DIGITOS]+
inline AFD numero() {
  AFD afd;
  int e1 = afd.novoEstado();
  afd.transicao(0, DIGITOS, e1);
  afd.transicao(e1, DIGITOS, e1);
  afd.marcarFinal(e1);
  return afd;
}

// [DIGITOS]+ '.' [DIGITOS]+
inline AFD decimal() {
  AFD afd;
  int e1 = afd.novoEstado();
  int e2 = afd.novoEstado();
  int e3 = afd.novoEstado();
  afd.transicao(0, DIGITOS, e1);
  afd.transicao(e1, DIGITOS, e1);
  afd.transicao(e1, ".", e2);
  afd.transicao(e2, DIGITOS, e3);
  afd.transicao(e3, DIGITOS, e3);
  afd.marcarFinal(e3);
  return afd;
}

// '\'' [^'\r\n]* '\''   (mesma regra STRING_LITERAL do .g4)
inline AFD stringLiteral() {
  AFD afd;
  int e1 = afd.novoEstado();
  int e2 = afd.novoEstado();
  afd.transicao(0, "'", e1);
  afd.transicaoExceto(e1, "'\r\n", e1);
  afd.transicao(e1, "'", e2);
  afd.marcarFinal(e2);
  return afd;
}

// '//' [^\r\n]*
inline AFD comentario() {
  AFD afd;
  int e1 = afd.novoEstado();
  int e2 = afd.novoEstado();
  afd.transicao(0, "/", e1);
  afd.transicao(e1, "/", e2);
  afd.transicaoExceto(e2, "\r\n", e2);
  afd.marcarFinal(e2);
  return afd;
}

}  // namespace construtor

// =====================================================================
// 5. RECLASSIFICAÇÃO (ID -> palavra reservada, FIXO -> operador/símbolo)
// =====================================================================

inline TipoToken reclassificar(TipoToken tipo, const std::string& valor) {
  static const auto tabelaReservadas = [] {
    std::unordered_map<std::string, TipoToken> m;
    for (const auto& [lex, t] : PALAVRAS_RESERVADAS) m.emplace(lex, t);
    return m;
  }();
  static const auto tabelaFixos = [] {
    std::unordered_map<std::string, TipoToken> m;
    for (const auto& [lex, t] : FIXOS) m.emplace(lex, t);
    return m;
  }();

  if (tipo == TipoToken::ID) {
    auto it = tabelaReservadas.find(valor);
    if (it != tabelaReservadas.end()) return it->second;
  } else if (tipo == TipoToken::FIXO) {
    auto it = tabelaFixos.find(valor);
    if (it != tabelaFixos.end()) return it->second;
  }
  return tipo;
}

// =====================================================================
// 6. LEXER
// =====================================================================

class Lexer {
 public:
  explicit Lexer(std::string entrada) : entrada_(std::move(entrada)) {
    // A ORDEM importa: em empate de tamanho, vence a primeira regra.
    regras_.push_back({TipoToken::ID, construtor::identificador()});
    regras_.push_back({TipoToken::NUM, construtor::numero()});
    regras_.push_back({TipoToken::REAL, construtor::decimal()});
    regras_.push_back({TipoToken::STRING_LITERAL, construtor::stringLiteral()});
    regras_.push_back({TipoToken::COMENTARIO, construtor::comentario()});
    regras_.push_back({TipoToken::FIXO, construtor::conjuntoLiterais(FIXOS)});
  }

  // Devolve o próximo token (FIM no fim do arquivo). Comentários são pulados.
  Token proximo() {
    while (true) {
      pularEspacos();
      if (pos_ >= entrada_.size()) return Token{TipoToken::FIM, "", linha_, coluna_};

      std::string_view resto(entrada_.data() + pos_, entrada_.size() - pos_);

      size_t melhorTam = 0;
      TipoToken melhorTipo = TipoToken::FIM;
      for (const auto& r : regras_) {
        size_t tam = r.afd.maiorPrefixo(resto);
        if (tam > melhorTam) {  // '>' estrito: empate fica com a regra anterior
          melhorTam = tam;
          melhorTipo = r.tipo;
        }
      }

      if (melhorTam == 0) {
        std::ostringstream msg;
        msg << "Caractere inesperado '" << resto[0] << "' em L" << linha_
            << ":C" << coluna_;
        throw ErroLexico(msg.str());
      }

      Token t;
      t.valor = std::string(resto.substr(0, melhorTam));
      t.linha = linha_;
      t.coluna = coluna_;
      t.inicio = pos_;
      avancar(melhorTam);

      if (melhorTipo == TipoToken::COMENTARIO) continue;  // descarta e segue

      t.tipo = reclassificar(melhorTipo, t.valor);
      return t;
    }
  }

  std::vector<Token> tokenizar() {
    std::vector<Token> tokens;
    for (Token t = proximo(); t.tipo != TipoToken::FIM; t = proximo())
      tokens.push_back(std::move(t));
    return tokens;
  }

 private:
  struct Regra {
    TipoToken tipo;
    AFD afd;
  };

  void pularEspacos() {
    while (pos_ < entrada_.size()) {
      char c = entrada_[pos_];
      if (c == ' ' || c == '\t' || c == '\r' || c == '\n') avancar(1);
      else break;
    }
  }

  void avancar(size_t n) {
    for (size_t i = 0; i < n && pos_ < entrada_.size(); ++i) {
      if (entrada_[pos_] == '\n') { ++linha_; coluna_ = 1; }
      else ++coluna_;
      ++pos_;
    }
  }

  std::string entrada_;
  size_t pos_ = 0;
  int linha_ = 1;
  int coluna_ = 1;
  std::vector<Regra> regras_;
};