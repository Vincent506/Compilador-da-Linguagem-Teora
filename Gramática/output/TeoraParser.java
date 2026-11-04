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
		IF=1, ELSE=2, WHILE=3, FOR=4, INT=5, FLOAT=6, DOUBLE=7, BOOL=8, OUTPUT=9, 
		TRUE=10, FALSE=11, OP_EQ=12, OP_NE=13, OP_LE=14, OP_GE=15, MAIOR=16, MENOR=17, 
		ATRIB=18, ATRIB_SUM=19, ATRIB_SUB=20, OP_AND=21, OP_OR=22, INCREMENT=23, 
		DECREMENT=24, OP_SUM=25, OP_SUB=26, PAR_ESQ=27, PAR_DIR=28, KEY_ESQ=29, 
		KEY_DIR=30, SEMICOL=31, COMMA=32, ID=33, REAL=34, NUM=35, WS=36;
	public static final int
		RULE_programa = 0, RULE_listaComandos = 1, RULE_comando = 2, RULE_declaracao = 3, 
		RULE_atribuicao = 4, RULE_tipo = 5, RULE_comandoIf = 6, RULE_comandoWhile = 7, 
		RULE_comandoFor = 8, RULE_incremento = 9, RULE_comandoOutput = 10, RULE_expressao = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "listaComandos", "comando", "declaracao", "atribuicao", "tipo", 
			"comandoIf", "comandoWhile", "comandoFor", "incremento", "comandoOutput", 
			"expressao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'while'", "'for'", "'int'", "'float'", "'double'", 
			"'bool'", "'output'", "'true'", "'false'", "'=='", "'!='", "'<='", "'>='", 
			"'>'", "'<'", "'='", "'+='", "'-='", "'&&'", "'||'", "'++'", "'--'", 
			"'+'", "'-'", "'('", "')'", "'{'", "'}'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "WHILE", "FOR", "INT", "FLOAT", "DOUBLE", "BOOL", 
			"OUTPUT", "TRUE", "FALSE", "OP_EQ", "OP_NE", "OP_LE", "OP_GE", "MAIOR", 
			"MENOR", "ATRIB", "ATRIB_SUM", "ATRIB_SUB", "OP_AND", "OP_OR", "INCREMENT", 
			"DECREMENT", "OP_SUM", "OP_SUB", "PAR_ESQ", "PAR_DIR", "KEY_ESQ", "KEY_DIR", 
			"SEMICOL", "COMMA", "ID", "REAL", "NUM", "WS"
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
		public ListaComandosContext listaComandos() {
			return getRuleContext(ListaComandosContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TeoraParser.EOF, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			listaComandos();
			setState(25);
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
		enterRule(_localctx, 2, RULE_listaComandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				comando();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 60263763962L) != 0) );
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
		public ComandoOutputContext comandoOutput() {
			return getRuleContext(ComandoOutputContext.class,0);
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
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				declaracao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				atribuicao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				comandoIf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				comandoWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				comandoFor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(37);
				comandoOutput();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(38);
				expressao(0);
				setState(39);
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
		enterRule(_localctx, 6, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			tipo();
			setState(44);
			match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATRIB) {
				{
				setState(45);
				match(ATRIB);
				setState(46);
				expressao(0);
				}
			}

			setState(49);
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
		enterRule(_localctx, 8, RULE_atribuicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ID);
			setState(52);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(53);
			expressao(0);
			setState(54);
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
		public TerminalNode BOOL() { return getToken(TeoraParser.BOOL, 0); }
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
		enterRule(_localctx, 10, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_comandoIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IF);
			setState(59);
			match(PAR_ESQ);
			setState(60);
			expressao(0);
			setState(61);
			match(PAR_DIR);
			setState(62);
			match(KEY_ESQ);
			setState(63);
			listaComandos();
			setState(64);
			match(KEY_DIR);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(65);
				match(ELSE);
				setState(66);
				match(KEY_ESQ);
				setState(67);
				listaComandos();
				setState(68);
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
		enterRule(_localctx, 14, RULE_comandoWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(WHILE);
			setState(73);
			match(PAR_ESQ);
			setState(74);
			expressao(0);
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
		enterRule(_localctx, 16, RULE_comandoFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(FOR);
			setState(81);
			match(PAR_ESQ);
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case BOOL:
				{
				setState(82);
				declaracao();
				}
				break;
			case ID:
				{
				setState(83);
				atribuicao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(86);
			expressao(0);
			setState(87);
			match(SEMICOL);
			setState(88);
			incremento();
			setState(89);
			match(PAR_DIR);
			setState(90);
			match(KEY_ESQ);
			setState(91);
			listaComandos();
			setState(92);
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
		enterRule(_localctx, 18, RULE_incremento);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(ID);
				setState(95);
				match(INCREMENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(ID);
				setState(97);
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
	public static class ComandoOutputContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(TeoraParser.OUTPUT, 0); }
		public TerminalNode PAR_ESQ() { return getToken(TeoraParser.PAR_ESQ, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PAR_DIR() { return getToken(TeoraParser.PAR_DIR, 0); }
		public TerminalNode SEMICOL() { return getToken(TeoraParser.SEMICOL, 0); }
		public ComandoOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).enterComandoOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TeoraListener ) ((TeoraListener)listener).exitComandoOutput(this);
		}
	}

	public final ComandoOutputContext comandoOutput() throws RecognitionException {
		ComandoOutputContext _localctx = new ComandoOutputContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comandoOutput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(OUTPUT);
			setState(101);
			match(PAR_ESQ);
			setState(102);
			expressao(0);
			setState(103);
			match(PAR_DIR);
			setState(104);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expressao, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(107);
				match(ID);
				setState(108);
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
				setState(109);
				match(PAR_ESQ);
				setState(110);
				expressao(0);
				setState(111);
				match(PAR_DIR);
				}
				break;
			case 3:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(NUM);
				}
				break;
			case 5:
				{
				_localctx = new RealExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(REAL);
				}
				break;
			case 6:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(TRUE);
				}
				break;
			case 7:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new OrExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(120);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(121);
						match(OP_OR);
						setState(122);
						expressao(12);
						}
						break;
					case 2:
						{
						_localctx = new AndExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(123);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(124);
						match(OP_AND);
						setState(125);
						expressao(11);
						}
						break;
					case 3:
						{
						_localctx = new RelExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(126);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(127);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						expressao(10);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(129);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(130);
						_la = _input.LA(1);
						if ( !(_la==OP_SUM || _la==OP_SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(131);
						expressao(9);
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		case 11:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u008a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u001d\b\u0001\u000b"+
		"\u0001\f\u0001\u001e\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002*\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00030\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006G\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bU\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tc\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000bw\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0085\b\u000b\n\u000b"+
		"\f\u000b\u0088\t\u000b\u0001\u000b\u0000\u0001\u0016\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0005\u0001\u0000\u0012"+
		"\u0014\u0001\u0000\u0005\b\u0001\u0000\u0017\u0018\u0001\u0000\f\u0011"+
		"\u0001\u0000\u0019\u001a\u0092\u0000\u0018\u0001\u0000\u0000\u0000\u0002"+
		"\u001c\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006+\u0001"+
		"\u0000\u0000\u0000\b3\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000"+
		"\f:\u0001\u0000\u0000\u0000\u000eH\u0001\u0000\u0000\u0000\u0010P\u0001"+
		"\u0000\u0000\u0000\u0012b\u0001\u0000\u0000\u0000\u0014d\u0001\u0000\u0000"+
		"\u0000\u0016v\u0001\u0000\u0000\u0000\u0018\u0019\u0003\u0002\u0001\u0000"+
		"\u0019\u001a\u0005\u0000\u0000\u0001\u001a\u0001\u0001\u0000\u0000\u0000"+
		"\u001b\u001d\u0003\u0004\u0002\u0000\u001c\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u0003\u0001\u0000\u0000\u0000"+
		" *\u0003\u0006\u0003\u0000!*\u0003\b\u0004\u0000\"*\u0003\f\u0006\u0000"+
		"#*\u0003\u000e\u0007\u0000$*\u0003\u0010\b\u0000%*\u0003\u0014\n\u0000"+
		"&\'\u0003\u0016\u000b\u0000\'(\u0005\u001f\u0000\u0000(*\u0001\u0000\u0000"+
		"\u0000) \u0001\u0000\u0000\u0000)!\u0001\u0000\u0000\u0000)\"\u0001\u0000"+
		"\u0000\u0000)#\u0001\u0000\u0000\u0000)$\u0001\u0000\u0000\u0000)%\u0001"+
		"\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000*\u0005\u0001\u0000\u0000"+
		"\u0000+,\u0003\n\u0005\u0000,/\u0005!\u0000\u0000-.\u0005\u0012\u0000"+
		"\u0000.0\u0003\u0016\u000b\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000012\u0005\u001f\u0000\u00002\u0007"+
		"\u0001\u0000\u0000\u000034\u0005!\u0000\u000045\u0007\u0000\u0000\u0000"+
		"56\u0003\u0016\u000b\u000067\u0005\u001f\u0000\u00007\t\u0001\u0000\u0000"+
		"\u000089\u0007\u0001\u0000\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005"+
		"\u0001\u0000\u0000;<\u0005\u001b\u0000\u0000<=\u0003\u0016\u000b\u0000"+
		"=>\u0005\u001c\u0000\u0000>?\u0005\u001d\u0000\u0000?@\u0003\u0002\u0001"+
		"\u0000@F\u0005\u001e\u0000\u0000AB\u0005\u0002\u0000\u0000BC\u0005\u001d"+
		"\u0000\u0000CD\u0003\u0002\u0001\u0000DE\u0005\u001e\u0000\u0000EG\u0001"+
		"\u0000\u0000\u0000FA\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\r\u0001\u0000\u0000\u0000HI\u0005\u0003\u0000\u0000IJ\u0005\u001b\u0000"+
		"\u0000JK\u0003\u0016\u000b\u0000KL\u0005\u001c\u0000\u0000LM\u0005\u001d"+
		"\u0000\u0000MN\u0003\u0002\u0001\u0000NO\u0005\u001e\u0000\u0000O\u000f"+
		"\u0001\u0000\u0000\u0000PQ\u0005\u0004\u0000\u0000QT\u0005\u001b\u0000"+
		"\u0000RU\u0003\u0006\u0003\u0000SU\u0003\b\u0004\u0000TR\u0001\u0000\u0000"+
		"\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0003\u0016"+
		"\u000b\u0000WX\u0005\u001f\u0000\u0000XY\u0003\u0012\t\u0000YZ\u0005\u001c"+
		"\u0000\u0000Z[\u0005\u001d\u0000\u0000[\\\u0003\u0002\u0001\u0000\\]\u0005"+
		"\u001e\u0000\u0000]\u0011\u0001\u0000\u0000\u0000^_\u0005!\u0000\u0000"+
		"_c\u0005\u0017\u0000\u0000`a\u0005!\u0000\u0000ac\u0005\u0018\u0000\u0000"+
		"b^\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000c\u0013\u0001\u0000"+
		"\u0000\u0000de\u0005\t\u0000\u0000ef\u0005\u001b\u0000\u0000fg\u0003\u0016"+
		"\u000b\u0000gh\u0005\u001c\u0000\u0000hi\u0005\u001f\u0000\u0000i\u0015"+
		"\u0001\u0000\u0000\u0000jk\u0006\u000b\uffff\uffff\u0000kl\u0005!\u0000"+
		"\u0000lw\u0007\u0002\u0000\u0000mn\u0005\u001b\u0000\u0000no\u0003\u0016"+
		"\u000b\u0000op\u0005\u001c\u0000\u0000pw\u0001\u0000\u0000\u0000qw\u0005"+
		"!\u0000\u0000rw\u0005#\u0000\u0000sw\u0005\"\u0000\u0000tw\u0005\n\u0000"+
		"\u0000uw\u0005\u000b\u0000\u0000vj\u0001\u0000\u0000\u0000vm\u0001\u0000"+
		"\u0000\u0000vq\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000vs\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"w\u0086\u0001\u0000\u0000\u0000xy\n\u000b\u0000\u0000yz\u0005\u0016\u0000"+
		"\u0000z\u0085\u0003\u0016\u000b\f{|\n\n\u0000\u0000|}\u0005\u0015\u0000"+
		"\u0000}\u0085\u0003\u0016\u000b\u000b~\u007f\n\t\u0000\u0000\u007f\u0080"+
		"\u0007\u0003\u0000\u0000\u0080\u0085\u0003\u0016\u000b\n\u0081\u0082\n"+
		"\b\u0000\u0000\u0082\u0083\u0007\u0004\u0000\u0000\u0083\u0085\u0003\u0016"+
		"\u000b\t\u0084x\u0001\u0000\u0000\u0000\u0084{\u0001\u0000\u0000\u0000"+
		"\u0084~\u0001\u0000\u0000\u0000\u0084\u0081\u0001\u0000\u0000\u0000\u0085"+
		"\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0017\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\t\u001e)/FTbv\u0084\u0086";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}