package org.czh.interview.validate;

/**
 * @author : CZH
 * description : 布尔 校验器
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class FlagValidate {

    /*
      -----------------------------true validate-------------------------------
     */

    public static boolean isTrue(final Boolean flag) {
        return EmptyValidate.isNotNull(flag) && flag;
    }

    public static boolean isTrue(final int num) {
        return num > 0;
    }

    public static boolean isTrue(final Integer num) {
        return EmptyValidate.isNotNull(num) && num > 0;
    }

    public static boolean isTrue(final long num) {
        return num > 0L;
    }

    public static boolean isTrue(final Long num) {
        return EmptyValidate.isNotNull(num) && num > 0L;
    }

    /*
      -----------------------------null/true validate-------------------------------
     */

    public static boolean isNullOrTrue(final Boolean flag) {
        return EmptyValidate.isNull(flag) || flag;
    }

    public static boolean isNullOrTrue(final Integer num) {
        return EmptyValidate.isNull(num) || num > 0;
    }

    public static boolean isNullOrTrue(final Long num) {
        return EmptyValidate.isNull(num) || num > 0L;
    }

    /*
      -----------------------------false validate-------------------------------
     */

    public static boolean isFalse(final Boolean flag) {
        return EmptyValidate.isNotNull(flag) && !flag;
    }

    public static boolean isFalse(final int num) {
        return num <= 0;
    }

    public static boolean isFalse(final Integer num) {
        return EmptyValidate.isNotNull(num) && num <= 0;
    }

    public static boolean isFalse(final long num) {
        return num <= 0L;
    }

    public static boolean isFalse(final Long num) {
        return EmptyValidate.isNotNull(num) && num <= 0L;
    }

    /*
      -----------------------------null/false validate-------------------------------
     */

    public static boolean isNullOrFalse(final Boolean flag) {
        return EmptyValidate.isNull(flag) || !flag;
    }

    public static boolean isNullOrFalse(final Integer num) {
        return EmptyValidate.isNull(num) || num <= 0;
    }

    public static boolean isNullOrFalse(final Long num) {
        return EmptyValidate.isNull(num) || num <= 0L;
    }
}
