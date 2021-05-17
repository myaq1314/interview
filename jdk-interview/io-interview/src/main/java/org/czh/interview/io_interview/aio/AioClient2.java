package org.czh.interview.io_interview.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class AioClient2 {

    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
            Future<Void> future = socketChannel.connect(new InetSocketAddress(8082));
            while (!future.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> read = socketChannel.read(buffer);
            while (!read.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("接收服务器数据:" + new String(buffer.array(), 0, read.get()));
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
