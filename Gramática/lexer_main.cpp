// Executável só do lexer: imprime a tabela de tokens.
#include <fstream>
#include <iomanip>
#include <iostream>
#include <sstream>

#include "teora_lexer.hpp"

int main(int argc, char** argv) {
  std::string codigo = "string fogo = 'quente';";
  if (argc > 1) {
    std::ifstream arq(argv[1], std::ios::binary);
    if (!arq) { std::cerr << "Não foi possível abrir " << argv[1] << "\n"; return 1; }
    std::ostringstream ss;
    ss << arq.rdbuf();
    codigo = ss.str();
  }
  try {
    Lexer lexer(codigo);
    std::cout << std::left << std::setw(16) << "TEXTO" << std::setw(16)
              << "TOKEN" << "LINHA:COL\n"
              << "------------------------------------------\n";
    for (const Token& t : lexer.tokenizar())
      std::cout << std::setw(16) << t.valor << std::setw(16) << nome(t.tipo)
                << t.linha << ":" << t.coluna << "\n";
  } catch (const ErroLexico& e) {
    std::cerr << "Erro léxico: " << e.what() << "\n";
    return 1;
  }
  return 0;
}