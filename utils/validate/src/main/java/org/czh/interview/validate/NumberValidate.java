package org.czh.interview.validate;

/**
 * @author : CZH
 * description : 数值 校验器
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class NumberValidate {

    /*
      -----------------------------Whether the text is numeric-------------------------------
     */

    /**
     * 判断是否是纯数字
     *
     * @param text 文本
     * @return true 数字
     */
    public static boolean isPureNumber(final String text) {
        return EmptyValidate.isNotBlank(text) && text.trim().matches("^[0-9]+$");
    }

    /**
     * 判断字符串为数字
     *
     * @param text 文本
     * @return true 数字
     */
    public static boolean isNumber(final String text) {
        return isDouble(text);
    }

    /**
     * 判断字符串为整数
     *
     * @param text 数值文本
     * @return true 整数
     */
    public static boolean isInt(final String text) {
        if (EmptyValidate.isBlank(text)) {
            return Boolean.FALSE;
        }

        try {
            Long.parseLong(text.trim());
        } catch (NumberFormatException e) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * 判断字符串是否为浮点数
     * 不能用来校验整数 false
     *
     * @param text 数值文本
     * @return true 小数
     */
    public static boolean isDouble(final String text) {
        if (EmptyValidate.isBlank(text)) {
            return Boolean.FALSE;
        }

        try {
            Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /*
      -----------------------------Integer validate-------------------------------
     */

    /**
     * 校验是否是自然数
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     * @return true 自然数
     */
    public static boolean isNaturalInt(final int num) {
        return num >= 0;
    }

    /**
     * 校验是否是自然数
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     * @return true 自然数
     */
    public static boolean isNaturalInt(final Integer num) {
        return EmptyValidate.isNotNull(num) && num >= 0;
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     * @return true 负整数
     */
    public static boolean isNegativeInt(final int num) {
        return num < 0;
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     * @return true 负整数
     */
    public static boolean isNegativeInt(final Integer num) {
        return EmptyValidate.isNotNull(num) && num < 0;
    }

    /**
     * 验证是否是正整数
     * 1 - 无穷大
     *
     * @param num 数值包装类
     * @return true 正整数
     */
    public static boolean isPositiveInt(final int num) {
        return num > 0;
    }

    /**
     * 验证是否是正整数
     * 1 - 无穷大
     *
     * @param num 数值包装类
     * @return true 正整数
     */
    public static boolean isPositiveInt(final Integer num) {
        return EmptyValidate.isNotNull(num) && num > 0;
    }

    /*
      -----------------------------Long validate-------------------------------
     */

    /**
     * 校验是否是自然数
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     * @return true 自然数
     */
    public static boolean isNaturalLong(final long num) {
        return num >= 0L;
    }

    /**
     * 校验是否是自然数
     * 0 - 无穷大
     *
     * @param num 数值 包装类
     * @return true 自然数
     */
    public static boolean isNaturalLong(final Long num) {
        return EmptyValidate.isNotNull(num) && num >= 0L;
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     * @return true 负整数
     */
    public static boolean isNegativeLong(final long num) {
        return num < 0L;
    }

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     * @return true 负整数
     */
    public static boolean isNegativeLong(final Long num) {
        return EmptyValidate.isNotNull(num) && num < 0L;
    }

    /**
     * 验证是否是正整数
     * 1 - 无穷大
     *
     * @param num 数值包装类
     * @return true 正整数
     */
    public static boolean isPositiveLong(final long num) {
        return num > 0L;
    }

    /**
     * 验证是否是正整数
     * 1 - 无穷大
     *
     * @param num 数值包装类
     * @return true 正整数
     */
    public static boolean isPositiveLong(final Long num) {
        return EmptyValidate.isNotNull(num) && num > 0L;
    }
}
