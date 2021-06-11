package org.czh.interview.jdk_interview.io_interview.piped.doc;

import java.io.IOException;

/**
 * @author : czh
 * description : 管道输如流 文档；从 内存中的 管道  流向 程序
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class PipedInputStream {

    // 管道的循环输入缓冲区的默认大小 1024
    private static final int DEFAULT_PIPE_SIZE = 1024;
    protected static final int PIPE_SIZE = DEFAULT_PIPE_SIZE;
    // 用于存放数据的循环缓冲区。
    protected byte[] buffer;
    // 管道输出流，下一个数据节点存储在循环缓冲区位置下标
    protected int in = -1;
    // 管道输入流，要读取的下一个数据节点在循环缓冲区位置下标
    protected int out = 0;
    // 标志位，管道输出流 是否关闭
    boolean closedByWriter = false;
    // 标志位，管道输入流 是否关闭 （volatile修饰，所有线程可见）
    volatile boolean closedByReader = false;
    // 标志位，管道输出流 与 管道输入流 是否绑定
    boolean connected = false;
    // 读线程 （持有 管道输入流 PipedInputStream 对象 的线程）
    Thread readSide;
    // 写线程 （持有 管道输出流 PipedOutputStream 对象 的线程）
    Thread writeSide;

    // 指定了要绑定的管道输出流对象，缓存区中的数据将由src这个管道输出流，输入
    public PipedInputStream(PipedOutputStream src) throws IOException {
        this(src, DEFAULT_PIPE_SIZE);
    }

    // 指定了要绑定的管道输出流对象，指定了管道的缓冲区大小
    public PipedInputStream(PipedOutputStream src, int pipeSize) throws IOException {
        initPipe(pipeSize);
        connect(src);
    }

    // 创建一个尚未连接的管道输入流对象，管道的缓冲区大小使用默认大小 1024，使用前，必须连接到管道输出流
    public PipedInputStream() {
        initPipe(DEFAULT_PIPE_SIZE);
    }

    // 创建一个尚未连接的管道输入流对象，指定管道的缓冲区大小
    public PipedInputStream(int pipeSize) {
        initPipe(pipeSize);
    }

    // 初始化管道缓冲区（一个byte数组）
    private void initPipe(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        buffer = new byte[pipeSize];
    }

    // 将该管道输入流，连接到管道输出流
    // 如果该对象已经连接到其它管道输出流，则抛出IO异常（使用connected标志位判断）
    public void connect(PipedOutputStream src) throws IOException {
        src.connect(this);
    }

    // 接收一个字节的数据，如果没有可用的输入，此方法阻塞
    protected synchronized void receive(int b) throws IOException {
        // 检查状态：连接状态，管道输入流是否关闭，管道输出流是否关闭，读线程是否关闭
        checkStateForReceive();
        // 管道输出流 write() ，调用 该方法
        // 所以调用本方法的是写侧线程
        writeSide = Thread.currentThread();
        // 如果缓冲区已满，进行等待，直到缓冲区空出来
        if (in == out)
            // 线程忙等待，被中断，抛出异常 java.io.InterruptedIOException()
            awaitSpace();
        // 如果缓冲区空了，in 和 out 为 0
        if (in < 0) {
            in = 0;
            out = 0;
        }
        // 在 in 位置写入b，同时in++
        buffer[in++] = (byte) (b & 0xFF);
        // 如果 in 到了末尾，下一次写入 int 为 0（循环缓冲）
        if (in >= buffer.length) {
            in = 0;
        }
    }

    // 接收byte数组数据，如果没有可用
    synchronized void receive(byte[] b, int off, int len) throws IOException {
        // 检查状态：连接状态，管道输入流是否关闭，管道输出流是否关闭，读线程是否关闭
        checkStateForReceive();
        // 管道输出流 write() ，调用 该方法
        // 所以调用本方法的是写侧线程
        writeSide = Thread.currentThread();
        int bytesToTransfer = len;
        // 当接收数据长度 大于 0，进入循环
        while (bytesToTransfer > 0) {
            // 如果缓冲区已满，进行等待，直到缓冲区空出来
            if (in == out)
                // 线程忙等待，被中断，抛出异常 java.io.InterruptedIOException()
                awaitSpace();
            int nextTransferAmount = 0;
            // 循环缓冲区 如果读的下标索引out 小于 写的下标索引in，那么写可以继续写，一直写到缓冲区结尾
            if (out < in) {
                nextTransferAmount = buffer.length - in; // 计算可以写的长度
            }
            // 循环缓冲区，如果读的下标索引out 大于 写的下标索引in，那么 说明新建缓冲区，或者是已经写完一轮了，开始第二轮
            else if (in < out) {
                // 新建缓冲区
                if (in == -1) {
                    in = out = 0;
                    // 计算可以写的长度
                    nextTransferAmount = buffer.length - in;
                }
                // 已经写完一轮，开始第二轮情况，可以写的范围，就是从in 到 out 的范围，因为 out 及 out 后面的数据还没有被读取
                else {
                    // 计算可以写的长度
                    nextTransferAmount = out - in;
                }
            }
            // 计算能写的长度，如果数据长度超过能写长度，那么只能写能写长度，剩余的要等到下一轮循环，再判断
            if (nextTransferAmount > bytesToTransfer)
                nextTransferAmount = bytesToTransfer;
            // 判断能写范围，要大于1
            assert (nextTransferAmount > 0);
            // 数组拷贝，拷贝数量为能写长度
            System.arraycopy(b, off, buffer, in, nextTransferAmount);
            // 计算剩余要写长度，总的要写长度 - 能写长度 = 剩余要写长度
            bytesToTransfer -= nextTransferAmount;
            // 计算偏移量，下一轮循环，从偏移量开始拷贝byte数组数据到缓冲区
            off += nextTransferAmount;
            // 计算下一个要写的下标
            in += nextTransferAmount;
            // 如果下一个要写的下标大于等于缓冲区长度，那么下一个要写的下标为0，循环缓冲区，从头开始
            if (in >= buffer.length) {
                in = 0;
            }
        }
    }

    // 判断状态 连接状态、读写流关闭状态、读线程是否活着
    private void checkStateForReceive() throws IOException {
        if (!connected) { // 连接状态
            throw new IOException("Pipe not connected");
        } else if (closedByWriter || closedByReader) { // 读写流关闭状态
            throw new IOException("Pipe closed");
        } else if (readSide != null && !readSide.isAlive()) { // 读线程是否活着
            throw new IOException("Read end dead");
        }
    }

    // 如果缓冲区已满，进入循环
    private void awaitSpace() throws IOException {
        while (in == out) {
            // 判断状态 连接状态、读写流关闭状态、读线程是否活着
            checkStateForReceive();
            // 缓冲区已满，提醒所有等待的读者（竞争 管道输入流（PipedInputStream）对象 锁的线程）
            notifyAll();
            try {
                // 线程忙等1秒，重复while循环
                wait(1000);
            } catch (InterruptedException ex) {
                // 抛出中断异常
                throw new java.io.InterruptedIOException();
            }
        }
    }

    // 管道输出流 关闭时，调用
    // 标记管道输出流关闭，并通知所有竞争锁的线程
    synchronized void receivedLast() {
        // 设置 绑定的管道输出流（PipedOutputStream）对象 关闭状态 为 关闭
        closedByWriter = true;
        // 唤醒 所有 竞争 管道输入流（PipedInputStream）对象锁 的线程，竞争锁
        notifyAll();
    }

    // 管道输入流（PipedInputStream）对象 读取 缓冲区一个字节数据 返回 int类型数据
    public synchronized int read() throws IOException {
        if (!connected) {
            throw new IOException("Pipe not connected");
        } else if (closedByReader) {
            throw new IOException("Pipe closed");
        }
        // 写线程 （持有 管道输出流 PipedOutputStream 对象 的线程） 不为 null
        // 写线程 （持有 管道输出流 PipedOutputStream 对象 的线程） 死亡
        // 管道输出流 PipedOutputStream 对象 关闭
        // 没有写入数据
        else if (writeSide != null && !writeSide.isAlive() && !closedByWriter && (in < 0)) {
            throw new IOException("Write end dead");
        }

        // 管道输入流（PipedInputStream）对象 调用该方法
        // 持有 管道输入流（PipedInputStream）对象 的线程为读线程
        readSide = Thread.currentThread();
        // 重试机制，实验两次，否则 就是管道损坏
        int trials = 2;
        // in 只有 新建或者清空时，为-1，小于0
        while (in < 0) {
            // 标志位已经关闭，返回-1，表示没有数据了
            if (closedByWriter) {
                return -1;
            }
            // 管道损坏
            if ((writeSide != null) && (!writeSide.isAlive()) && (--trials < 0)) {
                throw new IOException("Pipe broken");
            }
            /* might be a writer waiting */
            notifyAll();
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                throw new java.io.InterruptedIOException();
            }
        }
        // out 管道输入流，要读取的下一个数据节点在循环缓冲区位置下标
        // 取出 out 位置的数据，out + 1
        int ret = buffer[out++] & 0xFF;
        // 如果已经取到 缓冲区 尾部，那么再从 缓冲区 起点 开始 读取
        if (out >= buffer.length) {
            out = 0;
        }
        // 数据被读完了，重置了 in，丢弃缓冲区的数据
        if (in == out) {
            /* now empty */
            in = -1;
        }

        return ret;
    }

    // 管道输入流（PipedInputStream）对象 读取 缓冲区 数据，从偏移量off开始写入 byte数组 长度为len的数据
    public synchronized int read(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        // 可能等待第一个字节
        // 先读取一个字节，并可能等待
        int c = read();
        if (c < 0) {
            return -1;
        }
        b[off] = (byte) c;
        int rlen = 1;
        while ((in >= 0) && (len > 1)) {
            // 计算能读取的数据长度
            int available;
            // 写入偏移量 大于 读取偏移量
            if (in > out) {
                available = Math.min((buffer.length - out), (in - out));
            } else {
                available = buffer.length - out;
            }

            // 在循环外部已经预先读取了一个字节
            // 比较 available 能读取的字节长度 和 len 要读取的字节长度，取小的那个
            if (available > (len - 1)) {
                available = len - 1;
            }
            // 数组拷贝
            System.arraycopy(buffer, out, b, off + rlen, available);
            // out 管道输入流，要读取的下一个数据节点在循环缓冲区位置下标
            out += available;
            // 数组要下入的下一个数据节点的位置索引
            rlen += available;
            // 数组剩余要写入的数组长度
            len -= available;

            // 循环数组，读取数据到缓冲区结尾，重头开始
            if (out >= buffer.length) {
                out = 0;
            }
            // 数据读取干净，还原 in值，丢弃缓冲区的数据
            if (in == out) {
                in = -1;
            }
        }
        return rlen;
    }

    // 返回可以从这个 缓冲区中读取而不阻塞的字节数
    public synchronized int available() throws IOException {
        if (in < 0)
            return 0;
            // todo 不懂
        else if (in == out)
            return buffer.length;
        else if (in > out)
            return in - out;
        else
            return in + buffer.length - out;
    }

    // 关闭 管道输入流（PipedInputStream）对象
    public void close() throws IOException {
        // 记录标志位
        closedByReader = true;
        synchronized (this) {
            // 丢弃 缓冲区数据
            in = -1;
        }
    }

}
