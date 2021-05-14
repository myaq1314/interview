package org.czh.interview.io_interview.array.doc;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/**
 * @author : czh
 * description : 字符数组输出流 文档；从 数据源（程序 流向）内存中char数组
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public
class CharArrayWriter extends Writer {
    // 缓冲区
    protected char buf[];

    // 写入数据 字符个数
    protected int count;

    // 默认创建一个长度为32的缓冲区
    public CharArrayWriter() {
        this(32);
    }

    // 指定缓冲区长度
    public CharArrayWriter(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Negative initial size: "
                    + initialSize);
        }
        buf = new char[initialSize];
    }

    // 核心方法 向缓冲区写入一个字符长度的数据
    public void write(int c) {
        // 对对象本身进行加锁
        synchronized (lock) {
            int newcount = count + 1;
            // 缓冲区扩容，每次扩大两倍
            if (newcount > buf.length) {
                buf = Arrays.copyOf(buf, Math.max(buf.length << 1, newcount));
            }
            // 写入缓冲区
            buf[count] = (char) c;
            // 维护最终的 写入数据 总的字符个数 属性
            count = newcount;
        }
    }

    // 核心方法，将 从 偏移量off 开始的 char数组的 len个字符，写入缓冲区
    public void write(char c[], int off, int len) {
        if ((off < 0) || (off > c.length) || (len < 0) || ((off + len) > c.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        // 对对象本身进行加锁
        synchronized (lock) {
            int newcount = count + len;
            // 缓冲区扩容，默认扩大两倍
            if (newcount > buf.length) {
                buf = Arrays.copyOf(buf, Math.max(buf.length << 1, newcount));
            }
            // 数组拷贝
            System.arraycopy(c, off, buf, count, len);
            // 维护 最大 写入数据 长度
            count = newcount;
        }
    }

    // 核心方法，将一个字符串 写入 缓冲区，从字符串的偏移量 off开始的len个字符
    public void write(String str, int off, int len) {
        // 对 对象本身 进行加锁
        synchronized (lock) {
            int newcount = count + len;
            // 缓冲区扩容，默认扩大2倍
            if (newcount > buf.length) {
                buf = Arrays.copyOf(buf, Math.max(buf.length << 1, newcount));
            }
            // 拷贝 String 中 的char 字符数据，到 缓冲区
            str.getChars(off, off + len, buf, count);
            count = newcount;
        }
    }

    // 将缓冲区的数据，直接，全部 写到 其它的 字符 输出流中
    public void writeTo(Writer out) throws IOException {
        synchronized (lock) {
            out.write(buf, 0, count);
        }
    }

    // 向缓冲区追加 字符
    public CharArrayWriter append(CharSequence csq) {
        String s = (csq == null ? "null" : csq.toString());
        write(s, 0, s.length());
        return this;
    }

    // 向缓冲区追加字符，从 start位置开始，到 end位置的字符
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        String s = (csq == null ? "null" : csq).subSequence(start, end).toString();
        write(s, 0, s.length());
        return this;
    }

    // 向缓冲区 追加 一个 字符
    public CharArrayWriter append(char c) {
        write(c);
        return this;
    }

    // 将 数据最大长度 置为0，丢弃缓冲区所有数据，重新使用缓冲区
    public void reset() {
        count = 0;
    }

    // 创建一个新的char数组，将缓冲区数据，全部拷贝到这个新的char数组中
    public char toCharArray()[] {
        synchronized (lock) {
            return Arrays.copyOf(buf, count);
        }
    }

    // 能读取的最大数据长度
    public int size() {
        return count;
    }

    // 将缓冲区的全部数据，转换成 字符串
    public String toString() {
        synchronized (lock) {
            return new String(buf, 0, count);
        }
    }

    public void flush() {
    }

    public void close() {
    }

}
