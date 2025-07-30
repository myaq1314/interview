package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 选择排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class SelectionSortUtil {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 找到未排序部分的最小元素索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换当前位置与最小元素位置
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};
        System.out.println("排序前: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
