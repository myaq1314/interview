package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 基数排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class RadixSortUtil {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

    // 主函数：基数排序
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        // 找到最大值，确定最大位数
        int max = Arrays.stream(arr).max().getAsInt();

        // 从个位开始依次对每位进行计数排序（稳定排序）
        int exp = 1; // 位权：1, 10, 100, ...
        while (max / exp > 0) {
            countingSortByDigit(arr, exp);
            exp *= 10;
        }
    }

    // 对 arr[] 按某个位数进行计数排序（稳定）
    private static void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10]; // 每位是 0~9

        // 统计每个桶中元素个数
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // 构建前缀和数组（确保稳定性）
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 稳定排序：从后往前扫描
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }

        // 拷贝回原数组
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
