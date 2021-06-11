package org.czh.interview.jdk_interview.io_interview.file.test;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class MainClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(testClass);

        TestInterface testInterface = StaticClass.getTestInterface();
        if (testInterface != null) {
            testInterface.set(testClass, 1);
        }

        System.out.println(testClass);
    }

}
