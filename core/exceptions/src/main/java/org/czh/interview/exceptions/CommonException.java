package org.czh.interview.exceptions;

import lombok.Getter;
import org.czh.interview.enums.IDictEnum;

/**
 * @author : CZH
 * description : 通用异常
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@Getter
@SuppressWarnings("unused")
public class CommonException extends RuntimeException {

    private static final int DEFAULT_EXCEPTION_CODE = -99;
    private static final String DEFAULT_EXCEPTION_MESSAGE = "Common Exception";

    protected final Integer code;

    /**
     * 空参
     */
    public CommonException() {
        this(DEFAULT_EXCEPTION_MESSAGE);
    }

    /**
     * 一参
     */
    public CommonException(Integer code) {
        this(code, DEFAULT_EXCEPTION_MESSAGE);
    }

    public CommonException(String message) {
        this(DEFAULT_EXCEPTION_CODE, message);
    }

    public CommonException(Throwable cause) {
        this(DEFAULT_EXCEPTION_CODE, DEFAULT_EXCEPTION_MESSAGE, cause);
    }

    public CommonException(IDictEnum<Integer, String> dictEnum) {
        this(dictEnum.getKey(), dictEnum.getValue());
    }

    /**
     * 双参
     */
    public CommonException(Integer code, Throwable cause) {
        this(code, cause.getMessage(), cause);
    }

    public CommonException(String message, Throwable cause) {
        this(DEFAULT_EXCEPTION_CODE, message, cause);
    }

    public CommonException(IDictEnum<Integer, String> dictEnum,
                           Throwable cause) {
        this(dictEnum.getKey(), dictEnum.getValue(), cause);
    }

    public CommonException(Integer code, IDictEnum<Integer, String> dictEnum) {
        this(code, dictEnum.getValue());
    }

    public CommonException(IDictEnum<Integer, String> dictEnum, String message) {
        this(dictEnum.getKey(), message);
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 三参
     */
    public CommonException(Integer code, IDictEnum<Integer, String> dictEnum, Throwable cause) {
        this(code, dictEnum.getValue(), cause);
    }

    public CommonException(IDictEnum<Integer, String> dictEnum, String message, Throwable cause) {
        this(dictEnum.getKey(), message, cause);
    }

    public CommonException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * 多参
     */
    public CommonException(Integer code,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        this(code, cause.getMessage(), cause, enableSuppression, writableStackTrace);
    }

    public CommonException(Integer code,
                           IDictEnum<Integer, String> dictEnum,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        this(code, dictEnum.getValue(), cause, enableSuppression, writableStackTrace);
    }

    public CommonException(IDictEnum<Integer, String> dictEnum,
                           String message,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        this(dictEnum.getKey(), message, cause, enableSuppression, writableStackTrace);
    }

    public CommonException(IDictEnum<Integer, String> dictEnum,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        this(dictEnum.getKey(), dictEnum.getValue(), cause, enableSuppression, writableStackTrace);
    }

    public CommonException(Integer code,
                           String message,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
