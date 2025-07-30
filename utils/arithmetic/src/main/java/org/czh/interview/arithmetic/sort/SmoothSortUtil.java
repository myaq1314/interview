package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 平滑排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class SmoothSortUtil {

    // Leonardo 数列：L(0)=1, L(1)=1, L(n)=L(n−1)+L(n−2)+1
    private static final int[] LEONARDO = new int[32];

    static {
        LEONARDO[0] = 1;
        LEONARDO[1] = 1;
        for (int i = 2; i < LEONARDO.length; i++) {
            LEONARDO[i] = LEONARDO[i - 1] + LEONARDO[i - 2] + 1;
        }
    }

    public static void smoothSort(int[] arr) {
        int n = arr.length;
        int[] heapOrders = new int[n]; // 保存每个堆的 L 序列索引
        int size = 0; // 当前堆数量

        // 构造堆
        for (int i = 0; i < n; i++) {
            heapOrders[size++] = 1; // 插入新堆：初始为 L(1)=1
            fixHeapUp(arr, heapOrders, size - 1, i);
        }

        // 拆解堆并排序
        for (int i = n - 1; i >= 0; i--) {
            size--;
            int order = heapOrders[size];

            if (order >= 2) {
                int left = i - 1;
                int right = i - 1 - LEONARDO[order - 2];

                heapOrders[size++] = order - 1;
                fixHeapUp(arr, heapOrders, size - 1, right);

                heapOrders[size++] = order - 2;
                fixHeapUp(arr, heapOrders, size - 1, left);
            }
        }
    }

    // 保持堆的有序性，从底向上修复
    private static void fixHeapUp(int[] arr, int[] heapOrders, int idx, int root) {
        int order = heapOrders[idx];

        while (idx > 0) {
            int parentIdx = idx - 1;
            int parentOrder = heapOrders[parentIdx];

            if (compareRoots(arr, root, root - LEONARDO[order]) <= 0) break;

            // 交换堆顶元素
            swap(arr, root, root - LEONARDO[order]);
            idx = parentIdx;
            order = parentOrder;
            root = root - LEONARDO[order];
        }

        // 下滤修复堆
        siftDown(arr, root, order);
    }

    private static void siftDown(int[] arr, int root, int order) {
        while (order >= 2) {
            int left = root - 1;
            int right = root - 1 - LEONARDO[order - 2];
            int larger = (arr[left] > arr[right]) ? left : right;
            int childOrder = (arr[left] > arr[right]) ? order - 1 : order - 2;

            if (arr[root] >= arr[larger]) break;

            swap(arr, root, larger);
            root = larger;
            order = childOrder;
        }
    }

    private static int compareRoots(int[] arr, int a, int b) {
        if (a < 0 || b < 0 || a >= arr.length || b >= arr.length) return 0;
        return Integer.compare(arr[a], arr[b]);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 7, 4, 1, 9};
        System.out.println("排序前: " + Arrays.toString(arr));
        smoothSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
