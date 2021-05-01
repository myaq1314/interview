package org.czh.interview.commons.utils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.convertor.ArrayConvertor;
import org.czh.interview.commons.convertor.CollectionConvertor;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;
import org.czh.interview.commons.validate.FlagAssert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-04-30
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class FieldUtil {

    /**
     * 从源实体本类、父类、祖父类 所有属性中，写入 对应 Field 属性值
     *
     * @param source     源实体
     * @param fieldName  属性名称
     * @param fieldValue 属性值
     * @param <S>        源实体类型
     */
    public static <S> void writeFieldFromAll(S source, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromAll(source.getClass(), fieldName);
        writeField(source, field, fieldValue);
    }

    /**
     * 从源实体本类、父类、祖父类 所有属性中，写入 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @param fieldValue  属性值
     */
    public static void writeStaticFieldFromAll(Class<?> sourceClazz, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromAll(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        writeStaticField(field, fieldValue);
    }

    /**
     * 从源实体本类、父类、祖父类 所有公共属性中，写入 对应 Field 属性值
     *
     * @param source     源实体
     * @param fieldName  属性名称
     * @param fieldValue 属性值
     * @param <S>        源实体类型
     */
    public static <S> void writeFieldFromPublic(S source, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromPublic(source.getClass(), fieldName);
        writeField(source, field, fieldValue);
    }

    /**
     * 从源实体本类、父类、祖父类 所有公共属性中，写入 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @param fieldValue  属性值
     */
    public static void writeStaticFieldFromPublic(Class<?> sourceClazz, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromPublic(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        writeStaticField(field, fieldValue);
    }

    /**
     * 从源实体本类所有属性中，写入 对应 Field 属性值
     *
     * @param source     源实体
     * @param fieldName  属性名称
     * @param fieldValue 属性值
     * @param <S>        源实体类型
     */
    public static <S> void writeFieldFromOwn(S source, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromOwn(source.getClass(), fieldName);
        writeField(source, field, fieldValue);
    }

    /**
     * 从源实体本类所有属性中，写入 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @param fieldValue  属性值
     */
    public static void writeStaticFieldFromOwn(Class<?> sourceClazz, String fieldName, Object fieldValue) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromOwn(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        writeStaticField(field, fieldValue);
    }

    /**
     * 从源实体本类、父类、祖父类所有属性中，写入 对应 Field 属性值
     *
     * @param source     源实体
     * @param field      属性实体
     * @param fieldValue 属性值
     * @param <S>        源实体类型
     */
    public static <S> void writeField(S source, Field field, Object fieldValue) {
        EmptyAssert.isNotNull(field);
        if (EmptyValidate.isNull(source) && Modifier.isStatic(field.getModifiers())) {
            writeStaticField(field, fieldValue);
        }
        EmptyAssert.isNotNull(source);
        try {
            field.setAccessible(true);
            if (EmptyValidate.isNull(fieldValue)) {
                field.set(source, new Object[]{null});
            } else {
                field.set(source, fieldValue);
            }
        } catch (IllegalAccessException e) {
            throw new CommonException("The value cannot be obtained from this field");
        }
    }

    /**
     * 从源实体本类、父类、祖父类所有属性中，写入 对应 静态 Field 属性值
     *
     * @param field      属性实体
     * @param fieldValue 属性值
     */
    public static void writeStaticField(Field field, Object fieldValue) {
        try {
            field.setAccessible(true);
            if (EmptyValidate.isNull(fieldValue)) {
                field.set(null, new Object[]{null});
            } else {
                field.set(null, fieldValue);
            }
        } catch (IllegalAccessException e) {
            throw new CommonException("The value cannot be obtained from this static field");
        }
    }

    /**
     * 从源实体本类、父类、祖父类 所有属性中，读取 对应 Field 属性值
     *
     * @param source    源实体
     * @param fieldName 属性名称
     * @param <S>       源实体类型
     * @return 属性值
     */
    public static <S> Object readFieldFromAll(S source, String fieldName) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromAll(source.getClass(), fieldName);
        return readField(source, field);
    }

    /**
     * 从源实体本类、父类、祖父类 所有属性中，读取 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @return 属性值
     */
    public static Object readStaticFieldFromAll(Class<?> sourceClazz, String fieldName) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromAll(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        return readStaticField(field);
    }

    /**
     * 从源实体本类、父类、祖父类 所有公共属性中，读取 对应 Field 属性值
     *
     * @param source    源实体
     * @param fieldName 属性名称
     * @param <S>       源实体类型
     * @return 属性值
     */
    public static <S> Object readFieldFromPublic(S source, String fieldName) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromPublic(source.getClass(), fieldName);
        return readField(source, field);
    }

    /**
     * 从源实体本类、父类、祖父类 所有公共属性中，读取 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @return 属性值
     */
    public static Object readStaticFieldFromPublic(Class<?> sourceClazz, String fieldName) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromPublic(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        return readStaticField(field);
    }

    /**
     * 从源实体本类所有属性中，读取 对应 Field 属性值
     *
     * @param source    源实体
     * @param fieldName 属性名称
     * @param <S>       源实体类型
     * @return 属性值
     */
    public static <S> Object readFieldFromOwn(S source, String fieldName) {
        EmptyAssert.isNotNull(source);
        Field field = getFieldFromOwn(source.getClass(), fieldName);
        return readField(source, field);
    }

    /**
     * 从源实体本类所有属性中，读取 对应 静态 Field 属性值
     *
     * @param sourceClazz 源实体 类对象
     * @param fieldName   属性名称
     * @return 属性值
     */
    public static Object readStaticFieldFromOwn(Class<?> sourceClazz, String fieldName) {
        EmptyAssert.isNotNull(sourceClazz);
        Field field = getFieldFromOwn(sourceClazz, fieldName);
        FlagAssert.isTrue(Modifier.isStatic(field.getModifiers()), "this field is not a static field");
        return readStaticField(field);
    }

    /**
     * 从源实体本类、父类、祖父类所有属性中，读取 对应 Field 属性值
     *
     * @param source 源实体
     * @param field  属性实体
     * @param <S>    源实体类型
     * @return 属性值
     */
    public static <S> Object readField(S source, Field field) {
        EmptyAssert.isNotNull(field);
        if (EmptyValidate.isNull(source) && Modifier.isStatic(field.getModifiers())) {
            return readStaticField(field);
        }
        EmptyAssert.isNotNull(source);
        try {
            field.setAccessible(true);
            return field.get(source);
        } catch (IllegalAccessException e) {
            throw new CommonException("The value cannot be obtained from this field");
        }
    }

    /**
     * 从源实体本类、父类、祖父类所有属性中，读取 对应 静态 Field 属性值
     *
     * @param field 属性实体
     * @return 属性值
     */
    public static Object readStaticField(Field field) {
        try {
            field.setAccessible(true);
            return field.get(null);
        } catch (IllegalAccessException e) {
            throw new CommonException("The value cannot be obtained from this static field");
        }
    }

    /**
     * 在 本类 以及 父类、祖父类 所有属性中，根据 属性名称 查找 属性对象
     * 所有非静态属性、所有静态属性
     * 使用 FieldUtils.getField() 函数
     *
     * @param clazz     类对象
     * @param fieldName 属性名称
     * @return 属性对象
     */
    public static Field getFieldFromAll(@NotNullTag final Class<?> clazz,
                                        @NotBlankTag final String fieldName) {
        EmptyAssert.isNotNull(clazz);
        EmptyAssert.isNotBlank(fieldName);
        try {
            // forceAccess 为 false 时，只获取公共属性
            // forceAccess 为 true 时，获取所有属性
            Field field = FieldUtils.getField(clazz, fieldName, true);
            EmptyAssert.isNotNull(field);
            return field;
        } catch (Exception e) {
            throw new CommonException("The field can not be found by the fieldName");
        }
    }

    /**
     * 在 本类 以及 父类、祖父类 所有公共属性中，根据 属性名称 查找 属性对象
     * 所有公共非静态属性、所有公共静态属性
     * 使用 getField() 函数
     *
     * @param clazz     类对象
     * @param fieldName 属性名称
     * @return 属性对象
     */
    public static Field getFieldFromPublic(Class<?> clazz, String fieldName) {
        EmptyAssert.isNotNull(clazz);
        EmptyAssert.isNotBlank(fieldName);
        try {
            Field field = clazz.getField(fieldName);
            EmptyAssert.isNotNull(field);
            return field;
        } catch (Exception e) {
            throw new CommonException("The field can not be found by the fieldName");
        }
    }

    /**
     * 在 本类 所有属性中，根据 属性名称 查找 属性对象
     * 所有本类自有的非静态属性、所有本类自有的静态属性
     * 使用 getDeclaredField() 函数
     *
     * @param clazz     类对象
     * @param fieldName 属性名称
     * @return 属性对象
     */
    public static Field getFieldFromOwn(Class<?> clazz, String fieldName) {
        EmptyAssert.isNotNull(clazz);
        EmptyAssert.isNotBlank(fieldName);
        try {
            Field field = clazz.getDeclaredField(fieldName);
            EmptyAssert.isNotNull(field);
            return field;
        } catch (Exception e) {
            throw new CommonException("The field can not be found by the fieldName");
        }
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz 类对象
     * @return 属性集合
     */
    public static List<Field> queryAllFieldList(@NotNullTag final Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);

        final List<Field> fieldList = new ArrayList<>();
        Class<?> currentClazz = clazz;
        while (EmptyValidate.isNotNull(currentClazz)) {
            final Field[] fields = currentClazz.getDeclaredFields();
            Collections.addAll(fieldList, fields);
            currentClazz = currentClazz.getSuperclass();
        }
        return fieldList;
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] queryAllFields(@NotNullTag final Class<?> clazz) {
        List<Field> fieldList = queryAllFieldList(clazz);
        if (EmptyValidate.isEmpty(fieldList)) {
            return new Field[0];
        }
        return CollectionConvertor.convertToArray(fieldList, Field.class);
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static List<Field> queryPublicFieldList(Class<?> clazz) {
        Field[] fields = queryPublicFields(clazz);
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields);
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] queryPublicFields(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return clazz.getFields();
    }

    /**
     * 获取 当前类 所有 属性（不包含父类、祖父类 任何属性）
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz 类对象
     * @return 属性集合
     */
    public static List<Field> queryOwnFieldList(Class<?> clazz) {
        Field[] fields = queryOwnFields(clazz);
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields);
    }

    /**
     * 获取 当前类 所有 属性（不包含父类、祖父类 任何属性）
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] queryOwnFields(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return clazz.getDeclaredFields();
    }


    /**
     * 获取 当前类 以及 父类、祖父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性集合
     */
    public static List<Field> queryAllFieldListWithAnno(@NotNullTag final Class<?> clazz,
                                                        @NotNullTag final Class<? extends Annotation> annoClazz) {
        EmptyAssert.allNotNull(clazz, annoClazz);

        final List<Field> fieldList = new ArrayList<>();
        Class<?> currentClazz = clazz;
        while (EmptyValidate.isNotNull(currentClazz)) {
            final Field[] fields = currentClazz.getDeclaredFields();
            Arrays.stream(fields).filter(field -> EmptyValidate.isNotNull(field.getAnnotation(annoClazz))).forEach(fieldList::add);
            currentClazz = currentClazz.getSuperclass();
        }
        return fieldList;
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性数组
     */
    public static Field[] queryAllFieldsWithAnno(@NotNullTag final Class<?> clazz,
                                                 @NotNullTag final Class<? extends Annotation> annoClazz) {
        List<Field> fieldList = queryAllFieldListWithAnno(clazz, annoClazz);
        if (EmptyValidate.isEmpty(fieldList)) {
            return new Field[0];
        }
        return CollectionConvertor.convertToArray(fieldList, Field.class);
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性数组
     */
    public static List<Field> queryPublicFieldListWithAnno(@NotNullTag final Class<?> clazz,
                                                           @NotNullTag final Class<? extends Annotation> annoClazz) {
        EmptyAssert.allNotNull(clazz, annoClazz);

        Field[] fields = clazz.getFields();
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields, s -> s, s -> EmptyValidate.isNotNull(s.getAnnotation(annoClazz)));
    }

    /**
     * 获取 当前类 以及 父类、祖父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性数组
     */
    public static Field[] queryPublicFieldsWithAnno(@NotNullTag final Class<?> clazz,
                                                    @NotNullTag final Class<? extends Annotation> annoClazz) {
        EmptyAssert.allNotNull(clazz, annoClazz);

        Field[] fields = clazz.getFields();
        if (EmptyValidate.isEmpty(fields)) {
            return new Field[0];
        }
        return ArrayConvertor.convertToArray(fields, Field.class, s -> s, s -> EmptyValidate.isNotNull(s.getAnnotation(annoClazz)));
    }

    /**
     * 获取 当前类 所有 属性（不包含父类、祖父类 任何属性）
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性集合
     */
    public static List<Field> queryOwnFieldListWithAnno(@NotNullTag final Class<?> clazz,
                                                        @NotNullTag final Class<? extends Annotation> annoClazz) {
        EmptyAssert.allNotNull(clazz, annoClazz);

        Field[] fields = clazz.getDeclaredFields();
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields, s -> s, s -> EmptyValidate.isNotNull(s.getAnnotation(annoClazz)));
    }

    /**
     * 获取 当前类 所有 属性（不包含父类、祖父类 任何属性）
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz     类对象
     * @param annoClazz 属性中修饰的注解类
     * @return 属性数组
     */
    public static Field[] queryOwnFieldsWithAnno(@NotNullTag final Class<?> clazz,
                                                 @NotNullTag final Class<? extends Annotation> annoClazz) {
        EmptyAssert.allNotNull(clazz, annoClazz);

        Field[] fields = clazz.getDeclaredFields();
        if (EmptyValidate.isEmpty(fields)) {
            return new Field[0];
        }
        return ArrayConvertor.convertToArray(fields, Field.class, s -> s, s -> EmptyValidate.isNotNull(s.getAnnotation(annoClazz)));
    }
}
