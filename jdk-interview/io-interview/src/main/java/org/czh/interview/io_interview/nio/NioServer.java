package org.czh.interview.io_interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class NioServer {

    /**
     * 保存客户端连接
     */
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // 创建 Nio ServerSocketChannel
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(9000));
            // 设置 为非阻塞
            serverSocket.configureBlocking(false);
            System.out.println("Nio服务启动成功");

            while (true) {
                // 非阻塞模式 accept 方法不会阻塞
                // NIO 的非阻塞是由操作系统内部实现的，底层调用了linux内核的 accept 函数
                SocketChannel socketChannel = serverSocket.accept();
                if (socketChannel != null) {
                    System.out.println("连接成功");
                    socketChannel.configureBlocking(false);
                    channelList.add(socketChannel);
                }

                Iterator<SocketChannel> iterator = channelList.iterator();
                while (iterator.hasNext()) {
                    SocketChannel eachSocketChannel = iterator.next();

                    // 非阻塞模式 read 方法不会阻塞
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int len = eachSocketChannel.read(byteBuffer);
                    if (len > 0) {
                        System.out.println("接收到消息:" + new String(byteBuffer.array()));
                    } else if (len == -1) {
                        iterator.remove();
                        System.out.println("客户端断开连接");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
