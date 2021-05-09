package org.czh.interview.thread_interview.mcs;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class MCSLock {

    private final ThreadLocal<MCSNode> currentThreadNode; // 当前节点
    private final AtomicReference<MCSNode> tailAtomicNode; // 原子级尾节点

    public MCSLock() {
        this.currentThreadNode = ThreadLocal.withInitial(MCSNode::new);
        this.tailAtomicNode = new AtomicReference<>(null);
    }

    public void lock() {
        MCSNode currentNode = currentThreadNode.get();
        MCSNode preNode = tailAtomicNode.getAndSet(currentNode);
        if (preNode != null) {
            currentNode.locked = true;
            preNode.next = currentNode;
            // noinspection StatementWithEmptyBody
            while (currentNode.locked) {  // true 锁等待，当前节点自旋等待
                // 自旋当前节点状态位
            }
        }
        // 获取到了锁
    }

    public void unlock() {
        MCSNode currentNode = currentThreadNode.get();
        if (currentNode.locked) {
            return;
        }

        if (currentNode.next == null && !tailAtomicNode.compareAndSet(currentNode, null)) {

            // noinspection StatementWithEmptyBody
            while (currentNode.next == null) {
                // 当前要释放锁的节点，不属于尾节点，但是没有下一节点的情况，自旋等待
            }
        }

        if (currentNode.next != null) {
            currentNode.next.locked = false;
            currentNode.next = null;
        }
        currentThreadNode.set(new MCSNode());
    }

    private static class MCSNode {
        MCSNode next; // 后继节点
        volatile boolean locked = false; //  默认获取到了锁
    }
}
