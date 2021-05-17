package org.czh.interview.io_interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class NioSelectorClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        // 要先向多路复用器注册，然后才可以跟服务端进行连接
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    if (sc.finishConnect()) {
                        System.out.println("服务器连接成功");
                        ByteBuffer writeBuffer = ByteBuffer.wrap("HelloServer".getBytes());
                        sc.write(writeBuffer);
                        System.out.println("向服务端发送数据结束");

                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int length = sc.read(readBuffer);
                        if (length != -1) {
                            System.out.printf("接收到服务端响应结果，消息内容为: %s\n",
                                    new String(readBuffer.array(), StandardCharsets.UTF_8)
                            );
                        }
                    }
                }
            }
        }
    }
}