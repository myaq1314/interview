package org.czh.interview.jdk_interview.jvm_interview.load;

import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.utils.FieldUtil;
import org.czh.interview.commons.utils.StreamUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : czh
 * description :
 * date : 2021-05-20
 * email 916419307@qq.com
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 创建自定义类加载器示例
        MyClassLoader myClassLoader = new MyClassLoader();
        // 加载二进制class文件，生成Class对象
        Class<?> clazz = myClassLoader.loadClass("org.czh.interview.jdk_interview.jvm_interview.load.MyClassLoaderTester");
        // 构建有参构造
        Constructor<?> constructor = clazz.getConstructor(String.class);
        // 创建新实例
        Object obj = constructor.newInstance("TOM");
        // 验证实例是否正确
        assert "TOM".equals(FieldUtil.readFieldFromAll(obj, "name"));
    }

    /**
     * name
     * 格式 ：package + 类名
     * 示例：org.czh.interview.jdk_interview.jvm_interview.load.MyClassLoader
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 固定class文件目录
        // ./jdk-interview/jvm-interview/src/main/java
        String clazzFilePath = "./jdk-interview/jvm-interview/src/main/java"
                + File.separator
                + name.replace(".", File.separator)
                + ".class";
        byte[] classData = getClassData(clazzFilePath);

        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String path) {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(path);
            baos = new ByteArrayOutputStream();

            int bufferSize = 4 * 1024;
            byte[] buffer = new byte[bufferSize];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            throw new CommonException("IO异常");
        } finally {
            StreamUtil.close(baos, fis);
        }
    }
}
