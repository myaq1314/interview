package org.czh.interview.object_interview.wait;

import lombok.AllArgsConstructor;

/**
 * @author : czh
 * description :
 * date : 2021-05-17
 * email 916419307@qq.com
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            new Producer("生产者" + i, i).start();
            new Consumer("消费者" + (i + 10), i).start();
        }

    }

    private static int num;
    private static final Object lock = new Object();

    @AllArgsConstructor
    static class Producer extends Thread {

        private String name;
        private int produce;

        @Override
        public void run() {
                System.out.printf("%s 等待锁\n", this.name);
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                    System.out.printf("%s 获得锁\n", this.name);
                    System.out.printf("%s, [%d] + [%d] = [%d]\n", this.name, num, produce, num += produce);
                    try {
                        System.out.printf("%s 唤醒 下一个\n", this.name);
                        lock.notifyAll();
                        if (i != 4) {
                            System.out.printf("%s 沉睡\n", this.name);
                            lock.wait();
                            System.out.printf("%s 睡醒\n", this.name);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @AllArgsConstructor
    static class Consumer extends Thread {

        private String name;
        private int consume;

        @Override
        public void run() {
            System.out.printf("%s 等待锁\n", this.name);
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%s 获得锁\n", this.name);
                    System.out.printf("%s, [%d] - [%d] = [%d]\n", this.name, num, consume, num -= consume);
                    try {
                        System.out.printf("%s 唤醒 下一个\n", this.name);
                        lock.notifyAll();
                        if (i != 4) {
                            System.out.printf("%s 沉睡\n", this.name);
                            lock.wait();
                            System.out.printf("%s 睡醒\n", this.name);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}


