package org.czh.interview.commons.utils;

import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.validate.EmptyAssert;

import java.lang.reflect.Constructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-21
 * email 916419307@qq.com
 */
public final class ConstructorUtil {

    /**
     * 本方法 只支持 ，公共的无参构造
     */
    public static <T> T newInstance(Class<T> clazz) {
        EmptyAssert.isNotNull(clazz);

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("构建无参实体异常");
        }
    }

    public static <T> T newInstance(Constructor<T> constructor, Object... initargs) {
        EmptyAssert.isNotNull(constructor);

        try {
            return constructor.newInstance(initargs);
        } catch (Exception e) {
            throw new RuntimeException("构建实体异常");
        }
    }

    public static <T> Constructor<T> newConstructor(@NotNullTag Class<T> clazz,
                                                    @NotEmptyTag Class<?>... parameterTypes) {
        EmptyAssert.isNotNull(clazz);

        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return constructor;
        } catch (Exception e) {
            throw new RuntimeException("构建有参构造器异常");
        }
    }
}
