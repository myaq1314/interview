package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 位元排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class BitonicSortUtil {

    // 比较并交换，dir=true升序，false降序
    private static void compareAndSwap(int[] arr, int i, int j, boolean dir) {
        if (dir == (arr[i] > arr[j])) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 递归构建bitonic序列并排序
    private static void bitonicMerge(int[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compareAndSwap(arr, i, i + k, dir);
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    // 递归生成bitonic序列
    private static void bitonicSort(int[] arr, int low, int cnt, boolean dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            // 先递增排序前半部分
            bitonicSort(arr, low, k, true);
            // 再递减排序后半部分
            bitonicSort(arr, low + k, k, false);
            // 合并整个序列为升序或降序
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    public static void sort(int[] arr, boolean ascending) {
        int n = arr.length;
        if ((n & (n - 1)) != 0) {
            throw new IllegalArgumentException("数组长度必须是2的幂次方");
        }
        bitonicSort(arr, 0, n, ascending);
    }

    public static void main(String[] args) {
        int[] arr = {10, 30, 11, 20, 4, 33, 2, 1};
        System.out.println("排序前: " + Arrays.toString(arr));
        sort(arr, true);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
