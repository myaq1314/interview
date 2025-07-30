package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 插入排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class InsertionSortUtil {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // 将 key 插入到已排序部分的正确位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("排序前: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
