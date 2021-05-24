package org.czh.interview.commons.utils;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-21
 * email 916419307@qq.com
 */
public class ConstructorUtilTest {

    @Test
    public void test() {
        newInstanceTest(PrivateConstructorTest.class);
        newInstanceTest(DefaultConstructorTest.class);
        newInstanceTest(ProtectedConstructorTest.class);
        newInstanceTest(PublicConstructorTest.class);
    }

    private void newInstanceTest(Class<?> clazz) {
        try {
            Object obj = ConstructorUtil.newInstance(clazz);
            FieldUtil.writeFieldFromAll(obj, "name", "pct0");
            FieldUtil.writeFieldFromAll(obj, "age", 0);
            System.out.println(obj);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Constructor<?> pc1 = ConstructorUtil.newConstructor(clazz);
            Object obj1 = ConstructorUtil.newInstance(pc1);
            FieldUtil.writeFieldFromAll(obj1, "name", "pct1");
            FieldUtil.writeFieldFromAll(obj1, "age", 1);
            System.out.println(obj1);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Constructor<?> pc2 = ConstructorUtil.newConstructor(clazz, String.class);
            Object obj2 = ConstructorUtil.newInstance(pc2, "pct2");
            FieldUtil.writeFieldFromAll(obj2, "age", 2);
            System.out.println(obj2);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            Constructor<?> pc3 = ConstructorUtil.newConstructor(clazz, String.class, int.class);
            Object obj3 = ConstructorUtil.newInstance(pc3, "pct3", 3);
            System.out.println(obj3);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
