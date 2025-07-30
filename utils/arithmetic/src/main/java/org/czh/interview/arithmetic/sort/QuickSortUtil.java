package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 快速排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class QuickSortUtil {

    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};
        System.out.println("原始数组: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

    // 快速排序主函数
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // 分区操作
            quickSort(arr, left, pivotIndex - 1);          // 排序左子数组
            quickSort(arr, pivotIndex + 1, right);         // 排序右子数组
        }
    }

    // 分区函数（使用 Lomuto 分区方案）
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选最后一个元素作为枢轴
        int i = left - 1;       // 小于枢轴的元素区域的末尾指针

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // 把当前元素放入左边区域
            }
        }

        swap(arr, i + 1, right); // 把枢轴放到正确位置
        return i + 1;            // 返回枢轴索引
    }

    // 交换数组元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
