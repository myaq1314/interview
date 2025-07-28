package org.czh.interview.asserts;

import org.czh.interview.enums.IDictEnum;
import org.czh.interview.enums.IKeyEnum;
import org.czh.interview.exceptions.CommonException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 * @author : CZH
 * description : 空 断言
 * datetime : 2025/7/25
 * email : 916419307@qq.com
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public final class EmptyAssert {

    /*
      -----------------------------null assert-------------------------------
     */

    /**
     * 校验 对象 为空
     *
     * @param t   对象
     * @param <T> 对象类型
     */
    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t) {
        if (t != null) {
            throw new CommonException("[Assertion failed] - this t argument must be null");
        }
        return t;
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t, final String message) {
        if (t != null) {
            throw new CommonException(message);
        }
        return t;
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t, final Integer code, final String message) {
        if (t != null) {
            throw new CommonException(code, message);
        }
        return t;
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t, final IKeyEnum<Integer> keyEnum, final String message) {
        if (t != null) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return t;
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t, final IDictEnum<Integer, String> dictEnum) {
        if (t != null) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return t;
    }

    @SuppressWarnings("ConstantConditions")
    public static <T> T isNull(final T t, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (t != null) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return t;
    }

    @SafeVarargs
    public static <T> T[] allNull(final T... ts) {
        Arrays.stream(EmptyAssert.isNotEmpty(ts)).forEach(EmptyAssert::isNull);
        return ts;
    }

    /**
     * 校验 对象 不为空
     *
     * @param t   对象
     * @param <T> 对象类型
     */
    public static <T> T isNotNull(final T t) {
        if (t == null) {
            throw new CommonException("[Assertion failed] - this t argument must not be null");
        }
        return t;
    }

    public static <T> T isNotNull(final T t, final String message) {
        if (t == null) {
            throw new CommonException(message);
        }
        return t;
    }

    public static <T> T isNotNull(final T t, final Integer code, final String message) {
        if (t == null) {
            throw new CommonException(code, message);
        }
        return t;
    }

    public static <T> T isNotNull(final T t, final IKeyEnum<Integer> keyEnum, final String message) {
        if (t == null) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return t;
    }

    public static <T> T isNotNull(final T t, final IDictEnum<Integer, String> dictEnum) {
        if (t == null) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return t;
    }

    public static <T> T isNotNull(final T t, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (t == null) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return t;
    }

    @SafeVarargs
    public static <T> T[] allNotNull(final T... ts) {
        Arrays.stream(EmptyAssert.isNotEmpty(ts)).forEach(EmptyAssert::isNotNull);
        return ts;
    }


    /*
     * -----------------------------text assert-------------------------------
     */

    /**
     * 判断 文本 是否为空、或为空字符串
     *
     * @param text 文本
     */
    public static String isEmpty(final String text) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException("[Assertion failed] - this text argument must be empty");
        }
        return text;
    }

    public static String isEmpty(final String text, final String message) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException(message);
        }
        return text;
    }

    public static <T> String isEmpty(final String text, final Integer code, final String message) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException(code, message);
        }
        return text;
    }

    public static <T> String isEmpty(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return text;
    }

    public static <T> String isEmpty(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return text;
    }

    public static <T> String isEmpty(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (text != null && !text.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return text;
    }

    public static String[] allEmpty(final String... texts) {
        Arrays.stream(EmptyAssert.isNotEmpty(texts)).forEach(EmptyAssert::isEmpty);
        return texts;
    }

    /**
     * 判断 文本 是否不为空、不为空字符串
     *
     * @param text 文本
     */
    public static String isNotEmpty(final String text) {
        if (text == null || text.isEmpty()) {
            throw new CommonException("[Assertion failed] - this text argument must not be empty");
        }
        return text;
    }

    public static String isNotEmpty(final String text, final String message) {
        if (text == null || text.isEmpty()) {
            throw new CommonException(message);
        }
        return text;
    }

    public static <T> String isNotEmpty(final String text, final Integer code, final String message) {
        if (text == null || text.isEmpty()) {
            throw new CommonException(code, message);
        }
        return text;
    }

    public static <T> String isNotEmpty(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (text == null || text.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return text;
    }

    public static <T> String isNotEmpty(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (text == null || text.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return text;
    }

    public static <T> String isNotEmpty(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (text == null || text.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return text;
    }

    public static String[] allNotEmpty(final String... texts) {
        Arrays.stream(EmptyAssert.isNotEmpty(texts)).forEach(EmptyAssert::isNotEmpty);
        return texts;
    }

    /**
     * 判断 文本 是否为空、或为空字符串、或为空格字符串
     *
     * @param text 文本
     */
    public static String isBlank(final String text) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException("[Assertion failed] - this text argument must be blank");
        }
        return text;
    }

    public static String isBlank(final String text, final String message) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException(message);
        }
        return text;
    }

    public static <T> String isBlank(final String text, final Integer code, final String message) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException(code, message);
        }
        return text;
    }

    public static <T> String isBlank(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return text;
    }

    public static <T> String isBlank(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return text;
    }

    public static <T> String isBlank(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (text != null && !text.trim().isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return text;
    }

    public static String[] allBlank(final String... texts) {
        Arrays.stream(EmptyAssert.isNotEmpty(texts)).forEach(EmptyAssert::isBlank);
        return texts;
    }

    /**
     * 判断 文本 是否不为空、不为空字符串、不为空格字符串
     *
     * @param text 文本
     */
    public static String isNotBlank(final String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException("[Assertion failed] - this text argument must not be blank");
        }
        return text;
    }

    public static String isNotBlank(final String text, final String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException(message);
        }
        return text;
    }

    public static <T> String isNotBlank(final String text, final Integer code, final String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException(code, message);
        }
        return text;
    }

    public static <T> String isNotBlank(final String text, final IKeyEnum<Integer> keyEnum, final String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return text;
    }

    public static <T> String isNotBlank(final String text, final IDictEnum<Integer, String> dictEnum) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return text;
    }

    public static <T> String isNotBlank(final String text, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return text;
    }

    @SuppressWarnings("UnusedReturnValue")
    public static String[] allNotBlank(final String... texts) {
        Arrays.stream(EmptyAssert.isNotEmpty(texts)).forEach(EmptyAssert::isNotBlank);
        return texts;
    }

    /*
     * -----------------------------collection assert-------------------------------
     */

    /**
     * 判断 集合 为空、或为空集
     *
     * @param collection 集合
     */
    public static <T extends Collection<?>> T isEmpty(final T collection) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException("[Assertion failed] - this collection argument must be empty");
        }
        return collection;
    }

    public static <T extends Collection<?>> T isEmpty(final T collection, final String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException(message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isEmpty(final T collection, final Integer code, final String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException(code, message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isEmpty(final T collection, final IKeyEnum<Integer> keyEnum, final String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isEmpty(final T collection, final IDictEnum<Integer, String> dictEnum) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return collection;
    }

    public static <T extends Collection<?>> T isEmpty(final T collection, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return collection;
    }

    public static Collection<?>[] allEmpty(final Collection<?>... collections) {
        Arrays.stream(EmptyAssert.isNotEmpty(collections)).forEach(EmptyAssert::isEmpty);
        return collections;
    }

    /**
     * 判断 集合 不为空、不为空集
     *
     * @param collection 集合
     */
    public static <T extends Collection<?>> T isNotEmpty(final T collection) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException("[Assertion failed] - this collection argument must not be empty");
        }
        return collection;
    }

    public static <T extends Collection<?>> T isNotEmpty(final T collection, final String message) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException(message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isNotEmpty(final T collection, final Integer code, final String message) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException(code, message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isNotEmpty(final T collection, final IKeyEnum<Integer> keyEnum, final String message) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return collection;
    }

    public static <T extends Collection<?>> T isNotEmpty(final T collection, final IDictEnum<Integer, String> dictEnum) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return collection;
    }

    public static <T extends Collection<?>> T isNotEmpty(final T collection,
                                                         final IDictEnum<Integer, String> dictEnum,
                                                         final String message) {
        if (collection == null || collection.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return collection;
    }

    public static Collection<?>[] allNotEmpty(final Collection<?>... collections) {
        Arrays.stream(EmptyAssert.isNotEmpty(collections)).forEach(EmptyAssert::isNotEmpty);
        return collections;
    }

    /*
      -----------------------------map assert-------------------------------
     */

    /**
     * 校验 键值对 为空、或为空集
     *
     * @param map 键值对
     */
    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException("[Assertion failed] - this map argument must be empty");
        }
        return map;
    }

    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map, final String message) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException(message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map, final Integer code, final String message) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException(code, message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map, final IKeyEnum<Integer> keyEnum, final String message) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map, final IDictEnum<Integer, String> dictEnum) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return map;
    }

    public static <K, V> Map<K, V> isEmpty(final Map<K, V> map, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (map != null && !map.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return map;
    }

    public static Map<?, ?>[] allEmpty(final Map<?, ?>... maps) {
        Arrays.stream(EmptyAssert.isNotEmpty(maps)).forEach(EmptyAssert::isEmpty);
        return maps;
    }

    /**
     * 校验 键值对 不为空、不为空集
     *
     * @param map 键值对
     */
    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            throw new CommonException("[Assertion failed] - this map argument must not be empty");
        }
        return map;
    }

    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map, final String message) {
        if (map == null || map.isEmpty()) {
            throw new CommonException(message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map, final Integer code, final String message) {
        if (map == null || map.isEmpty()) {
            throw new CommonException(code, message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map, final IKeyEnum<Integer> keyEnum, final String message) {
        if (map == null || map.isEmpty()) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return map;
    }

    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map, final IDictEnum<Integer, String> dictEnum) {
        if (map == null || map.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return map;
    }

    public static <K, V> Map<K, V> isNotEmpty(final Map<K, V> map, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (map == null || map.isEmpty()) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return map;
    }

    public static Map<?, ?>[] allNotEmpty(final Map<?, ?>... maps) {
        Arrays.stream(EmptyAssert.isNotEmpty(maps)).forEach(EmptyAssert::isNotEmpty);
        return maps;
    }

    /*
      -----------------------------array assert-------------------------------
     */

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param bs 数组
     */
    public static byte[] isEmpty(final byte[] bs) {
        if (bs != null && bs.length > 0) {
            throw new CommonException("[Assertion failed] - this bs array argument must be empty");
        }
        return bs;
    }

    public static byte[] isEmpty(final byte[] bs, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(message);
        }
        return bs;
    }

    public static byte[] isEmpty(final byte[] bs, final Integer code, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(code, message);
        }
        return bs;
    }

    public static byte[] isEmpty(final byte[] bs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return bs;
    }

    public static byte[] isEmpty(final byte[] bs, final IDictEnum<Integer, String> dictEnum) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return bs;
    }

    public static byte[] isEmpty(final byte[] bs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return bs;
    }

    public static byte[][] allEmpty(final byte[]... bss) {
        Arrays.stream(EmptyAssert.isNotEmpty(bss)).forEach(EmptyAssert::isEmpty);
        return bss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param bs 数组
     */
    public static byte[] isNotEmpty(final byte[] bs) {
        if (bs == null || bs.length == 0) {
            throw new CommonException("[Assertion failed] - this bs array argument must not be empty");
        }
        return bs;
    }

    public static byte[] isNotEmpty(final byte[] bs, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(message);
        }
        return bs;
    }

    public static byte[] isNotEmpty(final byte[] bs, final Integer code, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(code, message);
        }
        return bs;
    }

    public static byte[] isNotEmpty(final byte[] bs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return bs;
    }

    public static byte[] isNotEmpty(final byte[] bs, final IDictEnum<Integer, String> dictEnum) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return bs;
    }

    public static byte[] isNotEmpty(final byte[] bs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return bs;
    }

    public static byte[][] allNotEmpty(final byte[]... bss) {
        Arrays.stream(EmptyAssert.isNotEmpty(bss)).forEach(EmptyAssert::isNotEmpty);
        return bss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param ss 数组
     */
    public static short[] isEmpty(final short[] ss) {
        if (ss != null && ss.length > 0) {
            throw new CommonException("[Assertion failed] - this ss array argument must be empty");
        }
        return ss;
    }

    public static short[] isEmpty(final short[] ss, final String message) {
        if (ss != null && ss.length > 0) {
            throw new CommonException(message);
        }
        return ss;
    }

    public static short[] isEmpty(final short[] ss, final Integer code, final String message) {
        if (ss != null && ss.length > 0) {
            throw new CommonException(code, message);
        }
        return ss;
    }

    public static short[] isEmpty(final short[] ss, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ss != null && ss.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ss;
    }

    public static short[] isEmpty(final short[] ss, final IDictEnum<Integer, String> dictEnum) {
        if (ss != null && ss.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ss;
    }

    public static short[] isEmpty(final short[] ss, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ss != null && ss.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ss;
    }

    public static short[][] allEmpty(final short[]... sss) {
        Arrays.stream(EmptyAssert.isNotEmpty(sss)).forEach(EmptyAssert::isEmpty);
        return sss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param ss 数组
     */
    public static short[] isNotEmpty(final short[] ss) {
        if (ss == null || ss.length == 0) {
            throw new CommonException("[Assertion failed] - this ss array argument must not be empty");
        }
        return ss;
    }

    public static short[] isNotEmpty(final short[] ss, final String message) {
        if (ss == null || ss.length == 0) {
            throw new CommonException(message);
        }
        return ss;
    }

    public static short[] isNotEmpty(final short[] ss, final Integer code, final String message) {
        if (ss == null || ss.length == 0) {
            throw new CommonException(code, message);
        }
        return ss;
    }

    public static short[] isNotEmpty(final short[] ss, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ss == null || ss.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ss;
    }

    public static short[] isNotEmpty(final short[] ss, final IDictEnum<Integer, String> dictEnum) {
        if (ss == null || ss.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ss;
    }

    public static short[] isNotEmpty(final short[] ss, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ss == null || ss.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ss;
    }

    public static short[][] allNotEmpty(final short[]... sss) {
        Arrays.stream(EmptyAssert.isNotEmpty(sss)).forEach(EmptyAssert::isNotEmpty);
        return sss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param is 数组
     */
    public static int[] isEmpty(final int[] is) {
        if (is != null && is.length > 0) {
            throw new CommonException("[Assertion failed] - this is array argument must be empty");
        }
        return is;
    }

    public static int[] isEmpty(final int[] is, final String message) {
        if (is != null && is.length > 0) {
            throw new CommonException(message);
        }
        return is;
    }

    public static int[] isEmpty(final int[] is, final Integer code, final String message) {
        if (is != null && is.length > 0) {
            throw new CommonException(code, message);
        }
        return is;
    }

    public static int[] isEmpty(final int[] is, final IKeyEnum<Integer> keyEnum, final String message) {
        if (is != null && is.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return is;
    }

    public static int[] isEmpty(final int[] is, final IDictEnum<Integer, String> dictEnum) {
        if (is != null && is.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return is;
    }

    public static int[] isEmpty(final int[] is, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (is != null && is.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return is;
    }

    public static int[][] allEmpty(final int[]... iss) {
        Arrays.stream(EmptyAssert.isNotEmpty(iss)).forEach(EmptyAssert::isEmpty);
        return iss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param is 数组
     */
    public static int[] isNotEmpty(final int[] is) {
        if (is == null || is.length == 0) {
            throw new CommonException("[Assertion failed] - this is array argument must not be empty");
        }
        return is;
    }

    public static int[] isNotEmpty(final int[] is, final String message) {
        if (is == null || is.length == 0) {
            throw new CommonException(message);
        }
        return is;
    }

    public static int[] isNotEmpty(final int[] is, final Integer code, final String message) {
        if (is == null || is.length == 0) {
            throw new CommonException(code, message);
        }
        return is;
    }

    public static int[] isNotEmpty(final int[] is, final IKeyEnum<Integer> keyEnum, final String message) {
        if (is == null || is.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return is;
    }

    public static int[] isNotEmpty(final int[] is, final IDictEnum<Integer, String> dictEnum) {
        if (is == null || is.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return is;
    }

    public static int[] isNotEmpty(final int[] is, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (is == null || is.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return is;
    }

    public static int[][] allNotEmpty(final int[]... iss) {
        Arrays.stream(EmptyAssert.isNotEmpty(iss)).forEach(EmptyAssert::isNotEmpty);
        return iss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param ls 数组
     */
    public static long[] isEmpty(final long[] ls) {
        if (ls != null && ls.length > 0) {
            throw new CommonException("[Assertion failed] - this ls array argument must be empty");
        }
        return ls;
    }

    public static long[] isEmpty(final long[] ls, final String message) {
        if (ls != null && ls.length > 0) {
            throw new CommonException(message);
        }
        return ls;
    }

    public static long[] isEmpty(final long[] ls, final Integer code, final String message) {
        if (ls != null && ls.length > 0) {
            throw new CommonException(code, message);
        }
        return ls;
    }

    public static long[] isEmpty(final long[] ls, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ls != null && ls.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ls;
    }

    public static long[] isEmpty(final long[] ls, final IDictEnum<Integer, String> dictEnum) {
        if (ls != null && ls.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ls;
    }

    public static long[] isEmpty(final long[] ls, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ls != null && ls.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ls;
    }

    public static long[][] allEmpty(final long[]... lss) {
        Arrays.stream(EmptyAssert.isNotEmpty(lss)).forEach(EmptyAssert::isEmpty);
        return lss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param ls 数组
     */
    public static long[] isNotEmpty(final long[] ls) {
        if (ls == null || ls.length == 0) {
            throw new CommonException("[Assertion failed] - this ls array argument must not be empty");
        }
        return ls;
    }

    public static long[] isNotEmpty(final long[] ls, final String message) {
        if (ls == null || ls.length == 0) {
            throw new CommonException(message);
        }
        return ls;
    }

    public static long[] isNotEmpty(final long[] ls, final Integer code, final String message) {
        if (ls == null || ls.length == 0) {
            throw new CommonException(code, message);
        }
        return ls;
    }

    public static long[] isNotEmpty(final long[] ls, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ls == null || ls.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ls;
    }

    public static long[] isNotEmpty(final long[] ls, final IDictEnum<Integer, String> dictEnum) {
        if (ls == null || ls.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ls;
    }

    public static long[] isNotEmpty(final long[] ls, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ls == null || ls.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ls;
    }

    public static long[][] allNotEmpty(final long[]... lss) {
        Arrays.stream(EmptyAssert.isNotEmpty(lss)).forEach(EmptyAssert::isNotEmpty);
        return lss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param fs 数组
     */
    public static float[] isEmpty(final float[] fs) {
        if (fs != null && fs.length > 0) {
            throw new CommonException("[Assertion failed] - this fs array argument must be empty");
        }
        return fs;
    }

    public static float[] isEmpty(final float[] fs, final String message) {
        if (fs != null && fs.length > 0) {
            throw new CommonException(message);
        }
        return fs;
    }

    public static float[] isEmpty(final float[] fs, final Integer code, final String message) {
        if (fs != null && fs.length > 0) {
            throw new CommonException(code, message);
        }
        return fs;
    }

    public static float[] isEmpty(final float[] fs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (fs != null && fs.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return fs;
    }

    public static float[] isEmpty(final float[] fs, final IDictEnum<Integer, String> dictEnum) {
        if (fs != null && fs.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return fs;
    }

    public static float[] isEmpty(final float[] fs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (fs != null && fs.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return fs;
    }

    public static float[][] allEmpty(final float[]... fss) {
        Arrays.stream(EmptyAssert.isNotEmpty(fss)).forEach(EmptyAssert::isEmpty);
        return fss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param fs 数组
     */
    public static float[] isNotEmpty(final float[] fs) {
        if (fs == null || fs.length == 0) {
            throw new CommonException("[Assertion failed] - this fs array argument must not be empty");
        }
        return fs;
    }

    public static float[] isNotEmpty(final float[] fs, final String message) {
        if (fs == null || fs.length == 0) {
            throw new CommonException(message);
        }
        return fs;
    }

    public static float[] isNotEmpty(final float[] fs, final Integer code, final String message) {
        if (fs == null || fs.length == 0) {
            throw new CommonException(code, message);
        }
        return fs;
    }

    public static float[] isNotEmpty(final float[] fs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (fs == null || fs.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return fs;
    }

    public static float[] isNotEmpty(final float[] fs, final IDictEnum<Integer, String> dictEnum) {
        if (fs == null || fs.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return fs;
    }

    public static float[] isNotEmpty(final float[] fs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (fs == null || fs.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return fs;
    }

    public static float[][] allNotEmpty(final float[]... fss) {
        Arrays.stream(EmptyAssert.isNotEmpty(fss)).forEach(EmptyAssert::isNotEmpty);
        return fss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param ds 数组
     */
    public static double[] isEmpty(final double[] ds) {
        if (ds != null && ds.length > 0) {
            throw new CommonException("[Assertion failed] - this ds array argument must be empty");
        }
        return ds;
    }

    public static double[] isEmpty(final double[] ds, final String message) {
        if (ds != null && ds.length > 0) {
            throw new CommonException(message);
        }
        return ds;
    }

    public static double[] isEmpty(final double[] ds, final Integer code, final String message) {
        if (ds != null && ds.length > 0) {
            throw new CommonException(code, message);
        }
        return ds;
    }

    public static double[] isEmpty(final double[] ds, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ds != null && ds.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ds;
    }

    public static double[] isEmpty(final double[] ds, final IDictEnum<Integer, String> dictEnum) {
        if (ds != null && ds.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ds;
    }

    public static double[] isEmpty(final double[] ds, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ds != null && ds.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ds;
    }

    public static double[][] allEmpty(final double[]... dss) {
        Arrays.stream(EmptyAssert.isNotEmpty(dss)).forEach(EmptyAssert::isEmpty);
        return dss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param ds 数组
     */
    public static double[] isNotEmpty(final double[] ds) {
        if (ds == null || ds.length == 0) {
            throw new CommonException("[Assertion failed] - this ds array argument must not be empty");
        }
        return ds;
    }

    public static double[] isNotEmpty(final double[] ds, final String message) {
        if (ds == null || ds.length == 0) {
            throw new CommonException(message);
        }
        return ds;
    }

    public static double[] isNotEmpty(final double[] ds, final Integer code, final String message) {
        if (ds == null || ds.length == 0) {
            throw new CommonException(code, message);
        }
        return ds;
    }

    public static double[] isNotEmpty(final double[] ds, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ds == null || ds.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ds;
    }

    public static double[] isNotEmpty(final double[] ds, final IDictEnum<Integer, String> dictEnum) {
        if (ds == null || ds.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ds;
    }

    public static double[] isNotEmpty(final double[] ds, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ds == null || ds.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ds;
    }

    public static double[][] allNotEmpty(final double[]... dss) {
        Arrays.stream(EmptyAssert.isNotEmpty(dss)).forEach(EmptyAssert::isNotEmpty);
        return dss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param cs 数组
     */
    public static char[] isEmpty(final char[] cs) {
        if (cs != null && cs.length > 0) {
            throw new CommonException("[Assertion failed] - this cs array argument must be empty");
        }
        return cs;
    }

    public static char[] isEmpty(final char[] cs, final String message) {
        if (cs != null && cs.length > 0) {
            throw new CommonException(message);
        }
        return cs;
    }

    public static char[] isEmpty(final char[] cs, final Integer code, final String message) {
        if (cs != null && cs.length > 0) {
            throw new CommonException(code, message);
        }
        return cs;
    }

    public static char[] isEmpty(final char[] cs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (cs != null && cs.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return cs;
    }

    public static char[] isEmpty(final char[] cs, final IDictEnum<Integer, String> dictEnum) {
        if (cs != null && cs.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return cs;
    }

    public static char[] isEmpty(final char[] cs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (cs != null && cs.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return cs;
    }

    public static char[][] allEmpty(final char[]... css) {
        Arrays.stream(EmptyAssert.isNotEmpty(css)).forEach(EmptyAssert::isEmpty);
        return css;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param cs 数组
     */
    public static char[] isNotEmpty(final char[] cs) {
        if (cs == null || cs.length == 0) {
            throw new CommonException("[Assertion failed] - this cs array argument must not be empty");
        }
        return cs;
    }

    public static char[] isNotEmpty(final char[] cs, final String message) {
        if (cs == null || cs.length == 0) {
            throw new CommonException(message);
        }
        return cs;
    }

    public static char[] isNotEmpty(final char[] cs, final Integer code, final String message) {
        if (cs == null || cs.length == 0) {
            throw new CommonException(code, message);
        }
        return cs;
    }

    public static char[] isNotEmpty(final char[] cs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (cs == null || cs.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return cs;
    }

    public static char[] isNotEmpty(final char[] cs, final IDictEnum<Integer, String> dictEnum) {
        if (cs == null || cs.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return cs;
    }

    public static char[] isNotEmpty(final char[] cs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (cs == null || cs.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return cs;
    }

    public static char[][] allNotEmpty(final char[]... css) {
        Arrays.stream(EmptyAssert.isNotEmpty(css)).forEach(EmptyAssert::isNotEmpty);
        return css;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param bs 数组
     */
    public static boolean[] isEmpty(final boolean[] bs) {
        if (bs != null && bs.length > 0) {
            throw new CommonException("[Assertion failed] - this bs array argument must be empty");
        }
        return bs;
    }

    public static boolean[] isEmpty(final boolean[] bs, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(message);
        }
        return bs;
    }

    public static boolean[] isEmpty(final boolean[] bs, final Integer code, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(code, message);
        }
        return bs;
    }

    public static boolean[] isEmpty(final boolean[] bs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return bs;
    }

    public static boolean[] isEmpty(final boolean[] bs, final IDictEnum<Integer, String> dictEnum) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return bs;
    }

    public static boolean[] isEmpty(final boolean[] bs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (bs != null && bs.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return bs;
    }

    public static boolean[][] allEmpty(final boolean[]... bss) {
        Arrays.stream(EmptyAssert.isNotEmpty(bss)).forEach(EmptyAssert::isEmpty);
        return bss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param bs 数组
     */
    public static boolean[] isNotEmpty(final boolean[] bs) {
        if (bs == null || bs.length == 0) {
            throw new CommonException("[Assertion failed] - this bs array argument must not be empty");
        }
        return bs;
    }

    public static boolean[] isNotEmpty(final boolean[] bs, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(message);
        }
        return bs;
    }

    public static boolean[] isNotEmpty(final boolean[] bs, final Integer code, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(code, message);
        }
        return bs;
    }

    public static boolean[] isNotEmpty(final boolean[] bs, final IKeyEnum<Integer> keyEnum, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return bs;
    }

    public static boolean[] isNotEmpty(final boolean[] bs, final IDictEnum<Integer, String> dictEnum) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return bs;
    }

    public static boolean[] isNotEmpty(final boolean[] bs, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (bs == null || bs.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return bs;
    }

    public static boolean[][] allNotEmpty(final boolean[]... bss) {
        Arrays.stream(EmptyAssert.isNotEmpty(bss)).forEach(EmptyAssert::isNotEmpty);
        return bss;
    }

    /**
     * 校验 数组 为空、或为空数组
     *
     * @param ts  数组
     * @param <T> 数组类型
     */
    public static <T> T[] isEmpty(final T[] ts) {
        if (ts != null && ts.length > 0) {
            throw new CommonException("[Assertion failed] - this ts array argument must be empty");
        }
        return ts;
    }

    public static <T> T[] isEmpty(final T[] ts, final String message) {
        if (ts != null && ts.length > 0) {
            throw new CommonException(message);
        }
        return ts;
    }

    public static <T> T[] isEmpty(final T[] ts, final Integer code, final String message) {
        if (ts != null && ts.length > 0) {
            throw new CommonException(code, message);
        }
        return ts;
    }

    public static <T> T[] isEmpty(final T[] ts, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ts != null && ts.length > 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ts;
    }

    public static <T> T[] isEmpty(final T[] ts, final IDictEnum<Integer, String> dictEnum) {
        if (ts != null && ts.length > 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ts;
    }

    public static <T> T[] isEmpty(final T[] ts, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ts != null && ts.length > 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ts;
    }

    @SafeVarargs
    public static <T> T[][] allEmpty(final T[]... tss) {
        Arrays.stream(EmptyAssert.isNotEmpty(tss)).forEach(EmptyAssert::isEmpty);
        return tss;
    }

    /**
     * 校验 数组 不为空、不为空数组
     *
     * @param ts  数组
     * @param <T> 数组类型
     */
    public static <T> T[] isNotEmpty(final T[] ts) {
        if (ts == null || ts.length == 0) {
            throw new CommonException("[Assertion failed] - this ts array argument must not be empty");
        }
        return ts;
    }

    public static <T> T[] isNotEmpty(final T[] ts, final String message) {
        if (ts == null || ts.length == 0) {
            throw new CommonException(message);
        }
        return ts;
    }

    public static <T> T[] isNotEmpty(final T[] ts, final Integer code, final String message) {
        if (ts == null || ts.length == 0) {
            throw new CommonException(code, message);
        }
        return ts;
    }

    public static <T> T[] isNotEmpty(final T[] ts, final IKeyEnum<Integer> keyEnum, final String message) {
        if (ts == null || ts.length == 0) {
            throw new CommonException(keyEnum.getKey(), message);
        }
        return ts;
    }

    public static <T> T[] isNotEmpty(final T[] ts, final IDictEnum<Integer, String> dictEnum) {
        if (ts == null || ts.length == 0) {
            throw new CommonException(dictEnum.getKey(), dictEnum.getValue());
        }
        return ts;
    }

    public static <T> T[] isNotEmpty(final T[] ts, final IDictEnum<Integer, String> dictEnum, final String message) {
        if (ts == null || ts.length == 0) {
            throw new CommonException(dictEnum.getKey(), message);
        }
        return ts;
    }

    @SafeVarargs
    public static <T> T[][] allNotEmpty(final T[]... tss) {
        Arrays.stream(EmptyAssert.isNotEmpty(tss)).forEach(EmptyAssert::isNotEmpty);
        return tss;
    }
}
