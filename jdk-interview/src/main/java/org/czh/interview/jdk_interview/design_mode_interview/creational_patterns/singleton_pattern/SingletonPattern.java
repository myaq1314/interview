package org.czh.interview.jdk_interview.design_mode_interview.creational_patterns.singleton_pattern;

// 枚举式
enum SingletonDict {
    INSTANCE
}

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class SingletonPattern {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance1);

        LazySingleton2 instance2 = LazySingleton2.getInstance();
        System.out.println(instance2);

        LazySingleton3 instance3 = LazySingleton3.getInstance();
        System.out.println(instance3);

        HungrySingleton instance4 = HungrySingleton.getInstance();
        System.out.println(instance4);

        SingletonDict instance5 = SingletonDict.INSTANCE;
        System.out.println(instance5);
    }
}

/**
 * 懒汉模式
 * 效率低下，每次获取单例类实例，都要先获取锁
 */
class LazySingleton {
    // 对于static修饰的属性，类的所有实例对象对于该属性公用一份，即只有一份内存地址
    // 但是线程加载static变量时，也会有对应的线程内部的缓存
    // 此时有必要增加 volatile，强迫线程从内存地址上重新获取变量取值，
    // 保证 instance 在所有线程中同步
    private static volatile LazySingleton instance = null;

    // private 避免类在外部被实例化
    private LazySingleton() {
    }

    // getInstance 方法前加同步，保证只有一个线程去实例化
    @SuppressWarnings("InstantiationOfUtilityClass")
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 懒汉模式
 * 高性能，只会在首次加载时，可能会竞争锁，以后获取时，没有锁竞争
 */
class LazySingleton2 {
    private static volatile LazySingleton2 instance;

    private LazySingleton2() {
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    public static LazySingleton2 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton2.class) {
                if (instance == null) {
                    instance = new LazySingleton2();
                }
            }
        }
        return instance;
    }
}

// 登记式/静态内部类，懒加载，线程安全
class LazySingleton3 {
    private LazySingleton3() {
    }

    public static LazySingleton3 getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        @SuppressWarnings("InstantiationOfUtilityClass")
        private static final LazySingleton3 INSTANCE = new LazySingleton3();
    }
}

/**
 * 饿汉模式
 * 类初始化时，加载，浪费内存
 */
class HungrySingleton {
    // 类加载时 创建
    @SuppressWarnings("InstantiationOfUtilityClass")
    private static final HungrySingleton instance = new HungrySingleton();

    // private 避免类在外部被实例化
    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}