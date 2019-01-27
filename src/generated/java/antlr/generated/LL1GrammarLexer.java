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
		T__9=10, T__10=11, T__11=12, T__12=13, OR=14, ARROW=15, NON_TERMINAL=16, 
		TERMINAL=17, REGEX=18, STRING=19, CODE=20, NUMBER=21, OPERATOR=22, Whitespace=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "OR", "ARROW", "NON_TERMINAL", "TERMINAL", 
		"REGEX", "STRING", "Schar", "CODE", "NUMBER", "NONZERODIGIT", "DIGIT", 
		"OPERATOR", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'='", "'null'", "'true'", "'false'", 
		"'['", "']'", "'.'", "'$'", "'_id_'", "'|'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "OR", "ARROW", "NON_TERMINAL", "TERMINAL", "REGEX", "STRING", 
		"CODE", "NUMBER", "OPERATOR", "Whitespace"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\7\21e\n\21\f\21\16\21h\13\21\3\22\3\22\7\22l\n\22\f\22\16\22"+
		"o\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24y\n\24\f\24\16\24"+
		"|\13\24\3\24\3\24\3\25\3\25\3\26\3\26\6\26\u0084\n\26\r\26\16\26\u0085"+
		"\3\26\5\26\u0089\n\26\7\26\u008b\n\26\f\26\16\26\u008e\13\26\3\26\3\26"+
		"\3\27\3\27\7\27\u0094\n\27\f\27\16\27\u0097\13\27\3\27\5\27\u009a\n\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\6\33\u00a3\n\33\r\33\16\33\u00a4\3"+
		"\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\26-\27/\2\61\2\63\30\65\31"+
		"\3\2\13\3\2c|\6\2\62;C\\aac|\3\2C\\\6\2\f\f\17\17$$^^\4\2}}\177\177\3"+
		"\2\63;\3\2\62;\5\2,-//\61\61\4\2\13\f\"\"\u00ad\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5"+
		"9\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17F\3\2\2\2\21"+
		"K\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31W\3\2\2\2\33Y\3\2\2\2"+
		"\35^\3\2\2\2\37`\3\2\2\2!b\3\2\2\2#i\3\2\2\2%p\3\2\2\2\'v\3\2\2\2)\177"+
		"\3\2\2\2+\u0081\3\2\2\2-\u0099\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2"+
		"\63\u009f\3\2\2\2\65\u00a2\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7*\2\2:\6\3"+
		"\2\2\2;<\7+\2\2<\b\3\2\2\2=>\7.\2\2>\n\3\2\2\2?@\7?\2\2@\f\3\2\2\2AB\7"+
		"p\2\2BC\7w\2\2CD\7n\2\2DE\7n\2\2E\16\3\2\2\2FG\7v\2\2GH\7t\2\2HI\7w\2"+
		"\2IJ\7g\2\2J\20\3\2\2\2KL\7h\2\2LM\7c\2\2MN\7n\2\2NO\7u\2\2OP\7g\2\2P"+
		"\22\3\2\2\2QR\7]\2\2R\24\3\2\2\2ST\7_\2\2T\26\3\2\2\2UV\7\60\2\2V\30\3"+
		"\2\2\2WX\7&\2\2X\32\3\2\2\2YZ\7a\2\2Z[\7k\2\2[\\\7f\2\2\\]\7a\2\2]\34"+
		"\3\2\2\2^_\7~\2\2_\36\3\2\2\2`a\7<\2\2a \3\2\2\2bf\t\2\2\2ce\t\3\2\2d"+
		"c\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\"\3\2\2\2hf\3\2\2\2im\t\4\2\2"+
		"jl\t\3\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n$\3\2\2\2om\3\2\2\2"+
		"pq\7t\2\2qr\7g\2\2rs\7i\2\2st\3\2\2\2tu\5\'\24\2u&\3\2\2\2vz\7$\2\2wy"+
		"\5)\25\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}"+
		"~\7$\2\2~(\3\2\2\2\177\u0080\n\5\2\2\u0080*\3\2\2\2\u0081\u008c\7}\2\2"+
		"\u0082\u0084\n\6\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\5+\26\2\u0088"+
		"\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0083\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\177\2\2\u0090,\3\2\2"+
		"\2\u0091\u0095\5/\30\2\u0092\u0094\5\61\31\2\u0093\u0092\3\2\2\2\u0094"+
		"\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0098\u009a\7\62\2\2\u0099\u0091\3\2\2\2\u0099"+
		"\u0098\3\2\2\2\u009a.\3\2\2\2\u009b\u009c\t\7\2\2\u009c\60\3\2\2\2\u009d"+
		"\u009e\t\b\2\2\u009e\62\3\2\2\2\u009f\u00a0\t\t\2\2\u00a0\64\3\2\2\2\u00a1"+
		"\u00a3\t\n\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\33\2\2\u00a7"+
		"\66\3\2\2\2\f\2fmz\u0085\u0088\u008c\u0095\u0099\u00a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}