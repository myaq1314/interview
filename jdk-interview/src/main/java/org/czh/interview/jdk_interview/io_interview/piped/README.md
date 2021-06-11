# 管道流

    PipedOutputStream 管道输出流（字节流）-- 数据直接输向管道（PipedInputStream的管道）
    PipedInputStream 管道输入流（字节流）-- 数据从管道输向程序（本身有管道，数据由PipedOutputStream输入）
    PipedWriter 管道输出流（字符流）-- 数据直接输向管道（PipedReader的管道）
    PipedReader 管道输入流（字符流）-- 数据从管道输向程序（本身有管道，数据由PipedWriter输入）

    管道输入输出流，配合使用可以实现线程间通信。
    数据由某个线程写入 输出流（PipedOutputStream/PipedWriter）对象，
        并由其它线程从连接的 输入流（PipedInputStream/PipedReader）对象 读取。
    不建议使用一个线程操作两个流，容易造成线程死锁。

## 绑定流程

[字节流绑定流程](ThreadPipedStreamLearn.java)

[字符流绑定流程](ThreadPipedReaderLearn.java)
