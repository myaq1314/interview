package org.czh.interview.io_interview.array.doc;

import java.io.IOException;
import java.io.Reader;

/**
 * @author : czh
 * description : 字符数组输入流 文档；从 内存中char数组  流向 程序
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class CharArrayReader extends Reader {
    // 缓冲区
    protected char buf[];
    // 缓冲区 读取偏移量 位置索引
    protected int pos;
    // 缓冲区 标记的 位置索引
    protected int markedPos = 0;
    // 能读取的字符数据 最大长度
    protected int count;

    // 指定 缓冲区 的构造
    public CharArrayReader(char buf[]) {
        // 缓冲区
        this.buf = buf;
        // 读取偏移量 位置索引 为 0，缓冲区开始的位置
        this.pos = 0;
        // 能读取的字符数据 最大长度，此处为 数组长度
        this.count = buf.length;
    }

    // 指定 缓冲区，偏移量，读取长度
    public CharArrayReader(char buf[], int offset, int length) {
        if ((offset < 0) || (offset > buf.length) || (length < 0) || ((offset + length) < 0)) {
            throw new IllegalArgumentException();
        }
        // 缓冲区
        this.buf = buf;
        // 偏移量
        this.pos = offset;
        // 能读取的最大长度
        this.count = Math.min(offset + length, buf.length);
        // 标记 位置索引
        this.markedPos = offset;
    }

    // 判断缓冲区是否存在
    private void ensureOpen() throws IOException {
        if (buf == null)
            throw new IOException("Stream closed");
    }

    // 核心方法，从缓冲区读取一个字符数据
    public int read() throws IOException {
        // 对当前对象进行 加锁
        synchronized (lock) {
            // 判断缓冲区是否存在
            ensureOpen();
            // 偏移量位置索引 大于 最大可读长度，数据已经读取完成，返回固定-1
            if (pos >= count)
                return -1;
            else
                // 读取偏移量位置 数据
                return buf[pos++];
        }
    }

    // 核心方法，从缓冲区读取 len个字符数据，从偏移量off位置开始存放到 char 数组 中
    public int read(char b[], int off, int len) throws IOException {
        // 对当前对象进行加锁
        synchronized (lock) {
            // 判断缓冲区是否存在
            ensureOpen();

            if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) > b.length) || ((off + len) < 0)) {
                throw new IndexOutOfBoundsException();
            } else if (len == 0) {
                return 0;
            }

            // 偏移量位置索引 大于 最大可读长度，数据已经读取完成，返回固定-1
            if (pos >= count) {
                return -1;
            }

            // 计算 能读取的最大长度
            int avail = count - pos;
            // 计算 要读取的最大长度
            if (len > avail) {
                // 当要读取的长度，大于 能读取的长度时，取能读取的长度
                len = avail;
            }
            // 要读取的长度小于等于0，返回0
            if (len <= 0) {
                return 0;
            }
            // 数组拷贝
            System.arraycopy(buf, pos, b, off, len);
            // 维护 偏移量
            pos += len;
            // 返回 读取的 字符个数
            return len;
        }
    }

    // 更改偏移量
    // 下次读取数据时，会跳过 n 个字符数据
    public long skip(long n) throws IOException {
        // 对 对象本身进行加锁
        synchronized (lock) {
            // 判断缓冲区是否存在
            ensureOpen();

            // 计算能读取的最大长度
            // 数据的最大长度 - 偏移量位置索引
            long avail = count - pos;
            // 跳过的字符数量 大于 剩余的字符数量
            // 去 剩余字符数量 跳过
            if (n > avail) {
                n = avail;
            }
            if (n < 0) {
                return 0;
            }
            pos += n;
            return n;
        }
    }

    // 准备，判断 是否有剩余数量，可供读取
    public boolean ready() throws IOException {
        // 对 对象本身 进行加锁
        synchronized (lock) {
            ensureOpen();
            return (count - pos) > 0;
        }
    }

    // 测试是否支持 标记、重置
    public boolean markSupported() {
        return true;
    }

    // 设置标记
    public void mark(int readAheadLimit) throws IOException {
        synchronized (lock) {
            ensureOpen();
            markedPos = pos;
        }
    }

    // 将缓冲区的偏移量 重置为 标记位置索引
    public void reset() throws IOException {
        synchronized (lock) {
            ensureOpen();
            pos = markedPos;
        }
    }

    // 关闭流，缓冲区 置为 null，由JVM统一回收
    public void close() {
        buf = null;
    }
}
