package org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.ConditionNode;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.Node;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.NumericalNode;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.SymbolDict;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.SymbolNode;
import org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.node.VariableNode;

/**
 * @author : czh
 * description :
 * date : 2021-04-19
 * email 916419307@qq.com
 */
public class OwnVisitor extends CalculateBaseVisitor<Node> {

    // 程序入口
    @Override
    public Node visitExecute(CalculateParser.ExecuteContext ctx) {
        Node node = new Node();
        for (CalculateParser.SymbolContext symbolContext : ctx.symbol()) {
            node.addChild(visit(symbolContext));
        }
        return node;
    }

    @Override
    public Node visitSymbol(CalculateParser.SymbolContext ctx) {
        return super.visitSymbol(ctx);
    }

    // 赋值符号
    @Override
    public Node visitAssignmentSymbol(CalculateParser.AssignmentSymbolContext ctx) {
        String variable = ctx.Variable().getText();
        SymbolNode node = new SymbolNode();
        node.setSymbolDict(SymbolDict.ASSIGNMENT);
        node.setLeftNode(new VariableNode(variable));
        node.setRightNode(visit(ctx.expression()));
        return node;
    }

    // 条件符号
    @Override
    public Node visitConditionSymbol(CalculateParser.ConditionSymbolContext ctx) {
        ConditionNode node = new ConditionNode();
        node.setCondition(visit(ctx.expression()));
        node.getCondition().setInput(ctx.expression().getText());
        node.setTrueCondition(visit(ctx.symbol()));
        return node;
    }

    // 求值符号
    @Override
    public Node visitEvaluationSymbol(CalculateParser.EvaluationSymbolContext ctx) {
        return visit(ctx.expression());
    }

    // 表达式
    @Override
    public Node visitExpression(CalculateParser.ExpressionContext ctx) {
        return visit(ctx.beEqualsExpression());
    }

    // 等同判断表达式
    @Override
    public Node visitBeEqualsExpression(CalculateParser.BeEqualsExpressionContext ctx) {
        return rightExpression(ctx, ctx.beEqualsExpression(), ctx.compareExpression());
    }

    // 比较表达式
    @Override
    public Node visitCompareExpression(CalculateParser.CompareExpressionContext ctx) {
        return rightExpression(ctx, ctx.compareExpression(), ctx.summationExpression());
    }

    // 求和表达式
    @Override
    public Node visitSummationExpression(CalculateParser.SummationExpressionContext ctx) {
        return rightExpression(ctx, ctx.summationExpression(), ctx.quadratureExpression());
    }

    // 求积表达式
    @Override
    public Node visitQuadratureExpression(CalculateParser.QuadratureExpressionContext ctx) {
        return rightExpression(ctx, ctx.quadratureExpression(), ctx.minimumExpression());
    }

    // 最小表达式
    @Override
    public Node visitMinimumExpression(CalculateParser.MinimumExpressionContext ctx) {
        return ctx.literalExpression() != null ? visit(ctx.literalExpression()) : visit(ctx.expression());
    }

    // 字面量
    @Override
    public Node visitLiteralExpression(CalculateParser.LiteralExpressionContext ctx) {
        TerminalNodeImpl node = (TerminalNodeImpl) (ctx.getChild(0));
        return node instanceof ErrorNode
                ? null
                : node.symbol.getType() == CalculateParser.Numerical
                ? new NumericalNode(node.getText())
                : new VariableNode(node.getText());
    }

    // 向右扩展
    private Node rightExpression(ParserRuleContext ctx,
                                 ParserRuleContext own,
                                 ParserRuleContext extend) {
        Node node = visit(extend);
        if (own == null) {
            return node;
        } else {
            return buildSymbolNode(getSymbol(ctx), own, node);
        }
    }

    // 获取符号
    private SymbolDict getSymbol(ParserRuleContext ctx) {
        int symbol = ((TerminalNodeImpl) ctx.getChild(1)).symbol.getType();
        switch (symbol) {
            case CalculateParser.SymbolAdd:
                return SymbolDict.ADD;
            case CalculateParser.SymbolSubtract:
                return SymbolDict.SUBTRACT;
            case CalculateParser.SymbolMultiply:
            case CalculateParser.SymbolProcedureMultiply:
                return SymbolDict.MULTIPLY;
            case CalculateParser.SymbolDivide:
            case CalculateParser.SymbolProcedureDivide:
                return SymbolDict.DIVIDE;
            case CalculateParser.SymbolEquals:
            case CalculateParser.SymbolWei:
                return SymbolDict.EQUALS;
            case CalculateParser.SymbolNotEquals:
            case CalculateParser.SymbolProcedureNotEquals:
                return SymbolDict.NOT_EQUALS;
            case CalculateParser.SymbolAnd:
                return SymbolDict.AND;
            case CalculateParser.SymbolOr:
                return SymbolDict.OR;
            case CalculateParser.SymbolGreater:
                return SymbolDict.GREATER;
            case CalculateParser.SymbolGreaterEquals:
            case CalculateParser.SymbolProcedureGreaterEquals:
                return SymbolDict.GREATER_EQUALS;
            case CalculateParser.SymbolLess:
                return SymbolDict.LESS;
            case CalculateParser.SymbolLessEquals:
            case CalculateParser.SymbolProcedureLessEquals:
                return SymbolDict.LESS_EQUALS;
            default:
                return null;
        }
    }

    // 构建运算节点
    private Node buildSymbolNode(SymbolDict symbol, ParserRuleContext left, Node right) {
        SymbolNode node = new SymbolNode();
        node.setSymbolDict(symbol);
        node.setLeftNode(visit(left));
        node.setRightNode(right);
        return node;
    }
}
