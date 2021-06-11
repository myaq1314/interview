package org.czh.interview.jdk_interview.object_interview.constructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-19
 * email 916419307@qq.com
 */
public class Child extends Parent {

    private static String child_static_param = "child static param";

    // 子类 静态 代码块 child static block
    static {
        System.out.println("child static block");
    }

    private String child_constructor_param = "child constructor param";

    // 子类 构造 代码块 child constructor block
    {
        System.out.println("child constructor block");
    }

    // 子类 构造器
    public Child() {
        // 默认带有这句代码，表示先执行父类的无参构造器
        super();
        System.out.println("child constructor");
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("child static method");
    }

    // 构造器才能执行的方法
    public void constructorMethod() {
        System.out.println("child constructor method");
    }
}
