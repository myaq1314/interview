package org.czh.interview.exceptions;

import org.czh.interview.enums.IDictEnum;

/**
 * @author : ZGH
 * description : 拼装异常
 * datetime : 2025/7/25
 * email : zgh@zghits.com
 */
@SuppressWarnings("unused")
public class JointException extends CommonException {
    /**
     * 空参
     */
    public JointException() {
        super();
    }

    /**
     * 一参
     */
    public JointException(Integer code) {
        super(code);
    }

    public JointException(String message, Object... params) {
        super(String.format(message, params));
    }

    public JointException(Throwable cause) {
        super(cause);
    }

    public JointException(IDictEnum<Integer, String> dictEnum, Object... params) {
        super(dictEnum.getKey(), String.format(dictEnum.getValue(), params));
    }

    /**
     * 双参
     */
    public JointException(Integer code, Throwable cause) {
        super(code, cause);
    }

    public JointException(String message, Throwable cause, Object... params) {
        super(String.format(message, params), cause);
    }

    public JointException(IDictEnum<Integer, String> dictEnum, Throwable cause, Object... params) {
        super(dictEnum.getKey(), String.format(dictEnum.getValue(), params), cause);
    }

    public JointException(Integer code, IDictEnum<Integer, String> dictEnum, Object... params) {
        super(code, String.format(dictEnum.getValue(), params));
    }

    public JointException(IDictEnum<Integer, String> dictEnum, String message, Object... params) {
        super(dictEnum, String.format(message, params));
    }

    public JointException(Integer code, String message, Object... params) {
        super(code, String.format(message, params));
    }

    /**
     * 三参
     */
    public JointException(Integer code, IDictEnum<Integer, String> dictEnum, Throwable cause, Object... params) {
        super(code, String.format(dictEnum.getValue(), params), cause);
    }

    public JointException(IDictEnum<Integer, String> dictEnum, String message, Throwable cause, Object... params) {
        super(dictEnum, String.format(message, params), cause);
    }

    public JointException(Integer code, String message, Throwable cause, Object... params) {
        super(code, String.format(message, params), cause);
    }

    /**
     * 多参
     */
    public JointException(Integer code, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, cause, enableSuppression, writableStackTrace);
    }

    public JointException(Integer code,
                          IDictEnum<Integer, String> dictEnum,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace,
                          Object... params) {
        super(code, String.format(dictEnum.getValue(), params), cause, enableSuppression, writableStackTrace);
    }

    public JointException(IDictEnum<Integer, String> dictEnum,
                          String message,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace,
                          Object... params) {
        super(dictEnum, String.format(message, params), cause, enableSuppression, writableStackTrace);
    }

    public JointException(IDictEnum<Integer, String> dictEnum,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace,
                          Object... params) {
        super(dictEnum.getKey(), String.format(dictEnum.getValue(), params), cause, enableSuppression, writableStackTrace);
    }

    public JointException(Integer code,
                          String message,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace,
                          Object... params) {
        super(code, String.format(message, params), cause, enableSuppression, writableStackTrace);
    }
}
