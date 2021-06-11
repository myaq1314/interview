package org.czh.interview.jdk_interview.thread_interview.lock_interview;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : czh
 * description :
 * date : 2021-05-02
 * email 916419307@qq.com
 */
public class Test {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 2; i++) {
            new Thread("A" + i) {
                @Override
                public void run() {
                    for (int j = 0; j < 2; j++) {
                        test.read(Thread.currentThread(), j);
                    }
                }
            }.start();
//            new Thread("B" + i) {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 1; j++) {
//                        test.write(Thread.currentThread(), j);
//                    }
//                }
//            }.start();
        }
    }

    public void read(Thread thread, int index) {
        lock.readLock().lock(); // 在外面获取锁
        try {
            System.out.println("线程" + thread.getName() + "开始第" + index + "次读操作...");
            Thread.sleep(100_000);
            System.out.println("线程" + thread.getName() + "正在进行第" + index + "次读操作...");
            Thread.sleep(100_000);
            System.out.println("线程" + thread.getName() + "第" + index + "次读操作完毕...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

//    public void write(Thread thread, int index) {
//        lock.writeLock().lock(); // 在外面获取锁
//        try {
//            System.out.println("线程" + thread.getName() + "开始第" + index + "次写操作...");
//            Thread.sleep(1000000);
//            System.out.println("线程" + thread.getName() + "正在进行第" + index + "次写操作...");
//            Thread.sleep(1000000);
//            System.out.println("线程" + thread.getName() + "第" + index + "次写操作完毕...");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.writeLock().unlock();
//        }
//    }

}
