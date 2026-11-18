// Compilador da Teora (por enquanto): lexer (AFDs) -> parser (ANTLR) ->
// análise semântica + tabela de símbolos.
// Uso: teorac arquivo.teo [--arvore]
#include <fstream>
#include <iostream>
#include <sstream>

#include "analisador_semantico.hpp"
#include "teora_token_source.hpp"

int main(int argc, char** argv) {
  if (argc < 2) {
    std::cerr << "Uso: " << argv[0] << " arquivo.teo\n";
    return 1;
  }
  std::ifstream arq(argv[1], std::ios::binary);
  if (!arq) {
    std::cerr << "Não foi possível abrir " << argv[1] << "\n";
    return 1;
  }
  std::ostringstream ss;
  ss << arq.rdbuf();
  const std::string codigo = ss.str();

  try {
    TeoraTokenSource fonte(codigo);
    antlr4::CommonTokenStream tokens(&fonte);
    TeoraParser parser(&tokens);

    TeoraParser::ProgramaContext* arvore = parser.programa();

    if (parser.getNumberOfSyntaxErrors() > 0) {
      std::cerr << parser.getNumberOfSyntaxErrors() << " erro(s) de sintaxe.\n";
      return 1;
    }

    const bool mostrarArvore = argc > 2 && std::string(argv[2]) == "--arvore";
    if (mostrarArvore) std::cout << arvore->toStringTree(&parser, true) << "\n\n";

    AnalisadorSemantico semantico;
    semantico.analisar(arvore);

    semantico.tabela().imprimir(std::cout);
    std::cout.flush();

    for (const Diagnostico& d : semantico.diagnosticos())
      std::cerr << argv[1] << ":" << d.linha << ":" << d.coluna << ": "
                << (d.nivel == Diagnostico::Nivel::ERRO ? "erro: " : "aviso: ")
                << d.mensagem << "\n";
    if (semantico.numErros() > 0) {
      std::cerr << semantico.numErros() << " erro(s) semantico(s).\n";
      return 1;
    }
  } catch (const ErroLexico& e) {
    std::cerr << "Erro léxico: " << e.what() << "\n";
    return 1;
  }
  return 0;
}