package org.czh.interview.io_interview.file.doc;

import java.io.Closeable;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : czh
 * description : 文件描述符，可以被用来表示开放文件，开方套接字
 * date : 2021-05-14
 * email 916419307@qq.com
 */
public final class FileDescriptor {

    // 系统内核为每一个进程维护一个打开文件的列表，称为文件表 file table，索引为fd
    // 数据为打开文件的信息（包括一个指向文件的inode对象的指针和相关的元数据，Inode包含文件的物理地址）
    // 简单来说，就是一个Map结构，key是fd，value是文件信息

    // 子进程默认获得一份父进程 file table 的拷贝
    // 而更改一个进程的 file table 不会影响另一个进程
    // fd 可以用来共享文件

    // 标注输入（键盘）的描述符
    public static final FileDescriptor in = new FileDescriptor(0);
    // 标注输出（屏幕）的描述符
    public static final FileDescriptor out = new FileDescriptor(1);
    // 标准错误（屏幕）的描述符
    public static final FileDescriptor err = new FileDescriptor(2);

    static {
        initIDs();
    }

    // 在SharedSecrets中设置Java IO文件描述符访问
    // 因为本类提供的一个无效值的空参构造，其它的构造是私有的，应用程序不能创建自己的文件描述符
    // 在这里，提供了一个修改当前对象 fd 属性的静态对象 JavaIOFileDescriptorAccess，存放在 SharedSecrets 中
    // 这样内核分配完索引fd，会通过这里将fd索引值写入对象
    static {
        sun.misc.SharedSecrets.setJavaIOFileDescriptorAccess(
                new sun.misc.JavaIOFileDescriptorAccess() {
                    public void set(java.io.FileDescriptor obj, int fd) {
                        // 因为报错，注释掉下面的语句 1 行
//                        obj.fd = fd;
                    }

                    public int get(java.io.FileDescriptor obj) {
                        // 因为报错，注释掉下面的语句 1 行
//                        return obj.fd;
                        // 因为报错，注释掉上面的语句，添加一条语句 1 行
                        return 0;
                    }

                    public void setHandle(java.io.FileDescriptor obj, long handle) {
                        throw new UnsupportedOperationException();
                    }

                    public long getHandle(java.io.FileDescriptor obj) {
                        throw new UnsupportedOperationException();
                    }
                }
        );
    }

    // fd 是 C语言的int表示非负整数，从0开始递增，直到默认上限1024
    private int fd;
    // 直接父节点，创建这个文件描述符的流对象
    private Closeable parent;
    // 其它父节点，包含直接父节点，复用这个文件描述符的流对象
    private List<Closeable> otherParents;
    // 关闭标识
    private boolean closed;

    // 应用程序不能创建自己的文件描述符
    // -1 值无效
    public FileDescriptor() {
        fd = -1;
    }

    private FileDescriptor(int fd) {
        this.fd = fd;
    }

    // 该方法在FileDescriptor类被加载入的时候进行调用，该方法是native
    // 当 FileDescriptor 被加载进内存后 fd 就不再改变了，防止每次都要重新获取浪费时间。
    private static native void initIDs();

    // 判断是否有效，这也证实了前面构造函数中的fd赋值为-1是无效的
    public boolean valid() {
        return fd != -1;
    }

    // 文件信息同步方法
    // 强制所有系统缓冲区与基础设备同步。
    // 该方法在此 FileDescriptor 的所有修改数据和属性都写入相关设备后返回。
    // 特别是，如果此 FileDescriptor 引用物理存储介质，比如文件系统中的文件，
    // 则一直要等到将与此 FileDescriptor 有关的缓冲区的所有内存中修改副本写入物理介质中，sync 方法才会返回。
    // sync 方法由要求物理存储（比例文件）处于某种已知状态下的代码使用。
    // 例如，提供简单事务处理设施的类可以使用 sync 来确保某个文件所有由给定事务造成的更改都记录在存储介质上。
    // sync 只影响此 FileDescriptor 的缓冲区下游。
    // 如果正通过应用程序（例如，通过一个 BufferedOutputStream 对象）实现内存缓冲，
    // 那么必须在数据受 sync 影响之前将这些缓冲区刷新，并转到 FileDescriptor 中（例如，通过调用 OutputStream.flush）。
    public native void sync() throws SyncFailedException;

    // 记录父节点
    synchronized void attach(Closeable c) {
        // 只有一个父节点时，记录在 parent属性上
        if (parent == null) {
            parent = c;
        }
        // 有多个父节点时，拷贝parent属性的原始父节点，在加上当前的父节点，统一记录在集合中
        else if (otherParents == null) {
            otherParents = new ArrayList<>();
            otherParents.add(parent);
            otherParents.add(c);
        }
        // 记录其它的父节点
        else {
            otherParents.add(c);
        }
    }

    // 依次关闭 所有 父节点 的流对象
    synchronized void closeAll(Closeable releaser) throws IOException {
        if (!closed) {
            closed = true;
            IOException ioe = null;
            try (Closeable c = releaser) {
                if (otherParents != null) {
                    for (Closeable referent : otherParents) {
                        try {
                            referent.close();
                        } catch (IOException x) {
                            if (ioe == null) {
                                ioe = x;
                            } else {
                                ioe.addSuppressed(x);
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                /*
                 * If releaser close() throws IOException
                 * add other exceptions as suppressed.
                 */
                if (ioe != null)
                    ex.addSuppressed(ioe);
                ioe = ex;
            } finally {
                if (ioe != null)
                    throw ioe;
            }
        }
    }
}