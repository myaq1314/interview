package org.czh.interview.design_mode_interview.interpreter_pattern.antlr.exceptions;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.Interval;

/**
 * @author : czh
 * description : 词法错误监听器
 * date : 2021-04-19
 * email 916419307@qq.com
 */
public class LexerException extends BaseErrorListener {

    /**
     * @param recognizer         识别器
     * @param offendingSymbol    问题符号
     * @param line               行
     * @param charPositionInLine 字符在行中位置
     * @param msg                错误文本
     * @param e                  异常信息
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        Lexer lexer = (Lexer) recognizer;

        String text = lexer._input.getText(Interval.of(lexer._tokenStartCharIndex, lexer._input.index()));
        String errorDisplay = lexer.getErrorDisplay(text);

        System.err.println("[词法错误] 行" + line + "列" + charPositionInLine + "错误词: " + errorDisplay);
    }
}
