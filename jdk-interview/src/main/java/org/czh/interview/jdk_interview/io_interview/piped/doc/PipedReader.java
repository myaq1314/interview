package org.czh.interview.jdk_interview.io_interview.piped.doc;

import java.io.IOException;
import java.io.Reader;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class PipedReader extends Reader {
    // 缓冲区 默认 大小 1024
    private static final int DEFAULT_PIPE_SIZE = 1024;
    // 输出流关闭标识
    boolean closedByWriter = false;
    // 输入流关闭标识
    boolean closedByReader = false;
    // 连接标识
    boolean connected = false;
    // 读线程 挂载 管道输入流
    Thread readSide;
    // 写线程 挂载 管道输出流
    Thread writeSide;
    // 字符 缓冲区，默认 1024 个字符
    char[] buffer;

    // 存储 下一个 字符数据的位置索引
    int in = -1;
    // 读取 下一个 字符数据的位置索引
    int out = 0;

    // 指定了要绑定的管道输出流对象，缓存区中的数据，将由src这个管道输出流，输入
    public PipedReader(PipedWriter src) throws IOException {
        this(src, DEFAULT_PIPE_SIZE);
    }

    // 指定了要绑定的管道输出流对象，指定了管道的缓冲区大小
    public PipedReader(PipedWriter src, int pipeSize) throws IOException {
        initPipe(pipeSize);
        connect(src);
    }

    // 创建了一个尚未连接的管道输入流对象，缓冲区默认大小1024，使用前，必选先连接管道输出流
    public PipedReader() {
        initPipe(DEFAULT_PIPE_SIZE);
    }

    // 指定缓冲区大小，创建了一个尚未连接的管道输入流对象，使用前，必须先连接管道输出流
    public PipedReader(int pipeSize) {
        initPipe(pipeSize);
    }

    // 初始化 缓冲区
    private void initPipe(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("Pipe size <= 0");
        }
        buffer = new char[pipeSize];
    }

    // 将 当前对象（管道输入流）连接 到 管道输出流 对象
    public void connect(PipedWriter src) throws IOException {
        src.connect(this);
    }

    // 接收 一个字节的 数据，由管道输出流 调用该方法，修饰符为default
    synchronized void receive(int c) throws IOException {
        if (!connected) {
            throw new IOException("Pipe not connected");
        } else if (closedByWriter || closedByReader) {
            throw new IOException("Pipe closed");
        } else if (readSide != null && !readSide.isAlive()) {
            throw new IOException("Read end dead");
        }

        // 该方法由 同一个包下的 管道输出流 调用，为写线程
        writeSide = Thread.currentThread();
        // 缓冲区满了，通知 管道输入流 读取数据，管道输出流线程 进入忙等待
        while (in == out) {
            if ((readSide != null) && !readSide.isAlive()) {
                throw new IOException("Pipe broken");
            }
            // 唤醒 等待锁的 管道输入流，读取数据
            notifyAll();
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                throw new java.io.InterruptedIOException();
            }
        }
        // 空管道（空缓冲区）情况
        if (in < 0) {
            in = 0;
            out = 0;
        }
        // 写入数据
        buffer[in++] = (char) c;
        // 数据已经写到了缓冲区末端，从0开始，循环缓冲区
        if (in >= buffer.length) {
            in = 0;
        }
    }

    // 接收字符数组数据，从数组的off偏移量位置索引开始读取，已知读取len个数据
    synchronized void receive(char[] c, int off, int len) throws IOException {
        // 循环调用 接收一个字符的 方法
        while (--len >= 0) {
            receive(c[off++]);
        }
    }

    // 接收 管道输出流 的最后一次通知
    // 该方法在 管道输出流 关闭时调用，通知当前对象，标识关闭状态，唤醒所有等待锁的对象
    synchronized void receivedLast() {
        closedByWriter = true;
        // 唤醒对象的等待池中的所有线程，进入锁池，竞争锁
        notifyAll();
    }

    // 从缓冲区读取一个字符的数据
    public synchronized int read() throws IOException {
        if (!connected) {
            throw new IOException("Pipe not connected");
        } else if (closedByReader) {
            throw new IOException("Pipe closed");
        } else if (writeSide != null && !writeSide.isAlive()
                && !closedByWriter && (in < 0)) {
            throw new IOException("Write end dead");
        }

        // 该方法由当前线程调用，当前线程持有 管道输入流，为读线程
        readSide = Thread.currentThread();
        // 重试机制 2次
        int trials = 2;
        while (in < 0) {
            // 判断 管道输出流 关闭状态
            if (closedByWriter) {
                /* closed by writer, return EOF */
                return -1;
            }
            // 当 管道输出流独享存在，线程死亡，那么重试机制会尝试3次
            if ((writeSide != null) && (!writeSide.isAlive()) && (--trials < 0)) {
                throw new IOException("Pipe broken");
            }
            // 忙等待，等待管道输出流，向缓冲区写数据
            notifyAll();
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                throw new java.io.InterruptedIOException();
            }
        }
        // 取一个字符数据
        int ret = buffer[out++];
        // 读偏移量 超过 缓冲区结尾索引，那么返回 0
        if (out >= buffer.length) {
            out = 0;
        }
        // 数据已经读完，清空管道，丢弃其中的数据
        if (in == out) {
            /* now empty */
            in = -1;
        }
        return ret;
    }

    // 读取len长度的字符数据，从偏移量off开始依次放入char数组中
    public synchronized int read(char[] cbuf, int off, int len) throws IOException {
        if (!connected) {
            throw new IOException("Pipe not connected");
        } else if (closedByReader) {
            throw new IOException("Pipe closed");
        } else if (writeSide != null && !writeSide.isAlive()
                && !closedByWriter && (in < 0)) {
            throw new IOException("Write end dead");
        }

        if ((off < 0) || (off > cbuf.length) || (len < 0) || ((off + len) > cbuf.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        // 先读取一个字符数据，判断有没有数据，或进入忙等待
        int c = read();
        if (c < 0) {
            return -1;
        }
        // 将这一个字符数据，存入char数组
        cbuf[off] = (char) c;
        int rlen = 1;
        // 读取剩余长度的字符数据
        while ((in >= 0) && (--len > 0)) {
            cbuf[off + rlen] = buffer[out++];
            rlen++;
            if (out >= buffer.length) {
                out = 0;
            }
            if (in == out) {
                /* now empty */
                in = -1;
            }
        }
        return rlen;
    }

    // 判断是否可以进行读数据
    public synchronized boolean ready() throws IOException {
        if (!connected) {
            throw new IOException("Pipe not connected");
        } else if (closedByReader) {
            throw new IOException("Pipe closed");
        } else if (writeSide != null && !writeSide.isAlive()
                && !closedByWriter && (in < 0)) {
            throw new IOException("Write end dead");
        }
        return in >= 0;
    }

    // 关闭流，丢弃缓冲区的数据，关闭读线程标识
    public void close() throws IOException {
        in = -1;
        closedByReader = true;
    }
}