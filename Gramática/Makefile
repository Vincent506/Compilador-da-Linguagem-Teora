# Primeiro rode ./setup.sh (uma vez). Depois: make
VERSION   ?= 4.13.2
ANTLR     ?= java -jar vendor/antlr-$(VERSION)-complete.jar
ANTLR_INC ?= vendor/antlr4-$(VERSION)/runtime/Cpp/runtime/src
ANTLR_LIB ?= vendor/build/runtime/libantlr4-runtime.a
CXX       ?= g++
CXXFLAGS  ?= -std=c++17 -Wall -Wextra -Wno-unused-parameter -I gen -isystem $(ANTLR_INC)

all: teorac lexer_main
# Garante que o ANTLR gera todos os componentes necessários
gen/TeoraParser.cpp: Teora.g4
	$(ANTLR) -Dlanguage=Cpp -visitor -no-listener -o gen Teora.g4

# Compila o main.cpp junto com todos os .cpp gerados pelo ANTLR (usando gen/*.cpp)
teorac: main.cpp teora_token_source.hpp teora_lexer.hpp gen/TeoraParser.cpp
	$(CXX) $(CXXFLAGS) -o $@ main.cpp gen/*.cpp $(ANTLR_LIB) -lpthread
	
lexer_main: lexer_main.cpp teora_lexer.hpp
	$(CXX) -std=c++17 -Wall -Wextra -o $@ lexer_main.cpp

clean:
	rm -rf gen teorac lexer_main

.PHONY: all clean