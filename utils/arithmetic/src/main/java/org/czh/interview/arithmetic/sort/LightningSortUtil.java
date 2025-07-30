package org.czh.interview.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : CZH
 * description : 闪电排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class LightningSortUtil {

    public static void lightningSort(int[] arr) {
        if (arr.length == 0) return;

        int min = arr[0], max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        int bucketCount = arr.length;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        double interval = (double)(max - min + 1) / bucketCount;

        // 分配元素到桶
        for (int val : arr) {
            int idx = (int)((val - min) / interval);
            if (idx == bucketCount) idx--; // 边界修正
            buckets.get(idx).add(val);
        }

        // 桶内排序，使用Collections.sort()
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int val : bucket) {
                arr[index++] = val;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};
        System.out.println("排序前：" + Arrays.toString(arr));
        lightningSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
