package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 史都吉排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class StoogeSortUtil {

    public static void stoogeSort(int[] arr, int i, int j) {
        if (i >= j) return;

        // 如果第一个元素比最后一个大，交换它们
        if (arr[i] > arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // 如果区间长度大于2，递归排序
        if (j - i + 1 > 2) {
            int t = (j - i + 1) / 3;
            stoogeSort(arr, i, j - t);       // 前2/3排序
            stoogeSort(arr, i + t, j);       // 后2/3排序
            stoogeSort(arr, i, j - t);       // 再前2/3排序
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        System.out.println("排序前: " + Arrays.toString(arr));
        stoogeSort(arr, 0, arr.length - 1);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
