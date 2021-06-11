package org.czh.interview.jdk_interview.thread_interview.thread_interview;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
@SuppressWarnings("all")
public class NewThreadDemo {
    public static void main(String[] args) {
        final ThreadGroup threadGroup = new ThreadGroup("线程组名称1");

        new Thread() {
            @Override
            public void run() {
                NewThreadUtil.newThread("空参", 10_000L);
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                NewThreadUtil.newThread("Runnable", 10_000L);
            }
        }).start();

        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                NewThreadUtil.newThread("ThreadGroup + Runnable", 10_000L);
            }
        }).start();

        new Thread("线程名称1") {
            @Override
            public void run() {
                NewThreadUtil.newThread("String name", 10_000L);
            }
        }.start();

        new Thread(threadGroup, "线程名称2") {
            @Override
            public void run() {
                NewThreadUtil.newThread("ThreadGroup + String name", 10_000L);
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                NewThreadUtil.newThread("Runnable + String name", 10_000L);
            }
        }, "线程名称3").start();

        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                NewThreadUtil.newThread("ThreadGroup + Runnable + String name", 10_000L);
            }
        }, "线程名称4").start();

        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                NewThreadUtil.newThread("ThreadGroup + Runnable + String name + long stackSize", 10_000L);
            }
        }, "线程名称5", 0).start();

        int activeCount = threadGroup.activeCount();
        System.out.println(activeCount);
    }
}

class NewThreadUtil {

    public static void newThread(String desc, long millis) {
        try {
            System.out.printf("使用 %s 的构造，新建了一个线程，线程开始执行\n", desc);
            Thread.sleep(millis);
            System.out.printf("使用 %s 的构造，新建的这个线程，执行完成\n", desc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
