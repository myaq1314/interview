package org.czh.interview.jdk_interview.io_interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class NioSelectorClient2 {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    SocketChannel socketChannel = SocketChannel.open();
                    socketChannel.configureBlocking(false);
                    // 要先向多路复用器注册，然后才可以跟服务端进行连接
                    socketChannel.register(selector, SelectionKey.OP_CONNECT);
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

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
                    }
                }
            }
        }
    }
}