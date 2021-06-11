package org.czh.interview.jdk_interview.io_interview.piped.doc;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author : czh
 * description : 管道输出流 文档；从数据源（程序） 流向 内存中的 管道
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class PipedOutputStream extends OutputStream {

    // 与 管道输出流（PipedOutputStream）对象 通信/绑定 的 管道输入流（PipedInputStream）对象
    private PipedInputStream sink;

    // 指定 要与 管道输出流（PipedOutputStream）对象 绑定 的 管道输入流（PipedInputStream）对象
    public PipedOutputStream(PipedInputStream snk) throws IOException {
        connect(snk);
    }

    // 创建一个尚未连接的管道输出流对象，使用前，必须连接到管道输入流
    public PipedOutputStream() {
    }

    // 将 管道输出流（PipedOutputStream）对象 与 管道输入流（PipedInputStream）对象 绑定
    public synchronized void connect(PipedInputStream snk) throws IOException {
        if (snk == null) { // 排空
            throw new NullPointerException();
        } else if (sink != null || snk.connected) { // 验证 管道输入流（PipedInputStream）是否早已经绑定过了
            throw new IOException("Already connected");
        }
        // 管道输出流（PipedOutputStream）对象，向管道输入流（PipedInputStream）对象 的 循环缓冲区写数据
        // 所以只需要 管道输出流（PipedOutputStream）对象 知道 管道输入流（PipedInputStream）对象
        // 管道输入流（PipedInputStream）对象 不需要知道 管道输出流（PipedOutputStream）对象，有一个标志位，就可以了
        sink = snk;
        snk.in = -1; // 管道输出流（PipedOutputStream）对象，要存储的 下一个数据节点 在循环缓冲区的位置索引
        snk.out = 0; // 管道输入流（PipedInputStream）对象，要读取的 下一个数据节点 在循环缓冲区的位置索引
        snk.connected = true; // 标志位，表示已经连接，维护在管道输入流（PipedInputStream）对象上
    }

    // 将 int类型数据 写入 管道输出流（PipedOutputStream）对象
    public void write(int b) throws IOException {
        if (sink == null) {
            throw new IOException("Pipe not connected");
        }
        // 管道输入流（PipedInputStream）对象 接收数据，存储在 管道输入流（PipedInputStream）对象 的 循环缓冲区
        sink.receive(b);
    }

    // 将 字节数组数据 写入 管道输出流（PipedOutputStream）对象
    public void write(byte[] b, int off, int len) throws IOException {
        if (sink == null) {
            throw new IOException("Pipe not connected");
        } else if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        // 管道输入流（PipedInputStream）对象 接收数据，存储在 管道输入流（PipedInputStream）对象 的 循环缓冲区
        sink.receive(b, off, len);
    }

    // 唤醒 管道输入流（PipedInputStream）读数据
    public synchronized void flush() throws IOException {
        if (sink != null) {
            synchronized (sink) {
                sink.notifyAll();
            }
        }
    }

    // 关闭 管道输出流（PipedOutputStream）对象
    public void close() throws IOException {
        if (sink != null) {
            // 管道输入流（PipedInputStream）对象 标记 绑定的 管道输出流（PipedOutputStream）对象 关闭状态
            // 执行 notifyAll() 唤醒所有竞争锁的线程
            sink.receivedLast();
        }
    }
}
