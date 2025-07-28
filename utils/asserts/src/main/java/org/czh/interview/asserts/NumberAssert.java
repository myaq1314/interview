package org.czh.interview.asserts;

import org.czh.interview.enums.IDictEnum;
import org.czh.interview.enums.IKeyEnum;
import org.czh.interview.exceptions.CommonException;
import org.czh.interview.validate.NumberValidate;

/**
 * @author : CZH
 * description : 数值 断言
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class NumberAssert {

    /*
      -----------------------------判断是否是纯数字，只包含0到9-------------------------------
     */

    public static void isPureNumber(final String text) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException("[Assertion failed] - The text must be pure numbers");
        }
    }

    public static void isPureNumber(final String text, final String message) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException(message);
        }
    }

    public static void isPureNumber(final String text, final Integer code, final String message) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException(code, message);
        }
    }

    public static void isPureNumber(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isPureNumber(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isPureNumber(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isPureNumber(text)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------判断字符串为数字，包含整数和小数两种-------------------------------
     */
    public static void isNumber(final String text) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException("[Assertion failed] - this text argument must be a number");
        }
    }

    public static void isNumber(final String text, final String message) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException(message);
        }
    }

    public static void isNumber(final String text, final Integer code, final String message) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNumber(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNumber(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNumber(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNumber(text)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------判断字符串为整数，只包含0到9-------------------------------
     */

    public static void isInt(final String text) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException("[Assertion failed] - this text argument must be a int number");
        }
    }

    public static void isInt(final String text, final String message) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException(message);
        }
    }

    public static void isInt(final String text, final Integer code, final String message) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException(code, message);
        }
    }

    public static void isInt(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isInt(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isInt(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isInt(text)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------判断字符串为小数，只包含0到9 小数点-------------------------------
     */

    public static void isDouble(final String text) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException("[Assertion failed] - this text argument must be a double number");
        }
    }

    public static void isDouble(final String text, final String message) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException(message);
        }
    }

    public static void isDouble(final String text, final Integer code, final String message) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException(code, message);
        }
    }

    public static void isDouble(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isDouble(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isDouble(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isDouble(text)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------int数值，是否是自然数 大于等于0-------------------------------
     */

    public static void isNaturalInt(final int num) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a natural number");
        }
    }

    public static void isNaturalInt(final int num, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNaturalInt(final int num, final Integer code, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNaturalInt(final int num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNaturalInt(final int num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNaturalInt(final int num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Integer数值，是否是自然数 大于等于0-------------------------------
     */
    public static void isNaturalInt(final Integer num) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a natural number");
        }
    }

    public static void isNaturalInt(final Integer num, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNaturalInt(final Integer num, final Integer code, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNaturalInt(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNaturalInt(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNaturalInt(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNaturalInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------int数值，是否是负整数 小于0-------------------------------
     */

    public static void isNegativeInt(final int num) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a negative number");
        }
    }

    public static void isNegativeInt(final int num, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNegativeInt(final int num, final Integer code, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNegativeInt(final int num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNegativeInt(final int num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNegativeInt(final int num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Integer数值，是否是负整数 小于0-------------------------------
     */

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     */
    public static void isNegativeInt(final Integer num) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a negative number");
        }
    }

    public static void isNegativeInt(final Integer num, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNegativeInt(final Integer num, final Integer code, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNegativeInt(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNegativeInt(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNegativeInt(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNegativeInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------int数值，是否是正整数 大于0-------------------------------
     */

    public static void isPositiveInt(final int num) {
        isPositiveInt(num, "[Assertion failed] - this text argument must be a positive number");
    }

    public static void isPositiveInt(final int num, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isPositiveInt(final int num, final Integer code, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isPositiveInt(final int num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isPositiveInt(final int num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isPositiveInt(final int num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Integer数值，是否是正整数 大于0-------------------------------
     */

    public static void isPositiveInt(final Integer num) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a positive number");
        }
    }

    public static void isPositiveInt(final Integer num, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(message);
        }
    }

    public static void isPositiveInt(final Integer num, final Integer code, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isPositiveInt(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isPositiveInt(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isPositiveInt(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isPositiveInt(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------long数值，是否是自然数 大于等于0-------------------------------
     */

    public static void isNaturalLong(final long num) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a natural number");
        }
    }

    public static void isNaturalLong(final long num, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNaturalLong(final long num, final Integer code, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNaturalLong(final long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNaturalLong(final long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNaturalLong(final long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Long数值，是否是自然数 大于等于0-------------------------------
     */
    public static void isNaturalLong(final Long num) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a natural number");
        }
    }

    public static void isNaturalLong(final Long num, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNaturalLong(final Long num, final Integer code, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNaturalLong(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNaturalLong(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNaturalLong(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNaturalLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------long数值，是否是负整数 小于0-------------------------------
     */

    public static void isNegativeLong(final long num) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a negative number");
        }
    }

    public static void isNegativeLong(final long num, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNegativeLong(final long num, final Integer code, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNegativeLong(final long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNegativeLong(final long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNegativeLong(final long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Long数值，是否是负整数 小于0-------------------------------
     */

    /**
     * 校验是否是负整数
     * -1 - 无穷小
     *
     * @param num 数值 包装类
     */
    public static void isNegativeLong(final Long num) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a negative number");
        }
    }

    public static void isNegativeLong(final Long num, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNegativeLong(final Long num, final Integer code, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNegativeLong(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNegativeLong(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNegativeLong(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isNegativeLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------long数值，是否是正整数 大于0-------------------------------
     */

    public static void isPositiveLong(final long num) {
        isPositiveLong(num, "[Assertion failed] - this text argument must be a positive number");
    }

    public static void isPositiveLong(final long num, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(message);
        }
    }

    public static void isPositiveLong(final long num, final Integer code, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isPositiveLong(final long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isPositiveLong(final long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isPositiveLong(final long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Long数值，是否是正整数 大于0-------------------------------
     */

    public static Long isPositiveLong(final Long num) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException("[Assertion failed] - this text argument must be a positive number");
        }
        return num;
    }

    public static Long isPositiveLong(final Long num, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(message);
        }
        return num;
    }

    public static Long isPositiveLong(final Long num, final Integer code, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(code, message);
        }
        return num;
    }

    public static Long isPositiveLong(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return num;
    }

    public static Long isPositiveLong(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return num;
    }

    public static Long isPositiveLong(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!NumberValidate.isPositiveLong(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return num;
    }
}
