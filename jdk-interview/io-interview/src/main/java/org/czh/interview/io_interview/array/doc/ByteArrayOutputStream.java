package org.czh.interview.io_interview.array.doc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author : czh
 * description : 字节数组输出流 文档；从 数据源（程序 流向）内存中byte数组
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class ByteArrayOutputStream extends OutputStream {

    // 最大数组长度
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    // 缓冲区，默认是一个长度为32的byte类型数组，可以扩容
    protected byte buf[];
    // 计数器，字节数个数
    protected int count;

    // 默认长度32的缓冲区
    public ByteArrayOutputStream() {
        this(32);
    }

    // 指定缓冲区长度
    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        buf = new byte[size];
    }

    // 最大容量
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    // 达到扩容要求时，进行扩容
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - buf.length > 0)
            grow(minCapacity);
    }

    // 扩容，默认2倍扩容
    private void grow(int minCapacity) {
        int oldCapacity = buf.length;
        // 2倍扩容
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 数组拷贝
        buf = Arrays.copyOf(buf, newCapacity);
    }

    // 将 int 类型 数据 写入 缓冲区
    public synchronized void write(int b) {
        // 判断是否需要扩容
        ensureCapacity(count + 1);
        // 数据，存入 数组
        buf[count] = (byte) b;
        // 维护 数据 长度
        count += 1;
    }

    // 将 byte数组 从偏移量 off 开始 的 len个字节写入 缓冲区
    public synchronized void write(byte b[], int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) || ((off + len) - b.length > 0)) {
            throw new IndexOutOfBoundsException();
        }
        // 判断是否需要扩容
        ensureCapacity(count + len);
        // 数组拷贝
        System.arraycopy(b, off, buf, count, len);
        // 维护 数据 长度
        count += len;
    }

    // 将缓冲区的所有数据，全部 写入 指定的输出流
    public synchronized void writeTo(OutputStream out) throws IOException {
        // 从 开头，到最大数据长度
        out.write(buf, 0, count);
    }

    // 丢弃缓冲区所有数据，重新使用缓冲空间
    public synchronized void reset() {
        count = 0;
    }

    // 创建一个新的byte数组，将缓冲区数据，全部拷贝到这个新的byte数组中
    public synchronized byte toByteArray()[] {
        return Arrays.copyOf(buf, count);
    }

    // 数据长度（字节数）
    public synchronized int size() {
        return count;
    }

    // 缓冲区 字节数组 转 String
    public synchronized String toString() {
        return new String(buf, 0, count);
    }

    // 根据 编码格式，将 缓冲区 字节数组 转换为 String
    public synchronized String toString(String charsetName)
            throws UnsupportedEncodingException {
        return new String(buf, 0, count, charsetName);
    }

    @Deprecated
    public synchronized String toString(int hibyte) {
        return new String(buf, hibyte, 0, count);
    }

    // 关闭流，没有任何处理，统一JVM回收
    public void close() throws IOException {
    }

}
