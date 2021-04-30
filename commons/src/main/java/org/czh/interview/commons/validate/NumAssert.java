package org.czh.interview.commons.validate;

import org.czh.interview.commons.exceptions.CommonException;

/**
 * @author : czh
 * description : 数字 断言
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class NumAssert {

    /**
     * 判断字符串为数字
     *
     * @param text 文本
     */
    public static void isNumber(final String text) {
        isNumber(text, "[Assertion failed] - this text argument must be a number");
    }

    public static void isNumber(final String text, final String message) {
        if (!NumValidate.isNumber(text)) {
            throw new CommonException(message);
        }
    }

    /**
     * 判断字符串为整数
     *
     * @param text 数值文本
     */
    public static void isInt(final String text) {
        isInt(text, "[Assertion failed] - this text argument must be a int number");
    }

    public static void isInt(final String text, final String message) {
        if (!NumValidate.isInt(text)) {
            throw new CommonException(message);
        }
    }

    /**
     * 判断字符串是否为浮点数
     * 不能用来校验整数 false
     *
     * @param text 数值文本
     */
    public static void isDouble(final String text) {
        isDouble(text, "[Assertion failed] - this text argument must be a double number");
    }

    public static void isDouble(final String text, final String message) {
        if (!NumValidate.isDouble(text)) {
            throw new CommonException(message);
        }
    }

    /**
     * 校验是否是自然数 0、1、2
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     */
    public static void isNaturalInt(final Integer num) {
        isNaturalInt(num, "[Assertion failed] - this text argument must be a natural number");
    }

    public static void isNaturalInt(final Integer num, final String message) {
        if (!NumValidate.isNaturalInt(num)) {
            throw new CommonException(message);
        }
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     */
    public static void isNegativeInt(final Integer num) {
        isNegativeInt(num, "[Assertion failed] - this text argument must be a negative number");
    }

    public static void isNegativeInt(final Integer num, final String message) {
        if (!NumValidate.isNegativeInt(num)) {
            throw new CommonException(message);
        }
    }

    /**
     * 验证是否是正整数 1、2、3
     * 1 - 无穷大
     *
     * @param num 数值包装类
     */
    public static void isPositiveInt(final Integer num) {
        isPositiveInt(num, "[Assertion failed] - this text argument must be a positive number");
    }

    public static void isPositiveInt(final Integer num, final String message) {
        if (!NumValidate.isPositiveInt(num)) {
            throw new CommonException(message);
        }
    }

    /**
     * 校验是否是自然数 0、1、2
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     */
    public static void isNaturalLong(final Long num) {
        isNaturalLong(num, "[Assertion failed] - this text argument must be a natural number");
    }

    public static void isNaturalLong(final Long num, final String message) {
        if (!NumValidate.isNaturalLong(num)) {
            throw new CommonException(message);
        }
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     */
    public static void isNegativeLong(final Long num) {
        isNegativeLong(num, "[Assertion failed] - this text argument must be a negative number");
    }

    public static void isNegativeLong(final Long num, final String message) {
        if (!NumValidate.isNegativeLong(num)) {
            throw new CommonException(message);
        }
    }

    /**
     * 验证是否是正整数 1、2、3
     * 1 - 无穷大
     *
     * @param num 数值包装类
     */
    public static void isPositiveLong(final Long num) {
        isPositiveLong(num, "[Assertion failed] - this text argument must be a positive number");
    }

    public static void isPositiveLong(final Long num, final String message) {
        if (!NumValidate.isPositiveLong(num)) {
            throw new CommonException(message);
        }
    }
}
