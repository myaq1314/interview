package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.exceptions.LexerException;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.exceptions.ParserException;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.ConditionNode;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.Node;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.NumericalNode;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.SymbolDict;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.SymbolNode;
import org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.VariableNode;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : czh
 * description :
 * date : 2021-04-23
 * email 916419307@qq.com
 */
public class OwnEvaluation {

    private static final LexerException lexerException = new LexerException();
    private static final ParserException parserException = new ParserException();
    private final Map<String, Object> variableMap = new HashMap<>();
    private Object result;

    public static Node parser(String text) {
        return parser(CharStreams.fromString(text));
    }

    public static Node parser(CharStream charStreams) {
        CalculateLexer lexer = new CalculateLexer(charStreams);
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerException);

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        CalculateParser parser = new CalculateParser(commonTokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(parserException);

        OwnVisitor visitor = new OwnVisitor();
        return visitor.visit(parser.execute());
    }

    @SuppressWarnings("unused")
    public Object parserFile(String path) {
        CharStream charStream;
        try {
            charStream = CharStreams.fromFileName(path);
        } catch (IOException e) {
            System.out.println(path + "文件打开出错");
            return null;
        }

        Node node = parser(charStream);
        if (node != null) {
            return evaluation(node);
        }
        return null;
    }

    public Object evaluation(String text) {
        Node node = parser(text + "\n");
        return evaluation(node);
    }

    public Object evaluation(Node node) {
        if (node instanceof SymbolNode) {
            SymbolDict symbolDict = ((SymbolNode) node).getSymbolDict();
            Object leftResult = evaluation(((SymbolNode) node).getLeftNode());
            Object rightResult = evaluation(((SymbolNode) node).getRightNode());
            switch (symbolDict) {
                case ADD:
                    return ((BigDecimal) leftResult).add((BigDecimal) rightResult);
                case SUBTRACT:
                    return ((BigDecimal) leftResult).subtract((BigDecimal) rightResult);
                case MULTIPLY:
                    return ((BigDecimal) leftResult).multiply((BigDecimal) rightResult);
                case DIVIDE:
                    return ((BigDecimal) leftResult).divide((BigDecimal) rightResult, 8, RoundingMode.HALF_DOWN).stripTrailingZeros();
                case EQUALS:
                    return leftResult.equals(rightResult);
                case NOT_EQUALS:
                    return !leftResult.equals(rightResult);
                case AND:
                    if (leftResult instanceof Boolean && rightResult instanceof Boolean) {
                        return ((Boolean) leftResult) && ((Boolean) rightResult);
                    } else {
                        System.err.println("[运行时错误] &&符号左右两端需为布尔值");
                        return null;
                    }
                case OR:
                    if (leftResult instanceof Boolean && rightResult instanceof Boolean) {
                        return ((Boolean) leftResult) || ((Boolean) rightResult);
                    } else {
                        System.err.println("[运行时错误] &&符号左右两端需为布尔值");
                        return null;
                    }
                case GREATER:
                    return ((BigDecimal) leftResult).compareTo((BigDecimal) rightResult) > 0;
                case GREATER_EQUALS:
                    return ((BigDecimal) leftResult).compareTo((BigDecimal) rightResult) >= 0;
                case LESS:
                    return ((BigDecimal) leftResult).compareTo((BigDecimal) rightResult) < 0;
                case LESS_EQUALS:
                    return ((BigDecimal) leftResult).compareTo((BigDecimal) rightResult) <= 0;
                case ASSIGNMENT:
                    variableMap.put(((SymbolNode) node).getLeftNode().getInput(), rightResult);
                default:
                    return null;
            }
        } else if (node instanceof VariableNode) {
            return variableMap.get(node.getInput());
        } else if (node instanceof NumericalNode) {
            return ((NumericalNode) node).getNumerical();
        } else if (node instanceof ConditionNode) {
            Object condition = evaluation(((ConditionNode) node).getCondition());
            if (condition instanceof Boolean) {
                return (boolean) condition ? evaluation(((ConditionNode) node).getTrueCondition()) : null;
            } else {
                System.err.println("[运行时错误] 条件部分需为布尔值: " + ((ConditionNode) node).getCondition().getInput());
                return null;
            }
        } else {
            for (Node child : node.getChildren()) {
                result = evaluation(child);
            }
            return result;
        }
    }
}
