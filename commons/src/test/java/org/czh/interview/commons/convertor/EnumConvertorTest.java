package org.czh.interview.commons.convertor;

import lombok.Getter;
import org.czh.interview.commons.enums.parent.IDictEnum;
import org.czh.interview.commons.validate.FlagAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author : czh
 * description :
 * date : 2021-04-29
 * email 916419307@qq.com
 */
public class EnumConvertorTest {

    @Test
    public void convertToNewArrayTest() {
        ConvertorDict[] compare1 = new ConvertorDict[]{ConvertorDict.ARRAY, ConvertorDict.LIST, ConvertorDict.SET};
        ConvertorDict[] target1 = EnumConvertor.convertToArray(ConvertorDict.class);
        FlagAssert.isTrue(Arrays.equals(target1, compare1));

        String[] compare2 = new String[]{"array", "list", "set"};
        String[] target2 = EnumConvertor.convertToArray(ConvertorDict.class, String.class, s -> s.key);
        FlagAssert.isTrue(Arrays.equals(target2, compare2));

        ConvertorDict[] compare3 = new ConvertorDict[]{ConvertorDict.LIST, ConvertorDict.SET};
        ConvertorDict[] target3 = EnumConvertor.convertToArray(
                ConvertorDict.class,
                ConvertorDict.class,
                s -> s,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Arrays.equals(target3, compare3));
    }

    @Test
    public void convertToNewListTest() {
        List<ConvertorDict> compare1 = new ArrayList<>();
        Collections.addAll(compare1, ConvertorDict.ARRAY, ConvertorDict.LIST, ConvertorDict.SET);
        List<ConvertorDict> target1 = EnumConvertor.convertToList(ConvertorDict.class);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        List<String> compare2 = new ArrayList<>();
        Collections.addAll(compare2, "array", "list", "set");
        List<String> target2 = EnumConvertor.convertToList(ConvertorDict.class, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        List<ConvertorDict> compare3 = new ArrayList<>();
        Collections.addAll(compare3, ConvertorDict.LIST, ConvertorDict.SET);
        List<ConvertorDict> target3 = EnumConvertor.convertToList(
                ConvertorDict.class,
                s -> s,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));
    }

    @Test
    public void convertToOldListTest() {
        List<ConvertorDict> compare1 = new ArrayList<>();
        Collections.addAll(compare1, ConvertorDict.ARRAY, ConvertorDict.LIST, ConvertorDict.SET);
        List<ConvertorDict> target1 = new ArrayList<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target1);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        List<String> compare2 = new ArrayList<>();
        Collections.addAll(compare2, "array", "list", "set");
        List<String> target2 = new ArrayList<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target2, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        List<ConvertorDict> compare3 = new ArrayList<>();
        Collections.addAll(compare3, ConvertorDict.LIST, ConvertorDict.SET);
        List<ConvertorDict> target3 = new ArrayList<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target3,
                s -> s,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));
    }

    @Test
    public void convertToNewSetTest() {
        Set<ConvertorDict> compare1 = new HashSet<>();
        Collections.addAll(compare1, ConvertorDict.ARRAY, ConvertorDict.LIST, ConvertorDict.SET);
        Set<ConvertorDict> target1 = EnumConvertor.convertToSet(ConvertorDict.class);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        Set<String> compare2 = new HashSet<>();
        Collections.addAll(compare2, "array", "list", "set");
        Set<String> target2 = EnumConvertor.convertToSet(ConvertorDict.class, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        Set<ConvertorDict> compare3 = new HashSet<>();
        Collections.addAll(compare3, ConvertorDict.LIST, ConvertorDict.SET);
        Set<ConvertorDict> target3 = EnumConvertor.convertToSet(
                ConvertorDict.class,
                s -> s,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));
    }

    @Test
    public void convertToOldSetTest() {
        Set<ConvertorDict> compare1 = new HashSet<>();
        Collections.addAll(compare1, ConvertorDict.ARRAY, ConvertorDict.LIST, ConvertorDict.SET);
        Set<ConvertorDict> target1 = new HashSet<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target1);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        Set<String> compare2 = new HashSet<>();
        Collections.addAll(compare2, "array", "list", "set");
        Set<String> target2 = new HashSet<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target2, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        Set<ConvertorDict> compare3 = new HashSet<>();
        Collections.addAll(compare3, ConvertorDict.LIST, ConvertorDict.SET);
        Set<ConvertorDict> target3 = new HashSet<>();
        EnumConvertor.convertToCollection(ConvertorDict.class, target3,
                s -> s,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));
    }

    @Test
    public void convertToNewMapTest() {
        Map<ConvertorDict, ConvertorDict> compare1 = new HashMap<>();
        compare1.put(ConvertorDict.ARRAY, ConvertorDict.ARRAY);
        compare1.put(ConvertorDict.LIST, ConvertorDict.LIST);
        compare1.put(ConvertorDict.SET, ConvertorDict.SET);
        Map<ConvertorDict, ConvertorDict> target1 = EnumConvertor.convertToMap(ConvertorDict.class);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        Map<String, ConvertorDict> compare2 = new HashMap<>();
        compare2.put(ConvertorDict.ARRAY.key, ConvertorDict.ARRAY);
        compare2.put(ConvertorDict.LIST.key, ConvertorDict.LIST);
        compare2.put(ConvertorDict.SET.key, ConvertorDict.SET);
        Map<String, ConvertorDict> target2 = EnumConvertor.convertToMap(ConvertorDict.class, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        Map<String, Class<?>> compare3 = new HashMap<>();
        compare3.put(ConvertorDict.ARRAY.key, ConvertorDict.ARRAY.value);
        compare3.put(ConvertorDict.LIST.key, ConvertorDict.LIST.value);
        compare3.put(ConvertorDict.SET.key, ConvertorDict.SET.value);
        Map<String, Class<?>> target3 = EnumConvertor.convertToMap(
                ConvertorDict.class,
                s -> s.key,
                s -> s.value
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));

        Map<String, Class<?>> compare4 = new HashMap<>();
        compare4.put(ConvertorDict.LIST.key, ConvertorDict.LIST.value);
        compare4.put(ConvertorDict.SET.key, ConvertorDict.SET.value);
        Map<String, Class<?>> target4 = EnumConvertor.convertToMap(
                ConvertorDict.class,
                s -> s.key,
                s -> s.value,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target4, compare4));
    }

    @Test
    public void convertToOldMapTest() {
        Map<ConvertorDict, ConvertorDict> compare1 = new HashMap<>();
        compare1.put(ConvertorDict.ARRAY, ConvertorDict.ARRAY);
        compare1.put(ConvertorDict.LIST, ConvertorDict.LIST);
        compare1.put(ConvertorDict.SET, ConvertorDict.SET);
        Map<ConvertorDict, ConvertorDict> target1 = new HashMap<>();
        EnumConvertor.convertToMap(ConvertorDict.class, target1);
        FlagAssert.isTrue(Objects.equals(target1, compare1));

        Map<String, ConvertorDict> compare2 = new HashMap<>();
        compare2.put(ConvertorDict.ARRAY.key, ConvertorDict.ARRAY);
        compare2.put(ConvertorDict.LIST.key, ConvertorDict.LIST);
        compare2.put(ConvertorDict.SET.key, ConvertorDict.SET);
        Map<String, ConvertorDict> target2 = new HashMap<>();
        EnumConvertor.convertToMap(ConvertorDict.class, target2, s -> s.key);
        FlagAssert.isTrue(Objects.equals(target2, compare2));

        Map<String, Class<?>> compare3 = new HashMap<>();
        compare3.put(ConvertorDict.ARRAY.key, ConvertorDict.ARRAY.value);
        compare3.put(ConvertorDict.LIST.key, ConvertorDict.LIST.value);
        compare3.put(ConvertorDict.SET.key, ConvertorDict.SET.value);
        Map<String, Class<?>> target3 = new HashMap<>();
        EnumConvertor.convertToMap(
                ConvertorDict.class,
                target3,
                s -> s.key,
                s -> s.value
        );
        FlagAssert.isTrue(Objects.equals(target3, compare3));

        Map<String, Class<?>> compare4 = new HashMap<>();
        compare4.put(ConvertorDict.LIST.key, ConvertorDict.LIST.value);
        compare4.put(ConvertorDict.SET.key, ConvertorDict.SET.value);
        Map<String, Class<?>> target4 = new HashMap<>();
        EnumConvertor.convertToMap(
                ConvertorDict.class,
                target4,
                s -> s.key,
                s -> s.value,
                s -> CollectionConvertor.class.equals(s.value)
        );
        FlagAssert.isTrue(Objects.equals(target4, compare4));
    }

    enum ConvertorDict implements IDictEnum<String, Class<?>> {

        ARRAY("array", ArrayConvertor.class),
        LIST("list", CollectionConvertor.class),
        SET("set", CollectionConvertor.class),

        // 预留扩展位
        ;

        @Getter
        public final String key;
        @Getter
        public final Class<?> value;

        ConvertorDict(String key, Class<?> value) {
            this.key = key;
            this.value = value;
        }
    }
}
