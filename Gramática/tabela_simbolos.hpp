/*
 * tabela_simbolos.hpp — Tabela de símbolos da Teora (tabela hash + escopos).
 *
 * Cada escopo tem sua própria tabela hash (unordered_map: nome -> posição).
 * Os escopos formam uma pilha durante a análise: ao entrar num bloco empilha-se
 * um escopo novo; ao sair, ele sai da pilha mas FICA guardado, para que a
 * tabela completa possa ser impressa no final.
 */
#pragma once

#include <deque>
#include <iomanip>
#include <ostream>
#include <string>
#include <unordered_map>
#include <utility>
#include <vector>

enum class Tipo { INT, FLOAT, DOUBLE, CHAR, STRING, BOOL, VOID, ARRAY, EXCECAO, ERRO };

inline const char* nomeTipo(Tipo t) {
  switch (t) {
    case Tipo::INT: return "int";
    case Tipo::FLOAT: return "float";
    case Tipo::DOUBLE: return "double";
    case Tipo::CHAR: return "char";
    case Tipo::STRING: return "string";
    case Tipo::BOOL: return "bool";
    case Tipo::VOID: return "void";
    case Tipo::ARRAY: return "array";
    case Tipo::EXCECAO: return "excecao";
    case Tipo::ERRO: return "<erro>";
  }
  return "?";
}

enum class Categoria { VARIAVEL, PARAMETRO, FUNCAO, CAPTURA };

inline const char* nomeCategoria(Categoria c) {
  switch (c) {
    case Categoria::VARIAVEL: return "variavel";
    case Categoria::PARAMETRO: return "parametro";
    case Categoria::FUNCAO: return "funcao";
    case Categoria::CAPTURA: return "captura";
  }
  return "?";
}

struct Simbolo {
  std::string nome;
  Tipo tipo = Tipo::ERRO;              // para função: tipo de retorno
  Categoria categoria = Categoria::VARIAVEL;
  size_t linha = 0, coluna = 0;        // onde foi declarado
  bool usado = false;                  // foi lido em alguma expressão?
  bool inicializado = false;           // recebeu valor?
  std::vector<Tipo> parametros;        // só para funções
  int escopo = -1;                     // id do escopo que o contém

  std::string descricaoTipo() const {
    std::string s = nomeTipo(tipo);
    if (categoria == Categoria::FUNCAO) {
      s += "(";
      for (size_t i = 0; i < parametros.size(); ++i)
        s += (i ? ", " : "") + std::string(nomeTipo(parametros[i]));
      s += ")";
    }
    return s;
  }
};

struct Escopo {
  int id = 0;
  int pai = -1;                                     // -1 = escopo global
  std::string nome;
  std::deque<Simbolo> simbolos;                     // em ordem de declaração
  std::unordered_map<std::string, size_t> indice;   // A TABELA HASH: nome -> posição
};

class TabelaSimbolos {
 public:
  TabelaSimbolos() { entrarEscopo("global"); }

  int entrarEscopo(const std::string& nome) {
    Escopo e;
    e.id = static_cast<int>(escopos_.size());
    e.pai = pilha_.empty() ? -1 : pilha_.back();
    e.nome = nome;
    escopos_.push_back(std::move(e));
    pilha_.push_back(escopos_.back().id);
    return escopos_.back().id;
  }

  // O escopo global nunca sai da pilha.
  void sairEscopo() {
    if (pilha_.size() > 1) pilha_.pop_back();
  }

  Escopo& escopoAtual() { return escopos_[pilha_.back()]; }
  bool noEscopoGlobal() const { return pilha_.size() == 1; }

  // Insere no escopo atual. Devolve nullptr se o nome já existe NESTE escopo.
  // (O ponteiro devolvido continua válido: usamos std::deque.)
  Simbolo* declarar(Simbolo s) {
    Escopo& e = escopoAtual();
    if (e.indice.count(s.nome)) return nullptr;
    s.escopo = e.id;
    e.indice[s.nome] = e.simbolos.size();
    e.simbolos.push_back(std::move(s));
    return &e.simbolos.back();
  }

  Simbolo* buscarLocal(const std::string& nome) {
    Escopo& e = escopoAtual();
    auto it = e.indice.find(nome);
    return it == e.indice.end() ? nullptr : &e.simbolos[it->second];
  }

  // Procura do escopo mais interno para o mais externo.
  Simbolo* buscar(const std::string& nome) {
    for (auto it = pilha_.rbegin(); it != pilha_.rend(); ++it) {
      Escopo& e = escopos_[*it];
      auto achado = e.indice.find(nome);
      if (achado != e.indice.end()) return &e.simbolos[achado->second];
    }
    return nullptr;
  }

  const std::deque<Escopo>& escopos() const { return escopos_; }

  void imprimir(std::ostream& os) const {
    os << "=== TABELA DE SIMBOLOS ===\n";
    for (const Escopo& e : escopos_) {
      if (e.simbolos.empty()) continue;
      int profundidade = 0;
      for (int p = e.pai; p != -1; p = escopos_[p].pai) ++profundidade;
      const std::string ind(static_cast<size_t>(profundidade) * 2, ' ');

      os << ind << "[escopo " << e.id << "] " << e.nome;
      if (e.pai >= 0) os << "  (pai: " << e.pai << ")";
      os << "\n";
      os << ind << "  " << std::left << std::setw(14) << "NOME" << std::setw(11)
         << "CATEGORIA" << std::setw(18) << "TIPO" << std::setw(9) << "POS"
         << std::setw(7) << "USADO" << "INIT\n";
      for (const Simbolo& s : e.simbolos) {
        const std::string pos =
            "L" + std::to_string(s.linha) + ":C" + std::to_string(s.coluna);
        os << ind << "  " << std::left << std::setw(14) << s.nome
           << std::setw(11) << nomeCategoria(s.categoria) << std::setw(18)
           << s.descricaoTipo() << std::setw(9) << pos << std::setw(7)
           << (s.usado ? "sim" : "nao") << (s.inicializado ? "sim" : "nao")
           << "\n";
      }
    }
  }

 private:
  std::deque<Escopo> escopos_;  // todos os escopos já criados (para imprimir)
  std::vector<int> pilha_;      // ids dos escopos ativos agora
};