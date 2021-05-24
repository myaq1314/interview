package org.czh.interview.jvm_interview.load;

/**
 * @author : czh
 * description :
 * date : 2021-05-20
 * email 916419307@qq.com
 */
public class InitializationLearn {

    public static void main(String[] args) {
        test();
    }

    private static int a = 1;

    static {
        // 静态代码块可以操作 在其之前出现的变量 a
        System.out.println(a); // 1
        a = 2;
        System.out.println(a); // 2

        // 静态代码块对 在其之后出现的变量 b 赋值，不可以访问
//        System.out.println(b); // 报错 java: 非法前向引用
        b = 12;
//        System.out.println(b); // 报错 java: 非法前向引用

        // 静态代码块对 在其之后出现的变量 c 赋值，不可以访问
//        System.out.println(c); // 报错 java: 非法前向引用
        c = 21;
//        System.out.println(c); // 报错 java: 非法前向引用
    }
    private static int b = 11;
    private static int c;

    public static void test() {
        System.out.println(a); // 2
        System.out.println(b); // 11
        System.out.println(c); // 21
    }
}
