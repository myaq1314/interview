package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class TreeSortUtil {

    // 二叉搜索树节点类
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int value) {
            this.val = value;
        }

        // 插入新节点
        void insert(int value) {
            if (value <= val) {
                if (left == null) left = new TreeNode(value);
                else left.insert(value);
            } else {
                if (right == null) right = new TreeNode(value);
                else right.insert(value);
            }
        }

        // 中序遍历写入数组
        void inOrderTraversal(int[] arr, int[] index) {
            if (left != null) left.inOrderTraversal(arr, index);
            arr[index[0]++] = val;
            if (right != null) right.inOrderTraversal(arr, index);
        }
    }

    // 树排序主函数
    public static void treeSort(int[] arr) {
        if (arr.length == 0) return;

        // 1. 构建 BST
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root.insert(arr[i]);
        }

        // 2. 中序遍历，写回原数组
        int[] index = {0}; // 用数组包装 index，支持引用传递
        root.inOrderTraversal(arr, index);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 8, 1, 6};
        System.out.println("原始数组: " + Arrays.toString(arr));

        treeSort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }
}
