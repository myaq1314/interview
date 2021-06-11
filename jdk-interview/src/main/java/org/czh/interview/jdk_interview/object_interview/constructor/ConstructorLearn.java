package org.czh.interview.jdk_interview.object_interview.constructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-19
 * email 916419307@qq.com
 */
public class ConstructorLearn {

    /**
     * 一起执行四个方法
     * <p>
     * parent static block（类加载时执行，只执行一次）
     * parent static method（随调用次数，多次调用，每次执行）
     * <p>
     * parent static method（随调用次数，多次调用，每次执行）
     * <p>
     * child static block（类加载时执行，只执行一次）
     * child static method（随调用次数，多次调用，每次执行）
     * <p>
     * child static method（随调用次数，多次调用，每次执行）
     * <p>
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor（每次新建实例，都会执行一次）
     * parent constructor method（随调用次数，多次调用，每次执行）
     * <p>
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor（每次新建实例，都会执行一次）
     * parent constructor method（随调用次数，多次调用，每次执行）
     * <p>
     * parent constructor block（每次新建子类实例，父类都会执行一次）
     * parent constructor（每次新建子类实例，父类都会执行一次）
     * child constructor block（每次新建实例，都会执行一次）
     * child constructor（每次新建实例，都会执行一次）
     * child constructor method（随调用次数，多次调用，每次执行）
     * <p>
     * parent constructor block（每次新建子类实例，父类都会执行一次）
     * parent constructor（每次新建子类实例，父类都会执行一次）
     * child constructor block（每次新建实例，都会执行一次）
     * child constructor（每次新建实例，都会执行一次）
     * child constructor method（随调用次数，多次调用，每次执行）
     */
    public static void main(String[] args) {
        repeatExecParentStaticMethod(); // 重复执行 父类 静态方法
        System.out.println();
        repeatExecChildStaticMethod(); // 重复执行 子类 静态方法
        System.out.println();
        repeatExecParentConstructorMethod(); // 重复执行 父类 构造器才能执行的方法
        System.out.println();
        repeatExecChildConstructorMethod(); // 重复执行 子类 构造器才能执行的方法
        System.out.println();
    }

    /**
     * 重复执行 父类 静态 方法
     * 执行一遍打印结果：
     * parent static block
     * parent static method
     * 执行两遍打印结果：
     * parent static block（类加载时执行，只执行一次）
     * parent static method
     * <p>
     * parent static method
     * 执行顺序：
     * 父类静态代码块（1次）（无论调用多少次，都只调用一次，在类加载的时候）
     * > 父类静态方法（调用次数）（多次调用，重复该步骤）
     */
    private static void repeatExecParentStaticMethod() {
        Parent.staticMethod();
        System.out.println();
        Parent.staticMethod();
    }

    /**
     * 重复执行 子类 静态 方法
     * 执行一遍打印结果：
     * parent static block
     * child static block
     * child static method
     * 执行两遍打印结果：
     * parent static block（类加载时执行，只执行一次）
     * child static block（类加载时执行，只执行一次）
     * child static method
     * <p>
     * child static method
     * 执行顺序：
     * 父类静态代码块（1次） > 子类静态代码块（1次）（无论调用多少次，都只调用一次，在类加载的时候）
     * > 子类静态方法（调用次数）（多次调用，重复该步骤）
     */
    private static void repeatExecChildStaticMethod() {
        Child.staticMethod();
        System.out.println();
        Child.staticMethod();
    }

    /**
     * 重复执行 父类 构造器才能执行的方法
     * 执行一遍打印结果：
     * parent static block
     * parent constructor block
     * parent constructor
     * parent constructor method
     * 执行两遍打印结果：
     * parent static block（类加载时执行，只执行一次）
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor
     * parent constructor method
     * <p>
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor
     * parent constructor method
     * 执行顺序：
     * 父类静态代码块（1次）（无论调用多少次，都只调用一次，在类加载的时候）
     * > 父类构造代码块（每次）> 父类构造器（每次）（新建多个实例，重复该步骤）
     * > 父类构造器才能执行的方法（调用次数）（多次调用，重复该步骤）
     */
    private static void repeatExecParentConstructorMethod() {
        new Parent().constructorMethod();
        System.out.println();
        new Parent().constructorMethod();
    }

    /**
     * 重复执行 子类 构造器才能执行的方法
     * 执行一遍打印结果：
     * parent static block
     * child static block
     * parent constructor block
     * parent constructor
     * child constructor block
     * child constructor
     * child constructor method
     * 执行两遍打印结果：
     * parent static block（类加载时执行，只执行一次）
     * child static block（类加载时执行，只执行一次）
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor
     * child constructor block（每次新建实例，都会执行一次）
     * child constructor
     * child constructor method
     * <p>
     * parent constructor block（每次新建实例，都会执行一次）
     * parent constructor
     * child constructor block（每次新建实例，都会执行一次）
     * child constructor
     * child constructor method
     * 执行顺序：
     * 父类静态代码块（1次） > 子类静态代码块（1次）（无论调用多少次，都只调用一次，在类加载的时候）
     * > 父类构造代码块（每次） > 父类构造器（每次） > 子类构造代码块（每次） > 子类构造器（每次） （新建多个实例，重复该步骤）
     * > 子类构造器才能执行的方法（调用次数）（多次调用，重复该步骤）
     */
    private static void repeatExecChildConstructorMethod() {
        new Child().constructorMethod();
        System.out.println();
        new Child().constructorMethod();
    }
}
