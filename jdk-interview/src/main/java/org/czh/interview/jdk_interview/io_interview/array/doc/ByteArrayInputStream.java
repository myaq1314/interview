package org.czh.interview.jdk_interview.io_interview.array.doc;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : czh
 * description : 字节数组输入流 文档；从 内存中byte数组  流向 程序
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class ByteArrayInputStream extends InputStream {

    // 缓冲区
    protected byte buf[];
    // 缓冲区 读取偏移量 位置索引
    protected int pos;
    // 缓冲区 标记的 位置索引
    protected int mark = 0;
    // 能读取的字节数据 长度
    protected int count;

    // 指定 缓冲区 的构造
    public ByteArrayInputStream(byte buf[]) {
        // 缓冲区
        this.buf = buf;
        // 读取偏移量 位置索引 为 0，缓冲区开始的位置
        this.pos = 0;
        // 能读取的字符数据 最大长度，此处为 数组长度
        this.count = buf.length;
    }

    // 指定 缓冲区，偏移量，长度
    public ByteArrayInputStream(byte buf[], int offset, int length) {
        // 缓冲区
        this.buf = buf;
        // 读取偏移量
        this.pos = offset;
        // 能读取的最大长度，
        this.count = Math.min(offset + length, buf.length);
        // 标记 位置索引
        this.mark = offset;
    }

    // 从 缓冲区 读取 一个 字节 数据
    public synchronized int read() {
        // 读取的偏移量，在能读取的最大长度范围内，返回 读取偏移量位置处数据，并且偏移量+1，
        // 否则返回-1，表示没有数据
        return (pos < count) ? (buf[pos++] & 0xff) : -1;
    }

    // 从 缓冲区 读取 长度为len的数据，从偏移量off开始存入 byte数组中。
    public synchronized int read(byte b[], int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        } else if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }

        // 读取的偏移量，必须在最大可读范围内
        if (pos >= count) {
            return -1;
        }

        // 能读的长度，最大长度 - 目前的长度
        int avail = count - pos;
        // 要读的长度，大于能读的长度，取小的那个长度
        if (len > avail) {
            len = avail;
        }
        // 能读的长度 小于等于0，表示没有数据，返回
        if (len <= 0) {
            return 0;
        }
        // 数据拷贝 native
        System.arraycopy(buf, pos, b, off, len);
        // 更改偏移量
        pos += len;
        return len;
    }

    // 更改偏移量
    // 下次读取数据时，会跳过 n 个节点数据
    public synchronized long skip(long n) {
        // 能读取的最大长度
        long k = count - pos;
        // 要读取的长度
        if (n < k) {
            // 计算 要跳过的 长度
            k = n < 0 ? 0 : n;
        }

        // 维护偏移量
        pos += k;
        return k;
    }

    // 返回 可从次 输入流 读取（跳过）的字节数
    public synchronized int available() {
        return count - pos;
    }

    // 测试是否支持 标记、重置
    public boolean markSupported() {
        return true;
    }

    // 设置标记
    public void mark(int readAheadLimit) {
        mark = pos;
    }

    // 将缓冲区的偏移量 重置为 标记位置索引
    public synchronized void reset() {
        pos = mark;
    }

    // 关闭流，没有任何操作，由JVM统一回收
    public void close() throws IOException {
    }

}
