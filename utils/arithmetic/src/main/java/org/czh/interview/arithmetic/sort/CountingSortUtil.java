package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 计数排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class CountingSortUtil {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("原始数组: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // 找出最大值
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        // 创建计数数组
        int[] count = new int[max + 1];

        // 统计每个数出现的次数
        for (int num : arr) {
            count[num]++;
        }

        // 回写到原始数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void stableCountingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        // 构建前缀和数组
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 构建输出数组（从后向前保证稳定性）
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[--count[arr[i]]] = arr[i];
        }

        // 复制回原数组
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
