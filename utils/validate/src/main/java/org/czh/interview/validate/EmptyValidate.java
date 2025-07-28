package org.czh.interview.validate;

import org.czh.interview.exceptions.CommonException;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @author : CZH
 * description : 空 校验器 （空 空集 空文本 空白文本）
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class EmptyValidate {

    /*
      -----------------------------null validate-------------------------------
     */

    /**
     * 校验 对象 为空
     * 属于 null
     *
     * @param t   对象
     * @param <T> 对象类型
     * @return true 对象为空
     */
    public static <T> boolean isNull(final T t) {
        return t == null;
    }

    /**
     * 校验 对象 不为空
     * 不属于 null
     *
     * @param t   对象
     * @param <T> 对象类型
     * @return true 对象不为空
     */
    public static <T> boolean isNotNull(final T t) {
        return t != null;
    }

    /*
      -----------------------------all null validate-------------------------------
     */

    /**
     * 校验 对象数组中每一个对象 皆为空
     * 属于 null
     *
     * @param ts  对象数组
     * @param <T> 对象类型
     * @return true 对象数组中每一个对象 皆为空
     */
    @SafeVarargs
    public static <T> boolean allNull(final T... ts) {
        if (ts == null) {
            throw new CommonException("[Assertion failed] - this ts argument must be not null");
        }

        boolean global = true;
        for (T t : ts) {
            global &= isNull(t);
        }
        return global;
    }

    /**
     * 校验 对象数组中每一个对象 皆不为空
     * 不属于 null
     *
     * @param ts  对象数组
     * @param <T> 对象类型
     * @return true 对象数组中每一个对象 皆不为空
     */
    @SafeVarargs
    public static <T> boolean allNotNull(final T... ts) {
        if (ts == null) {
            throw new CommonException("[Assertion failed] - this ts argument must be not null");
        }

        boolean global = true;
        for (T t : ts) {
            global &= isNotNull(t);
        }
        return global;
    }

    /*
      -----------------------------text validate-------------------------------
     */

    /**
     * 判断 文本 是否为空、或为空字符串
     * 属于 null || ""
     *
     * @param text 文本
     * @return true 文本为空、或为空字符串
     */
    public static boolean isEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    /**
     * 判断 文本 是否不为空、不为空字符串
     * 不属于 null && ""
     *
     * @param text 文本
     * @return true 文本不为空、不为空字符串
     */
    public static boolean isNotEmpty(final String text) {
        return !isEmpty(text);
    }

    /**
     * 判断 文本 是否为空、或为空字符串、或为空格字符串
     * null、空字符串、空格、退格\b、换页\f、换行\n、回车\r、制表\t
     *
     * @param text 文本
     * @return true 文本为空、或为空字符串、或为空格字符串
     */
    public static boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }

    /**
     * 判断 文本 是否不为空、不为空字符串、不为空格字符串
     * 不属于 null && "" && " " && "\n" && "\t" && "\r" && " \n\t\r"
     *
     * @param text 文本
     * @return true 文本不为空、不为空字符串、不为空格字符串
     */
    public static boolean isNotBlank(final String text) {
        return !isBlank(text);
    }

    /*
      -----------------------------all text validate-------------------------------
     */

    /**
     * 判断 文本数组中每一个文本 皆为空、或为空字符串
     * 属于 null || ""
     *
     * @param texts 文本数组
     * @return true 文本数组中每一个文本 皆为空、或为空字符串
     */
    public static boolean allEmpty(final String... texts) {
        if (texts == null) {
            throw new CommonException("[Assertion failed] - this texts argument must be not null");
        }

        boolean global = true;
        for (String text : texts) {
            global &= isEmpty(text);
        }
        return global;
    }

    /**
     * 判断 文本数组中每一个文本 皆不为空、并且不为空字符串
     * 不属于 null && ""
     *
     * @param texts 文本数组
     * @return true 文本数组中每一个文本 皆不为空、并且不为空字符串
     */
    public static boolean allNotEmpty(final String... texts) {
        if (texts == null) {
            throw new CommonException("[Assertion failed] - this texts argument must be not null");
        }

        boolean global = true;
        for (String text : texts) {
            global &= isNotEmpty(text);
        }
        return global;
    }

    /**
     * 判断 文本数组中每一个文本 皆为空、或为空字符串、或为空格字符串
     * null、空字符串、空格、退格\b、换页\f、换行\n、回车\r、制表\t
     *
     * @param texts 文本数组
     * @return true 文本数组中每一个文本 皆为空、或为空字符串、或为空格字符串
     */
    public static boolean allBlank(final String... texts) {
        if (texts == null) {
            throw new CommonException("[Assertion failed] - this texts argument must be not null");
        }

        boolean global = true;
        for (String text : texts) {
            global &= isBlank(text);
        }
        return global;
    }

    /**
     * 判断 文本数组中每一个文本 皆不为空、并且不为空字符串、并且不为空格字符串
     * 不属于 null && "" && " " && "\n" && "\t" && "\r" && " \n\t\r"
     *
     * @param texts 文本数组
     * @return true 文本数组中每一个文本 皆不为空、并且不为空字符串、并且不为空格字符串
     */
    public static boolean allNotBlank(final String... texts) {
        if (texts == null) {
            throw new CommonException("[Assertion failed] - this texts argument must be not null");
        }

        boolean global = true;
        for (String text : texts) {
            global &= isNotBlank(text);
        }
        return global;
    }

    /*
      -----------------------------collection validate-------------------------------
     */

    /**
     * 判断 集合 为空、或为空集
     * 属于 null || new List<>() 空集 || new Set<>() 空集
     *
     * @param collection 集合
     * @return true 集合为空、或为空集
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断 集合 不为空、不为空集
     * 不属于 null && new List<>() 空集 && new Set<>() 空集
     *
     * @param collection 集合
     * @return true 集合 不为空、不为空集
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return !isEmpty(collection);
    }

    /*
      -----------------------------all collection validate-------------------------------
     */

    /**
     * 判断 集合数组中每一个集合 为空、或为空集
     * 属于 null || new List<>() 空集 || new Set<>() 空集
     *
     * @param collections 集合数组
     * @return true 集合数组中每一个集合 为空、或为空集
     */
    public static boolean allEmpty(final Collection<?>... collections) {
        if (collections == null) {
            throw new CommonException("[Assertion failed] - this collections argument must be not null");
        }

        boolean global = true;
        for (Collection<?> collection : collections) {
            global &= isEmpty(collection);
        }
        return global;
    }

    /**
     * 判断 集合数组中每一个集合 不为空、并且不为空集
     * 不属于 null && new List<>() 空集 && new Set<>() 空集
     *
     * @param collections 集合数组
     * @return true 集合数组中每一个集合 不为空、并且不为空集
     */
    public static boolean allNotEmpty(final Collection<?>... collections) {
        if (collections == null) {
            throw new CommonException("[Assertion failed] - this collections argument must be not null");
        }

        boolean global = true;
        for (Collection<?> collection : collections) {
            global &= isNotEmpty(collection);
        }
        return global;
    }

    /*
      -----------------------------map validate-------------------------------
     */

    /**
     * 校验 键值对 为空、或为空集
     * 属于 null || new HashMap<>() 空集
     *
     * @param map 键值对
     * @return true 键值对 为空、或为空集
     */
    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 校验 键值对 不为空、不为空集
     * 不属于 null && new HashMap<>() 空集
     *
     * @param map 键值对
     * @return true 键值对 不为空、不为空集
     */
    public static boolean isNotEmpty(final Map<?, ?> map) {
        return !isEmpty(map);
    }

    /*
      -----------------------------all map validate-------------------------------
     */

    /**
     * 校验 键值对数组中每一个键值对 为空、或为空集
     * 属于 null || new HashMap<>() 空集
     *
     * @param maps 键值对数组
     * @return true 键值对数组中每一个键值对 为空、或为空集
     */
    public static boolean allEmpty(final Map<?, ?>... maps) {
        if (maps == null) {
            throw new CommonException("[Assertion failed] - this maps argument must be not null");
        }

        boolean global = true;
        for (Map<?, ?> map : maps) {
            global &= isEmpty(map);
        }
        return global;
    }

    /**
     * 校验 键值对数组中每一个集合 不为空、并且不为空集
     * 不属于 null && new HashMap<>() 空集
     *
     * @param maps 键值对数组
     * @return true 键值对数组中每一个集合 不为空、并且不为空集
     */
    public static boolean allNotEmpty(final Map<?, ?>... maps) {
        if (maps == null) {
            throw new CommonException("[Assertion failed] - this maps argument must be not null");
        }

        boolean global = true;
        for (Map<?, ?> map : maps) {
            global &= isNotEmpty(map);
        }
        return global;
    }

    /*
      -----------------------------byte array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final byte[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final byte[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all byte array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean isEmpty(final byte[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (byte[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean isNotEmpty(final byte[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (byte[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------short array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final short[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final short[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all short array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final short[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (short[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean allNotEmpty(final short[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (short[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------int array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final int[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final int[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all int array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final int[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (int[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean allNotEmpty(final int[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (int[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------long array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final long[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final long[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all long array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final long[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (long[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean allNotEmpty(final long[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (long[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------float array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final float[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final float[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all float array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final float[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (float[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean isNotEmpty(final float[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (float[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------double array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final double[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final double[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all double array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final double[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (double[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean isNotEmpty(final double[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (double[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------char array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final char[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final char[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all char array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final char[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (char[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean isNotEmpty(final char[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (char[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------boolean array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param array 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final boolean[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param array 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final boolean[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------all boolean array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    public static boolean allEmpty(final boolean[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (boolean[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param arrays 二维数组
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    public static boolean isNotEmpty(final boolean[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (boolean[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }

    /*
      -----------------------------object array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param array 数组
     * @param <T>   数组类型
     * @return true 数组 为空、或为空数组
     */
    public static <T> boolean isEmpty(final T[] array) {
        return array == null || Array.getLength(array) == 0;
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param array 数组
     * @param <T>   数组类型
     * @return true 数组 不为空、不为空数组
     */
    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    /*
      -----------------------------object array validate-------------------------------
     */

    /**
     * 校验 二维数组中每一个一维数组 为空、或为空数组
     * 属于 null || new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param arrays 二维数组
     * @param <T>    数组类型
     * @return true 二维数组中每一个一维数组 为空、或为空数组
     */
    @SafeVarargs
    public static <T> boolean allEmpty(final T[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (T[] array : arrays) {
            global &= isEmpty(array);
        }
        return global;
    }

    /**
     * 校验 二维数组中每一个一维数组 不为空、并且不为空数组
     * 不属于 null && new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param arrays 二维数组
     * @param <T>    数组类型
     * @return true 二维数组中每一个一维数组 不为空、并且不为空数组
     */
    @SafeVarargs
    public static <T> boolean isNotEmpty(final T[]... arrays) {
        if (arrays == null) {
            throw new CommonException("[Assertion failed] - this arrays argument must be not null");
        }

        boolean global = true;
        for (T[] array : arrays) {
            global &= isNotEmpty(array);
        }
        return global;
    }
}
