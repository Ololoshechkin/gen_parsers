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
		REGEX=17, STRING=18, CODE=19, NUMBER=20, OPERATOR=21, EPSILON=22, Whitespace=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "OR", "ARROW", "NON_TERMINAL", "TERMINAL", "REGEX", 
		"STRING", "Schar", "CODE", "NUMBER", "NONZERODIGIT", "DIGIT", "OPERATOR", 
		"EPSILON", "Whitespace"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20\\\n\20\f\20\16\20_\13\20\3"+
		"\21\3\21\7\21c\n\21\f\21\16\21f\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\7\23p\n\23\f\23\16\23s\13\23\3\23\3\23\3\24\3\24\3\25\3\25\6"+
		"\25{\n\25\r\25\16\25|\3\25\5\25\u0080\n\25\7\25\u0082\n\25\f\25\16\25"+
		"\u0085\13\25\3\25\3\25\3\26\3\26\7\26\u008b\n\26\f\26\16\26\u008e\13\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\6\33\u009b\n\33"+
		"\r\33\16\33\u009c\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\26-\2/\2"+
		"\61\27\63\30\65\31\3\2\13\3\2c|\6\2\62;C\\aac|\3\2C\\\6\2\f\f\17\17$$"+
		"^^\4\2}}\177\177\3\2\63;\3\2\62;\5\2,-//\61\61\4\2\13\f\"\"\u00a4\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2"+
		"\2\17C\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31P\3\2"+
		"\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3\2\2\2!`\3\2\2\2#g\3\2\2\2%m\3\2\2\2"+
		"\'v\3\2\2\2)x\3\2\2\2+\u0088\3\2\2\2-\u008f\3\2\2\2/\u0091\3\2\2\2\61"+
		"\u0093\3\2\2\2\63\u0095\3\2\2\2\65\u009a\3\2\2\2\678\7=\2\28\4\3\2\2\2"+
		"9:\7*\2\2:\6\3\2\2\2;<\7+\2\2<\b\3\2\2\2=>\7.\2\2>\n\3\2\2\2?@\7?\2\2"+
		"@\f\3\2\2\2AB\7\62\2\2B\16\3\2\2\2CD\7p\2\2DE\7w\2\2EF\7n\2\2FG\7n\2\2"+
		"G\20\3\2\2\2HI\7]\2\2I\22\3\2\2\2JK\7_\2\2K\24\3\2\2\2LM\7\60\2\2M\26"+
		"\3\2\2\2NO\7&\2\2O\30\3\2\2\2PQ\7a\2\2QR\7k\2\2RS\7f\2\2ST\7a\2\2T\32"+
		"\3\2\2\2UV\7~\2\2V\34\3\2\2\2WX\7<\2\2X\36\3\2\2\2Y]\t\2\2\2Z\\\t\3\2"+
		"\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^ \3\2\2\2_]\3\2\2\2`d\t\4"+
		"\2\2ac\t\3\2\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\"\3\2\2\2fd\3"+
		"\2\2\2gh\7t\2\2hi\7g\2\2ij\7i\2\2jk\3\2\2\2kl\5%\23\2l$\3\2\2\2mq\7$\2"+
		"\2np\5\'\24\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2"+
		"\2\2tu\7$\2\2u&\3\2\2\2vw\n\5\2\2w(\3\2\2\2x\u0083\7}\2\2y{\n\6\2\2zy"+
		"\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080\5)\25\2\177"+
		"~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081z\3\2\2\2\u0082\u0085"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\7\177\2\2\u0087*\3\2\2\2\u0088\u008c\5-\27"+
		"\2\u0089\u008b\5/\30\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d,\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0090\t\7\2\2\u0090.\3\2\2\2\u0091\u0092\t\b\2\2\u0092\60\3\2\2\2\u0093"+
		"\u0094\t\t\2\2\u0094\62\3\2\2\2\u0095\u0096\7G\2\2\u0096\u0097\7R\2\2"+
		"\u0097\u0098\7U\2\2\u0098\64\3\2\2\2\u0099\u009b\t\n\2\2\u009a\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\b\33\2\2\u009f\66\3\2\2\2\13\2]dq|\177\u0083"+
		"\u008c\u009c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}