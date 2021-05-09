package org.czh.interview.thread_interview.clh;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : czh
 * description :
 * date : 2021-05-03
 * email 916419307@qq.com
 */
public class CLHLock {

    private final AtomicReference<CLHNode> tailThreadNode; // 原子级尾节点
    private final ThreadLocal<CLHNode> preThreadNode; // 前继节点
    private final ThreadLocal<CLHNode> currentThreadNode; // 当前节点

    public CLHLock() {
        tailThreadNode = new AtomicReference<>(new CLHNode());
        currentThreadNode = ThreadLocal.withInitial(CLHNode::new);
        preThreadNode = new ThreadLocal<>();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void lock() {
        CLHNode currentNode = currentThreadNode.get();
        currentNode.locked = true; // 状态位为等待锁
        CLHNode preNode = tailThreadNode.getAndSet(currentNode);
        preThreadNode.set(preNode);
        while (preNode.locked) { // true 前继节点获取到了锁或等待锁，当前节点自旋等待
            // 自旋前继节点状态位
        }
        // 获取到了锁
    }

    public void unlock() {
        CLHNode currentNode = currentThreadNode.get();
        if (!currentNode.locked) {
            return;
        }
        currentNode.locked = false; // 没有获取到锁，或释放了锁
        currentThreadNode.set(preThreadNode.get());
//        currentThreadNode.set(new CLHNode());
    }

    private static class CLHNode {
        volatile boolean locked = false; // 默认状态没有获取到锁，或释放了锁
    }
}
