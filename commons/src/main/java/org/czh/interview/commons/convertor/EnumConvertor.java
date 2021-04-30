package org.czh.interview.commons.convertor;

import org.czh.interview.commons.annotations.tag.NotNull;
import org.czh.interview.commons.enums.parent.IBaseEnum;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;
import org.czh.interview.commons.validate.EnumAssert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author : czh
 * description : 枚举转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class EnumConvertor {

    /*
      -----------------------------enum convert to new array-------------------------------
     */

    /**
     * 枚举 取 第一个值
     *
     * @param sourceClazz 枚举类 类型
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @return 第一个值
     */
    public static <S> S convertToFirst(@NotNull final Class<S> sourceClazz,
                                       final Predicate<S> filter) {
        return convertToFirst(sourceClazz, filter, s -> s);
    }

    /**
     * 枚举 取 第一个值
     *
     * @param sourceClazz 枚举类 类型
     * @param filter      过滤器
     * @param convertor   转换器
     * @param <S>         枚举类型
     * @param <T>         目标元素类型
     * @return 第一个值
     */
    public static <S, T> T convertToFirst(@NotNull final Class<S> sourceClazz,
                                          final Predicate<S> filter,
                                          @NotNull final Function<S, T> convertor) {
        EnumAssert.isEnum(sourceClazz);
        EmptyAssert.isNotNull(convertor);

        return ArrayConvertor.convertToFirst(sourceClazz.getEnumConstants(), filter, convertor);
    }

    /*
      -----------------------------enum convert to new array-------------------------------
     */

    /**
     * 枚举 转换为 数组
     *
     * @param sourceClazz 枚举类 类型
     * @param <S>         枚举类型
     * @return 数组
     */
    public static <S extends IBaseEnum> S[] convertToArray(@NotNull final Class<S> sourceClazz) {
        return convertToArray(sourceClazz, sourceClazz, s -> s);
    }

    /**
     * 枚举 转换为 数组
     *
     * @param sourceClazz 枚举类 类型
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param <S>         枚举类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    public static <S extends IBaseEnum, T> T[] convertToArray(@NotNull final Class<S> sourceClazz,
                                                              @NotNull final Class<T> targetClazz,
                                                              @NotNull final Function<S, T> convertor) {
        return convertToArray(sourceClazz, targetClazz, convertor, null);
    }

    /**
     * 枚举 转换为 数组
     *
     * @param sourceClazz 枚举类 类型
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    public static <S extends IBaseEnum, T> T[] convertToArray(@NotNull final Class<S> sourceClazz,
                                                              @NotNull final Class<T> targetClazz,
                                                              @NotNull final Function<S, T> convertor,
                                                              final Predicate<S> filter) {
        // 定长时，使用 数组 转 数组
        if (EmptyValidate.isNull(filter)) {
            EnumAssert.isEnum(sourceClazz);
            S[] sourceFieldArray = sourceClazz.getEnumConstants();
            return ArrayConvertor.convertToArray(sourceFieldArray, targetClazz, convertor);
        }
        // 不定长时，先使用 数组 转 List集合 确定最终长度
        List<T> targetList = convertToList(sourceClazz, convertor, filter);
        // 再使用 集合 转 数组
        return CollectionConvertor.convertToArray(targetList, targetClazz);
    }

    /*
      -----------------------------enum convert to new list-------------------------------
     */

    /**
     * 枚举 转换为 List集合
     *
     * @param sourceClazz 枚举类 类型
     * @param <S>         枚举类型
     * @return List集合
     */
    public static <S extends IBaseEnum> List<S> convertToList(@NotNull final Class<S> sourceClazz) {
        return convertToList(sourceClazz, s -> s);
    }

    /**
     * 枚举 转换为 List集合
     *
     * @param sourceClazz 枚举类 类型
     * @param convertor   转换器
     * @param <S>         枚举类型
     * @param <T>         目标List集合元素类型
     * @return List集合
     */
    public static <S extends IBaseEnum, T> List<T> convertToList(@NotNull final Class<S> sourceClazz,
                                                                 @NotNull final Function<S, T> convertor) {
        return convertToList(sourceClazz, convertor, null);
    }

    /**
     * 枚举 转换为 List集合
     *
     * @param sourceClazz 枚举类 类型
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <T>         目标List集合元素类型
     * @return List集合
     */
    public static <S extends IBaseEnum, T> List<T> convertToList(@NotNull final Class<S> sourceClazz,
                                                                 @NotNull final Function<S, T> convertor,
                                                                 final Predicate<S> filter) {
        List<T> target = new ArrayList<>();
        convertToCollection(sourceClazz, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------enum convert to new set-------------------------------
     */

    /**
     * 枚举 转换为 Set集合
     *
     * @param sourceClazz 枚举类 类型
     * @param <S>         枚举类型
     * @return Set集合
     */
    public static <S extends IBaseEnum> Set<S> convertToSet(@NotNull final Class<S> sourceClazz) {
        return convertToSet(sourceClazz, s -> s);
    }

    /**
     * 枚举 转换为 Set集合
     *
     * @param sourceClazz 枚举类 类型
     * @param convertor   转换器
     * @param <S>         枚举类型
     * @param <T>         目标Set集合元素类型
     * @return Set集合
     */
    public static <S extends IBaseEnum, T> Set<T> convertToSet(@NotNull final Class<S> sourceClazz,
                                                               @NotNull final Function<S, T> convertor) {
        return convertToSet(sourceClazz, convertor, null);
    }

    /**
     * 枚举 转换为 Set集合
     *
     * @param sourceClazz 枚举类 类型
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <T>         目标Set集合元素类型
     * @return Set集合
     */
    public static <S extends IBaseEnum, T> Set<T> convertToSet(@NotNull final Class<S> sourceClazz,
                                                               @NotNull final Function<S, T> convertor,
                                                               final Predicate<S> filter) {
        Set<T> target = new HashSet<>();
        convertToCollection(sourceClazz, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------enum convert to collection-------------------------------
     */

    /**
     * 枚举 转换为 集合
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标集合
     * @param <S>         枚举类型
     */
    public static <S extends IBaseEnum> void convertToCollection(@NotNull final Class<S> sourceClazz,
                                                                 @NotNull final Collection<S> target) {
        convertToCollection(sourceClazz, target, s -> s);
    }

    /**
     * 枚举 转换为 集合
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标集合
     * @param convertor   转换器
     * @param <S>         枚举类型
     * @param <T>         目标集合元素类型
     */
    public static <S extends IBaseEnum, T> void convertToCollection(@NotNull final Class<S> sourceClazz,
                                                                    @NotNull final Collection<T> target,
                                                                    @NotNull final Function<S, T> convertor) {
        convertToCollection(sourceClazz, target, convertor, null);
    }

    /**
     * 枚举 转换为 集合
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标集合
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <T>         目标集合元素类型
     */
    public static <S extends IBaseEnum, T> void convertToCollection(@NotNull final Class<S> sourceClazz,
                                                                    @NotNull final Collection<T> target,
                                                                    @NotNull final Function<S, T> convertor,
                                                                    final Predicate<S> filter) {
        EnumAssert.isEnum(sourceClazz);
        EmptyAssert.allNotNull(target, convertor);

        S[] sourceFieldArray = sourceClazz.getEnumConstants();
        ArrayConvertor.convertToCollection(sourceFieldArray, target, convertor, filter);
    }

    /*
      -----------------------------enum convert to new map-------------------------------
     */

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param <S>         枚举类型
     * @return 键值对
     */
    public static <S extends IBaseEnum> Map<S, S> convertToMap(@NotNull final Class<S> sourceClazz) {
        return convertToMap(sourceClazz, s -> s);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param key         key转换器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     * @return 键值对
     */
    public static <S extends IBaseEnum, K> Map<K, S> convertToMap(@NotNull final Class<S> sourceClazz,
                                                                  @NotNull final Function<S, K> key) {
        return convertToMap(sourceClazz, key, s -> s);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param key         key转换器
     * @param value       value转换器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     * @param <V>         键值对value元素类型
     * @return 键值对
     */
    public static <S extends IBaseEnum, K, V> Map<K, V> convertToMap(@NotNull final Class<S> sourceClazz,
                                                                     @NotNull final Function<S, K> key,
                                                                     @NotNull final Function<S, V> value) {
        return convertToMap(sourceClazz, key, value, null);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param key         key转换器
     * @param value       value转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     * @param <V>         键值对value元素类型
     * @return 键值对
     */
    public static <S extends IBaseEnum, K, V> Map<K, V> convertToMap(@NotNull final Class<S> sourceClazz,
                                                                     @NotNull final Function<S, K> key,
                                                                     @NotNull final Function<S, V> value,
                                                                     final Predicate<S> filter) {
        Map<K, V> target = new HashMap<>();
        convertToMap(sourceClazz, target, key, value, filter);
        return target;
    }

    /*
      -----------------------------enum convert to map-------------------------------
     */

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标键值对
     * @param <S>         枚举类型
     */
    public static <S extends IBaseEnum> void convertToMap(@NotNull final Class<S> sourceClazz,
                                                          @NotNull final Map<S, S> target) {
        convertToMap(sourceClazz, target, s -> s);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标键值对
     * @param key         key转换器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     */
    public static <S extends IBaseEnum, K> void convertToMap(@NotNull final Class<S> sourceClazz,
                                                             @NotNull final Map<K, S> target,
                                                             @NotNull final Function<S, K> key) {
        convertToMap(sourceClazz, target, key, s -> s);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标键值对
     * @param key         key转换器
     * @param value       value转换器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     * @param <V>         键值对value元素类型
     */
    public static <S extends IBaseEnum, K, V> void convertToMap(@NotNull final Class<S> sourceClazz,
                                                                @NotNull final Map<K, V> target,
                                                                @NotNull final Function<S, K> key,
                                                                @NotNull final Function<S, V> value) {
        convertToMap(sourceClazz, target, key, value, null);
    }

    /**
     * 枚举 转换为 键值对
     *
     * @param sourceClazz 枚举类 类型
     * @param target      目标键值对
     * @param key         key转换器
     * @param value       value转换器
     * @param filter      过滤器
     * @param <S>         枚举类型
     * @param <K>         键值对key元素类型
     * @param <V>         键值对value元素类型
     */
    public static <S extends IBaseEnum, K, V> void convertToMap(@NotNull final Class<S> sourceClazz,
                                                                @NotNull final Map<K, V> target,
                                                                @NotNull final Function<S, K> key,
                                                                @NotNull final Function<S, V> value,
                                                                final Predicate<S> filter) {
        EnumAssert.isEnum(sourceClazz);
        EmptyAssert.allNotNull(target, key, value);

        S[] sourceFieldArray = sourceClazz.getEnumConstants();
        ArrayConvertor.convertToMap(sourceFieldArray, target, key, value, filter);
    }
}
