// Generated from /Users/czh/project/java/own/interview/design-mode-interview/src/main/java/org/czh/interview/design_mode_interview/interpreter_pattern/antlr/parser/Calculate.g4 by ANTLR 4.9.1
package org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface CalculateVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link CalculateParser#execute}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExecute(CalculateParser.ExecuteContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#symbol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSymbol(CalculateParser.SymbolContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#conditionSymbol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConditionSymbol(CalculateParser.ConditionSymbolContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#assignmentSymbol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignmentSymbol(CalculateParser.AssignmentSymbolContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#evaluationSymbol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEvaluationSymbol(CalculateParser.EvaluationSymbolContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(CalculateParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#beEqualsExpression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBeEqualsExpression(CalculateParser.BeEqualsExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#compareExpression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCompareExpression(CalculateParser.CompareExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#summationExpression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSummationExpression(CalculateParser.SummationExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#quadratureExpression()}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitQuadratureExpression(CalculateParser.QuadratureExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#minimumExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMinimumExpression(CalculateParser.MinimumExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalculateParser#literalExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLiteralExpression(CalculateParser.LiteralExpressionContext ctx);
}