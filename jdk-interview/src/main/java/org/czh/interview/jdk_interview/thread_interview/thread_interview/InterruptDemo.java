package org.czh.interview.jdk_interview.thread_interview.thread_interview;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class InterruptDemo {

    public static void main(String[] args) {
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("我被中断了");
                }
                super.run();
            }
        };

        long start = System.currentTimeMillis();
        Thread busyThread = new Thread(() -> {

            while (true) {
                if (System.currentTimeMillis() - start > 1000) {
                    break;
                }
            }
        });
        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted()) {
            // 这句有可能打印，有可能不打印，主要看sleepThread中断速度
            System.out.println("不停查看sleepThread是否中断");
        }
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }

}
