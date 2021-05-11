## 管道流

    PipedOutputStream 管道输出流
    PipedInputStream 管道输入流

    管道输入输出流，配合使用可以实现线程间通信。

### 流程

    建立 管道输出流 out 和 管道输入流 in，
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
    绑定 输入流 和 输出流 
            out.connect(in);
        或者是
            in.connect(out);
        或者是建立时绑定
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
        或者是
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);
    out 中写入的数据则会同步写入的 in 的缓冲区
        实际情况是，out中写入数据就是往in的缓冲区写数据，out中没有数据缓冲区

### PipedOutputStream API

    public PipedOutputStream(PipedInputStream snk);
    public PipedOutputStream();

    public synchronized void connect(PipedInputStream snk);
        将PipedOutputStream 和 PipedInputSteam绑定

    public void write(int b); 
        向output写入byte
    public void write(byte b[], int off, int len); 
        向output写入字节数组bytes

    public synchronized void flush();
        刷新缓冲区,通知其他input读取数据
    public void close();
        关闭

### PipedInputStream API

    public PipedInputStream(PipedOutputStream src);
    public PipedInputStream(PipedOutputStream src, int pipeSize);

    public void connect(PipedOutputStream src);
        将PipedOutputStream 和 PipedInputSteam绑定
    
    protected synchronized void receive(int b);
        向input缓冲区写入b
    synchronized void receive(byte b[], int off, int len);
        向input写入字节数组b

    public synchronized int read(); 
        读取缓冲区下一个字节byte
    public synchronized int read(byte b[], int off, int len)
        读取缓冲区字节数组到bytes
    public synchronized int available();
        缓冲区可读字节数组的个数
    public void close();
        关闭
