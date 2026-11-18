/*
 * teora_token_source.hpp — Adaptador: o parser do ANTLR passa a consumir os
 * tokens produzidos pelo NOSSO lexer (AFDs), em vez do TeoraLexer gerado.
 */
#pragma once

#include <memory>
#include <string>
#include <utility>

#include "antlr4-runtime.h"
#include "TeoraParser.h"
#include "teora_lexer.hpp"

// TipoToken (nosso) -> tipo numérico do token no ANTLR (TeoraParser::IF, ...).
// Funciona porque os nomes são idênticos; se faltar algum no .g4, não compila.
inline size_t tipoAntlr(TipoToken t) {
  switch (t) {
#define X(n) case TipoToken::n: return TeoraParser::n;
    TEORA_TOKENS(X)
#undef X
    default: return antlr4::Token::EOF;
  }
}

class TeoraTokenSource : public antlr4::TokenSource {
 public:
  explicit TeoraTokenSource(const std::string& codigo)
      : lexer_(codigo), input_(codigo) {}

  std::unique_ptr<antlr4::Token> nextToken() override {
    Token t = lexer_.proximo();  // pode lançar ErroLexico

    std::unique_ptr<antlr4::CommonToken> tok;
    if (t.tipo == TipoToken::FIM) {
      size_t fim = input_.size();
      tok = std::make_unique<antlr4::CommonToken>(
          std::make_pair(this, &input_), antlr4::Token::EOF,
          antlr4::Token::DEFAULT_CHANNEL, fim, fim - 1);
      tok->setText("<EOF>");
    } else {
      tok = std::make_unique<antlr4::CommonToken>(
          std::make_pair(this, &input_), tipoAntlr(t.tipo),
          antlr4::Token::DEFAULT_CHANNEL, t.inicio,
          t.inicio + t.valor.size() - 1);
      tok->setText(t.valor);
    }
    tok->setLine(static_cast<size_t>(t.linha));
    tok->setCharPositionInLine(static_cast<size_t>(t.coluna - 1));  // ANTLR é 0-based
    linha_ = static_cast<size_t>(t.linha);
    coluna_ = static_cast<size_t>(t.coluna - 1);
    return tok;
  }

  size_t getLine() const override { return linha_; }
  size_t getCharPositionInLine() override { return coluna_; }
  antlr4::CharStream* getInputStream() override { return &input_; }
  std::string getSourceName() override { return "teora"; }
  antlr4::TokenFactory<antlr4::CommonToken>* getTokenFactory() override {
    return antlr4::CommonTokenFactory::DEFAULT.get();
  }

 private:
  Lexer lexer_;
  antlr4::ANTLRInputStream input_;
  size_t linha_ = 1, coluna_ = 0;
};