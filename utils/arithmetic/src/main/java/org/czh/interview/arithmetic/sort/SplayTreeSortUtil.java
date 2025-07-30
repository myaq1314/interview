package org.czh.interview.arithmetic.sort;

import java.util.Arrays;

/**
 * @author : CZH
 * description : 伸展树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class SplayTreeSortUtil {

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    // 右旋
    static Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // 左旋
    static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Splay操作，将 key 节点伸展到根
    static Node splay(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        // key 在左子树
        if (key < root.key) {
            if (root.left == null) return root;

            // Zig-Zig (左左)
            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            // Zig-Zag (左右)
            else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }

            return (root.left == null) ? root : rightRotate(root);
        } else { // key 在右子树
            if (root.right == null) return root;

            // Zag-Zig (右左)
            if (key < root.right.key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }
            // Zag-Zag (右右)
            else if (key > root.right.key) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }

            return (root.right == null) ? root : leftRotate(root);
        }
    }

    // 插入节点
    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        root = splay(root, key);

        if (root.key == key) return root; // 已存在

        Node newNode = new Node(key);
        if (key < root.key) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        return newNode;
    }

    // 中序遍历写回数组
    static void inorder(Node root, int[] arr, int[] index) {
        if (root == null) return;
        inorder(root.left, arr, index);
        arr[index[0]++] = root.key;
        inorder(root.right, arr, index);
    }

    // 树排序函数
    public static void splaySort(int[] arr) {
        Node root = null;
        for (int key : arr) {
            root = insert(root, key);
        }
        int[] idx = {0};
        inorder(root, arr, idx);
    }

    public static void main(String[] args) {
        int[] arr = {50, 20, 40, 30, 70, 60, 80};
        System.out.println("原始数组: " + Arrays.toString(arr));
        splaySort(arr);
        System.out.println("排序后数组: " + Arrays.toString(arr));
    }
}
