package org.czh.interview.thread_interview.mcs;

import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class MCSLockTest {

    int num = 0;

    @Test
    public void test() {
        MCSLock mcsLock = new MCSLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                mcsLock.lock();
                try {
                    num++;
                } finally {
                    mcsLock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EqualsAssert.isEquals(100, num);
    }
}