package org.czh.interview.commons.convertor;

import com.alibaba.fastjson.JSONArray;
import org.czh.interview.commons.annotations.tag.NotEmpty;
import org.czh.interview.commons.annotations.tag.NotNull;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : czh
 * description : 数组转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class ArrayConvertor {

    /*
      -----------------------------array convert to new array-------------------------------
     */

    /**
     * 数组 转换为 第一个值
     *
     * @param source 源数组
     * @param filter 过滤器
     * @param <S>    源数组元素类型
     * @return 第一个值
     */
    public static <S> S convertToFirst(@NotEmpty final S[] source,
                                       final Predicate<S> filter) {
        return convertToFirst(source, filter, s -> s);
    }

    /**
     * 数组 转换为 第一个值
     *
     * @param source    源数组
     * @param filter    过滤器
     * @param convertor 转换器
     * @param <S>       源数组元素类型
     * @param <T>       目标元素类型
     * @return 第一个值
     */
    public static <S, T> T convertToFirst(@NotEmpty final S[] source,
                                          final Predicate<S> filter,
                                          @NotNull final Function<S, T> convertor) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.isNotNull(convertor);

        Stream<S> stream = Arrays.stream(source);
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        return stream.findFirst().map(convertor).orElse(null);
    }

    /*
      -----------------------------array convert to new array-------------------------------
     */

    /**
     * 数组 转换为 数组
     *
     * @param source      源数组
     * @param targetClazz 目标数组中元素类 类型
     * @param <S>         源数组元素类型
     * @return 数组
     */
    public static <S> S[] convertToArray(@NotEmpty final S[] source,
                                         @NotNull final Class<S> targetClazz) {
        return convertToArray(source, targetClazz, s -> s);
    }

    /**
     * 数组 转换为 数组
     *
     * @param source      源数组
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param <S>         源数组元素类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    public static <S, T> T[] convertToArray(@NotEmpty final S[] source,
                                            @NotNull final Class<T> targetClazz,
                                            @NotNull final Function<S, T> convertor) {
        return convertToArray(source, targetClazz, convertor, null);
    }

    /**
     * 数组 转换为 数组
     *
     * @param source      源数组
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         源数组元素类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    @SuppressWarnings("unchecked")
    public static <S, T> T[] convertToArray(@NotEmpty final S[] source,
                                            @NotNull final Class<T> targetClazz,
                                            @NotNull final Function<S, T> convertor,
                                            final Predicate<S> filter) {
        // 定长时，使用 数组 转 数组
        if (EmptyValidate.isNull(filter)) {
            EmptyAssert.isNotEmpty(source);
            EmptyAssert.allNotNull(targetClazz, convertor);

            T[] target = (T[]) Array.newInstance(targetClazz, source.length);
            IntStream.range(0, source.length).forEach(i -> target[i] = convertor.apply(source[i]));
            return target;
        }

        // 不定长时
        // 先 数组 转 List 确定长度
        List<T> targetList = convertToList(source, convertor, filter);
        // 再 使用 List 转 数组
        return CollectionConvertor.convertToArray(targetList, targetClazz);
    }

    /*
      -----------------------------array convert to new list-------------------------------
     */

    /**
     * 数组 转换为 List集合
     *
     * @param source 源数组
     * @param <S>    源数组元素类型
     * @return List集合
     */
    public static <S> List<S> convertToList(@NotEmpty final S[] source) {
        return convertToList(source, s -> s);
    }

    /**
     * 数组 转换为 List集合
     *
     * @param source    源数组
     * @param convertor 转换器
     * @param <S>       源数组元素类型
     * @param <T>       目标List集合元素类型
     * @return List集合
     */
    public static <S, T> List<T> convertToList(@NotEmpty final S[] source,
                                               @NotNull final Function<S, T> convertor) {
        return convertToList(source, convertor, null);
    }

    /**
     * 数组 转换为 List集合
     *
     * @param source    源数组
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源数组元素类型
     * @param <T>       目标List集合元素类型
     * @return List集合
     */
    public static <S, T> List<T> convertToList(@NotEmpty final S[] source,
                                               @NotNull final Function<S, T> convertor,
                                               final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        List<T> target = new ArrayList<>(source.length);
        convertToCollection(source, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------array convert to new set-------------------------------
     */

    /**
     * 数组 转换为 Set集合
     *
     * @param source 源数组
     * @param <S>    源数组元素类型
     * @return Set集合
     */
    public static <S> Set<S> convertToSet(@NotEmpty final S[] source) {
        return convertToSet(source, s -> s);
    }

    /**
     * 数组 转换为 Set集合
     *
     * @param source    源数组
     * @param convertor 转换器
     * @param <S>       源数组元素类型
     * @param <T>       目标Set集合元素类型
     * @return Set集合
     */
    public static <S, T> Set<T> convertToSet(@NotEmpty final S[] source,
                                             @NotNull final Function<S, T> convertor) {
        return convertToSet(source, convertor, null);
    }

    /**
     * 数组 转换为 Set集合
     *
     * @param source    源数组
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源数组元素类型
     * @param <T>       目标Set集合元素类型
     * @return Set集合
     */
    public static <S, T> Set<T> convertToSet(@NotEmpty final S[] source,
                                             @NotNull final Function<S, T> convertor,
                                             final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        Set<T> target = new HashSet<>(source.length);
        convertToCollection(source, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------array convert to collection-------------------------------
     */

    /**
     * 数组 转换为 集合
     *
     * @param source 源数组
     * @param target 目标集合
     * @param <S>    源数组元素类型
     */
    public static <S> void convertToCollection(@NotEmpty final S[] source,
                                               @NotNull final Collection<S> target) {
        convertToCollection(source, target, s -> s);
    }

    /**
     * 数组 转换为 集合
     *
     * @param source    源数组
     * @param target    目标集合
     * @param convertor 转换器
     * @param <S>       源数组元素类型
     * @param <T>       目标集合元素类型
     */
    public static <S, T> void convertToCollection(@NotEmpty final S[] source,
                                                  @NotNull final Collection<T> target,
                                                  @NotNull final Function<S, T> convertor) {
        convertToCollection(source, target, convertor, null);
    }

    /**
     * 数组 转换为 集合
     *
     * @param source    源数组
     * @param target    目标集合
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源数组元素类型
     * @param <T>       目标集合元素类型
     */
    public static <S, T> void convertToCollection(@NotEmpty final S[] source,
                                                  @NotNull final Collection<T> target,
                                                  @NotNull final Function<S, T> convertor,
                                                  final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.allNotNull(target, convertor);

        Stream<S> stream = Arrays.stream(source);
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        stream.map(convertor).forEach(target::add);
    }

    /*
      -----------------------------array convert to new map-------------------------------
     */

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param <S>    源数组元素类型
     * @return 键值对
     */
    public static <S> Map<S, S> convertToMap(@NotEmpty final S[] source) {
        return convertToMap(source, s -> s);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param key    key转换器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     * @return 键值对
     */
    public static <S, K> Map<K, S> convertToMap(@NotEmpty final S[] source,
                                                @NotNull final Function<S, K> key) {
        return convertToMap(source, key, s -> s);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param key    key转换器
     * @param value  value转换器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     * @return 键值对
     */
    public static <S, K, V> Map<K, V> convertToMap(@NotEmpty final S[] source,
                                                   @NotNull final Function<S, K> key,
                                                   @NotNull final Function<S, V> value) {
        return convertToMap(source, key, value, null);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param key    key转换器
     * @param value  value转换器
     * @param filter 过滤器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     * @return 键值对
     */
    public static <S, K, V> Map<K, V> convertToMap(@NotEmpty final S[] source,
                                                   @NotNull final Function<S, K> key,
                                                   @NotNull final Function<S, V> value,
                                                   final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        Map<K, V> target = new HashMap<>(source.length);
        convertToMap(source, target, key, value, filter);
        return target;
    }

    /*
      -----------------------------array convert to map-------------------------------
     */

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param target 目标键值对
     * @param <S>    源数组元素类型
     */
    public static <S> void convertToMap(@NotEmpty final S[] source,
                                        @NotNull final Map<S, S> target) {
        convertToMap(source, target, s -> s);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param target 目标键值对
     * @param key    key转换器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     */
    public static <S, K> void convertToMap(@NotEmpty final S[] source,
                                           @NotNull final Map<K, S> target,
                                           @NotNull final Function<S, K> key) {
        convertToMap(source, target, key, s -> s);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param target 目标键值对
     * @param key    key转换器
     * @param value  value转换器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     */
    public static <S, K, V> void convertToMap(@NotEmpty final S[] source,
                                              @NotNull final Map<K, V> target,
                                              @NotNull final Function<S, K> key,
                                              @NotNull final Function<S, V> value) {
        convertToMap(source, target, key, value, null);
    }

    /**
     * 数组 转换为 键值对
     *
     * @param source 源数组
     * @param target 目标键值对
     * @param key    key转换器
     * @param value  value转换器
     * @param filter 过滤器
     * @param <S>    源数组元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     */
    public static <S, K, V> void convertToMap(@NotEmpty final S[] source,
                                              @NotNull final Map<K, V> target,
                                              @NotNull final Function<S, K> key,
                                              @NotNull final Function<S, V> value,
                                              final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.allNotNull(target, key, value);

        Stream<S> stream = Arrays.stream(source);
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        stream.forEach(s -> target.put(key.apply(s), value.apply(s)));
    }

    /*
      -----------------------------array convert to new json-------------------------------
     */

    /**
     * 数组 转换为 JSONArray
     *
     * @param source 源数组
     * @param <S>    源数组元素类型
     * @return JSONArray
     */
    public static <S> JSONArray convertToJsonObject(@NotEmpty final S[] source) {
        EmptyAssert.isNotEmpty(source);
        return (JSONArray) JSONArray.toJSON(source);
    }

    /**
     * 数组 转换为 JSONString
     *
     * @param source 源数组
     * @param <S>    源数组元素类型
     * @return JSONString
     */
    public static <S> String convertToJsonString(@NotEmpty final S[] source) {
        EmptyAssert.isNotEmpty(source);
        return JSONArray.toJSONString(source);
    }
}
