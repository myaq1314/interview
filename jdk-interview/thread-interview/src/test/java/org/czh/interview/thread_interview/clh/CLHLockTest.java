package org.czh.interview.thread_interview.clh;

import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class CLHLockTest {

    int num = 0;

    @Test
    public void test() {
        CLHLock clhLock = new CLHLock();
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                clhLock.lock();
                try {
                    num++;
                } finally {
                    clhLock.unlock();
                }

                clhLock.lock();
                try {
                    num++;
                } finally {
                    clhLock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EqualsAssert.isEquals(2, num);
    }
}
