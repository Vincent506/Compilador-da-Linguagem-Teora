grammar Teora;

// ==========================================
// 1. REGRAS DE PARSER (Sintaxe e BNF)
// ==========================================

programa
    : listaComandos EOF
    ;

listaComandos
    : comando+
    ;

comando
    : declaracao
    | atribuicao
    | comandoIf
    | comandoWhile
    | comandoFor
    | comandoOutput
    | expressao SEMICOL // Para cobrir incrementos isolados (ex: a--;)
    ;

declaracao
    : tipo ID (ATRIB expressao)? SEMICOL
    ;

atribuicao
    : ID (ATRIB | ATRIB_SUM | ATRIB_SUB) expressao SEMICOL
    ;

tipo
    : INT 
    | FLOAT 
    | DOUBLE 
    | BOOL
    ;

comandoIf
    : IF PAR_ESQ expressao PAR_DIR KEY_ESQ listaComandos KEY_DIR (ELSE KEY_ESQ listaComandos KEY_DIR)?
    ;

comandoWhile
    : WHILE PAR_ESQ expressao PAR_DIR KEY_ESQ listaComandos KEY_DIR
    ;

comandoFor
    : FOR PAR_ESQ (declaracao | atribuicao) expressao SEMICOL incremento PAR_DIR KEY_ESQ listaComandos KEY_DIR
    ;

incremento
    : ID INCREMENT
    | ID DECREMENT
    ;

comandoOutput
    : OUTPUT PAR_ESQ expressao PAR_DIR SEMICOL
    ;

// Expressões com precedência de operadores (lógicos, relacionais e aritméticos)
expressao
    : expressao OP_OR expressao                      # OrExpr
    | expressao OP_AND expressao                     # AndExpr
    | expressao (OP_EQ | OP_NE | MAIOR | MENOR | OP_LE | OP_GE) expressao # RelExpr
    | expressao (OP_SUM | OP_SUB) expressao          # AddExpr
    | ID (INCREMENT | DECREMENT)                     # IncDecExpr
    | PAR_ESQ expressao PAR_DIR                      # ParExpr
    | ID                                             # IdExpr
    | NUM                                            # NumExpr
    | REAL                                           # RealExpr
    | TRUE                                           # TrueExpr
    | FALSE                                          # FalseExpr
    ;

// ==========================================
// 2. REGRAS DE LEXER (Tokens)
// ==========================================

// Palavras-chave da linguagem Teora
IF       : 'if';
ELSE     : 'else';
WHILE    : 'while';
FOR      : 'for';
INT      : 'int';
FLOAT    : 'float';
DOUBLE   : 'double';
BOOL     : 'bool';
OUTPUT   : 'output';
TRUE     : 'true';
FALSE    : 'false';

// Operadores compostos e simples
OP_EQ    : '==';
OP_NE    : '!=';
OP_LE    : '<=';
OP_GE    : '>=';
MAIOR    : '>';
MENOR    : '<';
ATRIB    : '=';
ATRIB_SUM: '+=';
ATRIB_SUB: '-=';
OP_AND   : '&&';
OP_OR    : '||';
INCREMENT: '++';
DECREMENT: '--';
OP_SUM   : '+';
OP_SUB   : '-';

// Delimitações e pontuação[cite: 3]
PAR_ESQ  : '(';
PAR_DIR  : ')';
KEY_ESQ  : '{';
KEY_DIR  : '}';
SEMICOL  : ';';
COMMA    : ',';

// Identificadores, Números Inteiros e de Ponto Flutuante (Reais)
ID       : [a-zA-Z] [a-zA-Z0-9_]* ;
REAL     : [0-9]+ '.' [0-9]+ ;
NUM      : [0-9]+ ;

// Ignorar espaços em branco, tabulações e quebras de linha[cite: 3]
WS       : [ \t\r\n]+ -> skip ;