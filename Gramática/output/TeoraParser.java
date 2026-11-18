// Generated from Teora.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TeoraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, SWITCH=3, CASE=4, BREAK=5, RETURN=6, CONTINUE=7, START=8, 
		END=9, MAIN=10, MODEL=11, FOR=12, DO=13, WHILE=14, VOID=15, INT=16, FLOAT=17, 
		DOUBLE=18, CHAR=19, STRING=20, BOOL=21, ARRAY=22, TRY=23, CATCH=24, INPUT=25, 
		OUTPUT=26, LIST=27, QUEUE=28, STACK=29, TREE=30, COMPLEX=31, RESULT=32, 
		OPTION=33, MATCH=34, DEFAULT=35, TRUE=36, FALSE=37, OP_EQ=38, OP_NE=39, 
		OP_LE=40, OP_GE=41, ATRIB=42, MENOR=43, MAIOR=44, ATRIB_SUM=45, INCREMENT=46, 
		DECREMENT=47, ATRIB_SUB=48, OP_AND=49, OP_OR=50, LAZY_AND=51, LAZY_OR=52, 
		OP_SUM=53, OP_SUB=54, PAR_ESQ=55, PAR_DIR=56, KEY_ESQ=57, KEY_DIR=58, 
		SEMICOL=59, COMMA=60, COLON=61, ASP=62, ID=63, REAL=64, NUM=65, STRING_LITERAL=66, 
		COMENTARIO=67, WS=68;
	public static final int
		RULE_programa = 0, RULE_startBlock = 1, RULE_endBlock = 2, RULE_funcao = 3, 
		RULE_parametros = 4, RULE_parametro = 5, RULE_listaComandos = 6, RULE_comando = 7, 
		RULE_declaracao = 8, RULE_atribuicao = 9, RULE_tipo = 10, RULE_comandoIf = 11, 
		RULE_comandoWhile = 12, RULE_comandoFor = 13, RULE_incremento = 14, RULE_comandoSwitch = 15, 
		RULE_casoBloco = 16, RULE_defaultBloco = 17, RULE_comandoTryCatch = 18, 
		RULE_comandoIO = 19, RULE_expressao = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "startBlock", "endBlock", "funcao", "parametros", "parametro", 
			"listaComandos", "comando", "declaracao", "atribuicao", "tipo", "comandoIf", 
			"comandoWhile", "comandoFor", "incremento", "comandoSwitch", "casoBloco", 
			"defaultBloco", "comandoTryCatch", "comandoIO", "expressao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'switch'", "'case'", "'break'", "'return'", 
			"'continue'", "'start'", "'end'", "'main'", "'model'", "'for'", "'do'", 
			"'while'", "'void'", "'int'", "'float'", "'double'", "'char'", "'string'", 
			"'bool'", "'array'", "'try'", "'catch'", "'input'", "'output'", "'list'", 
			"'queue'", "'stack'", "'tree'", "'complex'", "'result'", "'option'", 
			"'match'", "'default'", "'true'", "'false'", "'=='", "'!='", "'<='", 
			"'>='", "'='", "'<'", "'>'", "'+='", "'++'", "'--'", "'-='", "'&&'", 
			"'||'", "'&'", "'|'", "'+'", "'-'", "'('", "')'", "'{'", "'}'", "';'", 
			"','", "':'", "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "SWITCH", "CASE", "BREAK", "RETURN", "CONTINUE", 
			"START", "END", "MAIN", "MODEL", "FOR", "DO", "WHILE", "VOID", "INT", 
			"FLOAT", "DOUBLE", "CHAR", "STRING", "BOOL", "ARRAY", "TRY", "CATCH", 
			"INPUT", "OUTPUT", "LIST", "QUEUE", "STACK", "TREE", "COMPLEX", "RESULT", 
			"OPTION", "MATCH", "DEFAULT", "TRUE", "FALSE", "OP_EQ", "OP_NE", "OP_LE", 
			"OP_GE", "ATRIB", "MENOR", "MAIOR", "ATRIB_SUM", "INCREMENT", "DECREMENT", 
			"ATRIB_SUB", "OP_AND", "OP_OR", "LAZY_AND", "LAZY_OR", "OP_SUM", "OP_SUB", 
			"PAR_ESQ", "PAR_DIR", "KEY_ESQ", "KEY_DIR", "SEMICOL", "COMMA", "COLON", 
			"ASP", "ID", "REAL", "NUM", "STRING_LITERAL", "COMENTARIO", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Teora.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TeoraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TeoraParser.EOF, 0); }
		public StartBlockContext startBlock() {
			return getRuleContext(StartBlockContext.class,0);
		}
		public List<ListaComandosContext> listaComandos() {
			return getRuleContexts(ListaComandosContext.class);
		}
		public ListaComandosContext listaComandos(int i) {
			return getRuleContext(ListaComandosContext.class,i);
		}
		public List<FuncaoContext> funcao() {
			return getRuleContexts(FuncaoContext.class);
		}
		public FuncaoContext funcao(int i) {
			return getRuleContext(FuncaoContext.class,i);
		}
		public EndBlockContext endBlock() {
			return getRuleContext(EndBlockContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(42);
				startBlock();
				}
				break;
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9187343033559944950L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 7L) != 0)) {
				{
				setState(47);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
				case SWITCH:
				case FOR:
				case DO:
				case WHILE:
				case VOID:
				case INT:
				case FLOAT:
				case DOUBLE:
				case CHAR:
				case STRING:
				case BOOL:
				case ARRAY:
				case TRY:
				case INPUT:
				case OUTPUT:
				case TRUE:
				case FALSE:
				case PAR_ESQ:
				case ID:
				case REAL:
				case NUM:
				case STRING_LITERAL:
					{
					setState(45);
					listaComandos();
					}
					break;
				case START:
					{
					setState(46);
					funcao();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY_DIR) {
				{
				setState(52);
				endBlock();
				}
			}

			setState(55);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartBlockContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(TeoraParser.START, 0); }
		public TerminalNode MAIN() { return getToken(TeoraParser.MAIN, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode KEY_ESQ() { return getToken(TeoraParser.KEY_ESQ, 0); }
		public StartBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterStartBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitStartBlock(this);
		}
	}

	public final StartBlockContext startBlock() throws RecognitionException {
		StartBlockContext _localctx = new StartBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_startBlock);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(START);
				setState(58);
				match(MAIN);
				setState(59);
				match(PAR_ESQ);
				setState(60);
				match(PAR_DIR);
				setState(61);
				match(KEY_ESQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(START);
				setState(63);
				match(KEY_ESQ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndBlockContext extends ParserRuleContext {
		public TerminalNode KEY_DIR() { return getToken(TeoraParser.KEY_DIR, 0); }
		public EndBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterEndBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitEndBlock(this);
		}
	}

	public final EndBlockContext endBlock() throws RecognitionException {
		EndBlockContext _localctx = new EndBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_endBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(KEY_DIR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncaoContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(TeoraParser.START, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode KEY_ESQ() { return getToken(TeoraParser.KEY_ESQ, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode KEY_DIR() { return getToken(TeoraParser.KEY_DIR, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitFuncao(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(START);
			setState(69);
			tipo();
			setState(70);
			match(ID);
			setState(71);
			match(PAR_ESQ);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4161536L) != 0)) {
				{
				setState(72);
				parametros();
				}
			}

			setState(75);
			match(PAR_DIR);
			setState(76);
			match(KEY_ESQ);
			setState(77);
			listaComandos();
			setState(78);
			match(KEY_DIR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TeoraParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TeoraParser.COMMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitParametros(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			parametro();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(81);
				match(COMMA);
				setState(82);
				parametro();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitParametro(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			tipo();
			setState(89);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ListaComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaComandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterListaComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitListaComandos(this);
		}
	}

	public final ListaComandosContext listaComandos() throws RecognitionException {
		ListaComandosContext _localctx = new ListaComandosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listaComandos);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(91);
					comando();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ComandoIfContext comandoIf() {
			return getRuleContext(ComandoIfContext.class,0);
		}
		public ComandoWhileContext comandoWhile() {
			return getRuleContext(ComandoWhileContext.class,0);
		}
		public ComandoForContext comandoFor() {
			return getRuleContext(ComandoForContext.class,0);
		}
		public ComandoSwitchContext comandoSwitch() {
			return getRuleContext(ComandoSwitchContext.class,0);
		}
		public ComandoTryCatchContext comandoTryCatch() {
			return getRuleContext(ComandoTryCatchContext.class,0);
		}
		public ComandoIOContext comandoIO() {
			return getRuleContext(ComandoIOContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comando);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				declaracao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				atribuicao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				comandoIf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				comandoWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				comandoFor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
				comandoSwitch();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				comandoTryCatch();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(103);
				comandoIO();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(104);
				expressao(0);
				setState(105);
				match(SEMICOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public TerminalNode ATRIB() { return getToken(TeoraParser.ATRIB, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ARRAY() { return getToken(TeoraParser.ARRAY, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracao);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case STRING:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				tipo();
				setState(110);
				match(ID);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ATRIB) {
					{
					setState(111);
					match(ATRIB);
					setState(112);
					expressao(0);
					}
				}

				setState(115);
				match(SEMICOL);
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(ARRAY);
				setState(118);
				match(ID);
				setState(119);
				match(SEMICOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public TerminalNode ATRIB() { return getToken(TeoraParser.ATRIB, 0); }
		public TerminalNode ATRIB_SUM() { return getToken(TeoraParser.ATRIB_SUM, 0); }
		public TerminalNode ATRIB_SUB() { return getToken(TeoraParser.ATRIB_SUB, 0); }
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitAtribuicao(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atribuicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 321057395310592L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(124);
			expressao(0);
			setState(125);
			match(SEMICOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TeoraParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TeoraParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(TeoraParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(TeoraParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(TeoraParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(TeoraParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(TeoraParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4161536L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TeoraParser.IF, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public List<TerminalNode> KEY_ESQ() { return getTokens(TeoraParser.KEY_ESQ); }
		public TerminalNode KEY_ESQ(int i) {
			return getToken(TeoraParser.KEY_ESQ, i);
		}
		public List<ListaComandosContext> listaComandos() {
			return getRuleContexts(ListaComandosContext.class);
		}
		public ListaComandosContext listaComandos(int i) {
			return getRuleContext(ListaComandosContext.class,i);
		}
		public List<TerminalNode> KEY_DIR() { return getTokens(TeoraParser.KEY_DIR); }
		public TerminalNode KEY_DIR(int i) {
			return getToken(TeoraParser.KEY_DIR, i);
		}
		public TerminalNode ELSE() { return getToken(TeoraParser.ELSE, 0); }
		public ComandoIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoIf(this);
		}
	}

	public final ComandoIfContext comandoIf() throws RecognitionException {
		ComandoIfContext _localctx = new ComandoIfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comandoIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(IF);
			setState(130);
			match(PAR_ESQ);
			setState(131);
			expressao(0);
			setState(132);
			match(PAR_DIR);
			setState(133);
			match(KEY_ESQ);
			setState(134);
			listaComandos();
			setState(135);
			match(KEY_DIR);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(136);
				match(ELSE);
				setState(137);
				match(KEY_ESQ);
				setState(138);
				listaComandos();
				setState(139);
				match(KEY_DIR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TeoraParser.WHILE, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode KEY_ESQ() { return getToken(TeoraParser.KEY_ESQ, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode KEY_DIR() { return getToken(TeoraParser.KEY_DIR, 0); }
		public TerminalNode DO() { return getToken(TeoraParser.DO, 0); }
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public ComandoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoWhile(this);
		}
	}

	public final ComandoWhileContext comandoWhile() throws RecognitionException {
		ComandoWhileContext _localctx = new ComandoWhileContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_comandoWhile);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(WHILE);
				setState(144);
				match(PAR_ESQ);
				setState(145);
				expressao(0);
				setState(146);
				match(PAR_DIR);
				setState(147);
				match(KEY_ESQ);
				setState(148);
				listaComandos();
				setState(149);
				match(KEY_DIR);
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(DO);
				setState(152);
				match(KEY_ESQ);
				setState(153);
				listaComandos();
				setState(154);
				match(KEY_DIR);
				setState(155);
				match(WHILE);
				setState(156);
				match(PAR_ESQ);
				setState(157);
				expressao(0);
				setState(158);
				match(PAR_DIR);
				setState(159);
				match(SEMICOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(TeoraParser.FOR, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public IncrementoContext incremento() {
			return getRuleContext(IncrementoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode KEY_ESQ() { return getToken(TeoraParser.KEY_ESQ, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode KEY_DIR() { return getToken(TeoraParser.KEY_DIR, 0); }
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ComandoForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoFor(this);
		}
	}

	public final ComandoForContext comandoFor() throws RecognitionException {
		ComandoForContext _localctx = new ComandoForContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comandoFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(FOR);
			setState(164);
			match(PAR_ESQ);
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR:
			case STRING:
			case BOOL:
			case ARRAY:
				{
				setState(165);
				declaracao();
				}
				break;
			case ID:
				{
				setState(166);
				atribuicao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			expressao(0);
			setState(170);
			match(SEMICOL);
			setState(171);
			incremento();
			setState(172);
			match(PAR_DIR);
			setState(173);
			match(KEY_ESQ);
			setState(174);
			listaComandos();
			setState(175);
			match(KEY_DIR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode INCREMENT() { return getToken(TeoraParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(TeoraParser.DECREMENT, 0); }
		public IncrementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incremento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterIncremento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitIncremento(this);
		}
	}

	public final IncrementoContext incremento() throws RecognitionException {
		IncrementoContext _localctx = new IncrementoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_incremento);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(ID);
				setState(178);
				match(INCREMENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(ID);
				setState(180);
				match(DECREMENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoSwitchContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(TeoraParser.SWITCH, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode KEY_ESQ() { return getToken(TeoraParser.KEY_ESQ, 0); }
		public TerminalNode KEY_DIR() { return getToken(TeoraParser.KEY_DIR, 0); }
		public List<CasoBlocoContext> casoBloco() {
			return getRuleContexts(CasoBlocoContext.class);
		}
		public CasoBlocoContext casoBloco(int i) {
			return getRuleContext(CasoBlocoContext.class,i);
		}
		public DefaultBlocoContext defaultBloco() {
			return getRuleContext(DefaultBlocoContext.class,0);
		}
		public ComandoSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoSwitch(this);
		}
	}

	public final ComandoSwitchContext comandoSwitch() throws RecognitionException {
		ComandoSwitchContext _localctx = new ComandoSwitchContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(SWITCH);
			setState(184);
			match(PAR_ESQ);
			setState(185);
			match(ID);
			setState(186);
			match(PAR_DIR);
			setState(187);
			match(KEY_ESQ);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				casoBloco();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE );
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(193);
				defaultBloco();
				}
			}

			setState(196);
			match(KEY_DIR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CasoBlocoContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(TeoraParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(TeoraParser.COLON, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(TeoraParser.BREAK, 0); }
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public TerminalNode NUM() { return getToken(TeoraParser.NUM, 0); }
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public CasoBlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_casoBloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterCasoBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitCasoBloco(this);
		}
	}

	public final CasoBlocoContext casoBloco() throws RecognitionException {
		CasoBlocoContext _localctx = new CasoBlocoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_casoBloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(CASE);
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(200);
			match(COLON);
			setState(201);
			listaComandos();
			setState(202);
			match(BREAK);
			setState(203);
			match(SEMICOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultBlocoContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(TeoraParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(TeoraParser.COLON, 0); }
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public DefaultBlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterDefaultBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitDefaultBloco(this);
		}
	}

	public final DefaultBlocoContext defaultBloco() throws RecognitionException {
		DefaultBlocoContext _localctx = new DefaultBlocoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_defaultBloco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(DEFAULT);
			setState(206);
			match(COLON);
			setState(207);
			listaComandos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoTryCatchContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(TeoraParser.TRY, 0); }
		public List<TerminalNode> KEY_ESQ() { return getTokens(TeoraParser.KEY_ESQ); }
		public TerminalNode KEY_ESQ(int i) {
			return getToken(TeoraParser.KEY_ESQ, i);
		}
		public List<ListaComandosContext> listaComandos() {
			return getRuleContexts(ListaComandosContext.class);
		}
		public ListaComandosContext listaComandos(int i) {
			return getRuleContext(ListaComandosContext.class,i);
		}
		public List<TerminalNode> KEY_DIR() { return getTokens(TeoraParser.KEY_DIR); }
		public TerminalNode KEY_DIR(int i) {
			return getToken(TeoraParser.KEY_DIR, i);
		}
		public TerminalNode CATCH() { return getToken(TeoraParser.CATCH, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public ComandoTryCatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoTryCatch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoTryCatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoTryCatch(this);
		}
	}

	public final ComandoTryCatchContext comandoTryCatch() throws RecognitionException {
		ComandoTryCatchContext _localctx = new ComandoTryCatchContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comandoTryCatch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(TRY);
			setState(210);
			match(KEY_ESQ);
			setState(211);
			listaComandos();
			setState(212);
			match(KEY_DIR);
			setState(213);
			match(CATCH);
			setState(214);
			match(PAR_ESQ);
			setState(215);
			match(ID);
			setState(216);
			match(PAR_DIR);
			setState(217);
			match(KEY_ESQ);
			setState(218);
			listaComandos();
			setState(219);
			match(KEY_DIR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoIOContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(TeoraParser.OUTPUT, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public TerminalNode INPUT() { return getToken(TeoraParser.INPUT, 0); }
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public ComandoIOContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoIO; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoIO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoIO(this);
		}
	}

	public final ComandoIOContext comandoIO() throws RecognitionException {
		ComandoIOContext _localctx = new ComandoIOContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_comandoIO);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OUTPUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(OUTPUT);
				setState(222);
				match(PAR_ESQ);
				setState(223);
				expressao(0);
				setState(224);
				match(PAR_DIR);
				setState(225);
				match(SEMICOL);
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(INPUT);
				setState(228);
				match(PAR_ESQ);
				setState(229);
				match(ID);
				setState(230);
				match(PAR_DIR);
				setState(231);
				match(SEMICOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode OP_AND() { return getToken(TeoraParser.OP_AND, 0); }
		public AndExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitAndExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExprContext extends ExpressaoContext {
		public TerminalNode STRING_LITERAL() { return getToken(TeoraParser.STRING_LITERAL, 0); }
		public StringExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitStringExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueExprContext extends ExpressaoContext {
		public TerminalNode TRUE() { return getToken(TeoraParser.TRUE, 0); }
		public TrueExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitTrueExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpressaoContext {
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public IdExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitIdExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExprContext extends ExpressaoContext {
		public TerminalNode NUM() { return getToken(TeoraParser.NUM, 0); }
		public NumExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitNumExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode OP_EQ() { return getToken(TeoraParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(TeoraParser.OP_NE, 0); }
		public TerminalNode MAIOR() { return getToken(TeoraParser.MAIOR, 0); }
		public TerminalNode MENOR() { return getToken(TeoraParser.MENOR, 0); }
		public TerminalNode OP_LE() { return getToken(TeoraParser.OP_LE, 0); }
		public TerminalNode OP_GE() { return getToken(TeoraParser.OP_GE, 0); }
		public RelExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitRelExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExprContext extends ExpressaoContext {
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public ParExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitParExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode OP_SUM() { return getToken(TeoraParser.OP_SUM, 0); }
		public TerminalNode OP_SUB() { return getToken(TeoraParser.OP_SUB, 0); }
		public AddExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitAddExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncDecExprContext extends ExpressaoContext {
		public TerminalNode ID() { return getToken(TeoraParser.ID, 0); }
		public TerminalNode INCREMENT() { return getToken(TeoraParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(TeoraParser.DECREMENT, 0); }
		public IncDecExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterIncDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitIncDecExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RealExprContext extends ExpressaoContext {
		public TerminalNode REAL() { return getToken(TeoraParser.REAL, 0); }
		public RealExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterRealExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitRealExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode OP_OR() { return getToken(TeoraParser.OP_OR, 0); }
		public OrExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitOrExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseExprContext extends ExpressaoContext {
		public TerminalNode FALSE() { return getToken(TeoraParser.FALSE, 0); }
		public FalseExprContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitFalseExpr(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expressao, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(235);
				match(ID);
				setState(236);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(PAR_ESQ);
				setState(238);
				expressao(0);
				setState(239);
				match(PAR_DIR);
				}
				break;
			case 3:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(NUM);
				}
				break;
			case 5:
				{
				_localctx = new RealExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				match(REAL);
				}
				break;
			case 6:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(TRUE);
				}
				break;
			case 8:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(261);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new OrExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(249);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(250);
						match(OP_OR);
						setState(251);
						expressao(13);
						}
						break;
					case 2:
						{
						_localctx = new AndExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(252);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(253);
						match(OP_AND);
						setState(254);
						expressao(12);
						}
						break;
					case 3:
						{
						_localctx = new RelExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(255);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(256);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30511447670784L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(257);
						expressao(11);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(258);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(259);
						_la = _input.LA(1);
						if ( !(_la==OP_SUM || _la==OP_SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(260);
						expressao(10);
						}
						break;
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001D\u010b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0003\u0000"+
		",\b\u0000\u0001\u0000\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0003\u00006\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004T\b\u0004\n\u0004\f\u0004W\t\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006]\b\u0006\u000b"+
		"\u0006\f\u0006^\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007l\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\br\b"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\by\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008e\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00a2\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a8\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b6\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u00be"+
		"\b\u000f\u000b\u000f\f\u000f\u00bf\u0001\u000f\u0003\u000f\u00c3\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00e9\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00f8\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0106\b\u0014\n\u0014\f\u0014\u0109\t\u0014\u0001\u0014\u0000\u0001("+
		"\u0015\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(\u0000\u0006\u0003\u0000**--00\u0001\u0000\u000f"+
		"\u0015\u0002\u0000??AA\u0001\u0000./\u0002\u0000&)+,\u0001\u000056\u0119"+
		"\u0000+\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004B"+
		"\u0001\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\bP\u0001\u0000"+
		"\u0000\u0000\nX\u0001\u0000\u0000\u0000\f\\\u0001\u0000\u0000\u0000\u000e"+
		"k\u0001\u0000\u0000\u0000\u0010x\u0001\u0000\u0000\u0000\u0012z\u0001"+
		"\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000\u0000\u0016\u0081\u0001"+
		"\u0000\u0000\u0000\u0018\u00a1\u0001\u0000\u0000\u0000\u001a\u00a3\u0001"+
		"\u0000\u0000\u0000\u001c\u00b5\u0001\u0000\u0000\u0000\u001e\u00b7\u0001"+
		"\u0000\u0000\u0000 \u00c6\u0001\u0000\u0000\u0000\"\u00cd\u0001\u0000"+
		"\u0000\u0000$\u00d1\u0001\u0000\u0000\u0000&\u00e8\u0001\u0000\u0000\u0000"+
		"(\u00f7\u0001\u0000\u0000\u0000*,\u0003\u0002\u0001\u0000+*\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,1\u0001\u0000\u0000\u0000-0\u0003"+
		"\f\u0006\u0000.0\u0003\u0006\u0003\u0000/-\u0001\u0000\u0000\u0000/.\u0001"+
		"\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u0000"+
		"12\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000"+
		"\u000046\u0003\u0004\u0002\u000054\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000078\u0005\u0000\u0000\u00018\u0001"+
		"\u0001\u0000\u0000\u00009:\u0005\b\u0000\u0000:;\u0005\n\u0000\u0000;"+
		"<\u00057\u0000\u0000<=\u00058\u0000\u0000=A\u00059\u0000\u0000>?\u0005"+
		"\b\u0000\u0000?A\u00059\u0000\u0000@9\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000A\u0003\u0001\u0000\u0000\u0000BC\u0005:\u0000\u0000"+
		"C\u0005\u0001\u0000\u0000\u0000DE\u0005\b\u0000\u0000EF\u0003\u0014\n"+
		"\u0000FG\u0005?\u0000\u0000GI\u00057\u0000\u0000HJ\u0003\b\u0004\u0000"+
		"IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000KL\u00058\u0000\u0000LM\u00059\u0000\u0000MN\u0003\f\u0006\u0000"+
		"NO\u0005:\u0000\u0000O\u0007\u0001\u0000\u0000\u0000PU\u0003\n\u0005\u0000"+
		"QR\u0005<\u0000\u0000RT\u0003\n\u0005\u0000SQ\u0001\u0000\u0000\u0000"+
		"TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000V\t\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0003\u0014"+
		"\n\u0000YZ\u0005?\u0000\u0000Z\u000b\u0001\u0000\u0000\u0000[]\u0003\u000e"+
		"\u0007\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\r\u0001\u0000\u0000\u0000"+
		"`l\u0003\u0010\b\u0000al\u0003\u0012\t\u0000bl\u0003\u0016\u000b\u0000"+
		"cl\u0003\u0018\f\u0000dl\u0003\u001a\r\u0000el\u0003\u001e\u000f\u0000"+
		"fl\u0003$\u0012\u0000gl\u0003&\u0013\u0000hi\u0003(\u0014\u0000ij\u0005"+
		";\u0000\u0000jl\u0001\u0000\u0000\u0000k`\u0001\u0000\u0000\u0000ka\u0001"+
		"\u0000\u0000\u0000kb\u0001\u0000\u0000\u0000kc\u0001\u0000\u0000\u0000"+
		"kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kf\u0001\u0000\u0000"+
		"\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000l\u000f\u0001"+
		"\u0000\u0000\u0000mn\u0003\u0014\n\u0000nq\u0005?\u0000\u0000op\u0005"+
		"*\u0000\u0000pr\u0003(\u0014\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005;\u0000\u0000ty\u0001\u0000"+
		"\u0000\u0000uv\u0005\u0016\u0000\u0000vw\u0005?\u0000\u0000wy\u0005;\u0000"+
		"\u0000xm\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000\u0000y\u0011\u0001"+
		"\u0000\u0000\u0000z{\u0005?\u0000\u0000{|\u0007\u0000\u0000\u0000|}\u0003"+
		"(\u0014\u0000}~\u0005;\u0000\u0000~\u0013\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0007\u0001\u0000\u0000\u0080\u0015\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005\u0001\u0000\u0000\u0082\u0083\u00057\u0000\u0000\u0083\u0084"+
		"\u0003(\u0014\u0000\u0084\u0085\u00058\u0000\u0000\u0085\u0086\u00059"+
		"\u0000\u0000\u0086\u0087\u0003\f\u0006\u0000\u0087\u008d\u0005:\u0000"+
		"\u0000\u0088\u0089\u0005\u0002\u0000\u0000\u0089\u008a\u00059\u0000\u0000"+
		"\u008a\u008b\u0003\f\u0006\u0000\u008b\u008c\u0005:\u0000\u0000\u008c"+
		"\u008e\u0001\u0000\u0000\u0000\u008d\u0088\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0001\u0000\u0000\u0000\u008e\u0017\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005\u000e\u0000\u0000\u0090\u0091\u00057\u0000\u0000\u0091\u0092"+
		"\u0003(\u0014\u0000\u0092\u0093\u00058\u0000\u0000\u0093\u0094\u00059"+
		"\u0000\u0000\u0094\u0095\u0003\f\u0006\u0000\u0095\u0096\u0005:\u0000"+
		"\u0000\u0096\u00a2\u0001\u0000\u0000\u0000\u0097\u0098\u0005\r\u0000\u0000"+
		"\u0098\u0099\u00059\u0000\u0000\u0099\u009a\u0003\f\u0006\u0000\u009a"+
		"\u009b\u0005:\u0000\u0000\u009b\u009c\u0005\u000e\u0000\u0000\u009c\u009d"+
		"\u00057\u0000\u0000\u009d\u009e\u0003(\u0014\u0000\u009e\u009f\u00058"+
		"\u0000\u0000\u009f\u00a0\u0005;\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a1\u008f\u0001\u0000\u0000\u0000\u00a1\u0097\u0001\u0000\u0000"+
		"\u0000\u00a2\u0019\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\f\u0000\u0000"+
		"\u00a4\u00a7\u00057\u0000\u0000\u00a5\u00a8\u0003\u0010\b\u0000\u00a6"+
		"\u00a8\u0003\u0012\t\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0003(\u0014\u0000\u00aa\u00ab\u0005;\u0000\u0000\u00ab\u00ac\u0003\u001c"+
		"\u000e\u0000\u00ac\u00ad\u00058\u0000\u0000\u00ad\u00ae\u00059\u0000\u0000"+
		"\u00ae\u00af\u0003\f\u0006\u0000\u00af\u00b0\u0005:\u0000\u0000\u00b0"+
		"\u001b\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005?\u0000\u0000\u00b2\u00b6"+
		"\u0005.\u0000\u0000\u00b3\u00b4\u0005?\u0000\u0000\u00b4\u00b6\u0005/"+
		"\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b6\u001d\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0003"+
		"\u0000\u0000\u00b8\u00b9\u00057\u0000\u0000\u00b9\u00ba\u0005?\u0000\u0000"+
		"\u00ba\u00bb\u00058\u0000\u0000\u00bb\u00bd\u00059\u0000\u0000\u00bc\u00be"+
		"\u0003 \u0010\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00c3\u0003"+
		"\"\u0011\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005:\u0000"+
		"\u0000\u00c5\u001f\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0004\u0000"+
		"\u0000\u00c7\u00c8\u0007\u0002\u0000\u0000\u00c8\u00c9\u0005=\u0000\u0000"+
		"\u00c9\u00ca\u0003\f\u0006\u0000\u00ca\u00cb\u0005\u0005\u0000\u0000\u00cb"+
		"\u00cc\u0005;\u0000\u0000\u00cc!\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005"+
		"#\u0000\u0000\u00ce\u00cf\u0005=\u0000\u0000\u00cf\u00d0\u0003\f\u0006"+
		"\u0000\u00d0#\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\u0017\u0000\u0000"+
		"\u00d2\u00d3\u00059\u0000\u0000\u00d3\u00d4\u0003\f\u0006\u0000\u00d4"+
		"\u00d5\u0005:\u0000\u0000\u00d5\u00d6\u0005\u0018\u0000\u0000\u00d6\u00d7"+
		"\u00057\u0000\u0000\u00d7\u00d8\u0005?\u0000\u0000\u00d8\u00d9\u00058"+
		"\u0000\u0000\u00d9\u00da\u00059\u0000\u0000\u00da\u00db\u0003\f\u0006"+
		"\u0000\u00db\u00dc\u0005:\u0000\u0000\u00dc%\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0005\u001a\u0000\u0000\u00de\u00df\u00057\u0000\u0000\u00df\u00e0"+
		"\u0003(\u0014\u0000\u00e0\u00e1\u00058\u0000\u0000\u00e1\u00e2\u0005;"+
		"\u0000\u0000\u00e2\u00e9\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0019"+
		"\u0000\u0000\u00e4\u00e5\u00057\u0000\u0000\u00e5\u00e6\u0005?\u0000\u0000"+
		"\u00e6\u00e7\u00058\u0000\u0000\u00e7\u00e9\u0005;\u0000\u0000\u00e8\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e3\u0001\u0000\u0000\u0000\u00e9\'\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0006\u0014\uffff\uffff\u0000\u00eb\u00ec"+
		"\u0005?\u0000\u0000\u00ec\u00f8\u0007\u0003\u0000\u0000\u00ed\u00ee\u0005"+
		"7\u0000\u0000\u00ee\u00ef\u0003(\u0014\u0000\u00ef\u00f0\u00058\u0000"+
		"\u0000\u00f0\u00f8\u0001\u0000\u0000\u0000\u00f1\u00f8\u0005?\u0000\u0000"+
		"\u00f2\u00f8\u0005A\u0000\u0000\u00f3\u00f8\u0005@\u0000\u0000\u00f4\u00f8"+
		"\u0005B\u0000\u0000\u00f5\u00f8\u0005$\u0000\u0000\u00f6\u00f8\u0005%"+
		"\u0000\u0000\u00f7\u00ea\u0001\u0000\u0000\u0000\u00f7\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f1\u0001\u0000\u0000\u0000\u00f7\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f3\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u0107\u0001\u0000\u0000\u0000\u00f9\u00fa\n\f\u0000"+
		"\u0000\u00fa\u00fb\u00052\u0000\u0000\u00fb\u0106\u0003(\u0014\r\u00fc"+
		"\u00fd\n\u000b\u0000\u0000\u00fd\u00fe\u00051\u0000\u0000\u00fe\u0106"+
		"\u0003(\u0014\f\u00ff\u0100\n\n\u0000\u0000\u0100\u0101\u0007\u0004\u0000"+
		"\u0000\u0101\u0106\u0003(\u0014\u000b\u0102\u0103\n\t\u0000\u0000\u0103"+
		"\u0104\u0007\u0005\u0000\u0000\u0104\u0106\u0003(\u0014\n\u0105\u00f9"+
		"\u0001\u0000\u0000\u0000\u0105\u00fc\u0001\u0000\u0000\u0000\u0105\u00ff"+
		"\u0001\u0000\u0000\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0106\u0109"+
		"\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0001\u0000\u0000\u0000\u0108)\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0015+/15@IU^kqx\u008d\u00a1\u00a7\u00b5\u00bf\u00c2"+
		"\u00e8\u00f7\u0105\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}