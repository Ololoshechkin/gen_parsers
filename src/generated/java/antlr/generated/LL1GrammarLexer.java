// Generated from LL1Grammar.g4 by ANTLR 4.5.3
package antlr.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LL1GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, OR=13, ARROW=14, NON_TERMINAL=15, TERMINAL=16, 
		REGEX=17, STRING=18, CODE=19, NUMBER=20, OPERATOR=21, Whitespace=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "OR", "ARROW", "NON_TERMINAL", "TERMINAL", "REGEX", 
		"STRING", "Schar", "CODE", "NUMBER", "NONZERODIGIT", "DIGIT", "OPERATOR", 
		"Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", "'0'", "'null'", "'['", "']'", 
		"'.'", "'$'", "'_id_'", "'|'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "OR", "ARROW", "NON_TERMINAL", "TERMINAL", "REGEX", "STRING", "CODE", 
		"NUMBER", "OPERATOR", "Whitespace"
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


	public LL1GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LL1Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\7\20Z\n\20\f\20\16\20]\13\20\3\21\3\21\7"+
		"\21a\n\21\f\21\16\21d\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\7"+
		"\23n\n\23\f\23\16\23q\13\23\3\23\3\23\3\24\3\24\3\25\3\25\6\25y\n\25\r"+
		"\25\16\25z\3\25\5\25~\n\25\7\25\u0080\n\25\f\25\16\25\u0083\13\25\3\25"+
		"\3\25\3\26\3\26\7\26\u0089\n\26\f\26\16\26\u008c\13\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\6\32\u0095\n\32\r\32\16\32\u0096\3\32\3\32\2\2\33"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\2)\25+\26-\2/\2\61\27\63\30\3\2\13\3\2c|\6\2\62;"+
		"C\\aac|\3\2C\\\6\2\f\f\17\17$$^^\4\2}}\177\177\3\2\63;\3\2\62;\5\2,-/"+
		"/\61\61\4\2\13\f\"\"\u009e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13="+
		"\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25J\3\2\2\2\27"+
		"L\3\2\2\2\31N\3\2\2\2\33S\3\2\2\2\35U\3\2\2\2\37W\3\2\2\2!^\3\2\2\2#e"+
		"\3\2\2\2%k\3\2\2\2\'t\3\2\2\2)v\3\2\2\2+\u0086\3\2\2\2-\u008d\3\2\2\2"+
		"/\u008f\3\2\2\2\61\u0091\3\2\2\2\63\u0094\3\2\2\2\65\66\7=\2\2\66\4\3"+
		"\2\2\2\678\7*\2\28\6\3\2\2\29:\7+\2\2:\b\3\2\2\2;<\7.\2\2<\n\3\2\2\2="+
		">\7?\2\2>\f\3\2\2\2?@\7\62\2\2@\16\3\2\2\2AB\7p\2\2BC\7w\2\2CD\7n\2\2"+
		"DE\7n\2\2E\20\3\2\2\2FG\7]\2\2G\22\3\2\2\2HI\7_\2\2I\24\3\2\2\2JK\7\60"+
		"\2\2K\26\3\2\2\2LM\7&\2\2M\30\3\2\2\2NO\7a\2\2OP\7k\2\2PQ\7f\2\2QR\7a"+
		"\2\2R\32\3\2\2\2ST\7~\2\2T\34\3\2\2\2UV\7<\2\2V\36\3\2\2\2W[\t\2\2\2X"+
		"Z\t\3\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\ \3\2\2\2][\3\2\2"+
		"\2^b\t\4\2\2_a\t\3\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\"\3\2"+
		"\2\2db\3\2\2\2ef\7t\2\2fg\7g\2\2gh\7i\2\2hi\3\2\2\2ij\5%\23\2j$\3\2\2"+
		"\2ko\7$\2\2ln\5\'\24\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2"+
		"\2qo\3\2\2\2rs\7$\2\2s&\3\2\2\2tu\n\5\2\2u(\3\2\2\2v\u0081\7}\2\2wy\n"+
		"\6\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|~\5)\25\2}|\3"+
		"\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177x\3\2\2\2\u0080\u0083\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2"+
		"\2\u0084\u0085\7\177\2\2\u0085*\3\2\2\2\u0086\u008a\5-\27\2\u0087\u0089"+
		"\5/\30\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b,\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\t\7\2\2"+
		"\u008e.\3\2\2\2\u008f\u0090\t\b\2\2\u0090\60\3\2\2\2\u0091\u0092\t\t\2"+
		"\2\u0092\62\3\2\2\2\u0093\u0095\t\n\2\2\u0094\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\b\32\2\2\u0099\64\3\2\2\2\13\2[boz}\u0081\u008a\u0096\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}