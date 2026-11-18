grammar Teora;

// ==========================================
// 1. REGRAS DE PARSER (Sintaxe e Estrutura)
// ==========================================

programa
    : blocoStart? (listaComandos|funcao)* endBlock? EOF
    ;

blocoStart
    : START MAIN PAR_ESQ PAR_DIR listaComandos KEY_ESQ
    | START KEY_ESQ listaComandos KEY_DIR
    ;

endBlock
    : KEY_DIR
    ;

funcao
    : START tipo ID PAR_ESQ parametros? PAR_DIR KEY_ESQ listaComandos KEY_DIR
    ;

parametros
    : parametro (COMMA parametro)*
    ;

parametro
    : tipo ID
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
    | comandoSwitch
    | comandoTryCatch
    | comandoIO
    | expressao SEMICOL
    ;

declaracao
    : tipo ID (ATRIB expressao)? SEMICOL
    | ARRAY ID SEMICOL
    ;

atribuicao
    : ID (ATRIB | ATRIB_SUM | ATRIB_SUB) expressao SEMICOL
    ;

tipo
    : INT 
    | FLOAT 
    | DOUBLE 
    | CHAR 
    | STRING 
    | BOOL
    | VOID
    ;

comandoIf
    : IF PAR_ESQ expressao PAR_DIR KEY_ESQ listaComandos KEY_DIR (ELSE KEY_ESQ listaComandos KEY_DIR)?
    ;

comandoWhile
    : WHILE PAR_ESQ expressao PAR_DIR KEY_ESQ listaComandos KEY_DIR
    | DO KEY_ESQ listaComandos KEY_DIR WHILE PAR_ESQ expressao PAR_DIR SEMICOL
    ;

comandoFor
    : FOR PAR_ESQ (declaracao | atribuicao) expressao SEMICOL incremento PAR_DIR KEY_ESQ listaComandos KEY_DIR
    ;

incremento
    : ID INCREMENT
    | ID DECREMENT
    ;

comandoSwitch
    : SWITCH PAR_ESQ ID PAR_DIR KEY_ESQ casoBloco+ defaultBloco? KEY_DIR
    ;

casoBloco
    : CASE (NUM | ID) COLON listaComandos BREAK SEMICOL
    ;

defaultBloco
    : DEFAULT COLON listaComandos
    ;

comandoTryCatch
    : TRY KEY_ESQ listaComandos KEY_DIR CATCH PAR_ESQ ID PAR_DIR KEY_ESQ listaComandos KEY_DIR
    ;

comandoIO
    : OUTPUT PAR_ESQ expressao PAR_DIR SEMICOL
    | INPUT PAR_ESQ ID PAR_DIR SEMICOL
    ;

expressao
    : expressao OP_OR expressao                      # OrExpr
    | expressao OP_AND expressao                     # AndExpr
    | expressao (OP_EQ | OP_NE | MAIOR | MENOR | OP_LE | OP_GE) expressao # RelExpr
    | expressao (OP_SUM | OP_SUB) expressao          # AddExpr
    | expressao (OP_MUL | OP_DIV | OP_MOD) expressao # MulExpr
    | ID (INCREMENT | DECREMENT)                     # IncDecExpr
    | PAR_ESQ expressao PAR_DIR                      # ParExpr
    | ID                                             # IdExpr
    | NUM                                            # NumExpr
    | REAL                                           # RealExpr
    | STRING_LITERAL                                 # StringExpr
    | TRUE                                           # TrueExpr
    | FALSE                                          # FalseExpr
    ;

// ==========================================
// 2. REGRAS DE LEXER (Tokens fiéis ao C)
// ==========================================

// Palavras-chave extraídas da sua config em C
IF       : 'if';
ELSE     : 'else';
SWITCH   : 'switch';
CASE     : 'case';
BREAK    : 'break';
RETURN   : 'return';
CONTINUE : 'continue';
START    : 'start';
END      : 'end';
MAIN     : 'main';
MODEL    : 'model';
FOR      : 'for';
DO       : 'do';
WHILE    : 'while';
VOID     : 'void';
INT      : 'int';
FLOAT    : 'float';
DOUBLE   : 'double';
CHAR     : 'char';
STRING   : 'string';
BOOL     : 'bool';
ARRAY    : 'array';
TRY      : 'try';
CATCH    : 'catch';
INPUT    : 'input';
OUTPUT   : 'output';
LIST     : 'list';
QUEUE    : 'queue';
STACK    : 'stack';
TREE     : 'tree';
COMPLEX  : 'complex';
RESULT   : 'result';
OPTION   : 'option';
MATCH    : 'match';
DEFAULT  : 'default';
TRUE     : 'true';
FALSE    : 'false';

// Operadores compostos e símbolos do array FIXOS em C
OP_EQ    : '==';
OP_NE    : '!=';
OP_LE    : '<=';
OP_GE    : '>=';
ATRIB    : '=';
MENOR    : '<';
MAIOR    : '>';
ATRIB_SUM: '+=';
INCREMENT: '++';
DECREMENT: '--';
ATRIB_SUB: '-=';
OP_AND   : '&&';
OP_OR    : '||';
LAZY_AND : '&';
LAZY_OR  : '|';
OP_SUM   : '+';
OP_SUB   : '-';
OP_MUL   : '*';
OP_DIV   : '/';
OP_MOD   : '%';

// Delimitadores e Pontuação
PAR_ESQ  : '(';
PAR_DIR  : ')';
KEY_ESQ  : '{';
KEY_DIR  : '}';
SEMICOL  : ';';
COMMA    : ',';
COLON    : ':';
ASP      : '\'';

// Padrões específicos de ID, Números e Reais espelhados no seu AFD
ID       : [a-zA-Z_] [a-zA-Z0-9_]* ;
REAL     : [0-9]+ '.' [0-9]+ ;
NUM      : [0-9]+ ;
STRING_LITERAL : '\'' ~['\r\n]* '\'' ;

// Comentários e Espaços em Branco (Ignorados)
COMENTARIO : '//' ~[\r\n]* -> skip ;
WS       : [ \t\r\n]+ -> skip ;