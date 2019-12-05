// Generated from ExprLexer.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR=1, FROM=2, TO=3, DO=4, ENDDO=5, STEP=6, IF=7, THEN=8, ELSE=9, ENDIF=10, 
		FUNCION=11, VOID=12, INCLUDE=13, BEGIN=14, END=15, NUMERO=16, CADENA=17, 
		WHILE=18, TRUE=19, FALSE=20, DEVOLVER=21, SWITCH=22, END_SWITCH=23, BREAK=24, 
		CASE=25, DEFAULT=26, IDENTIFICADOR=27, OPERACION=28, NEWLINE=29, INT=30, 
		FLOTANTE=31, STRING=32, MULT=33, DIV=34, SUM=35, RES=36, NOT=37, MENOR=38, 
		MAYOR=39, DISTINTO=40, IGUALES=41, IGUALDEASIGNACION=42, AND=43, OR=44, 
		DOSPUNTOS=45, COMA=46, PUNTOYCOMA=47, AB=48, CB=49, AP=50, CP=51, ESC=52, 
		COMENTARIOLINEA=53, COMENTARIOBLOQUE=54, WS=55;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FOR", "FROM", "TO", "DO", "ENDDO", "STEP", "IF", "THEN", "ELSE", "ENDIF", 
			"FUNCION", "VOID", "INCLUDE", "BEGIN", "END", "NUMERO", "CADENA", "WHILE", 
			"TRUE", "FALSE", "DEVOLVER", "SWITCH", "END_SWITCH", "BREAK", "CASE", 
			"DEFAULT", "IDENTIFICADOR", "OPERACION", "NEWLINE", "INT", "FLOTANTE", 
			"STRING", "MULT", "DIV", "SUM", "RES", "NOT", "MENOR", "MAYOR", "DISTINTO", 
			"IGUALES", "IGUALDEASIGNACION", "AND", "OR", "DOSPUNTOS", "COMA", "PUNTOYCOMA", 
			"AB", "CB", "AP", "CP", "ESC", "COMENTARIOLINEA", "COMENTARIOBLOQUE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'for'", "'from'", "'to'", "'do'", "'enddo'", "'step'", "'if'", 
			"'then'", "'else'", "'endif'", "'function'", "'void'", "'include'", "'begin'", 
			"'end'", "'numero'", "'cadena'", "'while'", "'true'", "'false'", "'devolver'", 
			"'switch'", "'endswitch'", "'break'", "'case'", "'default'", null, null, 
			null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'!'", "'<'", "'>'", 
			"'!='", "'=='", "':='", "'&&'", "'||'", "':'", "','", "';'", "'['", "']'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FOR", "FROM", "TO", "DO", "ENDDO", "STEP", "IF", "THEN", "ELSE", 
			"ENDIF", "FUNCION", "VOID", "INCLUDE", "BEGIN", "END", "NUMERO", "CADENA", 
			"WHILE", "TRUE", "FALSE", "DEVOLVER", "SWITCH", "END_SWITCH", "BREAK", 
			"CASE", "DEFAULT", "IDENTIFICADOR", "OPERACION", "NEWLINE", "INT", "FLOTANTE", 
			"STRING", "MULT", "DIV", "SUM", "RES", "NOT", "MENOR", "MAYOR", "DISTINTO", 
			"IGUALES", "IGUALDEASIGNACION", "AND", "OR", "DOSPUNTOS", "COMA", "PUNTOYCOMA", 
			"AB", "CB", "AP", "CP", "ESC", "COMENTARIOLINEA", "COMENTARIOBLOQUE", 
			"WS"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExprLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u018e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\7\34\u010d"+
		"\n\34\f\34\16\34\u0110\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\5\35\u011b\n\35\3\36\6\36\u011e\n\36\r\36\16\36\u011f\3\36\3\36\3"+
		"\37\6\37\u0125\n\37\r\37\16\37\u0126\3 \7 \u012a\n \f \16 \u012d\13 \3"+
		" \3 \6 \u0131\n \r \16 \u0132\3!\3!\3!\7!\u0138\n!\f!\16!\u013b\13!\3"+
		"!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3"+
		"+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0171\n\66"+
		"\f\66\16\66\u0174\13\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u017e"+
		"\n\67\f\67\16\67\u0181\13\67\3\67\3\67\3\67\3\67\3\67\38\68\u0189\n8\r"+
		"8\168\u018a\38\38\5\u0139\u0172\u017f\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9\3\2\7\5\2C\\aac|\6\2\62;C\\"+
		"aac|\4\2\f\f\17\17\3\2\62;\b\2$$^^ddppttvv\2\u0199\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3q\3\2\2"+
		"\2\5u\3\2\2\2\7z\3\2\2\2\t}\3\2\2\2\13\u0080\3\2\2\2\r\u0086\3\2\2\2\17"+
		"\u008b\3\2\2\2\21\u008e\3\2\2\2\23\u0093\3\2\2\2\25\u0098\3\2\2\2\27\u009e"+
		"\3\2\2\2\31\u00a7\3\2\2\2\33\u00ac\3\2\2\2\35\u00b4\3\2\2\2\37\u00ba\3"+
		"\2\2\2!\u00be\3\2\2\2#\u00c5\3\2\2\2%\u00cc\3\2\2\2\'\u00d2\3\2\2\2)\u00d7"+
		"\3\2\2\2+\u00dd\3\2\2\2-\u00e6\3\2\2\2/\u00ed\3\2\2\2\61\u00f7\3\2\2\2"+
		"\63\u00fd\3\2\2\2\65\u0102\3\2\2\2\67\u010a\3\2\2\29\u011a\3\2\2\2;\u011d"+
		"\3\2\2\2=\u0124\3\2\2\2?\u012b\3\2\2\2A\u0134\3\2\2\2C\u013e\3\2\2\2E"+
		"\u0140\3\2\2\2G\u0142\3\2\2\2I\u0144\3\2\2\2K\u0146\3\2\2\2M\u0148\3\2"+
		"\2\2O\u014a\3\2\2\2Q\u014c\3\2\2\2S\u014f\3\2\2\2U\u0152\3\2\2\2W\u0155"+
		"\3\2\2\2Y\u0158\3\2\2\2[\u015b\3\2\2\2]\u015d\3\2\2\2_\u015f\3\2\2\2a"+
		"\u0161\3\2\2\2c\u0163\3\2\2\2e\u0165\3\2\2\2g\u0167\3\2\2\2i\u0169\3\2"+
		"\2\2k\u016c\3\2\2\2m\u0179\3\2\2\2o\u0188\3\2\2\2qr\7h\2\2rs\7q\2\2st"+
		"\7t\2\2t\4\3\2\2\2uv\7h\2\2vw\7t\2\2wx\7q\2\2xy\7o\2\2y\6\3\2\2\2z{\7"+
		"v\2\2{|\7q\2\2|\b\3\2\2\2}~\7f\2\2~\177\7q\2\2\177\n\3\2\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7p\2\2\u0082\u0083\7f\2\2\u0083\u0084\7f\2\2\u0084"+
		"\u0085\7q\2\2\u0085\f\3\2\2\2\u0086\u0087\7u\2\2\u0087\u0088\7v\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008a\7r\2\2\u008a\16\3\2\2\2\u008b\u008c\7k\2\2\u008c"+
		"\u008d\7h\2\2\u008d\20\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7j\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7p\2\2\u0092\22\3\2\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097\24\3\2\2\2\u0098"+
		"\u0099\7g\2\2\u0099\u009a\7p\2\2\u009a\u009b\7f\2\2\u009b\u009c\7k\2\2"+
		"\u009c\u009d\7h\2\2\u009d\26\3\2\2\2\u009e\u009f\7h\2\2\u009f\u00a0\7"+
		"w\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7e\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4"+
		"\7k\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7p\2\2\u00a6\30\3\2\2\2\u00a7\u00a8"+
		"\7x\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7f\2\2\u00ab"+
		"\32\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7e\2\2\u00af"+
		"\u00b0\7n\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7f\2\2\u00b2\u00b3\7g\2\2"+
		"\u00b3\34\3\2\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7"+
		"i\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\36\3\2\2\2\u00ba\u00bb"+
		"\7g\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7f\2\2\u00bd \3\2\2\2\u00be\u00bf"+
		"\7p\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7o\2\2\u00c1\u00c2\7g\2\2\u00c2"+
		"\u00c3\7t\2\2\u00c3\u00c4\7q\2\2\u00c4\"\3\2\2\2\u00c5\u00c6\7e\2\2\u00c6"+
		"\u00c7\7c\2\2\u00c7\u00c8\7f\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7p\2\2"+
		"\u00ca\u00cb\7c\2\2\u00cb$\3\2\2\2\u00cc\u00cd\7y\2\2\u00cd\u00ce\7j\2"+
		"\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7g\2\2\u00d1&\3\2"+
		"\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6(\3\2\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da"+
		"\7n\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7g\2\2\u00dc*\3\2\2\2\u00dd\u00de"+
		"\7f\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7x\2\2\u00e0\u00e1\7q\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2\u00e3\7x\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7t\2\2"+
		"\u00e5,\3\2\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7y\2\2\u00e8\u00e9\7k\2"+
		"\2\u00e9\u00ea\7v\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7j\2\2\u00ec.\3\2"+
		"\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7f\2\2\u00f0\u00f1"+
		"\7u\2\2\u00f1\u00f2\7y\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00f5\7e\2\2\u00f5\u00f6\7j\2\2\u00f6\60\3\2\2\2\u00f7\u00f8\7d\2\2\u00f8"+
		"\u00f9\7t\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7m\2\2"+
		"\u00fc\62\3\2\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7"+
		"u\2\2\u0100\u0101\7g\2\2\u0101\64\3\2\2\2\u0102\u0103\7f\2\2\u0103\u0104"+
		"\7g\2\2\u0104\u0105\7h\2\2\u0105\u0106\7c\2\2\u0106\u0107\7w\2\2\u0107"+
		"\u0108\7n\2\2\u0108\u0109\7v\2\2\u0109\66\3\2\2\2\u010a\u010e\t\2\2\2"+
		"\u010b\u010d\t\3\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f8\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
		"\u0112\7e\2\2\u0112\u0113\7q\2\2\u0113\u011b\7u\2\2\u0114\u0115\7u\2\2"+
		"\u0115\u0116\7g\2\2\u0116\u011b\7p\2\2\u0117\u0118\7v\2\2\u0118\u0119"+
		"\7c\2\2\u0119\u011b\7p\2\2\u011a\u0111\3\2\2\2\u011a\u0114\3\2\2\2\u011a"+
		"\u0117\3\2\2\2\u011b:\3\2\2\2\u011c\u011e\t\4\2\2\u011d\u011c\3\2\2\2"+
		"\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\u0122\b\36\2\2\u0122<\3\2\2\2\u0123\u0125\t\5\2\2\u0124"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127>\3\2\2\2\u0128\u012a\5=\37\2\u0129\u0128\3\2\2\2\u012a\u012d"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012e\u0130\7\60\2\2\u012f\u0131\5=\37\2\u0130\u012f\3"+
		"\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"@\3\2\2\2\u0134\u0139\7$\2\2\u0135\u0138\5i\65\2\u0136\u0138\13\2\2\2"+
		"\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u013a"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u013d\7$\2\2\u013dB\3\2\2\2\u013e\u013f\7,\2\2\u013fD\3\2\2\2\u0140\u0141"+
		"\7\61\2\2\u0141F\3\2\2\2\u0142\u0143\7-\2\2\u0143H\3\2\2\2\u0144\u0145"+
		"\7/\2\2\u0145J\3\2\2\2\u0146\u0147\7#\2\2\u0147L\3\2\2\2\u0148\u0149\7"+
		">\2\2\u0149N\3\2\2\2\u014a\u014b\7@\2\2\u014bP\3\2\2\2\u014c\u014d\7#"+
		"\2\2\u014d\u014e\7?\2\2\u014eR\3\2\2\2\u014f\u0150\7?\2\2\u0150\u0151"+
		"\7?\2\2\u0151T\3\2\2\2\u0152\u0153\7<\2\2\u0153\u0154\7?\2\2\u0154V\3"+
		"\2\2\2\u0155\u0156\7(\2\2\u0156\u0157\7(\2\2\u0157X\3\2\2\2\u0158\u0159"+
		"\7~\2\2\u0159\u015a\7~\2\2\u015aZ\3\2\2\2\u015b\u015c\7<\2\2\u015c\\\3"+
		"\2\2\2\u015d\u015e\7.\2\2\u015e^\3\2\2\2\u015f\u0160\7=\2\2\u0160`\3\2"+
		"\2\2\u0161\u0162\7]\2\2\u0162b\3\2\2\2\u0163\u0164\7_\2\2\u0164d\3\2\2"+
		"\2\u0165\u0166\7*\2\2\u0166f\3\2\2\2\u0167\u0168\7+\2\2\u0168h\3\2\2\2"+
		"\u0169\u016a\7^\2\2\u016a\u016b\t\6\2\2\u016bj\3\2\2\2\u016c\u016d\7\61"+
		"\2\2\u016d\u016e\7\61\2\2\u016e\u0172\3\2\2\2\u016f\u0171\13\2\2\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0173\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176\7\f\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0178\b\66\2\2\u0178l\3\2\2\2\u0179\u017a\7\61\2"+
		"\2\u017a\u017b\7,\2\2\u017b\u017f\3\2\2\2\u017c\u017e\13\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7,\2\2\u0183\u0184\7\61"+
		"\2\2\u0184\u0185\3\2\2\2\u0185\u0186\b\67\2\2\u0186n\3\2\2\2\u0187\u0189"+
		"\7\"\2\2\u0188\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\b8\2\2\u018dp\3\2\2\2\16"+
		"\2\u010e\u011a\u011f\u0126\u012b\u0132\u0137\u0139\u0172\u017f\u018a\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}