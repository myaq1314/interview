package org.czh.interview.io_interview.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;


/**
 * @author : czh
 * description : Aio客户端
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class AioClient {

    public static void main(String[] args) {
        try {
            // 创建Aio客户端
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000)).get();
            // 发送消息
            socketChannel.write(ByteBuffer.wrap("hello AIO server ！".getBytes()));
            // 接收消息
            ByteBuffer buffer = ByteBuffer.allocate(128);
            Integer len = socketChannel.read(buffer).get();
            if (len != -1) {
                // 客户端收到消息:hello Aio Client!
                System.out.println("客户端收到消息:" + new String(buffer.array(), 0, len));
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}