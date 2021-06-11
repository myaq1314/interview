package org.czh.interview.jdk_interview.object_interview.doc;

/**
 * @author : czh
 * description :
 * date : 2021-05-17
 * email 916419307@qq.com
 */
public class Object {

    // 对象初始化时自动调用此方法
    static {
        registerNatives();
    }

    // 将C/C++中的方法映射到Java中的native方法，实现方法命名的解耦
    // 函数的执行实在静态代码块中执行，在类首次进行加载的时候执行。
    // 具体是用C/C++在DLL中实现的，然后通过JNI调用
    private static native void registerNatives();

    // 返回此Object的运行时类
//    public final native Class<?> getClass();

    // hashCode的常规协定
    // 1、在java应用程序执行期间，在对同一个对象多次条用hashCode()方法时，必须一致地返回相同的整数，
    // 前提是将对象进行equals比较时所用的信息没有被修改。
    // 从某一应用程序的依次执行到同一应用程序的另一次执行，该整数无需保持一致。
    // 2、如果根据 equals(Object) 方法，两个对象是相等的，那么对这两个对象中的每个对象调用hashCode方法都必须生成相同的整数结果
    // 3、如果根据 equals(java.lang.Object)方法，两个对象不相等，那么对这两个对象中的任一对象上调用hashCode()方法不要求一定生成不同的整数结果。
    // 但是，为不相等的对象生成不同整数结果可以提高哈希表的性能。
    public native int hashCode();

    // 这里比较的是对象的内存地址
    public boolean equals(java.lang.Object obj) {
        return (this == obj);
    }

    // 本地 clone 方法，用于对象的赋值
    protected native java.lang.Object clone() throws CloneNotSupportedException;

    // 返回该对象的字符串表示
    // getClass().getName 获取字节码文件的对应全路径名称，例如java.lang.Object
    // Integer.toHexString(hashCode()) 将哈希值转成16进制格式的字符串。
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    // 用于唤醒，因该对象调用wait()方法，被处于等待状态（waiting或time_waiting）的线程
    // 该方法只能同步方法或同步块中调用
//    public final native void notify();

    //
//    public final native void notifyAll();

    // 在线程调用中，导致当前线程进入等待状态（time_waiting），单位毫秒
    // 该方法只能同步方法或同步块中调用,超过设置时间后线程重新进入可运行状态
//    public final native void wait(long timeout) throws InterruptedException;

    // 单位毫秒，纳秒
//    public final void wait(long timeout, int nanos) throws InterruptedException {
//        if (timeout < 0) {
//            throw new IllegalArgumentException("timeout value is negative");
//        }
//
//        if (nanos < 0 || nanos > 999999) {
//            throw new IllegalArgumentException(
//                    "nanosecond timeout value out of range");
//        }
//
//        if (nanos > 0) {
//            timeout++;
//        }
//
//        wait(timeout);
//    }

    // 在其他线程调用此对象的notify()方法或notifyAll方法前，导致当前线程等待。
    // 换句话说，此方法的行为就好像它仅执行wait(0)调用一样
    // 当前线程必须拥有此对象监视器。
    // 该线程发布对此监视器的所有权并等待，直到其他线程通过调用notify()方法或notifyAll()方法通知在此对象的监视器上等待的线程醒来，
    // 然后改线程将等到重新获得对监视器的所有权后才能继续执行。
//    public final void wait() throws InterruptedException {
//        wait(0);
//    }

    // 这个方法用于对对象被回收时调用，这个由JVM支持，Object 的finalize方法默认是什么都没做。
    // 如果子类需要在对象被回收时执行一些逻辑处理，则可以重新
    protected void finalize() throws Throwable {
    }
}

