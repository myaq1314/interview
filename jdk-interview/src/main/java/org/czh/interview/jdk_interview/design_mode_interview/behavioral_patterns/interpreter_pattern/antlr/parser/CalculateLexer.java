// Generated from /Users/czh/project/java/own/interview/design-mode-interview/src/main/java/org/czh/interview/design_mode_interview/interpreter_pattern/antlr/parser/Calculate.g4 by ANTLR 4.9.1
package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculateLexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Variable = 5, Numerical = 6, SymbolAdd = 7,
            SymbolSubtract = 8, SymbolProcedureMultiply = 9, SymbolMultiply = 10, SymbolProcedureDivide = 11,
            SymbolDivide = 12, SymbolWei = 13, SymbolEquals = 14, SymbolProcedureNotEquals = 15,
            SymbolNotEquals = 16, SymbolAnd = 17, SymbolOr = 18, SymbolGreater = 19, SymbolProcedureGreaterEquals = 20,
            SymbolGreaterEquals = 21, SymbolLess = 22, SymbolProcedureLessEquals = 23, SymbolLessEquals = 24,
            SymbolNewLine = 25, SymbolBlank = 26;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u0089\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6" +
                    "B\n\6\r\6\16\6C\3\7\6\7G\n\7\r\7\16\7H\3\7\5\7L\n\7\3\7\7\7O\n\7\f\7\16" +
                    "\7R\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3" +
                    "\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3" +
                    "\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3" +
                    "\32\5\32\177\n\32\3\32\3\32\3\33\6\33\u0084\n\33\r\33\16\33\u0085\3\33" +
                    "\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16" +
                    "\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34" +
                    "\3\2\6\4\2C\\c|\3\2\62;\3\2\60\60\3\2\"\"\2\u008e\2\3\3\2\2\2\2\5\3\2" +
                    "\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21" +
                    "\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2" +
                    "\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3" +
                    "\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3" +
                    "\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2\t>\3\2\2\2\13A" +
                    "\3\2\2\2\rF\3\2\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27" +
                    "[\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35a\3\2\2\2\37d\3\2\2\2!g\3\2\2\2#i" +
                    "\3\2\2\2%l\3\2\2\2\'o\3\2\2\2)q\3\2\2\2+t\3\2\2\2-v\3\2\2\2/x\3\2\2\2" +
                    "\61{\3\2\2\2\63~\3\2\2\2\65\u0083\3\2\2\2\678\7\u5984\2\289\7\u679e\2" +
                    "\29\4\3\2\2\2:;\7?\2\2;\6\3\2\2\2<=\7*\2\2=\b\3\2\2\2>?\7+\2\2?\n\3\2" +
                    "\2\2@B\t\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\f\3\2\2\2EG\t" +
                    "\3\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JL\t\4\2\2KJ\3" +
                    "\2\2\2KL\3\2\2\2LP\3\2\2\2MO\t\3\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3" +
                    "\2\2\2Q\16\3\2\2\2RP\3\2\2\2ST\7-\2\2T\20\3\2\2\2UV\7/\2\2V\22\3\2\2\2" +
                    "WX\7,\2\2X\24\3\2\2\2YZ\7\u00d9\2\2Z\26\3\2\2\2[\\\7\61\2\2\\\30\3\2\2" +
                    "\2]^\7\u00f9\2\2^\32\3\2\2\2_`\7\u4e3c\2\2`\34\3\2\2\2ab\7?\2\2bc\7?\2" +
                    "\2c\36\3\2\2\2de\7#\2\2ef\7?\2\2f \3\2\2\2gh\7\u2262\2\2h\"\3\2\2\2ij" +
                    "\7(\2\2jk\7(\2\2k$\3\2\2\2lm\7~\2\2mn\7~\2\2n&\3\2\2\2op\7@\2\2p(\3\2" +
                    "\2\2qr\7@\2\2rs\7?\2\2s*\3\2\2\2tu\7\u2267\2\2u,\3\2\2\2vw\7>\2\2w.\3" +
                    "\2\2\2xy\7>\2\2yz\7?\2\2z\60\3\2\2\2{|\7\u2266\2\2|\62\3\2\2\2}\177\7" +
                    "\17\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\f\2\2\u0081" +
                    "\64\3\2\2\2\u0082\u0084\t\5\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2" +
                    "\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088" +
                    "\b\33\2\2\u0088\66\3\2\2\2\t\2CHKP~\u0085\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public CalculateLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "Variable", "Numerical", "SymbolAdd",
                "SymbolSubtract", "SymbolProcedureMultiply", "SymbolMultiply", "SymbolProcedureDivide",
                "SymbolDivide", "SymbolWei", "SymbolEquals", "SymbolProcedureNotEquals",
                "SymbolNotEquals", "SymbolAnd", "SymbolOr", "SymbolGreater", "SymbolProcedureGreaterEquals",
                "SymbolGreaterEquals", "SymbolLess", "SymbolProcedureLessEquals", "SymbolLessEquals",
                "SymbolNewLine", "SymbolBlank"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'\u5982\u679C'", "'='", "'('", "')'", null, null, "'+'", "'-'",
                "'*'", "'\u00D7'", "'/'", "'\u00F7'", "'\u4E3A'", "'=='", "'!='", "'\u2260'",
                "'&&'", "'||'", "'>'", "'>='", "'\u2265'", "'<'", "'<='", "'\u2264'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, "Variable", "Numerical", "SymbolAdd", "SymbolSubtract",
                "SymbolProcedureMultiply", "SymbolMultiply", "SymbolProcedureDivide",
                "SymbolDivide", "SymbolWei", "SymbolEquals", "SymbolProcedureNotEquals",
                "SymbolNotEquals", "SymbolAnd", "SymbolOr", "SymbolGreater", "SymbolProcedureGreaterEquals",
                "SymbolGreaterEquals", "SymbolLess", "SymbolProcedureLessEquals", "SymbolLessEquals",
                "SymbolNewLine", "SymbolBlank"
        };
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
    public String getGrammarFileName() {
        return "Calculate.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}