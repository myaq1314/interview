package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 希尔排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class ShellSortUtil {

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // 逐步缩小增量 gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个 gap 间隔的子序列进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // 插入排序逻辑，向前移动间隔为 gap 的元素
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 12, 1, 8, 34, 54, 2, 3};
        System.out.println("排序前: " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
