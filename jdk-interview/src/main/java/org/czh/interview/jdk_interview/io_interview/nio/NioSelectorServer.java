package org.czh.interview.jdk_interview.io_interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : czh
 * description : 引入多路复用器后的NIO服务端
 * SelectionKey.OP_ACCEPT —— 接收连接继续事件，表示服务器监听到了客户连接，服务器可以接收这个连接了
 * SelectionKey.OP_CONNECT —— 连接就绪事件，表示客户与服务器的连接已经建立成功
 * SelectionKey.OP_READ —— 读就绪事件，表示通道中已经有了可读的数据，可以执行读操作了（通道目前有数据，可以进行读操作了）
 * SelectionKey.OP_WRITE —— 写就绪事件，表示已经可以向通道写数据了（通道目前可以用于写操作）
 * 1.当向通道中注册SelectionKey.OP_READ事件后，如果客户端有向缓存中write数据，下次轮询时，则会 isReadable()=true；
 * 2.当向通道中注册SelectionKey.OP_WRITE事件后，这时你会发现当前轮询线程中isWritable()一直为true，如果不设置为其他事件
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class NioSelectorServer {

    /**
     * 创建server端，并且向多路复用器注册，让多路复用器监听连接事件
     */
    public static void main(String[] args) throws IOException {
        // 1.根据操作系统选择适当的底层 io复用方法
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        // 2.设置为非阻塞
        serverSocket.configureBlocking(false);
        // 3.选择与操作系统适配的选择器
        Selector selector = Selector.open();
        // 将 serverSocket 的 OP_ACCEPT 事件注册到 selector 选择器上
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NioSelectorServer服务启动成功");

        while (true) {
            // 4.监听当前连接建立情况
            // 阻塞等待需要处理的事件发生
            int select = selector.select();
            if (select > 0) {
                // 判断连接业务类型
                // 获取 selector 中注册的全部事件的 SelectionKey 实例
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                // 遍历 selectionKeys,对事件进行处理
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 从事件集合里删除本次处理的key，防止下次select重复处理
                    iterator.remove();
                    // 如果是 OP_ACCEPT 事件，则进行连接和事件注册
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        // 通过 accept 方法获取与 server端 已经创建好的 socket连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 设置为非阻塞
                        socketChannel.configureBlocking(false);
                        // 把 SocketChannel 注册到 selector 上，并且 selector 对客户端的 read 操作(即读取来自客户端的消息)感兴趣
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("客户端" + socketChannel.getRemoteAddress() + "连接成功!");
                    } else if (key.isReadable()) { // 可读
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len = socketChannel.read(byteBuffer);
                        if (len > 0) {
                            System.out.printf("接收到客户端 %s 发来的消息，消息内容为: %s\n",
                                    socketChannel.getRemoteAddress(),
                                    new String(byteBuffer.array(), StandardCharsets.UTF_8)
                            );
                            key.interestOps(SelectionKey.OP_WRITE);
                        }
                    } else if (key.isWritable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(ByteBuffer.wrap("I'm receive your message".getBytes(StandardCharsets.UTF_8)));
                        socketChannel.close();
                        System.out.println("连接关闭成功！");
                    }
                }

            }


        }
    }
}