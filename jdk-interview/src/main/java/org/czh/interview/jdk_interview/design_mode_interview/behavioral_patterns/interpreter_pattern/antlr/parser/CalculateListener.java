// Generated from /Users/czh/project/java/own/interview/design-mode-interview/src/main/java/org/czh/interview/design_mode_interview/interpreter_pattern/antlr/parser/Calculate.g4 by ANTLR 4.9.1
package org.czh.interview.jdk_interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculateParser}.
 */
public interface CalculateListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link CalculateParser#execute}.
     *
     * @param ctx the parse tree
     */
    void enterExecute(CalculateParser.ExecuteContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#execute}.
     *
     * @param ctx the parse tree
     */
    void exitExecute(CalculateParser.ExecuteContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#symbol}.
     *
     * @param ctx the parse tree
     */
    void enterSymbol(CalculateParser.SymbolContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#symbol}.
     *
     * @param ctx the parse tree
     */
    void exitSymbol(CalculateParser.SymbolContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#conditionSymbol}.
     *
     * @param ctx the parse tree
     */
    void enterConditionSymbol(CalculateParser.ConditionSymbolContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#conditionSymbol}.
     *
     * @param ctx the parse tree
     */
    void exitConditionSymbol(CalculateParser.ConditionSymbolContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#assignmentSymbol}.
     *
     * @param ctx the parse tree
     */
    void enterAssignmentSymbol(CalculateParser.AssignmentSymbolContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#assignmentSymbol}.
     *
     * @param ctx the parse tree
     */
    void exitAssignmentSymbol(CalculateParser.AssignmentSymbolContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#evaluationSymbol}.
     *
     * @param ctx the parse tree
     */
    void enterEvaluationSymbol(CalculateParser.EvaluationSymbolContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#evaluationSymbol}.
     *
     * @param ctx the parse tree
     */
    void exitEvaluationSymbol(CalculateParser.EvaluationSymbolContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(CalculateParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(CalculateParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#beEqualsExpression()}.
     *
     * @param ctx the parse tree
     */
    void enterBeEqualsExpression(CalculateParser.BeEqualsExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#beEqualsExpression()}.
     *
     * @param ctx the parse tree
     */
    void exitBeEqualsExpression(CalculateParser.BeEqualsExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#compareExpression()}.
     *
     * @param ctx the parse tree
     */
    void enterCompareExpression(CalculateParser.CompareExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#compareExpression()}.
     *
     * @param ctx the parse tree
     */
    void exitCompareExpression(CalculateParser.CompareExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#summationExpression()}.
     *
     * @param ctx the parse tree
     */
    void enterSummationExpression(CalculateParser.SummationExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#summationExpression()}.
     *
     * @param ctx the parse tree
     */
    void exitSummationExpression(CalculateParser.SummationExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#quadratureExpression()}.
     *
     * @param ctx the parse tree
     */
    void enterQuadratureExpression(CalculateParser.QuadratureExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#quadratureExpression()}.
     *
     * @param ctx the parse tree
     */
    void exitQuadratureExpression(CalculateParser.QuadratureExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#minimumExpression}.
     *
     * @param ctx the parse tree
     */
    void enterMinimumExpression(CalculateParser.MinimumExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#minimumExpression}.
     *
     * @param ctx the parse tree
     */
    void exitMinimumExpression(CalculateParser.MinimumExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalculateParser#literalExpression}.
     *
     * @param ctx the parse tree
     */
    void enterLiteralExpression(CalculateParser.LiteralExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalculateParser#literalExpression}.
     *
     * @param ctx the parse tree
     */
    void exitLiteralExpression(CalculateParser.LiteralExpressionContext ctx);
}