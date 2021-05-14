# 数组流

## 应用场景

    在网络传输中我们往往要传输很多变量，
    我们可以利用ByteArrayOutputStream把所有的变量收集到一起，
    然后一次性把数据发送出去。

## 种类

    ByteArrayOutputStream
        将捕获的数据，转换成字节数组放在内存缓冲区中
    ByteArrayInputStream
        可以将内存缓冲区中的字节数组转化为输入流
    CharArrayWriter
        将捕获的数据，转换成字符数组放在内存缓冲区中
    CharArrayReader
        可以将内存缓冲区中的字符数据转化为输入流
