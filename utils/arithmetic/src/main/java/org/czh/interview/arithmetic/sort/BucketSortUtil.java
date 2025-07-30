package org.czh.interview.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : CZH
 * description : 桶排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class BucketSortUtil {

    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.23, 0.52, 0.25, 0.47, 0.51};
        System.out.println("原始数组: " + Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

    // 桶排序函数
    public static void bucketSort(double[] arr) {
        if (arr.length <= 0) return;

        int n = arr.length;
        List<List<Double>> buckets = new ArrayList<>(n);

        // 初始化桶
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到桶中（假设输入范围是 [0, 1)）
        for (double num : arr) {
            int bucketIndex = (int) (num * n); // 0 <= num < 1
            buckets.get(bucketIndex).add(num);
        }

        // 对每个桶排序（使用内置排序）
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 合并所有桶中的数据
        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
