package org.czh.interview.arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : CZH
 * description : 树堆排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class TreapSortUtil {

    static class TreapNode {
        int key, priority;
        TreapNode left, right;

        TreapNode(int key) {
            this.key = key;
            this.priority = rand.nextInt();
        }
    }

    static Random rand = new Random();

    // 右旋
    static TreapNode rightRotate(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }

    // 左旋
    static TreapNode leftRotate(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

    // 插入节点
    static TreapNode insert(TreapNode root, int key) {
        if (root == null) return new TreapNode(key);

        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority)
                root = rightRotate(root);
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority)
                root = leftRotate(root);
        }
        return root;
    }

    // 中序遍历写回数组
    static void inorder(TreapNode root, int[] arr, int[] index) {
        if (root != null) {
            inorder(root.left, arr, index);
            arr[index[0]++] = root.key;
            inorder(root.right, arr, index);
        }
    }

    // 树排序函数
    public static void treapSort(int[] arr) {
        TreapNode root = null;
        for (int key : arr) {
            root = insert(root, key);
        }
        int[] idx = {0};
        inorder(root, arr, idx);
    }

    public static void main(String[] args) {
        int[] arr = {30, 10, 20, 40, 25, 5, 35};
        System.out.println("原始数组: " + Arrays.toString(arr));
        treapSort(arr);
        System.out.println("排序后数组: " + Arrays.toString(arr));
    }
}
