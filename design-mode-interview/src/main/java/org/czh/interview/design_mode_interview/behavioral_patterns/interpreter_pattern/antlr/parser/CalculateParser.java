// Generated from /Users/czh/project/java/own/interview/design-mode-interview/src/main/java/org/czh/interview/design_mode_interview/interpreter_pattern/antlr/parser/Calculate.g4 by ANTLR 4.9.1
package org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculateParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, Variable = 5, Numerical = 6, SymbolAdd = 7,
            SymbolSubtract = 8, SymbolProcedureMultiply = 9, SymbolMultiply = 10, SymbolProcedureDivide = 11,
            SymbolDivide = 12, SymbolWei = 13, SymbolEquals = 14, SymbolProcedureNotEquals = 15,
            SymbolNotEquals = 16, SymbolAnd = 17, SymbolOr = 18, SymbolGreater = 19, SymbolProcedureGreaterEquals = 20,
            SymbolGreaterEquals = 21, SymbolLess = 22, SymbolProcedureLessEquals = 23, SymbolLessEquals = 24,
            SymbolNewLine = 25, SymbolBlank = 26;
    public static final int
            RULE_execute = 0, RULE_symbol = 1, RULE_conditionSymbol = 2, RULE_assignmentSymbol = 3,
            RULE_evaluationSymbol = 4, RULE_expression = 5, RULE_beEqualsExpression = 6,
            RULE_compareExpression = 7, RULE_summationExpression = 8, RULE_quadratureExpression = 9,
            RULE_minimumExpression = 10, RULE_literalExpression = 11;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0093\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\5\3$" +
                    "\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3" +
                    "\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b" +
                    "\3\b\7\bI\n\b\f\b\16\bL\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3" +
                    "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tc\n\t\f\t\16\tf\13\t\3\n" +
                    "\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nq\n\n\f\n\16\nt\13\n\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0085" +
                    "\n\13\f\13\16\13\u0088\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u008f\n\f\3\r\3\r" +
                    "\3\r\2\6\16\20\22\24\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\7\b\2\u009d" +
                    "\2\33\3\2\2\2\4#\3\2\2\2\6%\3\2\2\2\b)\3\2\2\2\n.\3\2\2\2\f\61\3\2\2\2" +
                    "\16\63\3\2\2\2\20M\3\2\2\2\22g\3\2\2\2\24u\3\2\2\2\26\u008e\3\2\2\2\30" +
                    "\u0090\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2" +
                    "\35\36\3\2\2\2\36\3\3\2\2\2\37$\5\b\5\2 $\5\6\4\2!$\5\n\6\2\"$\7\33\2" +
                    "\2#\37\3\2\2\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\3\2\2&\'" +
                    "\5\f\7\2\'(\5\4\3\2(\7\3\2\2\2)*\7\7\2\2*+\7\4\2\2+,\5\f\7\2,-\7\33\2" +
                    "\2-\t\3\2\2\2./\5\f\7\2/\60\7\33\2\2\60\13\3\2\2\2\61\62\5\16\b\2\62\r" +
                    "\3\2\2\2\63\64\b\b\1\2\64\65\5\20\t\2\65J\3\2\2\2\66\67\f\b\2\2\678\7" +
                    "\20\2\28I\5\20\t\29:\f\7\2\2:;\7\17\2\2;I\5\20\t\2<=\f\6\2\2=>\7\21\2" +
                    "\2>I\5\20\t\2?@\f\5\2\2@A\7\22\2\2AI\5\20\t\2BC\f\4\2\2CD\7\23\2\2DI\5" +
                    "\20\t\2EF\f\3\2\2FG\7\24\2\2GI\5\20\t\2H\66\3\2\2\2H9\3\2\2\2H<\3\2\2" +
                    "\2H?\3\2\2\2HB\3\2\2\2HE\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\17\3\2" +
                    "\2\2LJ\3\2\2\2MN\b\t\1\2NO\5\22\n\2Od\3\2\2\2PQ\f\b\2\2QR\7\30\2\2Rc\5" +
                    "\22\n\2ST\f\7\2\2TU\7\25\2\2Uc\5\22\n\2VW\f\6\2\2WX\7\31\2\2Xc\5\22\n" +
                    "\2YZ\f\5\2\2Z[\7\26\2\2[c\5\22\n\2\\]\f\4\2\2]^\7\32\2\2^c\5\22\n\2_`" +
                    "\f\3\2\2`a\7\27\2\2ac\5\22\n\2bP\3\2\2\2bS\3\2\2\2bV\3\2\2\2bY\3\2\2\2" +
                    "b\\\3\2\2\2b_\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\21\3\2\2\2fd\3\2" +
                    "\2\2gh\b\n\1\2hi\5\24\13\2ir\3\2\2\2jk\f\4\2\2kl\7\t\2\2lq\5\24\13\2m" +
                    "n\f\3\2\2no\7\n\2\2oq\5\24\13\2pj\3\2\2\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2" +
                    "\2rs\3\2\2\2s\23\3\2\2\2tr\3\2\2\2uv\b\13\1\2vw\5\26\f\2w\u0086\3\2\2" +
                    "\2xy\f\6\2\2yz\7\13\2\2z\u0085\5\26\f\2{|\f\5\2\2|}\7\f\2\2}\u0085\5\26" +
                    "\f\2~\177\f\4\2\2\177\u0080\7\r\2\2\u0080\u0085\5\26\f\2\u0081\u0082\f" +
                    "\3\2\2\u0082\u0083\7\16\2\2\u0083\u0085\5\26\f\2\u0084x\3\2\2\2\u0084" +
                    "{\3\2\2\2\u0084~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086" +
                    "\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u0086\3\2\2" +
                    "\2\u0089\u008f\5\30\r\2\u008a\u008b\7\5\2\2\u008b\u008c\5\f\7\2\u008c" +
                    "\u008d\7\6\2\2\u008d\u008f\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008a\3\2" +
                    "\2\2\u008f\27\3\2\2\2\u0090\u0091\t\2\2\2\u0091\31\3\2\2\2\r\35#HJbdp" +
                    "r\u0084\u0086\u008e";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

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

    public CalculateParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "execute", "symbol", "conditionSymbol", "assignmentSymbol", "evaluationSymbol",
                "expression", "beEqualsExpression", "compareExpression", "summationExpression",
                "quadratureExpression", "minimumExpression", "literalExpression"
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
    public ATN getATN() {
        return _ATN;
    }

    public final ExecuteContext execute() throws RecognitionException {
        ExecuteContext _localctx = new ExecuteContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_execute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(24);
                            symbol();
                        }
                    }
                    setState(27);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << Variable) | (1L << Numerical) | (1L << SymbolNewLine))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SymbolContext symbol() throws RecognitionException {
        SymbolContext _localctx = new SymbolContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_symbol);
        try {
            setState(33);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(29);
                    assignmentSymbol();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(30);
                    conditionSymbol();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(31);
                    evaluationSymbol();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(32);
                    match(SymbolNewLine);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConditionSymbolContext conditionSymbol() throws RecognitionException {
        ConditionSymbolContext _localctx = new ConditionSymbolContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_conditionSymbol);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                match(T__0);
                setState(36);
                expression();
                setState(37);
                symbol();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentSymbolContext assignmentSymbol() throws RecognitionException {
        AssignmentSymbolContext _localctx = new AssignmentSymbolContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_assignmentSymbol);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(39);
                match(Variable);
                setState(40);
                match(T__1);
                setState(41);
                expression();
                setState(42);
                match(SymbolNewLine);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EvaluationSymbolContext evaluationSymbol() throws RecognitionException {
        EvaluationSymbolContext _localctx = new EvaluationSymbolContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_evaluationSymbol);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                expression();
                setState(45);
                match(SymbolNewLine);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(47);
                beEqualsExpression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BeEqualsExpressionContext beEqualsExpression() throws RecognitionException {
        return beEqualsExpression(0);
    }

    private BeEqualsExpressionContext beEqualsExpression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        BeEqualsExpressionContext _localctx = new BeEqualsExpressionContext(_ctx, _parentState);
        BeEqualsExpressionContext _prevctx = _localctx;
        int _startState = 12;
        enterRecursionRule(_localctx, 12, RULE_beEqualsExpression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(50);
                    compareExpression(0);
                }
                _ctx.stop = _input.LT(-1);
                setState(72);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(70);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                                case 1: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(52);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(53);
                                    match(SymbolEquals);
                                    setState(54);
                                    compareExpression(0);
                                }
                                break;
                                case 2: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(55);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(56);
                                    match(SymbolWei);
                                    setState(57);
                                    compareExpression(0);
                                }
                                break;
                                case 3: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(58);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(59);
                                    match(SymbolProcedureNotEquals);
                                    setState(60);
                                    compareExpression(0);
                                }
                                break;
                                case 4: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(61);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(62);
                                    match(SymbolNotEquals);
                                    setState(63);
                                    compareExpression(0);
                                }
                                break;
                                case 5: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(64);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(65);
                                    match(SymbolAnd);
                                    setState(66);
                                    compareExpression(0);
                                }
                                break;
                                case 6: {
                                    _localctx = new BeEqualsExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_beEqualsExpression);
                                    setState(67);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(68);
                                    match(SymbolOr);
                                    setState(69);
                                    compareExpression(0);
                                }
                                break;
                            }
                        }
                    }
                    setState(74);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final CompareExpressionContext compareExpression() throws RecognitionException {
        return compareExpression(0);
    }

    private CompareExpressionContext compareExpression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        CompareExpressionContext _localctx = new CompareExpressionContext(_ctx, _parentState);
        CompareExpressionContext _prevctx = _localctx;
        int _startState = 14;
        enterRecursionRule(_localctx, 14, RULE_compareExpression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(76);
                    summationExpression(0);
                }
                _ctx.stop = _input.LT(-1);
                setState(98);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(96);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                                case 1: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(78);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(79);
                                    match(SymbolLess);
                                    setState(80);
                                    summationExpression(0);
                                }
                                break;
                                case 2: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(81);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(82);
                                    match(SymbolGreater);
                                    setState(83);
                                    summationExpression(0);
                                }
                                break;
                                case 3: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(84);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(85);
                                    match(SymbolProcedureLessEquals);
                                    setState(86);
                                    summationExpression(0);
                                }
                                break;
                                case 4: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(87);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(88);
                                    match(SymbolProcedureGreaterEquals);
                                    setState(89);
                                    summationExpression(0);
                                }
                                break;
                                case 5: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(90);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(91);
                                    match(SymbolLessEquals);
                                    setState(92);
                                    summationExpression(0);
                                }
                                break;
                                case 6: {
                                    _localctx = new CompareExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
                                    setState(93);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(94);
                                    match(SymbolGreaterEquals);
                                    setState(95);
                                    summationExpression(0);
                                }
                                break;
                            }
                        }
                    }
                    setState(100);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final SummationExpressionContext summationExpression() throws RecognitionException {
        return summationExpression(0);
    }

    private SummationExpressionContext summationExpression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        SummationExpressionContext _localctx = new SummationExpressionContext(_ctx, _parentState);
        SummationExpressionContext _prevctx = _localctx;
        int _startState = 16;
        enterRecursionRule(_localctx, 16, RULE_summationExpression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(102);
                    quadratureExpression(0);
                }
                _ctx.stop = _input.LT(-1);
                setState(112);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(110);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                                case 1: {
                                    _localctx = new SummationExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_summationExpression);
                                    setState(104);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(105);
                                    match(SymbolAdd);
                                    setState(106);
                                    quadratureExpression(0);
                                }
                                break;
                                case 2: {
                                    _localctx = new SummationExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_summationExpression);
                                    setState(107);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(108);
                                    match(SymbolSubtract);
                                    setState(109);
                                    quadratureExpression(0);
                                }
                                break;
                            }
                        }
                    }
                    setState(114);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final QuadratureExpressionContext quadratureExpression() throws RecognitionException {
        return quadratureExpression(0);
    }

    private QuadratureExpressionContext quadratureExpression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        QuadratureExpressionContext _localctx = new QuadratureExpressionContext(_ctx, _parentState);
        QuadratureExpressionContext _prevctx = _localctx;
        int _startState = 18;
        enterRecursionRule(_localctx, 18, RULE_quadratureExpression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(116);
                    minimumExpression();
                }
                _ctx.stop = _input.LT(-1);
                setState(132);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(130);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                                case 1: {
                                    _localctx = new QuadratureExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_quadratureExpression);
                                    setState(118);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(119);
                                    match(SymbolProcedureMultiply);
                                    setState(120);
                                    minimumExpression();
                                }
                                break;
                                case 2: {
                                    _localctx = new QuadratureExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_quadratureExpression);
                                    setState(121);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(122);
                                    match(SymbolMultiply);
                                    setState(123);
                                    minimumExpression();
                                }
                                break;
                                case 3: {
                                    _localctx = new QuadratureExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_quadratureExpression);
                                    setState(124);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(125);
                                    match(SymbolProcedureDivide);
                                    setState(126);
                                    minimumExpression();
                                }
                                break;
                                case 4: {
                                    _localctx = new QuadratureExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_quadratureExpression);
                                    setState(127);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(128);
                                    match(SymbolDivide);
                                    setState(129);
                                    minimumExpression();
                                }
                                break;
                            }
                        }
                    }
                    setState(134);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final MinimumExpressionContext minimumExpression() throws RecognitionException {
        MinimumExpressionContext _localctx = new MinimumExpressionContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_minimumExpression);
        try {
            setState(140);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Variable:
                case Numerical:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(135);
                    literalExpression();
                }
                break;
                case T__2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(136);
                    match(T__2);
                    setState(137);
                    expression();
                    setState(138);
                    match(T__3);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LiteralExpressionContext literalExpression() throws RecognitionException {
        LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_literalExpression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                _la = _input.LA(1);
                if (!(_la == Variable || _la == Numerical)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 6:
                return beEqualsExpression_sempred((BeEqualsExpressionContext) _localctx, predIndex);
            case 7:
                return compareExpression_sempred((CompareExpressionContext) _localctx, predIndex);
            case 8:
                return summationExpression_sempred((SummationExpressionContext) _localctx, predIndex);
            case 9:
                return quadratureExpression_sempred((QuadratureExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean beEqualsExpression_sempred(BeEqualsExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 6);
            case 1:
                return precpred(_ctx, 5);
            case 2:
                return precpred(_ctx, 4);
            case 3:
                return precpred(_ctx, 3);
            case 4:
                return precpred(_ctx, 2);
            case 5:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean compareExpression_sempred(CompareExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 6:
                return precpred(_ctx, 6);
            case 7:
                return precpred(_ctx, 5);
            case 8:
                return precpred(_ctx, 4);
            case 9:
                return precpred(_ctx, 3);
            case 10:
                return precpred(_ctx, 2);
            case 11:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean summationExpression_sempred(SummationExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 12:
                return precpred(_ctx, 2);
            case 13:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean quadratureExpression_sempred(QuadratureExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 14:
                return precpred(_ctx, 4);
            case 15:
                return precpred(_ctx, 3);
            case 16:
                return precpred(_ctx, 2);
            case 17:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static class ExecuteContext extends ParserRuleContext {
        public ExecuteContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<SymbolContext> symbol() {
            return getRuleContexts(SymbolContext.class);
        }

        public SymbolContext symbol(int i) {
            return getRuleContext(SymbolContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_execute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterExecute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitExecute(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitExecute(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SymbolContext extends ParserRuleContext {
        public SymbolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AssignmentSymbolContext assignmentSymbol() {
            return getRuleContext(AssignmentSymbolContext.class, 0);
        }

        public ConditionSymbolContext conditionSymbol() {
            return getRuleContext(ConditionSymbolContext.class, 0);
        }

        public EvaluationSymbolContext evaluationSymbol() {
            return getRuleContext(EvaluationSymbolContext.class, 0);
        }

        public TerminalNode SymbolNewLine() {
            return getToken(CalculateParser.SymbolNewLine, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_symbol;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterSymbol(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitSymbol(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor) return ((CalculateVisitor<? extends T>) visitor).visitSymbol(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConditionSymbolContext extends ParserRuleContext {
        public ConditionSymbolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public SymbolContext symbol() {
            return getRuleContext(SymbolContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionSymbol;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterConditionSymbol(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitConditionSymbol(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitConditionSymbol(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AssignmentSymbolContext extends ParserRuleContext {
        public AssignmentSymbolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Variable() {
            return getToken(CalculateParser.Variable, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode SymbolNewLine() {
            return getToken(CalculateParser.SymbolNewLine, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentSymbol;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterAssignmentSymbol(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitAssignmentSymbol(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitAssignmentSymbol(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EvaluationSymbolContext extends ParserRuleContext {
        public EvaluationSymbolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode SymbolNewLine() {
            return getToken(CalculateParser.SymbolNewLine, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_evaluationSymbol;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterEvaluationSymbol(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitEvaluationSymbol(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitEvaluationSymbol(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BeEqualsExpressionContext beEqualsExpression() {
            return getRuleContext(BeEqualsExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class BeEqualsExpressionContext extends ParserRuleContext {
        public BeEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public CompareExpressionContext compareExpression() {
            return getRuleContext(CompareExpressionContext.class, 0);
        }

        public BeEqualsExpressionContext beEqualsExpression() {
            return getRuleContext(BeEqualsExpressionContext.class, 0);
        }

        public TerminalNode SymbolEquals() {
            return getToken(CalculateParser.SymbolEquals, 0);
        }

        public TerminalNode SymbolWei() {
            return getToken(CalculateParser.SymbolWei, 0);
        }

        public TerminalNode SymbolProcedureNotEquals() {
            return getToken(CalculateParser.SymbolProcedureNotEquals, 0);
        }

        public TerminalNode SymbolNotEquals() {
            return getToken(CalculateParser.SymbolNotEquals, 0);
        }

        public TerminalNode SymbolAnd() {
            return getToken(CalculateParser.SymbolAnd, 0);
        }

        public TerminalNode SymbolOr() {
            return getToken(CalculateParser.SymbolOr, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_beEqualsExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterBeEqualsExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitBeEqualsExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitBeEqualsExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class CompareExpressionContext extends ParserRuleContext {
        public CompareExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public SummationExpressionContext summationExpression() {
            return getRuleContext(SummationExpressionContext.class, 0);
        }

        public CompareExpressionContext compareExpression() {
            return getRuleContext(CompareExpressionContext.class, 0);
        }

        public TerminalNode SymbolLess() {
            return getToken(CalculateParser.SymbolLess, 0);
        }

        public TerminalNode SymbolGreater() {
            return getToken(CalculateParser.SymbolGreater, 0);
        }

        public TerminalNode SymbolProcedureLessEquals() {
            return getToken(CalculateParser.SymbolProcedureLessEquals, 0);
        }

        public TerminalNode SymbolProcedureGreaterEquals() {
            return getToken(CalculateParser.SymbolProcedureGreaterEquals, 0);
        }

        public TerminalNode SymbolLessEquals() {
            return getToken(CalculateParser.SymbolLessEquals, 0);
        }

        public TerminalNode SymbolGreaterEquals() {
            return getToken(CalculateParser.SymbolGreaterEquals, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_compareExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterCompareExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitCompareExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitCompareExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SummationExpressionContext extends ParserRuleContext {
        public SummationExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QuadratureExpressionContext quadratureExpression() {
            return getRuleContext(QuadratureExpressionContext.class, 0);
        }

        public SummationExpressionContext summationExpression() {
            return getRuleContext(SummationExpressionContext.class, 0);
        }

        public TerminalNode SymbolAdd() {
            return getToken(CalculateParser.SymbolAdd, 0);
        }

        public TerminalNode SymbolSubtract() {
            return getToken(CalculateParser.SymbolSubtract, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_summationExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterSummationExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitSummationExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitSummationExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class QuadratureExpressionContext extends ParserRuleContext {
        public QuadratureExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public MinimumExpressionContext minimumExpression() {
            return getRuleContext(MinimumExpressionContext.class, 0);
        }

        public QuadratureExpressionContext quadratureExpression() {
            return getRuleContext(QuadratureExpressionContext.class, 0);
        }

        public TerminalNode SymbolProcedureMultiply() {
            return getToken(CalculateParser.SymbolProcedureMultiply, 0);
        }

        public TerminalNode SymbolMultiply() {
            return getToken(CalculateParser.SymbolMultiply, 0);
        }

        public TerminalNode SymbolProcedureDivide() {
            return getToken(CalculateParser.SymbolProcedureDivide, 0);
        }

        public TerminalNode SymbolDivide() {
            return getToken(CalculateParser.SymbolDivide, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_quadratureExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterQuadratureExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitQuadratureExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitQuadratureExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MinimumExpressionContext extends ParserRuleContext {
        public MinimumExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LiteralExpressionContext literalExpression() {
            return getRuleContext(LiteralExpressionContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_minimumExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterMinimumExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitMinimumExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitMinimumExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LiteralExpressionContext extends ParserRuleContext {
        public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Numerical() {
            return getToken(CalculateParser.Numerical, 0);
        }

        public TerminalNode Variable() {
            return getToken(CalculateParser.Variable, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literalExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).enterLiteralExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalculateListener) ((CalculateListener) listener).exitLiteralExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalculateVisitor)
                return ((CalculateVisitor<? extends T>) visitor).visitLiteralExpression(this);
            else return visitor.visitChildren(this);
        }
    }
}