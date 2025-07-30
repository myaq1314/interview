package org.czh.interview.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : CZH
 * description : 分布排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class DistributionSortUtil {

    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // 1. 创建桶
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. 将数组元素分布到桶中
        for (float val : arr) {
            int bucketIndex = (int) (val * n);  // 假设输入是 [0,1) 区间
            if (bucketIndex >= n) bucketIndex = n - 1; // 边界修正
            buckets[bucketIndex].add(val);
        }

        // 3. 对每个桶进行排序
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 4. 合并所有桶
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float val : bucket) {
                arr[index++] = val;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
        System.out.println("排序前: " + Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
