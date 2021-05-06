package org.czh.interview.commons.validate;

import org.czh.interview.commons.exceptions.CommonException;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class EqualsAssert {

    @SafeVarargs
    public static <T> void allEquals(final T... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static <T> void isEquals(final T target, final T compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static <T> void isEquals(final T target, final T compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    @SafeVarargs
    public static <T> void isEquals(final T[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static <T> void isEquals(final T[] target, final T[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static <T> void isEquals(final T[] target, final T[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final byte[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final byte[] target, final byte[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final byte[] target, final byte[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final short[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final short[] target, final short[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final short[] target, final short[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final int[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final int[] target, final int[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final int[] target, final int[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final long[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final long[] target, final long[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final long[] target, final long[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final float[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final float[] target, final float[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final float[] target, final float[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final double[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final double[] target, final double[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final double[] target, final double[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final char[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final char[] target, final char[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final char[] target, final char[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

    public static void allEquals(final boolean[]... targets) {
        EmptyAssert.isNotEmpty(targets);
        for (int i = 1; i < targets.length; i++) {
            isEquals(targets[i - 1], targets[i],
                    String.format("[Assertion failed] - the targets[%d] argument must equals the targets[%d] argument", i - 1, i));
        }
    }

    public static void isEquals(final boolean[] target, final boolean[] compare) {
        isEquals(target, compare, "[Assertion failed] - the target argument must equals the compare argument");
    }

    public static void isEquals(final boolean[] target, final boolean[] compare, final String message) {
        if (!EqualsValidate.equals(target, compare)) {
            throw new CommonException(message);
        }
    }

}
