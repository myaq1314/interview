package org.czh.interview.commons.utils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.czh.interview.commons.convertor.ArrayConvertor;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-04-30
 * email 916419307@qq.com
 */
public final class FieldUtil {

    /**
     * 获取 当前类 以及 父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz 类对象
     * @return 属性集合
     */
    public static List<Field> getAllFieldList(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return FieldUtils.getAllFieldsList(clazz);
    }

    /**
     * 获取 当前类 以及 父类 所有 属性
     * 这包括公共、受保护、默认(包)访问和私有字段
     * FieldUtils.getAllFields() 原理：
     * 循环调用，依次取出 本类、父类、祖父类的所有 属性
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] getAllFields(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return FieldUtils.getAllFields(clazz);
    }

    /**
     * 获取 当前类 以及 父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static List<Field> getPublicFieldList(Class<?> clazz) {
        Field[] fields = getPublicFields(clazz);
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields);
    }

    /**
     * 获取 当前类 以及 父类 所有 公共 属性
     * 返回一个包含Field对象的数组，
     * 该数组反映由这个class对象表示的类或接口的所有可访问的公共字段。
     * 输出结果：sonPublicField	parentPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] getPublicFields(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return clazz.getFields();
    }

    /**
     * 获取 当前类 所有 属性
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz 类对象
     * @return 属性集合
     */
    public static List<Field> getOwnFieldList(Class<?> clazz) {
        Field[] fields = getOwnFields(clazz);
        if (EmptyValidate.isEmpty(fields)) {
            return new ArrayList<>();
        }
        return ArrayConvertor.convertToList(fields);
    }

    /**
     * 获取 当前类 所有 属性
     * [dɪˈkleəd] 公然的；公开宣布的
     * 返回一个Field对象数组，反映由这个class对象表示的类或接口声明的所有字段。
     * 这包括公共、受保护、默认(包)访问和私有字段，
     * 但不包括继承字段。
     * 输出结果：sonPrivateField sonProtectedField sonDefaultField sonPublicField
     *
     * @param clazz 类对象
     * @return 属性数组
     */
    public static Field[] getOwnFields(Class<?> clazz) {
        EmptyAssert.isNotNull(clazz);
        return clazz.getDeclaredFields();
    }

}
