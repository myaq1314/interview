package org.czh.interview.asserts;

import org.czh.interview.enums.IDictEnum;
import org.czh.interview.enums.IKeyEnum;
import org.czh.interview.exceptions.CommonException;
import org.czh.interview.validate.FlagValidate;

/**
 * @author : CZH
 * description : 布尔值 断言
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class FlagAssert {

    /*
      -----------------------------true expression assert-------------------------------
     */

    /**
     * 校验 对象 是否为true
     *
     * @param expression boolean 对象
     */
    public static void isTrue(final boolean expression) {
        if (!expression) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final boolean expression, final String message) {
        if (!expression) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final boolean expression, final Integer code, final String message) {
        if (!expression) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final boolean expression, final IKeyEnum<Integer> keyEnum, final String message) {
        if (!expression) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final boolean expression, final IDictEnum<Integer, String> dictEnum) {
        if (!expression) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final boolean expression, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (!expression) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------true flag assert-------------------------------
     */

    public static void isTrue(final Boolean flag) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final Boolean flag, final String message) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final Boolean flag, final Integer code, final String message) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final Boolean flag, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final Boolean flag, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final Boolean flag, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrFalse(flag)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------int true flag assert-------------------------------
     */

    public static void isTrue(final int num) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final int num, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final int num, final Integer code, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final int num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final int num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final int num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------long true flag assert-------------------------------
     */

    public static void isTrue(final long num) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final long num, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final long num, final Integer code, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Integer true flag assert-------------------------------
     */

    public static void isTrue(final Integer num) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final Integer num, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final Integer num, final Integer code, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Long true flag assert-------------------------------
     */

    public static void isTrue(final Long num) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isTrue(final Long num, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isTrue(final Long num, final Integer code, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isTrue(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isTrue(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isTrue(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or true flag assert-------------------------------
     */

    public static void isNullOrTrue(final Boolean flag) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException("[Assertion failed] - this expression argument must be null or true");
        }
    }

    public static void isNullOrTrue(final Boolean flag, final String message) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrTrue(final Boolean flag, final Integer code, final String message) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrTrue(final Boolean flag, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrTrue(final Boolean flag, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrTrue(final Boolean flag, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isFalse(flag)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or Integer true flag assert-------------------------------
     */

    public static void isNullOrTrue(final Integer num) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be null or true");
        }
    }

    public static void isNullOrTrue(final Integer num, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrTrue(final Integer num, final Integer code, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrTrue(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrTrue(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrTrue(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or Long true flag assert-------------------------------
     */

    public static void isNullOrTrue(final Long num) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be null or true");
        }
    }

    public static void isNullOrTrue(final Long num, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrTrue(final Long num, final Integer code, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrTrue(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrTrue(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrTrue(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isFalse(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------false expression assert-------------------------------
     */

    /**
     * 校验 对象 是否为false
     *
     * @param expression boolean 对象
     */
    public static void isFalse(final boolean expression) {
        if (expression) {
            throw new CommonException("[Assertion failed] - this expression argument must be false");
        }
    }

    public static void isFalse(final boolean expression, final String message) {
        if (expression) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final boolean expression, final Integer code, final String message) {
        if (expression) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final boolean expression, final IKeyEnum<Integer> keyEnum, final String message) {
        if (expression) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final boolean expression, final IDictEnum<Integer, String> dictEnum) {
        if (expression) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final boolean expression, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (expression) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------false flag assert-------------------------------
     */

    public static void isFalse(final Boolean flag) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException("[Assertion failed] - this expression argument must be false");
        }
    }

    public static void isFalse(final Boolean flag, final String message) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final Boolean flag, final Integer code, final String message) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final Boolean flag, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final Boolean flag, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final Boolean flag, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrTrue(flag)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------int false flag assert-------------------------------
     */

    public static void isFalse(final int num) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isFalse(final int num, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final int num, final Integer code, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final int num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final int num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final int num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------long false flag assert-------------------------------
     */

    public static void isFalse(final long num) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isFalse(final long num, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final long num, final Integer code, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Integer false flag assert-------------------------------
     */

    public static void isFalse(final Integer num) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isFalse(final Integer num, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final Integer num, final Integer code, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------Long false flag assert-------------------------------
     */

    public static void isFalse(final Long num) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be true");
        }
    }

    public static void isFalse(final Long num, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isFalse(final Long num, final Integer code, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isFalse(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isFalse(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isFalse(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isNullOrTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or false flag assert-------------------------------
     */

    public static void isNullOrFalse(final Boolean flag) {
        isNullOrFalse(flag, "[Assertion failed] - this expression argument must be null or false");
    }

    public static void isNullOrFalse(final Boolean flag, final String message) {
        if (FlagValidate.isTrue(flag)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrFalse(final Boolean flag, final Integer code, final String message) {
        if (FlagValidate.isTrue(flag)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrFalse(final Boolean flag, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isTrue(flag)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrFalse(final Boolean flag, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isTrue(flag)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrFalse(final Boolean flag, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isTrue(flag)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or Integer false flag assert-------------------------------
     */

    public static void isNullOrFalse(final Integer num) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be null or true");
        }
    }

    public static void isNullOrFalse(final Integer num, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrFalse(final Integer num, final Integer code, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrFalse(final Integer num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrFalse(final Integer num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrFalse(final Integer num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }

    /*
      -----------------------------null or Long false flag assert-------------------------------
     */

    public static void isNullOrFalse(final Long num) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException("[Assertion failed] - this expression argument must be null or true");
        }
    }

    public static void isNullOrFalse(final Long num, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(message);
        }
    }

    public static void isNullOrFalse(final Long num, final Integer code, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(code, message);
        }
    }

    public static void isNullOrFalse(final Long num, final IKeyEnum<Integer> keyEnum, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(keyEnum.getKey(), message);
        }
    }

    public static void isNullOrFalse(final Long num, final IDictEnum<Integer, String> dictEnum) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
    }

    public static void isNullOrFalse(final Long num, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (FlagValidate.isTrue(num)) {
            throw new CommonException(dictEnum.getKey(), message);
        }
    }
}
