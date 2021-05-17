package org.czh.interview.io_interview.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author : czh
 * description : Nio客户端
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class NioClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9000));
        socketChannel.configureBlocking(false);

        ByteBuffer writeBuffer = ByteBuffer.wrap("HelloServer1".getBytes());
        socketChannel.write(writeBuffer);
        System.out.println("向服务端发送数据1结束");

        writeBuffer = ByteBuffer.wrap("HelloServer2".getBytes());
        socketChannel.write(writeBuffer);
        System.out.println("向服务端发送数据2结束");

        writeBuffer = ByteBuffer.wrap("HelloServer3".getBytes());
        socketChannel.write(writeBuffer);
        System.out.println("向服务端发送数据3结束");
    }
}