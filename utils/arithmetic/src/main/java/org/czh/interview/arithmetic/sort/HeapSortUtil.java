package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 堆排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class HeapSortUtil {

    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        System.out.println("原始数组: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

    // 堆排序主函数
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 建堆（从最后一个非叶子节点开始下沉）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 一个个将堆顶元素（最大值）移到末尾，并重新构建堆
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);          // 把最大值放到末尾
            heapify(arr, i, 0);       // 重新对前 i 个元素建堆
        }
    }

    // 调整堆，使以 i 为根的子树满足最大堆性质
    public static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;             // 假设当前节点是最大
        int left = 2 * i + 1;        // 左子节点索引
        int right = 2 * i + 2;       // 右子节点索引

        // 找出最大值的下标
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，则交换并递归调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, heapSize, largest);
        }
    }

    // 交换两个元素
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
