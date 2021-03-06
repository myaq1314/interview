package org.czh.interview.commons.convertor;

import com.alibaba.fastjson.JSONArray;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.entity.parent.ConcreteTreeEntity;
import org.czh.interview.commons.entity.parent.IBaseTreeEntity;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : czh
 * description : 集合转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class CollectionConvertor {

    /*
      -----------------------------collection convert to first-------------------------------
     */

    /**
     * 集合 转换为 第一个值
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return 第一个值
     */
    public static <S> S convertToFirst(@NotEmptyTag final Collection<S> source) {
        return convertToFirst(source, null);
    }

    /**
     * 集合 转换为 第一个值
     *
     * @param source 源集合
     * @param filter 过滤器
     * @param <S>    源集合元素类型
     * @return 第一个值
     */
    public static <S> S convertToFirst(@NotEmptyTag final Collection<S> source,
                                       final Predicate<S> filter) {
        return convertToFirst(source, filter, s -> s);
    }


    /**
     * 集合 转换为 第一个值
     *
     * @param source    源集合
     * @param filter    过滤器
     * @param convertor 转换器
     * @param <S>       源集合元素类型
     * @param <T>       目标元素类型
     * @return 第一个值
     */
    public static <S, T> T convertToFirst(@NotEmptyTag final Collection<S> source,
                                          final Predicate<S> filter,
                                          @NotNullTag final Function<S, T> convertor) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.isNotNull(convertor);

        Stream<S> stream = source.stream();
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        return stream.findFirst().map(convertor).orElse(null);
    }

    /*
      -----------------------------collection convert to new array-------------------------------
     */

    /**
     * 集合 转换为 数组
     *
     * @param source      源集合
     * @param targetClazz 目标数组中元素类 类型
     * @param <S>         源集合元素类型
     * @return 数组
     */
    public static <S> S[] convertToArray(@NotEmptyTag final Collection<S> source,
                                         @NotNullTag final Class<S> targetClazz) {
        return convertToArray(source, targetClazz, s -> s);
    }

    /**
     * 集合 转换为 数组
     *
     * @param source      源集合
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param <S>         源集合元素类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    public static <S, T> T[] convertToArray(@NotEmptyTag final Collection<S> source,
                                            @NotNullTag final Class<T> targetClazz,
                                            @NotNullTag final Function<S, T> convertor) {
        return convertToArray(source, targetClazz, convertor, null);
    }

    /**
     * 集合 转换为 数组
     *
     * @param source      源集合
     * @param targetClazz 目标数组中元素类 类型
     * @param convertor   转换器
     * @param filter      过滤器
     * @param <S>         源集合元素类型
     * @param <T>         目标数组元素类型
     * @return 数组
     */
    @SuppressWarnings("unchecked")
    public static <S, T> T[] convertToArray(@NotEmptyTag final Collection<S> source,
                                            @NotNullTag final Class<T> targetClazz,
                                            @NotNullTag final Function<S, T> convertor,
                                            final Predicate<S> filter) {
        // 定长时， 使用 集合 转 数组
        if (EmptyValidate.isNull(filter)) {
            EmptyAssert.isNotEmpty(source);
            EmptyAssert.allNotNull(targetClazz, convertor);

            T[] target = (T[]) Array.newInstance(targetClazz, source.size());
            Iterator<S> iterator = source.iterator();
            IntStream.range(0, source.size()).forEach(i -> target[i] = convertor.apply(iterator.next()));
            return target;
        }

        // 不定长时
        EmptyAssert.isNotNull(targetClazz);
        // 先 集合 转 List 确定长度
        List<T> targetList = convertToList(source, convertor, filter);
        T[] target = (T[]) Array.newInstance(targetClazz, targetList.size());
        // 再 List 转 数组
        IntStream.range(0, targetList.size()).forEach(i -> target[i] = targetList.get(i));
        return target;
    }

    /*
      -----------------------------collection convert to new list-------------------------------
     */

    /**
     * 集合 转换为 List集合
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return List集合
     */
    public static <S> List<S> convertToList(@NotEmptyTag final Collection<S> source) {
        return convertToList(source, s -> s);
    }

    /**
     * 集合 转换为 List集合
     *
     * @param source    源集合
     * @param convertor 转换器
     * @param <S>       源集合元素类型
     * @param <T>       目标List集合元素类型
     * @return List集合
     */
    public static <S, T> List<T> convertToList(@NotEmptyTag final Collection<S> source,
                                               @NotNullTag final Function<S, T> convertor) {
        return convertToList(source, convertor, null);
    }

    /**
     * 集合 转换为 List集合
     *
     * @param source    源集合
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源集合元素类型
     * @param <T>       目标List集合元素类型
     * @return List集合
     */
    public static <S, T> List<T> convertToList(@NotEmptyTag final Collection<S> source,
                                               @NotNullTag final Function<S, T> convertor,
                                               final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        List<T> target = new ArrayList<>(source.size());
        convertToCollection(source, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------collection convert to new set-------------------------------
     */

    /**
     * 集合 转换为 Set集合
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return Set集合
     */
    public static <S> Set<S> convertToSet(@NotEmptyTag final Collection<S> source) {
        return convertToSet(source, s -> s);
    }

    /**
     * 集合 转换为 Set集合
     *
     * @param source    源集合
     * @param convertor 转换器
     * @param <S>       源集合元素类型
     * @param <T>       目标Set集合元素类型
     * @return Set集合
     */
    public static <S, T> Set<T> convertToSet(@NotEmptyTag final Collection<S> source,
                                             @NotNullTag final Function<S, T> convertor) {
        return convertToSet(source, convertor, null);
    }

    /**
     * 集合 转换为 Set集合
     *
     * @param source    源集合
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源集合元素类型
     * @param <T>       目标Set集合元素类型
     * @return Set集合
     */
    public static <S, T> Set<T> convertToSet(@NotEmptyTag final Collection<S> source,
                                             @NotNullTag final Function<S, T> convertor,
                                             final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        Set<T> target = new HashSet<>(source.size());
        convertToCollection(source, target, convertor, filter);
        return target;
    }

    /*
      -----------------------------collection convert to collection-------------------------------
     */

    /**
     * 集合 转换为 集合
     *
     * @param source 源集合
     * @param target 目标集合
     * @param <S>    源集合元素类型
     */
    public static <S> void convertToCollection(@NotEmptyTag final Collection<S> source,
                                               @NotNullTag final Collection<S> target) {
        convertToCollection(source, target, s -> s);
    }

    /**
     * 集合 转换为 集合
     *
     * @param source    源集合
     * @param target    目标集合
     * @param convertor 转换器
     * @param <S>       源集合元素类型
     * @param <T>       目标集合元素类型
     */
    public static <S, T> void convertToCollection(@NotEmptyTag final Collection<S> source,
                                                  @NotNullTag final Collection<T> target,
                                                  @NotNullTag final Function<S, T> convertor) {
        convertToCollection(source, target, convertor, null);
    }

    /**
     * 集合 转换为 集合
     *
     * @param source    源集合
     * @param target    目标集合
     * @param convertor 转换器
     * @param filter    过滤器
     * @param <S>       源集合元素类型
     * @param <T>       目标集合元素类型
     */
    public static <S, T> void convertToCollection(@NotEmptyTag final Collection<S> source,
                                                  @NotNullTag final Collection<T> target,
                                                  @NotNullTag final Function<S, T> convertor,
                                                  final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.allNotNull(target, convertor);

        Stream<S> stream = source.stream();
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        stream.map(convertor).forEach(target::add);
    }

    /*
      -----------------------------collection convert to new map-------------------------------
     */

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return 键值对
     */
    public static <S> Map<S, S> convertToMap(@NotEmptyTag final Collection<S> source) {
        return convertToMap(source, s -> s);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param key    key转换器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     * @return 键值对
     */
    public static <S, K> Map<K, S> convertToMap(@NotEmptyTag final Collection<S> source,
                                                @NotNullTag final Function<S, K> key) {
        return convertToMap(source, key, s -> s);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param key    key转换器
     * @param value  value转换器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     * @return 键值对
     */
    public static <S, K, V> Map<K, V> convertToMap(@NotEmptyTag final Collection<S> source,
                                                   @NotNullTag final Function<S, K> key,
                                                   @NotNullTag final Function<S, V> value) {
        return convertToMap(source, key, value, null);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param key    key转换器
     * @param value  value转换器
     * @param filter 过滤器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     * @return 键值对
     */
    public static <S, K, V> Map<K, V> convertToMap(@NotEmptyTag final Collection<S> source,
                                                   @NotNullTag final Function<S, K> key,
                                                   @NotNullTag final Function<S, V> value,
                                                   final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        Map<K, V> target = new HashMap<>(source.size());
        convertToMap(source, target, key, value, filter);
        return target;
    }

    /*
      -----------------------------collection convert to map-------------------------------
     */

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param target 目标键值对
     * @param <S>    源集合元素类型
     */
    public static <S> void convertToMap(@NotEmptyTag final Collection<S> source,
                                        @NotNullTag final Map<S, S> target) {
        convertToMap(source, target, s -> s);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param target 目标键值对
     * @param key    key转换器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     */
    public static <S, K> void convertToMap(@NotEmptyTag final Collection<S> source,
                                           @NotNullTag final Map<K, S> target,
                                           @NotNullTag final Function<S, K> key) {
        convertToMap(source, target, key, s -> s);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param target 目标键值对
     * @param key    key转换器
     * @param value  value转换器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     */
    public static <S, K, V> void convertToMap(@NotEmptyTag final Collection<S> source,
                                              @NotNullTag final Map<K, V> target,
                                              @NotNullTag final Function<S, K> key,
                                              @NotNullTag final Function<S, V> value) {
        convertToMap(source, target, key, value, null);
    }

    /**
     * 集合 转换为 键值对
     *
     * @param source 源集合
     * @param target 目标键值对
     * @param key    key转换器
     * @param value  value转换器
     * @param filter 过滤器
     * @param <S>    源集合元素类型
     * @param <K>    键值对key元素类型
     * @param <V>    键值对value元素类型
     */
    public static <S, K, V> void convertToMap(@NotEmptyTag final Collection<S> source,
                                              @NotNullTag final Map<K, V> target,
                                              @NotNullTag final Function<S, K> key,
                                              @NotNullTag final Function<S, V> value,
                                              final Predicate<S> filter) {
        EmptyAssert.isNotEmpty(source);
        EmptyAssert.allNotNull(target, key, value);

        Stream<S> stream = source.stream();
        if (EmptyValidate.isNotNull(filter)) {
            stream = stream.filter(filter);
        }
        stream.forEach(s -> target.put(key.apply(s), value.apply(s)));
    }

    /*
      -----------------------------collection convert to new json-------------------------------
     */

    /**
     * 集合 转换为 JSONArray
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return JSONArray
     */
    public static <S> JSONArray convertToJsonObject(@NotEmptyTag final Collection<S> source) {
        EmptyAssert.isNotEmpty(source);
        return (JSONArray) JSONArray.toJSON(source);
    }

    /**
     * 集合 转换为 JSONString
     *
     * @param source 源集合
     * @param <S>    源集合元素类型
     * @return JSONString
     */
    public static <S> String convertToJsonString(@NotEmptyTag final Collection<S> source) {
        EmptyAssert.isNotEmpty(source);
        return JSONArray.toJSONString(source);
    }

    /*
      -----------------------------bean convert to tree-------------------------------
     */

    /**
     * 集合 转换为 树结构
     *
     * @param source              源集合
     * @param currentTagConvertor 当前节点唯一标识 函数
     * @param parentTagConvertor  父节点唯一标识 函数
     * @param parentTag           顶级节点唯一表示
     * @param <S>                 源集合元素类型
     * @param <K>                 唯一标识元素类型
     * @return 树结构
     */
    public static <S extends IBaseTreeEntity<S>, K> List<S> convertToTree(final Collection<S> source,
                                                                          @NotNullTag final Function<S, K> currentTagConvertor,
                                                                          @NotNullTag final Function<S, K> parentTagConvertor,
                                                                          final K parentTag) {
        return convertToTree(source, s -> s, currentTagConvertor, parentTagConvertor, parentTag);
    }

    /**
     * 集合 转换为 树结构
     *
     * @param source              源集合
     * @param convertor           转换器
     * @param currentTagConvertor 当前节点唯一标识 函数
     * @param parentTagConvertor  父节点唯一标识 函数
     * @param parentTag           顶级节点唯一表示
     * @param <S>                 源集合元素类型
     * @param <T>                 目标树结构元素类型
     * @param <K>                 唯一标识元素类型
     * @return 树结构
     */
    public static <S, T extends IBaseTreeEntity<T>, K> List<T> convertToTree(final Collection<S> source,
                                                                             @NotNullTag final Function<S, T> convertor,
                                                                             @NotNullTag final Function<S, K> currentTagConvertor,
                                                                             @NotNullTag final Function<S, K> parentTagConvertor,
                                                                             final K parentTag) {
        return convertToTree(source, convertor, currentTagConvertor, parentTagConvertor, null, parentTag);
    }

    /**
     * 集合 转换为 树结构
     *
     * @param source              源集合
     * @param convertor           转换器
     * @param currentTagConvertor 当前节点唯一标识 函数
     * @param parentTagConvertor  父节点唯一标识 函数
     * @param filter              过滤器
     * @param parentTag           顶级节点唯一表示
     * @param <S>                 源集合元素类型
     * @param <T>                 目标树结构元素类型
     * @param <K>                 唯一标识元素类型
     * @return 树结构
     */
    public static <S, T extends IBaseTreeEntity<T>, K> List<T> convertToTree(final Collection<S> source,
                                                                             @NotNullTag final Function<S, T> convertor,
                                                                             @NotNullTag final Function<S, K> currentTagConvertor,
                                                                             @NotNullTag final Function<S, K> parentTagConvertor,
                                                                             final Predicate<S> filter,
                                                                             final K parentTag) {

        if (EmptyValidate.isEmpty(source)) {
            return new ArrayList<>(0);
        }

        EmptyAssert.allNotNull(convertor, currentTagConvertor, parentTagConvertor);

        // 最终输出结果
        List<T> target = new ArrayList<>();
        // 所有节点都要暂存到Map中，方便查找
        Map<K, IBaseTreeEntity<T>> tempMap = new HashMap<>(source.size());

        source.stream().filter(s -> EmptyValidate.isNull(filter) || filter.test(s)).forEach(s -> {
            T t = convertor.apply(s);
            // 获取当前节点唯一标识
            K currentId = currentTagConvertor.apply(s);
            // 缓存Map中存放着虚假值，此处进行替换
            if (tempMap.containsKey(currentId)) {
                t.setChildren(tempMap.get(currentId).getChildren());
            }
            tempMap.put(currentId, t);
            // 获取父节点唯一标识
            K parentId = parentTagConvertor.apply(s);
            // 通过比较，判断当前节点是否属于顶层节点数据
            if (Objects.equals(parentId, parentTag)) {
                target.add(t);
            } else {
                // 缓存Map中不存在父节点数据，那么制造一个虚假值，等真正的节点数据到来时，再替换掉
                if (!tempMap.containsKey(parentId)) {
                    tempMap.put(parentId, new ConcreteTreeEntity<>());
                }
                IBaseTreeEntity<T> parentNode = tempMap.get(parentId);
                parentNode.addChild(t);
            }
        });
        return target;
    }
}
