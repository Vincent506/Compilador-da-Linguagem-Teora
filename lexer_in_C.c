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
  /* TODO 1:
   *   - copie o nome (strncpy ou snprintf)
   *   - preencha todas as transições com -1
   *   - zere finais
   *   - inicial = 0; prox_estado = 1
   */
  (void)afd;
  (void)nome;
}

int afd_novo_estado(AFD* afd) {
  /* TODO 2: retorne afd->prox_estado e incremente. */
  return -1;
}

void afd_transicao(AFD* afd, int origem, const char* simbolos, int destino) {
  /* TODO 3: para cada caractere c em `simbolos`,
   *         afd->transicoes[origem][(unsigned char)c] = destino. */
  (void)afd;
  (void)origem;
  (void)simbolos;
  (void)destino;
}

void afd_marcar_final(AFD* afd, int estado) {
  /* TODO 4 */
  (void)afd;
  (void)estado;
}

int afd_maior_prefixo(const AFD* afd, const char* texto) {
  /* TODO 4b:
   *   estado = afd->inicial
   *   ultimo = afd->finais[estado] ? 0 : -1
   *   for (i = 0; texto[i]; i++) {
   *       int prox = afd->transicoes[estado][(unsigned char)texto[i]];
   *       if (prox < 0) break;
   *       estado = prox;
   *       if (afd->finais[estado]) ultimo = i + 1;
   *   }
   *   return ultimo;
   */
  return -1;
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
                                              {"int", "INT"},
                                              /* {"while",  "WHILE"}, */
                                              /* {"return", "RETURN"}, */
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
                                /* símbolos simples */
                                {"(", "PAR_ESQ"},
                                {")", "PAR_DIR"},
                                {"{", "CHAVE_ESQ"},
                                {"}", "CHAVE_DIR"},
                                {";", "PV"},
                                {NULL, NULL}};

/* =====================================================================
 * 4. CONSTRUTORES GENÉRICOS DE AFDs
 * ===================================================================== */

void afd_literal(AFD* afd, const char* nome, const char* texto) {
  /* TODO 5: AFD que reconhece exatamente `texto`.
   *   afd_init(afd, nome);
   *   atual = afd->inicial;
   *   for (p = texto; *p; p++) {
   *       prox = afd_novo_estado(afd);
   *       char buf[2] = { *p, '\0' };
   *       afd_transicao(afd, atual, buf, prox);
   *       atual = prox;
   *   }
   *   afd_marcar_final(afd, atual);
   */
  afd_init(afd, nome);
}

void afd_conjunto_literais(AFD* afd, const char* nome, const Entrada* ents) {
  /* TODO 6: trie reconhecendo qualquer um dos `ents[i].lexema`.
   *   for (i = 0; ents[i].lexema; i++) {
   *       atual = afd->inicial;
   *       for (p = ents[i].lexema; *p; p++) {
   *           unsigned char c = (unsigned char)*p;
   *           int prox = afd->transicoes[atual][c];
   *           if (prox < 0) {
   *               prox = afd_novo_estado(afd);
   *               char buf[2] = { *p, '\0' };
   *               afd_transicao(afd, atual, buf, prox);
   *           }
   *           atual = prox;
   *       }
   *       afd_marcar_final(afd, atual);
   *   }
   */
  afd_init(afd, nome);
}

/* =====================================================================
 * 5. CONSTRUTORES ESPECÍFICOS — ID e NUM
 * ===================================================================== */

void afd_identificador(AFD* afd) {
  /* TODO 7: [INICIAIS_ID][CONTINUACAO_ID]* */
  afd_init(afd, "ID");
}

void afd_numero(AFD* afd) {
  /* TODO 8: [DIGITOS]+
   * Para floats, adicione estados/transições para '.' e dígitos.
   */
  afd_init(afd, "NUM");
}

/* =====================================================================
 * 6. RECLASSIFICAÇÃO
 * ===================================================================== */

const char* reclassificar(const char* tipo, const char* valor) {
  /* TODO 9:
   *   if (strcmp(tipo, "ID") == 0) {
   *       para cada PALAVRAS_RESERVADAS[i]:
   *           if (strcmp(lexema, valor) == 0) return tipo;
   *   } else if (strcmp(tipo, "FIXO") == 0) {
   *       para cada FIXOS[i]:
   *           if (strcmp(lexema, valor) == 0) return tipo;
   *   }
   *   return tipo;
   */
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
  (void)lx;
  (void)entrada;
}

void lexer_add_regra(Lexer* lx, const char* tipo, const AFD* afd) {
  /* TODO 10b: copie *afd e o tipo para lx->regras[lx->n_regras++]. */
  (void)lx;
  (void)tipo;
  (void)afd;
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
  /* TODO 10c:
   *   for (int i = 0; i < lx->n_regras; i++) {
   *       int tam = afd_maior_prefixo(&lx->regras[i].afd, resto);
   *       if (tam > melhor_tam) {
   *           melhor_tam  = tam;
   *           melhor_tipo = lx->regras[i].tipo;
   *       }
   *   }
   */

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
  /* TODO 10d:
   *   const char *r = reclassificar(out->tipo, out->valor);
   *   snprintf(out->tipo, sizeof out->tipo, "%s", r);
   */

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
  const char* codigo = "";
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