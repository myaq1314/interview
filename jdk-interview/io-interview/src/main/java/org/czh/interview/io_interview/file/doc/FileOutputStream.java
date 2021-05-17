package org.czh.interview.io_interview.file.doc;

import sun.nio.ch.FileChannelImpl;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * @author : czh
 * description :
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public class FileOutputStream extends OutputStream {

    /**
     * 类加载时调用
     */
    static {
        initIDs();
    }

    /**
     * 文件描述符
     */
    private final FileDescriptor fd;
    /**
     * 是否写入到文件后面，默认为false，将文件中原本内容清空
     * 新建 流 实例时 指定，其它时候不能更改这个值
     */
    private final boolean append;
    /**
     * 文件路径
     */
    private final String path;

    /**
     * 流关闭时用到的锁
     */
    private final Object closeLock = new Object();
    /**
     * 关联的文件管道
     */
    private FileChannel channel;
    /**
     * 是否关闭
     */
    private volatile boolean closed = false;

    /**
     * 指定文件路径，
     * 指定文件清空输入
     */
    public FileOutputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null, false);
    }

    /**
     * 指定文件路径
     * 指定文件是否追加输入
     */
    public FileOutputStream(String name, boolean append) throws FileNotFoundException {
        this(name != null ? new File(name) : null, append);
    }

    /**
     * 指定文件对象
     * 指定文件清空输入
     */
    public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
    }

    /**
     * 指定文件对象
     * 指定文件是否追加输入
     */
    public FileOutputStream(File file, boolean append) throws FileNotFoundException {
        String name = (file != null ? file.getPath() : null);
        // 安全管理器
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            // 是否有写权限
            security.checkWrite(name);
        }
        if (name == null) {
            throw new NullPointerException();
        }
        // 检查路径是否合法
        // 因为报错，注释掉下面的语句 3 行
//        if (file.isInvalid()) {
//            throw new FileNotFoundException("Invalid file path");
//        }
        // 初始化文件描述符
        this.fd = new FileDescriptor();
        // 将当前输出流实例，注册到fd 父节点中
        // 因为报错，注释掉下面的语句 1 行
//        fd.attach(this);
        // true 追加输出、false 清空输出
        this.append = append;
        this.path = name;

        // 打开文件描述符
        open(name, append);
    }

    // 指定文件描述符
    // 0、1、2 标注输入、标准输出、标准错误
    // 其它，打开一个文件
    public FileOutputStream(FileDescriptor fdObj) {
        // 安全管理器
        SecurityManager security = System.getSecurityManager();
        if (fdObj == null) {
            throw new NullPointerException();
        }
        // 检查是否有写权限
        if (security != null) {
            security.checkWrite(fdObj);
        }
        this.fd = fdObj;
        this.append = false;
        this.path = null;

        // 将当前输出流实例，注册到fd 父节点中
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
    // 私有方法，使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    private native void open0(String name, boolean append) throws FileNotFoundException;

    // 使用文件全路径，打开文件
    // 私有方法，使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    private void open(String name, boolean append) throws FileNotFoundException {
        open0(name, append);
    }

    // 本地方法，将一个字节的数据，写入文件末尾
    // 私有方法，使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    private native void write(int b, boolean append) throws IOException;

    // 将一个字节的数据，写入文件末尾
    // 使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    public void write(int b) throws IOException {
        write(b, append);
    }

    // 本地方法，将字节数组的数据，写入文件末尾
    // 私有方法，使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    private native void writeBytes(byte b[], int off, int len, boolean append) throws IOException;

    // 将字节数组的数据，写入文件末尾
    // 使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    public void write(byte b[]) throws IOException {
        writeBytes(b, 0, b.length, append);
    }

    // 将字节数组b 从偏移量off开始的len长度的字节数据，写入文件末尾
    // 使用新建输出流时指定的 append true 追加到末尾，false 清空后追加到末尾
    public void write(byte b[], int off, int len) throws IOException {
        writeBytes(b, off, len, append);
    }

    // 关闭流
    public void close() throws IOException {
        // 类同 当前对象 锁
        synchronized (closeLock) {
            if (closed) {
                return;
            }
            closed = true;
        }

        // 关闭 文件管道
        if (channel != null) {
            channel.close();
        }

        // 文件描述符，依次关闭父节点流
        // 因为报错，注释掉下面的语句 5 行
//        fd.closeAll(new Closeable() {
//            public void close() throws IOException {
//                close0();
//            }
//        });
    }

    // 获取文件描述符
    public final FileDescriptor getFD() throws IOException {
        if (fd != null) {
            return fd;
        }
        throw new IOException();
    }

    // 开启一个文件管道
    public FileChannel getChannel() {
        synchronized (this) {
            if (channel == null) {
                channel = FileChannelImpl.open(fd, path, false, true, append, this);
            }
            return channel;
        }
    }

    // 用于释放与文件的连接
    // 并确保不存在对此 文件输出流 实例 的引用时，调用 close方法
    protected void finalize() throws IOException {
        if (fd != null) {
            if (fd == FileDescriptor.out || fd == FileDescriptor.err) {
                flush();
            } else {
                close();
            }
        }
    }

    private native void close0() throws IOException;

}
