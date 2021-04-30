package org.czh.interview.commons.validate;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author : czh
 * description : 空 判断
 * date : 2021-04-28
 * email 916419307@qq.com
 */
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
        return StringUtils.isEmpty(text);
    }

    /**
     * 判断 文本 是否不为空、不为空字符串
     * 不属于 null && ""
     *
     * @param text 文本
     * @return true 文本不为空、不为空字符串
     */
    public static boolean isNotEmpty(final String text) {
        return StringUtils.isNotEmpty(text);
    }

    /**
     * 判断 文本 是否为空、或为空字符串、或为空格字符串
     * 属于 null || "" || " " || "\n" || "\t" || "\r" || " \n\t\r"
     *
     * @param text 文本
     * @return true 文本为空、或为空字符串、或为空格字符串
     */
    public static boolean isBlank(final String text) {
        return StringUtils.isBlank(text);
    }

    /**
     * 判断 文本 是否不为空、不为空字符串、不为空格字符串
     * 不属于 null && "" && " " && "\n" && "\t" && "\r" && " \n\t\r"
     *
     * @param text 文本
     * @return true 文本不为空、不为空字符串、不为空格字符串
     */
    public static boolean isNotBlank(final String text) {
        return StringUtils.isNotBlank(text);
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
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断 集合 不为空、不为空集
     * 不属于 null && new List<>() 空集 && new Set<>() 空集
     *
     * @param collection 集合
     * @return true 集合 不为空、不为空集
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return CollectionUtils.isNotEmpty(collection);
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
        return MapUtils.isEmpty(map);
    }

    /**
     * 校验 键值对 不为空、不为空集
     * 不属于 null && new HashMap<>() 空集
     *
     * @param map 键值对
     * @return true 键值对 不为空、不为空集
     */
    public static boolean isNotEmpty(final Map<?, ?> map) {
        return MapUtils.isNotEmpty(map);
    }

    /*
      -----------------------------array validate-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param bs 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final byte[] bs) {
        return ArrayUtils.isEmpty(bs);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new byte[0]
     * new byte[1] 不为空，有默认1个元素 0
     *
     * @param bs 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final byte[] bs) {
        return ArrayUtils.isNotEmpty(bs);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param ss 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final short[] ss) {
        return ArrayUtils.isEmpty(ss);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new short[0]
     * new short[1] 不为空，有默认1个元素 0
     *
     * @param ss 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final short[] ss) {
        return ArrayUtils.isNotEmpty(ss);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param is 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final int[] is) {
        return ArrayUtils.isEmpty(is);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new int[0]
     * new int[1] 不为空，有默认1个元素 0
     *
     * @param is 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final int[] is) {
        return ArrayUtils.isNotEmpty(is);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param ls 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final long[] ls) {
        return ArrayUtils.isEmpty(ls);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new long[0]
     * new long[1] 不为空，有默认1个元素 0
     *
     * @param ls 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final long[] ls) {
        return ArrayUtils.isNotEmpty(ls);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param fs 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final float[] fs) {
        return ArrayUtils.isEmpty(fs);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new float[0]
     * new float[1] 不为空，有默认1个元素 0.0
     *
     * @param fs 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final float[] fs) {
        return ArrayUtils.isNotEmpty(fs);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param ds 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final double[] ds) {
        return ArrayUtils.isEmpty(ds);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new double[0]
     * new double[1] 不为空，有默认1个元素 0.0
     *
     * @param ds 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final double[] ds) {
        return ArrayUtils.isNotEmpty(ds);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param cs 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final char[] cs) {
        return ArrayUtils.isEmpty(cs);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new char[0]
     * new char[1] 不为空，有默认1个元素 '\u0000'
     *
     * @param cs 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final char[] cs) {
        return ArrayUtils.isNotEmpty(cs);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param bs 数组
     * @return true 数组 为空、或为空数组
     */
    public static boolean isEmpty(final boolean[] bs) {
        return ArrayUtils.isEmpty(bs);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new boolean[0]
     * new boolean[1] 不为空，有默认1个元素 false
     *
     * @param bs 数组
     * @return true 数组 不为空、不为空数组
     */
    public static boolean isNotEmpty(final boolean[] bs) {
        return ArrayUtils.isNotEmpty(bs);
    }

    /**
     * 校验 数组 为空、或为空数组
     * 属于 null || new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param ts  数组
     * @param <T> 数组类型
     * @return true 数组 为空、或为空数组
     */
    public static <T> boolean isEmpty(final T[] ts) {
        return ArrayUtils.isEmpty(ts);
    }

    /**
     * 校验 数组 不为空、不为空数组
     * 不属于 null && new T[0]
     * new T[1] 不为空，有默认1个元素 null
     *
     * @param ts  数组
     * @param <T> 数组类型
     * @return true 数组 不为空、不为空数组
     */
    public static <T> boolean isNotEmpty(final T[] ts) {
        return ArrayUtils.isNotEmpty(ts);
    }
}
