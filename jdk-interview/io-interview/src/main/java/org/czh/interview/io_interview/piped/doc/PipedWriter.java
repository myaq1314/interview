package org.czh.interview.io_interview.piped.doc;

import java.io.IOException;
import java.io.Writer;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class PipedWriter extends Writer {

    // 与 管道输出流 通信/绑定 的 管道输入流
    private PipedReader sink;

    // 关闭标识
    private boolean closed = false;

    // 指定 要绑定的 管道输入流
    public PipedWriter(PipedReader snk) throws IOException {
        // 连接管道输入流
        connect(snk);
    }

    // 创建一个尚未连接的管道输出流，使用前，必须先连接到管道输入流
    public PipedWriter() {
    }

    // 当前对象 管道输出流 对象，连接 管道输入流 对象
    public synchronized void connect(PipedReader snk) throws IOException {
        if (snk == null) {
            throw new NullPointerException();
        } else if (sink != null || snk.connected) {
            throw new IOException("Already connected");
        } else if (snk.closedByReader || closed) {
            throw new IOException("Pipe closed");
        }

        // 管道输入流对象
        sink = snk;
        // 存储位置索引（管道输出流操作）
        snk.in = -1;
        // 读取位置索引（管道输入流操作）
        snk.out = 0;
        // 连接 标识
        snk.connected = true;
    }

    // 向 管道输入流 管道（缓冲区） 写入数据
    public void write(int c) throws IOException {
        if (sink == null) {
            throw new IOException("Pipe not connected");
        }
        // 管道输入流 接收数据
        sink.receive(c);
    }

    // 向 管道输入流 管道（缓冲区）写入数据
    public void write(char[] cbuf, int off, int len) throws IOException {
        if (sink == null) {
            throw new IOException("Pipe not connected");
        } else if ((off | len | (off + len) | (cbuf.length - (off + len))) < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 管道输入流 接收数据
        sink.receive(cbuf, off, len);
    }

    // 唤醒 管道输入流 读取数据
    public synchronized void flush() throws IOException {
        if (sink != null) {
            if (sink.closedByReader || closed) {
                throw new IOException("Pipe closed");
            }
            synchronized (sink) {
                sink.notifyAll();
            }
        }
    }

    // 关闭管道输出流对象
    // 标识关闭状态
    // 通知 管道输入流对象
    public void close() throws IOException {
        closed = true;
        if (sink != null) {
            sink.receivedLast();
        }
    }
}