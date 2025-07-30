package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 归并排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class MergeSortUtil {

    // 主方法：测试归并排序
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("原始数组: " + Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);

        System.out.println("排序后数组: " + Arrays.toString(array));
    }

    // 归并排序主函数
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 递归排序左右两边
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 合并两个有序数组
            merge(arr, left, mid, right);
        }
    }

    // 合并两个有序子数组
    public static void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组
        int[] temp = new int[right - left + 1];

        int i = left;      // 左半部分起始索引
        int j = mid + 1;   // 右半部分起始索引
        int k = 0;         // 临时数组索引

        // 合并两个有序数组到 temp[]
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 复制剩余的左边部分
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 复制剩余的右边部分
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 把临时数组复制回原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
