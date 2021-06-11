package org.czh.interview.jdk_interview.thread_interview.thread_interview;

/**
 * @author : czh
 * description :
 * date : 2021-05-04
 * email 916419307@qq.com
 */
public class JoinDemo {

    public static void main(String[] args) {
        Thread fiveThread = null;
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i <= 9; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
            if (i == 5) {
                fiveThread = curThread;
            }
        }
        assert fiveThread != null;
        fiveThread.interrupt();
        while (fiveThread.isInterrupted()) {

        }
        System.out.printf("线程 %s ：我已经执行完成，请下一个线程开始执行 \n", Thread.currentThread().getName());
    }

    static class JoinThread extends Thread {
        private Thread preThread;

        public JoinThread(Thread preThread) {
            this.preThread = preThread;
        }

        @Override
        public void run() {
            try {
                preThread.join();
                System.out.printf("线程 %s ：线程 %s 已经执行完成，下一个轮到我执行了", Thread.currentThread().getName(), preThread.getName());
                JoinUtil.coreMethod(1000);
            } catch (InterruptedException e) {
                System.out.printf("线程 %s ：我被中断了，我不需要受别人制约了，我要立即执行了", Thread.currentThread().getName());
                JoinUtil.coreMethod(1000);
            }
        }
    }
}

class JoinUtil {
    public static void coreMethod(long millis) {
        try {
            System.out.printf("线程 %s ：我开始执行\n", Thread.currentThread().getName());
            Thread.sleep(millis);
            System.out.printf("线程 %s ：我已经执行完成 \n", Thread.currentThread().getName());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
