package org.czh.interview.jdk_interview.object_interview.constructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-19
 * email 916419307@qq.com
 */
public class Parent {

    private static String parent_static_param = "parent static param";

    // 父类 静态 代码块 parent static block
    static {
        System.out.println("parent static block");
    }

    private String parent_constructor_param = "parent constructor param";

    // 父类 构造 代码块 parent constructor block
    {
        System.out.println("parent constructor block");
    }

    // 父类 构造器
    public Parent() {
        System.out.println("parent constructor");
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("parent static method");
    }

    // 构造器才能执行的方法
    public void constructorMethod() {
        System.out.println("parent constructor method");
    }
}
