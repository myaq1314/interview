package org.czh.interview.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : CZH
 * description : B树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class BTreeSortUtil {

    static class BTreeNode {
        int t; // 最小度数 (每个节点最少有 t-1 个 key)
        ArrayList<Integer> keys; // 关键字
        ArrayList<BTreeNode> children; // 子节点
        boolean leaf;

        BTreeNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            keys = new ArrayList<>();
            children = new ArrayList<>();
        }

        // 在非满节点中插入关键字
        void insertNonFull(int k) {
            int i = keys.size() - 1;

            if (leaf) {
                // 插入到叶子节点，保持排序
                keys.add(0);
                while (i >= 0 && keys.get(i) > k) {
                    keys.set(i + 1, keys.get(i));
                    i--;
                }
                keys.set(i + 1, k);
            } else {
                // 找到子节点插入位置
                while (i >= 0 && keys.get(i) > k)
                    i--;
                i++;
                if (children.get(i).keys.size() == 2 * t - 1) {
                    splitChild(i, children.get(i));
                    if (keys.get(i) < k)
                        i++;
                }
                children.get(i).insertNonFull(k);
            }
        }

        // 分裂满子节点
        void splitChild(int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.t, y.leaf);
            for (int j = 0; j < t - 1; j++) {
                z.keys.add(y.keys.remove(t));
            }
            if (!y.leaf) {
                for (int j = 0; j < t; j++) {
                    z.children.add(y.children.remove(t));
                }
            }
            keys.add(i, y.keys.remove(t - 1));
            children.add(i + 1, z);
        }

        // 中序遍历，写入结果
        void traverse(ArrayList<Integer> result) {
            int i;
            for (i = 0; i < keys.size(); i++) {
                if (!leaf) {
                    children.get(i).traverse(result);
                }
                result.add(keys.get(i));
            }
            if (!leaf) {
                children.get(i).traverse(result);
            }
        }
    }

    static class BTree {
        BTreeNode root;
        int t; // 度数

        BTree(int t) {
            this.t = t;
            root = new BTreeNode(t, true);
        }

        void insert(int k) {
            if (root.keys.size() == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children.add(root);
                s.splitChild(0, root);
                root = s;
            }
            root.insertNonFull(k);
        }

        ArrayList<Integer> traverse() {
            ArrayList<Integer> result = new ArrayList<>();
            if (root != null) {
                root.traverse(result);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 6, 12, 30, 7, 17};
        System.out.println("原始数组: " + Arrays.toString(arr));

        BTree bTree = new BTree(3); // 设定度数为3

        for (int val : arr) {
            bTree.insert(val);
        }

        ArrayList<Integer> sortedList = bTree.traverse();
        System.out.println("排序后结果: " + sortedList);
    }
}
