package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : AVL树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class AVLTreeSortUtil {

    static class AVLNode {
        int val, height;
        AVLNode left, right;

        AVLNode(int val) {
            this.val = val;
            height = 1;
        }
    }

    static class AVLTree {
        AVLNode root;

        // 获取节点高度
        int height(AVLNode node) {
            return node == null ? 0 : node.height;
        }

        // 计算平衡因子
        int getBalance(AVLNode node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        // 右旋转
        AVLNode rightRotate(AVLNode y) {
            AVLNode x = y.left;
            AVLNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        // 左旋转
        AVLNode leftRotate(AVLNode x) {
            AVLNode y = x.right;
            AVLNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        // 插入节点并保持平衡
        AVLNode insert(AVLNode node, int val) {
            if (node == null) return new AVLNode(val);

            if (val <= node.val)
                node.left = insert(node.left, val);
            else
                node.right = insert(node.right, val);

            node.height = 1 + Math.max(height(node.left), height(node.right));
            int balance = getBalance(node);

            // LL
            if (balance > 1 && val <= node.left.val)
                return rightRotate(node);

            // RR
            if (balance < -1 && val > node.right.val)
                return leftRotate(node);

            // LR
            if (balance > 1 && val > node.left.val) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // RL
            if (balance < -1 && val <= node.right.val) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        // 中序遍历写回数组
        void inOrder(AVLNode node, int[] arr, int[] index) {
            if (node == null) return;
            inOrder(node.left, arr, index);
            arr[index[0]++] = node.val;
            inOrder(node.right, arr, index);
        }

        // 对外接口：排序函数
        void sort(int[] arr) {
            root = null;
            for (int val : arr) {
                root = insert(root, val);
            }
            int[] idx = {0};
            inOrder(root, arr, idx);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 6, 15, 30, 25};
        System.out.println("原始数组: " + Arrays.toString(arr));

        AVLTree tree = new AVLTree();
        tree.sort(arr);

        System.out.println("排序后数组: " + Arrays.toString(arr));
    }

}
