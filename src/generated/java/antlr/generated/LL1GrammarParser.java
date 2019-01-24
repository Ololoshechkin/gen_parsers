// Generated from LL1Grammar.g4 by ANTLR 4.5.3
package antlr.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LL1GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, OR=13, ARROW=14, NON_TERMINAL=15, TERMINAL=16, 
		REGEX=17, STRING=18, CODE=19, NUMBER=20, OPERATOR=21, EPSILON=22, Whitespace=23;
	public static final int
		RULE_ruleset = 0, RULE_ruleStatement = 1, RULE_nonTerminalRule = 2, RULE_terminalRule = 3, 
		RULE_simpleAttributes = 4, RULE_inheritedAttributes = 5, RULE_attributeList = 6, 
		RULE_attribute = 7, RULE_varName = 8, RULE_type = 9, RULE_initialValue = 10, 
		RULE_nonTerminal = 11, RULE_terminal = 12, RULE_nonTerminalOptionList = 13, 
		RULE_nonTerminalOption = 14, RULE_sequence = 15, RULE_sequenceItem = 16, 
		RULE_namedArg = 17, RULE_inheritedValues = 18, RULE_initializer = 19, 
		RULE_varValue = 20, RULE_variable = 21, RULE_literal = 22, RULE_code = 23, 
		RULE_terminalOptionList = 24, RULE_terminalOption = 25, RULE_identifier = 26;
	public static final String[] ruleNames = {
		"ruleset", "ruleStatement", "nonTerminalRule", "terminalRule", "simpleAttributes", 
		"inheritedAttributes", "attributeList", "attribute", "varName", "type", 
		"initialValue", "nonTerminal", "terminal", "nonTerminalOptionList", "nonTerminalOption", 
		"sequence", "sequenceItem", "namedArg", "inheritedValues", "initializer", 
		"varValue", "variable", "literal", "code", "terminalOptionList", "terminalOption", 
		"identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", "'0'", "'null'", "'['", "']'", 
		"'.'", "'$'", "'_id_'", "'|'", "':'", null, null, null, null, null, null, 
		null, "'EPS'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "OR", "ARROW", "NON_TERMINAL", "TERMINAL", "REGEX", "STRING", "CODE", 
		"NUMBER", "OPERATOR", "EPSILON", "Whitespace"
	};
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
	public String getGrammarFileName() { return "LL1Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LL1GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RulesetContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LL1GrammarParser.EOF, 0); }
		public List<RuleStatementContext> ruleStatement() {
			return getRuleContexts(RuleStatementContext.class);
		}
		public RuleStatementContext ruleStatement(int i) {
			return getRuleContext(RuleStatementContext.class,i);
		}
		public RulesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterRuleset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitRuleset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitRuleset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesetContext ruleset() throws RecognitionException {
		RulesetContext _localctx = new RulesetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ruleset);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << NON_TERMINAL) | (1L << TERMINAL) | (1L << EPSILON))) != 0)) {
				{
				{
				setState(54);
				ruleStatement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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

	public static class RuleStatementContext extends ParserRuleContext {
		public NonTerminalRuleContext nonTerminalRule() {
			return getRuleContext(NonTerminalRuleContext.class,0);
		}
		public TerminalRuleContext terminalRule() {
			return getRuleContext(TerminalRuleContext.class,0);
		}
		public RuleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterRuleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitRuleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitRuleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleStatementContext ruleStatement() throws RecognitionException {
		RuleStatementContext _localctx = new RuleStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ruleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			switch (_input.LA(1)) {
			case T__1:
			case NON_TERMINAL:
				{
				setState(62);
				nonTerminalRule();
				}
				break;
			case TERMINAL:
			case EPSILON:
				{
				setState(63);
				terminalRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(66);
			match(T__0);
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

	public static class NonTerminalRuleContext extends ParserRuleContext {
		public NonTerminalContext nonTerminal() {
			return getRuleContext(NonTerminalContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(LL1GrammarParser.ARROW, 0); }
		public NonTerminalOptionListContext nonTerminalOptionList() {
			return getRuleContext(NonTerminalOptionListContext.class,0);
		}
		public SimpleAttributesContext simpleAttributes() {
			return getRuleContext(SimpleAttributesContext.class,0);
		}
		public InheritedAttributesContext inheritedAttributes() {
			return getRuleContext(InheritedAttributesContext.class,0);
		}
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterNonTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitNonTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitNonTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTerminalRuleContext nonTerminalRule() throws RecognitionException {
		NonTerminalRuleContext _localctx = new NonTerminalRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nonTerminalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(68);
				simpleAttributes();
				}
			}

			setState(71);
			nonTerminal();
			setState(73);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(72);
				inheritedAttributes();
				}
			}

			setState(75);
			match(ARROW);
			setState(76);
			nonTerminalOptionList();
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

	public static class TerminalRuleContext extends ParserRuleContext {
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(LL1GrammarParser.ARROW, 0); }
		public TerminalOptionListContext terminalOptionList() {
			return getRuleContext(TerminalOptionListContext.class,0);
		}
		public TerminalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalRuleContext terminalRule() throws RecognitionException {
		TerminalRuleContext _localctx = new TerminalRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_terminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			terminal();
			setState(79);
			match(ARROW);
			setState(80);
			terminalOptionList();
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

	public static class SimpleAttributesContext extends ParserRuleContext {
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public SimpleAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterSimpleAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitSimpleAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitSimpleAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleAttributesContext simpleAttributes() throws RecognitionException {
		SimpleAttributesContext _localctx = new SimpleAttributesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleAttributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__1);
			setState(83);
			attributeList();
			setState(84);
			match(T__2);
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

	public static class InheritedAttributesContext extends ParserRuleContext {
		public AttributeListContext attributeList() {
			return getRuleContext(AttributeListContext.class,0);
		}
		public InheritedAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritedAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterInheritedAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitInheritedAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitInheritedAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritedAttributesContext inheritedAttributes() throws RecognitionException {
		InheritedAttributesContext _localctx = new InheritedAttributesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inheritedAttributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__1);
			setState(87);
			attributeList();
			setState(88);
			match(T__2);
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

	public static class AttributeListContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public AttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeListContext attributeList() throws RecognitionException {
		AttributeListContext _localctx = new AttributeListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attributeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			attribute();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(91);
				match(T__3);
				setState(92);
				attribute();
				}
				}
				setState(97);
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

	public static class AttributeContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitialValueContext initialValue() {
			return getRuleContext(InitialValueContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			varName();
			setState(99);
			match(ARROW);
			setState(100);
			type();
			setState(102);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(101);
				initialValue();
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

	public static class VarNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			identifier();
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

	public static class TypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			identifier();
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

	public static class InitialValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LL1GrammarParser.STRING, 0); }
		public InitialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterInitialValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitInitialValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitInitialValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialValueContext initialValue() throws RecognitionException {
		InitialValueContext _localctx = new InitialValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initialValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__4);
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NonTerminalContext extends ParserRuleContext {
		public TerminalNode NON_TERMINAL() { return getToken(LL1GrammarParser.NON_TERMINAL, 0); }
		public NonTerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterNonTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitNonTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitNonTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTerminalContext nonTerminal() throws RecognitionException {
		NonTerminalContext _localctx = new NonTerminalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nonTerminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(NON_TERMINAL);
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

	public static class TerminalContext extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(LL1GrammarParser.TERMINAL, 0); }
		public TerminalNode EPSILON() { return getToken(LL1GrammarParser.EPSILON, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !(_la==TERMINAL || _la==EPSILON) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NonTerminalOptionListContext extends ParserRuleContext {
		public List<NonTerminalOptionContext> nonTerminalOption() {
			return getRuleContexts(NonTerminalOptionContext.class);
		}
		public NonTerminalOptionContext nonTerminalOption(int i) {
			return getRuleContext(NonTerminalOptionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LL1GrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LL1GrammarParser.OR, i);
		}
		public NonTerminalOptionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalOptionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterNonTerminalOptionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitNonTerminalOptionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitNonTerminalOptionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTerminalOptionListContext nonTerminalOptionList() throws RecognitionException {
		NonTerminalOptionListContext _localctx = new NonTerminalOptionListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_nonTerminalOptionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			nonTerminalOption();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(116);
				match(OR);
				setState(117);
				nonTerminalOption();
				}
				}
				setState(122);
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

	public static class NonTerminalOptionContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public NonTerminalOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterNonTerminalOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitNonTerminalOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitNonTerminalOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonTerminalOptionContext nonTerminalOption() throws RecognitionException {
		NonTerminalOptionContext _localctx = new NonTerminalOptionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nonTerminalOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			sequence();
			setState(125);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(124);
				code();
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

	public static class SequenceContext extends ParserRuleContext {
		public List<SequenceItemContext> sequenceItem() {
			return getRuleContexts(SequenceItemContext.class);
		}
		public SequenceItemContext sequenceItem(int i) {
			return getRuleContext(SequenceItemContext.class,i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				sequenceItem();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERMINAL) | (1L << TERMINAL) | (1L << STRING) | (1L << EPSILON))) != 0) );
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

	public static class SequenceItemContext extends ParserRuleContext {
		public NonTerminalContext nonTerminal() {
			return getRuleContext(NonTerminalContext.class,0);
		}
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public NamedArgContext namedArg() {
			return getRuleContext(NamedArgContext.class,0);
		}
		public InheritedValuesContext inheritedValues() {
			return getRuleContext(InheritedValuesContext.class,0);
		}
		public SequenceItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterSequenceItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitSequenceItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitSequenceItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceItemContext sequenceItem() throws RecognitionException {
		SequenceItemContext _localctx = new SequenceItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sequenceItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			switch (_input.LA(1)) {
			case NON_TERMINAL:
				{
				setState(132);
				nonTerminal();
				}
				break;
			case TERMINAL:
			case EPSILON:
				{
				setState(133);
				terminal();
				}
				break;
			case STRING:
				{
				setState(134);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(138);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(137);
				namedArg();
				}
			}

			setState(141);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(140);
				inheritedValues();
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

	public static class NamedArgContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public NamedArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterNamedArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitNamedArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitNamedArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedArgContext namedArg() throws RecognitionException {
		NamedArgContext _localctx = new NamedArgContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_namedArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__7);
			setState(144);
			varName();
			setState(145);
			match(T__8);
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

	public static class InheritedValuesContext extends ParserRuleContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public InheritedValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritedValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterInheritedValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitInheritedValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitInheritedValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritedValuesContext inheritedValues() throws RecognitionException {
		InheritedValuesContext _localctx = new InheritedValuesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_inheritedValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__1);
			setState(148);
			initializer();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(149);
				match(T__3);
				setState(150);
				initializer();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__2);
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

	public static class InitializerContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			varName();
			setState(159);
			match(T__4);
			setState(160);
			varValue();
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

	public static class VarValueContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(LL1GrammarParser.OPERATOR, 0); }
		public List<VarValueContext> varValue() {
			return getRuleContexts(VarValueContext.class);
		}
		public VarValueContext varValue(int i) {
			return getRuleContext(VarValueContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitVarValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitVarValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varValue);
		int _la;
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				variable();
				setState(165);
				_la = _input.LA(1);
				if (_la==OPERATOR) {
					{
					setState(163);
					match(OPERATOR);
					setState(164);
					varValue();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				variable();
				setState(168);
				match(T__9);
				setState(169);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				identifier();
				setState(172);
				match(T__1);
				setState(173);
				varValue();
				setState(174);
				match(T__2);
				setState(177);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(175);
					match(T__9);
					setState(176);
					varValue();
					}
				}

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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(LL1GrammarParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(LL1GrammarParser.STRING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(181);
				match(NUMBER);
				}
				break;
			case T__6:
				{
				setState(182);
				match(T__6);
				}
				break;
			case STRING:
				{
				setState(183);
				match(STRING);
				}
				break;
			case T__10:
				{
				setState(184);
				match(T__10);
				setState(185);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LL1GrammarParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(STRING);
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(LL1GrammarParser.CODE, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(CODE);
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

	public static class TerminalOptionListContext extends ParserRuleContext {
		public List<TerminalOptionContext> terminalOption() {
			return getRuleContexts(TerminalOptionContext.class);
		}
		public TerminalOptionContext terminalOption(int i) {
			return getRuleContext(TerminalOptionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(LL1GrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(LL1GrammarParser.OR, i);
		}
		public TerminalOptionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalOptionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterTerminalOptionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitTerminalOptionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitTerminalOptionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalOptionListContext terminalOptionList() throws RecognitionException {
		TerminalOptionListContext _localctx = new TerminalOptionListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_terminalOptionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			terminalOption();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(193);
				match(OR);
				setState(194);
				terminalOption();
				}
				}
				setState(199);
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

	public static class TerminalOptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LL1GrammarParser.STRING, 0); }
		public TerminalNode REGEX() { return getToken(LL1GrammarParser.REGEX, 0); }
		public TerminalOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterTerminalOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitTerminalOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitTerminalOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalOptionContext terminalOption() throws RecognitionException {
		TerminalOptionContext _localctx = new TerminalOptionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_terminalOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << REGEX) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(LL1GrammarParser.TERMINAL, 0); }
		public TerminalNode NON_TERMINAL() { return getToken(LL1GrammarParser.NON_TERMINAL, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LL1GrammarListener ) ((LL1GrammarListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LL1GrammarVisitor ) return ((LL1GrammarVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !(_la==NON_TERMINAL || _la==TERMINAL) ) {
			_errHandler.recoverInline(this);
			} else {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00cf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3"+
		"\3\3\5\3C\n\3\3\3\3\3\3\4\5\4H\n\4\3\4\3\4\5\4L\n\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b`\n\b\f\b\16"+
		"\bc\13\b\3\t\3\t\3\t\3\t\5\ti\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\7\17y\n\17\f\17\16\17|\13\17\3\20\3\20\5\20"+
		"\u0080\n\20\3\21\6\21\u0083\n\21\r\21\16\21\u0084\3\22\3\22\3\22\5\22"+
		"\u008a\n\22\3\22\5\22\u008d\n\22\3\22\5\22\u0090\n\22\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\7\24\u009a\n\24\f\24\16\24\u009d\13\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u00a8\n\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00b4\n\26\5\26\u00b6\n\26\3"+
		"\27\3\27\3\27\3\27\3\27\5\27\u00bd\n\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\7\32\u00c6\n\32\f\32\16\32\u00c9\13\32\3\33\3\33\3\34\3\34\3\34"+
		"\2\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2"+
		"\6\4\2\b\t\24\24\4\2\22\22\30\30\4\2\16\16\23\24\3\2\21\22\u00c9\2;\3"+
		"\2\2\2\4B\3\2\2\2\6G\3\2\2\2\bP\3\2\2\2\nT\3\2\2\2\fX\3\2\2\2\16\\\3\2"+
		"\2\2\20d\3\2\2\2\22j\3\2\2\2\24l\3\2\2\2\26n\3\2\2\2\30q\3\2\2\2\32s\3"+
		"\2\2\2\34u\3\2\2\2\36}\3\2\2\2 \u0082\3\2\2\2\"\u0089\3\2\2\2$\u0091\3"+
		"\2\2\2&\u0095\3\2\2\2(\u00a0\3\2\2\2*\u00b5\3\2\2\2,\u00bc\3\2\2\2.\u00be"+
		"\3\2\2\2\60\u00c0\3\2\2\2\62\u00c2\3\2\2\2\64\u00ca\3\2\2\2\66\u00cc\3"+
		"\2\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3"+
		"\2\2\2>?\7\2\2\3?\3\3\2\2\2@C\5\6\4\2AC\5\b\5\2B@\3\2\2\2BA\3\2\2\2CD"+
		"\3\2\2\2DE\7\3\2\2E\5\3\2\2\2FH\5\n\6\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2"+
		"IK\5\30\r\2JL\5\f\7\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\20\2\2NO\5\34"+
		"\17\2O\7\3\2\2\2PQ\5\32\16\2QR\7\20\2\2RS\5\62\32\2S\t\3\2\2\2TU\7\4\2"+
		"\2UV\5\16\b\2VW\7\5\2\2W\13\3\2\2\2XY\7\4\2\2YZ\5\16\b\2Z[\7\5\2\2[\r"+
		"\3\2\2\2\\a\5\20\t\2]^\7\6\2\2^`\5\20\t\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2"+
		"\2ab\3\2\2\2b\17\3\2\2\2ca\3\2\2\2de\5\22\n\2ef\7\20\2\2fh\5\24\13\2g"+
		"i\5\26\f\2hg\3\2\2\2hi\3\2\2\2i\21\3\2\2\2jk\5\66\34\2k\23\3\2\2\2lm\5"+
		"\66\34\2m\25\3\2\2\2no\7\7\2\2op\t\2\2\2p\27\3\2\2\2qr\7\21\2\2r\31\3"+
		"\2\2\2st\t\3\2\2t\33\3\2\2\2uz\5\36\20\2vw\7\17\2\2wy\5\36\20\2xv\3\2"+
		"\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\35\3\2\2\2|z\3\2\2\2}\177\5 \21\2"+
		"~\u0080\5\60\31\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\37\3\2\2\2\u0081"+
		"\u0083\5\"\22\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085!\3\2\2\2\u0086\u008a\5\30\r\2\u0087\u008a"+
		"\5\32\16\2\u0088\u008a\5.\30\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u008d\5$\23\2\u008c\u008b"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0090\5&\24\2\u008f"+
		"\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090#\3\2\2\2\u0091\u0092\7\n\2\2"+
		"\u0092\u0093\5\22\n\2\u0093\u0094\7\13\2\2\u0094%\3\2\2\2\u0095\u0096"+
		"\7\4\2\2\u0096\u009b\5(\25\2\u0097\u0098\7\6\2\2\u0098\u009a\5(\25\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\5\2\2\u009f"+
		"\'\3\2\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\7\7\2\2\u00a2\u00a3\5*\26"+
		"\2\u00a3)\3\2\2\2\u00a4\u00a7\5,\27\2\u00a5\u00a6\7\27\2\2\u00a6\u00a8"+
		"\5*\26\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00b6\3\2\2\2\u00a9"+
		"\u00aa\5,\27\2\u00aa\u00ab\7\f\2\2\u00ab\u00ac\5*\26\2\u00ac\u00b6\3\2"+
		"\2\2\u00ad\u00ae\5\66\34\2\u00ae\u00af\7\4\2\2\u00af\u00b0\5*\26\2\u00b0"+
		"\u00b3\7\5\2\2\u00b1\u00b2\7\f\2\2\u00b2\u00b4\5*\26\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00a4\3\2\2\2\u00b5"+
		"\u00a9\3\2\2\2\u00b5\u00ad\3\2\2\2\u00b6+\3\2\2\2\u00b7\u00bd\7\26\2\2"+
		"\u00b8\u00bd\7\t\2\2\u00b9\u00bd\7\24\2\2\u00ba\u00bb\7\r\2\2\u00bb\u00bd"+
		"\5\66\34\2\u00bc\u00b7\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00b9\3\2\2\2"+
		"\u00bc\u00ba\3\2\2\2\u00bd-\3\2\2\2\u00be\u00bf\7\24\2\2\u00bf/\3\2\2"+
		"\2\u00c0\u00c1\7\25\2\2\u00c1\61\3\2\2\2\u00c2\u00c7\5\64\33\2\u00c3\u00c4"+
		"\7\17\2\2\u00c4\u00c6\5\64\33\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\63\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cb\t\4\2\2\u00cb\65\3\2\2\2\u00cc\u00cd\t\5\2\2\u00cd"+
		"\67\3\2\2\2\24;BGKahz\177\u0084\u0089\u008c\u008f\u009b\u00a7\u00b3\u00b5"+
		"\u00bc\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}