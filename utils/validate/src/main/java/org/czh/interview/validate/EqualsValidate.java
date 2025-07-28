package org.czh.interview.validate;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author : CZH
 * description : 相等 校验器
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class EqualsValidate {

    public static boolean isNotEquals(final byte target, final byte compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final byte target, final byte compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final short target, final short compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final short target, final short compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final int target, final int compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final int target, final int compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final long target, final long compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final long target, final long compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final float target, final float compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final float target, final float compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final double target, final double compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final double target, final double compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final boolean target, final boolean compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final boolean target, final boolean compare) {
        return target == compare;
    }

    public static boolean isNotEquals(final char target, final char compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final char target, final char compare) {
        return target == compare;
    }

    public static <T> boolean isNotEquals(final T target, final T compare) {
        return !isEquals(target, compare);
    }

    public static <T> boolean isEquals(final T target, final T compare) {
        if (target == compare) {
            return true;
        }
        if (target == null || compare == null) {
            return false;
        }
        if (target.getClass().isArray()) {
            boolean check;
            if (byte[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((byte[]) target, (byte[]) compare);
            } else if (short[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((short[]) target, (short[]) compare);
            } else if (int[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((int[]) target, (int[]) compare);
            } else if (long[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((long[]) target, (long[]) compare);
            } else if (float[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((float[]) target, (float[]) compare);
            } else if (double[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((double[]) target, (double[]) compare);
            } else if (boolean[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((boolean[]) target, (boolean[]) compare);
            } else if (char[].class.isAssignableFrom(target.getClass())) {
                check = isEquals((char[]) target, (char[]) compare);
            } else {
                //noinspection unchecked
                check = isEquals((T[]) target, (T[]) compare);
            }
            return check;
        } else {
            return Objects.equals(target, compare);
        }

    }

    public static <T> boolean isNotEquals(final T[] target, final T[] compare) {
        return !isEquals(target, compare);
    }

    public static <T> boolean isEquals(final T[] target, final T[] compare) {
        return Arrays.deepEquals(target, compare);
    }

    public static boolean isNotEquals(final byte[] target, final byte[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final byte[] target, final byte[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final short[] target, final short[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final short[] target, final short[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final int[] target, final int[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final int[] target, final int[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final long[] target, final long[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final long[] target, final long[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final float[] target, final float[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final float[] target, final float[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final double[] target, final double[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final double[] target, final double[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final char[] target, final char[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final char[] target, final char[] compare) {
        return Arrays.equals(target, compare);
    }

    public static boolean isNotEquals(final boolean[] target, final boolean[] compare) {
        return !isEquals(target, compare);
    }

    public static boolean isEquals(final boolean[] target, final boolean[] compare) {
        return Arrays.equals(target, compare);
    }
}
