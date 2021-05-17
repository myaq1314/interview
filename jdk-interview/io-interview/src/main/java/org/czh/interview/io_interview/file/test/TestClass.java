package org.czh.interview.io_interview.file.test;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class TestClass {

    static {
        StaticClass.setTestInterface(new TestInterface() {
            @Override
            public void set(TestClass var1, int test) {
                var1.test = test;
            }

            @Override
            public int get(TestClass var1) {
                return var1.test;
            }
        });
    }

    private int test;

    public TestClass() {
        this.test = -1;
    }

    private TestClass(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestClass{" + "test=" + test + '}';
    }
}
