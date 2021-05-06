package org.czh.interview.thread_interview.thread_interview;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class TestSleepThread {

    public static void main(String[] args) {
        countDown(10000);
    }

    public static void countDown(long mills) {
        Date endDate = new Date(System.currentTimeMillis() + mills);
        long endTime = endDate.getTime();
        do {
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(endDate));
            endDate = new Date(endDate.getTime() - 1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (endTime - endDate.getTime() <= mills);
    }
}
