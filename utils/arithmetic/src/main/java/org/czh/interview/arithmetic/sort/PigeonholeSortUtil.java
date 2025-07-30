package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 鸽巢排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class PigeonholeSortUtil {

    public static void pigeonholeSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        // 找出数组中的最小值和最大值
        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        int range = max - min + 1;

        // 创建鸽巢数组，统计每个值出现的次数
        int[] holes = new int[range];

        // 填充鸽巢
        for (int val : arr) {
            holes[val - min]++;
        }

        // 将排序后的数据写回原数组
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (holes[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 7, 4, 6, 8};
        System.out.println("排序前: " + Arrays.toString(arr));

        pigeonholeSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
