package org.czh.interview.jdk_interview.thread_interview.thread_interview;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class SleepDemo {

    public static void main(String[] args) {
        Thread ownRunnable = new Thread(new OwnRunnable());
        ownRunnable.setName("RunnableThread");
        ownRunnable.start();

        Thread thread2 = new OwnThread("OwnThread");
        thread2.start();

        SleepUtil.sleep(2, 1000L);
    }

    static class OwnRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                SleepUtil.sleep(2, 1000L);
            }
        }
    }

    static class OwnThread extends Thread {

        public OwnThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            SleepUtil.sleep(2, 1000L);
        }
    }
}

class SleepUtil {
    public static void sleep(int time, long millis) {
        for (int i = 0; i < time; i++) {
            System.out.printf("线程 %s 第 %d 次睡眠 %d 毫钟\n", Thread.currentThread().getName(), i, millis);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("-------线程 %s 第 %d 次醒来-------\n", Thread.currentThread().getName(), i);
        }
    }
}
