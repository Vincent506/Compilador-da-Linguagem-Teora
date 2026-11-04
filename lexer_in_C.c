/*
 * Uso:
 *   ./lexer_aluno [arquivo]
 *
 * Ordem sugerida:
 *   TODO 1-4 : primitivas do AFD
 *   TODO 5-6 : construtores genéricos (literal, trie)
 *   TODO 7-8 : construtores específicos (ID, NUM)
 *   TODO 9-10: motor do lexer
 *   Config   : no topo do arquivo
 */

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* =====================================================================
 * 1. TOKEN
 * ===================================================================== */

typedef struct {
  char tipo[32];
  char valor[256];
  int linha;
  int coluna;
} Token;

/* =====================================================================
 * 2. AFD — tabela de transições
 * ===================================================================== */

#define MAX_ESTADOS 32 /* suficiente para ID/NUM/FIXO do exemplo */
#define NUM_SIMBOLOS 256

typedef struct {
  char nome[32];
  int transicoes[MAX_ESTADOS][NUM_SIMBOLOS]; /* -1 = sem transição */
  bool finais[MAX_ESTADOS];
  int inicial;
  int prox_estado;
} AFD;

void afd_init(AFD* afd, const char* nome) {
  snprintf(afd->nome,sizeof(afd->nome),"%s",nome);

  for (int i = 0; i < MAX_ESTADOS; i++)
  {
    afd->finais[i] = false;
    for (int j = 0; j < NUM_SIMBOLOS; j++)
    {
      afd->transicoes[i][j] = -1;
    }
    
  }
  
  afd->inicial = 0;
  afd->prox_estado = 1;
}

int afd_novo_estado(AFD* afd) {
  /* TODO 2: retorne afd->prox_estado e incremente. */
  return afd->prox_estado++;
}

void afd_transicao(AFD* afd, int origem, const char* simbolos, int destino) {
  /* TODO 3: para cada caractere c em `simbolos`,
   *         afd->transicoes[origem][(unsigned char)c] = destino. */
  for (int i = 0; simbolos[i] != '\0'; i++)
  {
    unsigned char c = (unsigned char)simbolos[i];
    afd->transicoes[origem][c] = destino;
  }
}

void afd_marcar_final(AFD* afd, int estado) {
  /* TODO 4 */
  afd->finais[estado] = true;
}

int afd_maior_prefixo(const AFD* afd, const char* texto) {
  // TODO 4b:
      int estado = afd->inicial;
      int ultimo = afd->finais[estado] ? 0 : -1;
      for (int i = 0; texto[i]; i++) {
          int prox = afd->transicoes[estado][(unsigned char)texto[i]];
          if (prox < 0) break;
          estado = prox;
          if (afd->finais[estado]) ultimo = i + 1;
      }
      return ultimo;
   
}

/* =====================================================================
 * 3. CONFIGURAÇÃO DA LINGUAGEM
 * ---------------------------------------------------------------------
 * Edite APENAS esta seção para adaptar o lexer à sua linguagem.
 * ===================================================================== */

#define LETRAS_ID "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
#define INICIAIS_ID LETRAS_ID "_"
#define CONTINUACAO_ID LETRAS_ID "0123456789_"
#define DIGITOS "0123456789"

typedef struct {
  const char* lexema;
  const char* tipo;
} Entrada;

/* Palavras reservadas (reclassificadas a partir de ID). Sentinela {NULL,NULL}.
 */
static const Entrada PALAVRAS_RESERVADAS[] = {{"if", "IF"},
                                              {"else", "ELSE"},
                                              {"switch", "SWITCH"},
                                              {"case","CASE"},
                                              {"break","BREAK"}, 
                                              {"return", "RETURN"},
                                              {"continue", "CONTINUE"},
                                              {"start","START"},
                                              {"end","END"},
                                              {"main","MAIN"},
                                              {"model","MODEL"},
                                              {"for","FOR"},
                                              {"do","DO"},
                                              {"while",  "WHILE"},
                                              {"void","VOID"}, 
                                              {"int", "INT"},
                                              {"float","FLOAT"},
                                              {"double","DOUBLE"},
                                              {"char","CHAR"},
                                              {"string","STRING"},
                                              {"bool","BOOL"},
                                              {"array","ARRAY"},
                                              {"try","TRY"},
                                              {"catch","CATCH"},
                                              {"input","INPUT"},
                                              {"output","OUTPUT"},
                                              {"list","LIST"},
                                              {"queue","QUEUE"},
                                              {"stack","STACK"},
                                              {"tree","TREE"},
                                              {"complex", "COMPLEX"},
                                              {"result","RESULT"},
                                              {"option","OPTION"},
                                              {"match","MATCH"},
                                              {NULL, NULL}};

/* Operadores + símbolos simples (reconhecidos por um único trie "FIXO"). */
static const Entrada FIXOS[] = {/* operadores compostos */
                                {"==", "OP_EQ"},
                                {"!=", "OP_NE"},
                                {"<=", "OP_LE"},
                                {">=", "OP_GE"},
                                {"=", "ATRIB"},
                                {"<", "MENOR"},
                                {">", "MAIOR"},
                                {"+=","ATRIB-SUM"},
                                {"++","INCREMENT"},
                                {"--","DECREMENT"},
                                {"-=","ATRIB-SUB"},
                                {"&&", "AND"},
                                {"||","OR"},
                                {"&","LAZY-AND"},
                                {"|","LAZY-OR"},
                                /* símbolos simples */
                                {"//","COMENTARIOS"},
                                {"(", "PAR_ESQ"},
                                {"'","ASP-SIMPLES"},
                                {")", "PAR_DIR"},
                                {"{", "CHAVE_ESQ"},
                                {"}", "CHAVE_DIR"},
                                {";", "PV"},
                                {NULL, NULL}};

/* =====================================================================
 * 4. CONSTRUTORES GENÉRICOS DE AFDs
 * ===================================================================== */

void afd_literal(AFD* afd, const char* nome, const char* texto) {
  // TODO 5: AFD que reconhece exatamente `texto`.
      afd_init(afd, nome);
      int atual = afd->inicial;
      for (const char* p = texto; *p; p++) {
          int prox = afd_novo_estado(afd);
          char buf[2] = { *p, '\0' };
          afd_transicao(afd, atual, buf, prox);
          atual = prox;
      }
      afd_marcar_final(afd, atual);
}

void afd_conjunto_literais(AFD* afd, const char* nome, const Entrada* ents) {
  // TODO 6: trie reconhecendo qualquer um dos `ents[i].lexema`.
  afd_init(afd,nome);
      for (int i = 0; ents[i].lexema; i++) {
          int atual = afd->inicial;
          for (const char* p = ents[i].lexema; *p; p++) {
              unsigned char c = (unsigned char)*p;
              int prox = afd->transicoes[atual][c];
              if (prox < 0) {
                  prox = afd_novo_estado(afd);
                  char buf[2] = { *p, '\0' };
                  afd_transicao(afd, atual, buf, prox);
              }
              atual = prox;
          }
          afd_marcar_final(afd, atual);
      }
}

/* =====================================================================
 * 5. CONSTRUTORES ESPECÍFICOS — ID e NUM
 * ===================================================================== */

void afd_identificador(AFD* afd) {
  /* TODO 7: [INICIAIS_ID][CONTINUACAO_ID]* */
  afd_init(afd, "ID");
  int e0 = afd->inicial;
  int e1 = afd_novo_estado(afd);

  afd_transicao(afd,e0,INICIAIS_ID,e1);
  
  afd_transicao(afd,e1,CONTINUACAO_ID,e1);

  afd_marcar_final(afd,e1);
}

void afd_numero(AFD* afd) {
  /* TODO 8: [DIGITOS]+
   * Para floats, adicione estados/transições para '.' e dígitos.
   */
  afd_init(afd, "NUM");

  int e0 = afd->inicial;
  int e1 = afd_novo_estado(afd);
  int e2 = afd_novo_estado(afd);
  int e3 = afd_novo_estado(afd);

  afd_transicao(afd,e0,DIGITOS,e1);
  
  afd_transicao(afd,e1,DIGITOS,e1);

  afd_transicao(afd,e1,".",e2);

  afd_transicao(afd,e2,DIGITOS, e3);

  afd_transicao(afd,e3,DIGITOS,e3);

  afd_marcar_final(afd,e1);

  afd_marcar_final(afd,e3);
}

/* =====================================================================
 * 6. RECLASSIFICAÇÃO
 * ===================================================================== */

const char* reclassificar(const char* tipo, const char* valor) {
  // TODO 9:
      if (strcmp(tipo, "ID") == 0) {
          for (int i = 0; PALAVRAS_RESERVADAS[i].lexema != NULL; i++)
          {
            if (strcmp(PALAVRAS_RESERVADAS[i].lexema, valor) == 0){
              return PALAVRAS_RESERVADAS[i].tipo;
            } 
          }
          
      } else if (strcmp(tipo, "FIXO") == 0) {
          for (int i = 0; FIXOS[i].lexema != NULL; i++)
          {
            if (strcmp(FIXOS[i].lexema, valor) == 0){
              return FIXOS[i].tipo;
          }
        }
      }
      return tipo;
}

/* =====================================================================
 * 7. LEXER
 * ===================================================================== */

#define MAX_REGRAS 8

typedef struct {
  AFD afd;
  const char* tipo;
} Regra;

typedef struct {
  const char* entrada;
  size_t pos;
  int linha;
  int coluna;
  Regra regras[MAX_REGRAS];
  int n_regras;
} Lexer;

void lexer_init(Lexer* lx, const char* entrada) {
  /* TODO 10a */
  lx->entrada = entrada;
  lx->pos = 0;
  lx->linha = 1;
  lx->coluna = 1;
  lx->n_regras = 0;
}

void lexer_add_regra(Lexer* lx, const char* tipo, const AFD* afd) {
  /* TODO 10b: copie *afd e o tipo para lx->regras[lx->n_regras++]. */
  if (lx->n_regras < MAX_REGRAS) {
    lx->regras[lx->n_regras].tipo = tipo;
    lx->regras[lx->n_regras].afd = *afd;
    lx->n_regras++;
  }
}

static void lexer_avancar(Lexer* lx, int n) {
  for (int i = 0; i < n; i++) {
    if (lx->entrada[lx->pos] == '\0') return;
    if (lx->entrada[lx->pos] == '\n') {
      lx->linha++;
      lx->coluna = 1;
    } else {
      lx->coluna++;
    }
    lx->pos++;
  }
}

bool lexer_proximo(Lexer* lx, Token* out) {
  /* pular espaços em branco */
  while (lx->entrada[lx->pos] == ' ' || lx->entrada[lx->pos] == '\t' ||
         lx->entrada[lx->pos] == '\r' || lx->entrada[lx->pos] == '\n') {
    lexer_avancar(lx, 1);
  }
  if (lx->entrada[lx->pos] == '\0') return false;

  int linha = lx->linha;
  int coluna = lx->coluna;
  const char* resto = lx->entrada + lx->pos;

  /* processa o maximo de caracteres */
  int melhor_tam = 0;
  const char* melhor_tipo = NULL;
  // TODO 10c:
      for (int i = 0; i < lx->n_regras; i++) {
          int tam = afd_maior_prefixo(&lx->regras[i].afd, resto);
          if (tam > melhor_tam) {
              melhor_tam  = tam;
              melhor_tipo = lx->regras[i].tipo;
          }
      }

  if (melhor_tam == 0) {
    fprintf(stderr, "Caractere inesperado '%c' em L%d:C%d\n", resto[0], linha,
            coluna);
    exit(1);
  }

  snprintf(out->tipo, sizeof out->tipo, "%s", melhor_tipo);
  memcpy(out->valor, resto, melhor_tam);
  out->valor[melhor_tam] = '\0';
  out->linha = linha;
  out->coluna = coluna;
  lexer_avancar(lx, melhor_tam);

  /* reclassificação */
  // TODO 10d:
      const char *r = reclassificar(out->tipo, out->valor);
      if (r != out->tipo){
        snprintf(out->tipo, sizeof out->tipo, "%s", r);
      }
      
   

  return true;
}

/* =====================================================================
 * 8. PROGRAMA PRINCIPAL
 * ===================================================================== */

static void construir_regras(Lexer* lx) {
  AFD afd;

  afd_identificador(&afd);
  lexer_add_regra(lx, "ID", &afd);
  afd_numero(&afd);
  lexer_add_regra(lx, "NUM", &afd);
  afd_conjunto_literais(&afd, "FIXO", FIXOS);
  lexer_add_regra(lx, "FIXO", &afd);
}

int main(int argc, char** argv) {
  const char* codigo = "string fogo = 'quente'";
  char* buffer = NULL;

  if (argc > 1) {
    FILE* f = fopen(argv[1], "rb");
    if (!f) {
      perror(argv[1]);
      return 1;
    }
    fseek(f, 0, SEEK_END);
    long n = ftell(f);
    rewind(f);
    buffer = malloc((size_t)n + 1);
    if (!buffer) {
      fclose(f);
      return 1;
    }
    fread(buffer, 1, (size_t)n, f);
    buffer[n] = '\0';
    fclose(f);
    codigo = buffer;
  }

  Lexer lx;
  lexer_init(&lx, codigo);
  construir_regras(&lx);

  printf("%-12s %-10s\n", "TEXTO", "TOKEN");
  printf("----------------------\n");

  Token t;
  while (lexer_proximo(&lx, &t)) {
    printf("%-12s %-10s\n", t.valor, t.tipo);
  }

  free(buffer);
  return 0; 
}