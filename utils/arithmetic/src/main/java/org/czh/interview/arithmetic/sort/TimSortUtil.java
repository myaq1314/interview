package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 混合排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class TimSortUtil {

    private static final int RUN = 32;

    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, 10, 15, 2, 3, 17};
        System.out.println("排序前: " + Arrays.toString(arr));
        timSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    public static void timSort(int[] array) {
        int n = array.length;

        // 1. 分块用插入排序处理
        for (int i = 0; i < n; i += RUN) {
            insertionSort(array, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // 2. 归并大小逐渐增加的块
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(array, left, mid, right);
                }
            }
        }
    }

    // 插入排序：对arr从left到right进行插入排序
    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= left && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    // 归并两个已排序子数组：arr[l..m]和arr[m+1..r]
    private static void merge(int[] array, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        System.arraycopy(array, l, left, 0, len1);
        System.arraycopy(array, m + 1, right, 0, len2);

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < len1) array[k++] = left[i++];
        while (j < len2) array[k++] = right[j++];
    }
}
