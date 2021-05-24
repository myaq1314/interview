package org.czh.interview.object_interview.wait;

/**
 * @author : czh
 * description :
 * date : 2021-05-19
 * email 916419307@qq.com
 */
public class NotifyDemo {

    /**
     * thread-A : get lock（此时A运行，BC未运行）
     * thread-A : start thread B（此时A运行，B就绪等待锁，C未运行）
     * thread-A : start wait（此时A释放锁，阻塞，B获取锁运行，C未运行）
     * thread-B : get lock（此时A阻塞，B运行，C未运行）
     * thread-B : start thread C（此时A阻塞，B运行，C就绪等待锁）
     * thread-B : start notify（此时A被唤醒，B运行，C等待锁）
     * thread-B : release lock（此时A被唤醒等待锁，B释放锁，C等待锁）
     * thread-A : get lock after wait（此时A获取锁，继续执行wait后代码，B销毁，C等待锁）
     * thread-A : release lock（此时A释放锁，B销毁，C等待锁）
     * thread-C : get lock（此时A销毁，B销毁，C获取锁运行）
     * thread-C : release lock（此时A销毁，B销毁，C释放锁销毁）
     */
    public static void main(String[] args) {
        new NotifyDemo().startThreadA();
    }

    final Object lock = new Object();

    public void startThreadA() {
        new Thread(() -> {
            synchronized (lock) {
                log("get lock");
                log("start thread B");
                startThreadB();
                log("start wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log("get lock after wait");
                log("release lock");
            }
        }, "thread-A").start();
    }

    public void startThreadB() {
        new Thread(() -> {
            synchronized (lock) {
                log("get lock");
                log("start thread C");
                startThreadC();
                sleep(100_000);
                log("start notify");
                lock.notify();
                log("release lock");

            }
        }, "thread-B").start();
    }

    public void startThreadC() {
        new Thread(() -> {
            synchronized (lock) {
                log("get lock");
                log("release lock");
            }
        }, "thread-C").start();
    }

    @SuppressWarnings("SameParameterValue")
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void log(String desc) {
        System.out.println(Thread.currentThread().getName() + " : " + desc);
    }
}
