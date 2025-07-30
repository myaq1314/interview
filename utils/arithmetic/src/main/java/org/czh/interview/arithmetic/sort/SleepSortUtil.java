package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 睡眠排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class SleepSortUtil {

    public static void sleepSort(int[] arr) {
        final Object lock = new Object();

        for (int num : arr) {
            new Thread(() -> {
                try {
                    // 睡眠时间与数字成比例，这里乘以10毫秒避免过快
                    Thread.sleep(num * 10L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock) {
                    System.out.print(num + " ");
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4, 2, 6, 1, 3};
        System.out.println("原始数组: " + Arrays.toString(arr));
        System.out.print("排序结果: ");

        sleepSort(arr);

        // 主线程等待足够时间保证所有线程输出完毕
        Thread.sleep(700);
        System.out.println();
    }

}
