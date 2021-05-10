package org.czh.interview.design_mode_interview.behavioral_patterns.interpreter_pattern.antlr.exceptions;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Collections;
import java.util.List;

/**
 * @author : czh
 * description : 语法错误监听器
 * date : 2021-04-19
 * email 916419307@qq.com
 */
public class ParserException extends BaseErrorListener {

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
        List<String> ruleInvocationStackList = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(ruleInvocationStackList);
        System.err.println("[语法错误] 规则栈: " + ruleInvocationStackList);
        System.err.println("行" + line + "列" + charPositionInLine + "非法符号: " + offendingSymbol + ". 原始原因:" + msg);
    }
}
