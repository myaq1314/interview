package org.czh.interview.design_mode_interview.singleton_pattern;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject2 instance2 = SingleObject2.getInstance();
        System.out.println(instance2);

        SingleObject3 instance3 = SingleObject3.getInstance();
        System.out.println(instance3);

        SingleObject4 instance4 = SingleObject4.getInstance();
        System.out.println(instance4);

        SingleObject5 instance5 = SingleObject5.getInstance();
        System.out.println(instance5);

        SingleObject6 instance6 = SingleObject6.getInstance();
        System.out.println(instance6);

        SingleObject7 instance7 = SingleObject7.INSTANCE;
        System.out.println(instance7);
    }
}

// 懒汉式，懒加载，线程不安全，不建议使用
class SingleObject2 {
    private static SingleObject2 instance;

    private SingleObject2() {
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static SingleObject2 getInstance() {
        if (instance == null) {
            instance = new SingleObject2();
        }
        return instance;
    }
}

// 懒汉式，拦截在，线程安全，效率低下
class SingleObject3 {
    private static SingleObject3 instance;

    private SingleObject3() {
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static synchronized SingleObject3 getInstance() {
        if (instance == null) {
            instance = new SingleObject3();
        }
        return instance;
    }
}

// 懒汉式，懒加载，线程安全，高性能
class SingleObject4 {
    private static SingleObject4 instance;

    private SingleObject4() {
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static SingleObject4 getInstance() {
        if (instance == null) {
            synchronized (SingleObject4.class) {
                if (instance == null) {
                    instance = new SingleObject4();
                }
            }
        }
        return instance;
    }
}

// 饿汉式，初始化加载，线程安全，性能最高
// 类加载时就初始化，浪费内存
class SingleObject5 {
    @SuppressWarnings("InstantiationOfUtilityClass")
    private static final SingleObject5 instance = new SingleObject5();

    private SingleObject5() {
    }

    public static SingleObject5 getInstance() {
        return instance;
    }
}

// 登记式/静态内部类，懒加载，线程安全
class SingleObject6 {
    private SingleObject6() {
    }

    public static SingleObject6 getInstance() {
        return SingleHolder.INSTANCE;
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    private static class SingleHolder {
        private static final SingleObject6 INSTANCE = new SingleObject6();

        static {
            System.out.println("SingleHolder");
        }
    }
}

// 枚举式
enum SingleObject7 {
    INSTANCE
}