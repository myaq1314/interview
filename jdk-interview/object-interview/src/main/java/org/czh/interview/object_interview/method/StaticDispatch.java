package org.czh.interview.object_interview.method;

/**
 * @author : czh
 * description :
 * date : 2021-05-20
 * email 916419307@qq.com
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy！");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman！");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady！");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man); // hello,guy！
        sr.sayHello(woman); // hello,guy！
    }
}
