# FileDescriptor（文件描述符）（句柄）

    内核（kernel）利用文件描述符（file descriptor）来访问文件。文件描述符是非负整数。
    文件描述符的有效范围是 0 到 OPEN_MAX。
        标准输入（standard input）的文件描述符是 0
        标准输出（standard output）是 1
        标准错误（standard error）是 2

## FileDescriptor 如何访问文件

    内核为每一个进程维护一个打开文件的列表，称为文件表（File Table），索引是fd，
    数据为打开文件的信息（包括一个指向文件的Inode对象的指针，和相关元数据）。(Inode包含文件的物理地址)

    也就是有了Map结构，key是fd，value是文件的信息（包括物理地址、读取模式。。。。。）

    子进程默认获得一份父进程FIle Table的拷贝，
    而 更改一个进程的FileTable不会影响另一个进程
    （如果子进程关闭了文件 不会影响父进程的File Table），
    所以fd可以用来共享文件。

## 学习代码

[代码入口](FileDescriptorLearn.java)

