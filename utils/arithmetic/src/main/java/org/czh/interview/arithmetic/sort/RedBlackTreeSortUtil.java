package org.czh.interview.arithmetic.sort;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author : CZH
 * description : 红黑树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class RedBlackTreeSortUtil {

    public static void treeSort(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int val : arr) {
            treeSet.add(val);
        }

        int i = 0;
        for (int val : treeSet) {
            arr[i++] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 6, 15, 30, 25};
        System.out.println("原始数组: " + Arrays.toString(arr));

        treeSort(arr);

        System.out.println("排序后数组(去重): " + Arrays.toString(arr));
    }
}
