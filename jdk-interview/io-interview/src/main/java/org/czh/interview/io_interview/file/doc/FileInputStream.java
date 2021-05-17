package org.czh.interview.io_interview.file.doc;

import sun.nio.ch.FileChannelImpl;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class FileInputStream extends InputStream {

    static {
        initIDs();
    }

    // 文件描述符
    private final FileDescriptor fd;
    // 文件全路径
    private final String path;
    // 锁对象
    private final Object closeLock = new Object();
    // 文件管道
    private FileChannel channel = null;
    // 关闭 标识
    private volatile boolean closed = false;

    // 使用文件路径，构建文件输入流，流向 文件 -》 系统
    public FileInputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null);
    }

    // 使用文件对象，构建文件输入流，流向 文件 -》 系统
    public FileInputStream(File file) throws FileNotFoundException {
        String name = (file != null ? file.getPath() : null);
        // 安全管理器
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            // 使用Java安全管理器，检查 文件是否可读
            security.checkRead(name);
        }
        if (name == null) {
            throw new NullPointerException();
        }
        // 文件无效，抛出异常
        // 因为报错，注释掉下面的语句 3 行
//        if (file.isInvalid()) {
//            throw new FileNotFoundException("Invalid file path");
//        }
        // 创建了一个新的文件描述符，这是一个无效的fd值，后续真实的fd值，会通过内核分配，SharedSecrets写入
        fd = new FileDescriptor();
        // 文件描述符，记录所有父节点
        // 因为报错，注释掉下面的语句 1 行
//        fd.attach(this);
        // 记录文件路径
        path = name;
        // 打开文件
        open(name);
    }

    // 使用文件描述符，创建一个文件输入流
    // 使用 0，1，2系统提供的文件描述符，分别能创建，标准输入，标准输出，标准错误的三个文件流
    // 复用别的文件输入流的文件描述符，会共享同一个文件
    public FileInputStream(FileDescriptor fdObj) {
        // 安全管理器
        SecurityManager security = System.getSecurityManager();
        if (fdObj == null) {
            throw new NullPointerException();
        }
        // 安全管理器，检查文件描述符，是否可读文件
        if (security != null) {
            security.checkRead(fdObj);
        }
        fd = fdObj;
        path = null;

        // 文件描述符，记录所有父节点
        // 因为报错，注释掉下面的语句 1 行
//        fd.attach(this);
    }

    /**
     * 设置类的属性的内存地址偏移量，便于在必要时操作内存给它赋值
     * 此处，只设置fd这一个属性
     */
    private static native void initIDs();

    // 本地方法，打开文件
    // 如果成功，则对FD（File Description文件描述符）进行设置
    // 如果不存在，则字节返回
    private native void open0(String name) throws FileNotFoundException;

    // 打开文件
    private void open(String name) throws FileNotFoundException {
        open0(name);
    }

    // 读取文件一个字节数据
    public int read() throws IOException {
        return read0();
    }

    // 本地方法，读取文件一个字节数据
    // 文件输入流只是已只读方式打开了一个文件流
    // 而且这个文件流只能依次向后读取
    private native int read0() throws IOException;

    // 本地方法，读取文件 len个字节的数据，存放到从偏移量off开始的byte类型数组 b 中
    private native int readBytes(byte b[], int off, int len) throws IOException;

    // 读取文件 数组长度 length个字节的数据，存放到从偏移量0开始的byte类型数组 b 中
    public int read(byte b[]) throws IOException {
        return readBytes(b, 0, b.length);
    }

    // 读取文件 len 个字节的数据，存放到从偏移量off开始的byte类型数据 b 中
    public int read(byte b[], int off, int len) throws IOException {
        return readBytes(b, off, len);
    }

    // 跳过 n 个字节
    public long skip(long n) throws IOException {
        return skip0(n);
    }

    // skip0的核心是用于获取和操作文件读写位置的lseek函数，
    private native long skip0(long n) throws IOException;

    // 剩余能读取的字节数量
    public int available() throws IOException {
        return available0();
    }

    // available0的实现会区分fd的类型，
    // 如果是Socket等文件描述符，则使用ioctl函数获取接受缓冲区中的字节数，
    // 如果是常规的文件，则使用lseek函数获取剩余的未读取的字节数。
    private native int available0() throws IOException;

    // 关闭方法，
    public void close() throws IOException {
        // 等同 等当前对象 进行加锁
        synchronized (closeLock) {
            if (closed) {
                return;
            }
            closed = true;
        }
        // 关闭 管道
        if (channel != null) {
            channel.close();
        }

        // 依次 关闭 文件描述符 父节点的流
        // 因为报错，注释掉下面的语句 5 行
//        fd.closeAll(new Closeable() {
//            public void close() throws IOException {
//                close0();
//            }
//        });
    }

    // 获取 文件描述符
    public final FileDescriptor getFD() throws IOException {
        if (fd != null) {
            return fd;
        }
        throw new IOException();
    }

    // 获取 文件通道
    public FileChannel getChannel() {
        // 对对象本身进行加锁
        synchronized (this) {
            if (channel == null) {
                channel = FileChannelImpl.open(fd, path, true, false, this);
            }
            return channel;
        }
    }

    // close0的核心就是关闭文件描述符的close函数。
    private native void close0() throws IOException;

    protected void finalize() throws IOException {
        if ((fd != null) && (fd != FileDescriptor.in)) {
            close();
        }
    }
}
