package org.czh.interview.commons.validate;

import org.czh.interview.commons.exceptions.CommonException;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
public final class EqualsAssert {

    public static <T> void equals(final T target, final T compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static <T> void equals(final T target, final T compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static <T> void equals(final T[] target, final T[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static <T> void equals(final T[] target, final T[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final byte[] target, final byte[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final byte[] target, final byte[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final short[] target, final short[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final short[] target, final short[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final int[] target, final int[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final int[] target, final int[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final long[] target, final long[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final long[] target, final long[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final float[] target, final float[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final float[] target, final float[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final double[] target, final double[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final double[] target, final double[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final char[] target, final char[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final char[] target, final char[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void equals(final boolean[] target, final boolean[] compare) {
        equals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void equals(final boolean[] target, final boolean[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

}
