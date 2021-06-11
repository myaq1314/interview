package org.czh.interview.jdk_interview.io_interview.file.test;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class StaticClass {

    private static TestInterface testInterface;

    public static TestInterface getTestInterface() {
        return testInterface;
    }

    public static void setTestInterface(TestInterface testInterface) {
        StaticClass.testInterface = testInterface;
    }
}
