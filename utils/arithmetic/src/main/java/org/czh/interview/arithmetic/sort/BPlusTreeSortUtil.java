package org.czh.interview.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : CZH
 * description : B+树排序
 * datetime : 2025/7/28
 * email : 916419307@qq.com
 */
public class BPlusTreeSortUtil {

    static class BPlusNode {
        int t; // 度数（每个节点最大子节点数为2t）
        boolean leaf;
        List<Integer> keys;           // 关键字
        List<BPlusNode> children;     // 子节点
        BPlusNode next;               // 叶子节点链表指针

        BPlusNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            keys = new ArrayList<>();
            children = new ArrayList<>();
            next = null;
        }
    }

    static class BPlusTree {
        BPlusNode root;
        int t;

        BPlusTree(int t) {
            this.t = t;
            root = new BPlusNode(t, true);
        }

        // 查找插入位置
        private int findInsertIndex(List<Integer> keys, int key) {
            int i = 0;
            while (i < keys.size() && keys.get(i) < key) {
                i++;
            }
            return i;
        }

        public void insert(int key) {
            BPlusNode r = root;
            if (r.keys.size() == 2 * t - 1) {
                BPlusNode s = new BPlusNode(t, false);
                s.children.add(r);
                splitChild(s, 0, r);
                root = s;
                insertNonFull(s, key);
            } else {
                insertNonFull(r, key);
            }
        }

        private void insertNonFull(BPlusNode node, int key) {
            if (node.leaf) {
                int idx = findInsertIndex(node.keys, key);
                node.keys.add(idx, key);
            } else {
                int idx = findInsertIndex(node.keys, key);
                BPlusNode child = node.children.get(idx);
                if (child.keys.size() == 2 * t -1) {
                    splitChild(node, idx, child);
                    if (key > node.keys.get(idx)) {
                        idx++;
                    }
                }
                insertNonFull(node.children.get(idx), key);
            }
        }

        private void splitChild(BPlusNode parent, int idx, BPlusNode child) {
            BPlusNode sibling = new BPlusNode(t, child.leaf);

            // 分割关键字
            for (int i = 0; i < t - 1; i++) {
                sibling.keys.add(child.keys.remove(t));
            }

            // 分割子节点（非叶节点）
            if (!child.leaf) {
                for (int i = 0; i < t; i++) {
                    sibling.children.add(child.children.remove(t));
                }
            }

            parent.keys.add(idx, child.keys.remove(t - 1));
            parent.children.add(idx + 1, sibling);

            // 叶子节点之间维护链表
            if (child.leaf) {
                sibling.next = child.next;
                child.next = sibling;
            }
        }

        // 叶子节点遍历，得到排序结果
        public List<Integer> traverse() {
            List<Integer> result = new ArrayList<>();
            BPlusNode node = root;
            while (!node.leaf) {
                node = node.children.get(0);
            }
            while (node != null) {
                result.addAll(node.keys);
                node = node.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 5, 15, 10, 25, 30, 35, 1, 7};
        System.out.println("原始数组: " + Arrays.toString(arr));

        BPlusTree bpt = new BPlusTree(3); // 度数为3

        for (int val : arr) {
            bpt.insert(val);
        }

        List<Integer> sorted = bpt.traverse();
        System.out.println("排序后结果: " + sorted);
    }
}
