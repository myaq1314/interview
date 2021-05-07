package org.czh.interview.design_mode_interview.facade_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-07
 * email 916419307@qq.com
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }

    // 外观角色
    static class Facade {

        private SubSystem01 obj1 = new SubSystem01();
        private SubSystem02 obj2 = new SubSystem02();
        private SubSystem03 obj3 = new SubSystem03();

        public void method() {
            obj1.method1();
            obj2.method2();
            obj3.method3();
        }
    }

    // 子系统角色
    static class SubSystem01 {
        public void method1() {
            System.out.println("子系统01的method1()被调用！");
        }
    }

    // 子系统角色
    static class SubSystem02 {
        public void method2() {
            System.out.println("子系统02的method2()被调用！");
        }
    }

    // 子系统角色
    static class SubSystem03 {
        public void method3() {
            System.out.println("子系统03的method3()被调用！");
        }
    }
}
