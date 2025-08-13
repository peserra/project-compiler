// Generated from /home/pserra/code/ufabc/compiladores/LangDef.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LangDefParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, OPEN_PARENTHESIS=5, CLOSE_PARENTHESIS=6, 
		SEMI_COLON=7, OPERATOR=8, ATTR=9, ID=10, NUMBER=11, WHITE_SPACE=12;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_cmdRead = 3, RULE_cmdWrite = 4, 
		RULE_cmdAttr = 5, RULE_expr = 6, RULE_term = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "cmdRead", "cmdWrite", "cmdAttr", "expr", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'endprog'", "'read'", "'write'", "'('", "')'", "';'", 
			null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", 
			"SEMI_COLON", "OPERATOR", "ATTR", "ID", "NUMBER", "WHITE_SPACE"
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
	public String getGrammarFileName() { return "LangDef.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangDefParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			bloco();
			setState(18);
			match(T__1);
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
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				cmd();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1048L) != 0) );
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
	public static class CmdContext extends ParserRuleContext {
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				cmdRead();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				cmdWrite();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				cmdAttr();
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
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(LangDefParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode ID() { return getToken(LangDefParser.ID, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(LangDefParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LangDefParser.SEMI_COLON, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__2);
			setState(31);
			match(OPEN_PARENTHESIS);
			setState(32);
			match(ID);
			setState(33);
			match(CLOSE_PARENTHESIS);
			setState(34);
			match(SEMI_COLON);
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
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(LangDefParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode ID() { return getToken(LangDefParser.ID, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(LangDefParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode SEMI_COLON() { return getToken(LangDefParser.SEMI_COLON, 0); }
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__3);
			setState(37);
			match(OPEN_PARENTHESIS);
			setState(38);
			match(ID);
			setState(39);
			match(CLOSE_PARENTHESIS);
			setState(40);
			match(SEMI_COLON);
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
	public static class CmdAttrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangDefParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(LangDefParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(LangDefParser.SEMI_COLON, 0); }
		public CmdAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr; }
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(ID);
			setState(43);
			match(ATTR);
			setState(44);
			expr();
			setState(45);
			match(SEMI_COLON);
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
	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> OPERATOR() { return getTokens(LangDefParser.OPERATOR); }
		public TerminalNode OPERATOR(int i) {
			return getToken(LangDefParser.OPERATOR, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			term();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPERATOR) {
				{
				{
				setState(48);
				match(OPERATOR);
				setState(49);
				term();
				}
				}
				setState(54);
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
	public static class TermContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangDefParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(LangDefParser.NUMBER, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\f:\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u0016"+
		"\b\u0001\u000b\u0001\f\u0001\u0017\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u001d\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u00063\b\u0006"+
		"\n\u0006\f\u00066\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0000\u0000"+
		"\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001\u0001\u0000\n\u000b"+
		"5\u0000\u0010\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000"+
		"\u0004\u001c\u0001\u0000\u0000\u0000\u0006\u001e\u0001\u0000\u0000\u0000"+
		"\b$\u0001\u0000\u0000\u0000\n*\u0001\u0000\u0000\u0000\f/\u0001\u0000"+
		"\u0000\u0000\u000e7\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000"+
		"\u0000\u0011\u0012\u0003\u0002\u0001\u0000\u0012\u0013\u0005\u0002\u0000"+
		"\u0000\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0016\u0003\u0004\u0002"+
		"\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000"+
		"\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u0003\u0001\u0000\u0000\u0000\u0019\u001d\u0003\u0006\u0003"+
		"\u0000\u001a\u001d\u0003\b\u0004\u0000\u001b\u001d\u0003\n\u0005\u0000"+
		"\u001c\u0019\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u001b\u0001\u0000\u0000\u0000\u001d\u0005\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005\u0003\u0000\u0000\u001f \u0005\u0005\u0000\u0000 !"+
		"\u0005\n\u0000\u0000!\"\u0005\u0006\u0000\u0000\"#\u0005\u0007\u0000\u0000"+
		"#\u0007\u0001\u0000\u0000\u0000$%\u0005\u0004\u0000\u0000%&\u0005\u0005"+
		"\u0000\u0000&\'\u0005\n\u0000\u0000\'(\u0005\u0006\u0000\u0000()\u0005"+
		"\u0007\u0000\u0000)\t\u0001\u0000\u0000\u0000*+\u0005\n\u0000\u0000+,"+
		"\u0005\t\u0000\u0000,-\u0003\f\u0006\u0000-.\u0005\u0007\u0000\u0000."+
		"\u000b\u0001\u0000\u0000\u0000/4\u0003\u000e\u0007\u000001\u0005\b\u0000"+
		"\u000013\u0003\u000e\u0007\u000020\u0001\u0000\u0000\u000036\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005\r\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0007\u0000\u0000\u0000"+
		"8\u000f\u0001\u0000\u0000\u0000\u0003\u0017\u001c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}