package org.czh.interview.io_interview.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class AioServer2 {

    public static void main(String[] args) {
        try {
            // 根据操作系统建立对应的底层操作类
            AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(8082));
            while (true) {
                Future<AsynchronousSocketChannel> future = channel.accept();
                try {
                    AsynchronousSocketChannel asc = future.get();
                    System.out.println("建立连接成功");
                    Future<Integer> write = asc.write(ByteBuffer.wrap("Now let's exchange data".getBytes(StandardCharsets.UTF_8)));
                    while (!write.isDone()) {
                        TimeUnit.SECONDS.sleep(2);
                    }
                    System.out.println("发送数据完成");
                    asc.close();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
