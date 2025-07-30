package org.czh.interview.arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : CZH
 * description : 猴子排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class BogoSortUtil {

    private static Random random = new Random();

    // 判断数组是否已经有序
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    // 随机打乱数组
    private static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 猴子排序主函数
    public static void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 4};
        System.out.println("排序前: " + Arrays.toString(arr));
        bogoSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
