package org.czh.interview.jdk_interview.io_interview.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class BioServer2 {

    public static void main(String[] args) {
        try {
            // 服务端处理客户端连接请求
            ServerSocket serverSocket = new ServerSocket(3333);
            // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
            new Thread(() -> {
                while (true) {
                    try {
                        String firstName = Thread.currentThread().getName();
                        // 阻塞方法获取新的连接
                        Socket socket = serverSocket.accept();
                        // 每一个新的连接都创建一个线程，负责读取数据
                        new Thread(() -> {
                            try {
                                String secondName = Thread.currentThread().getName();
                                int len;
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                // 按字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.printf("线程1：【%s】，线程2：【%s】，数据：【%s】\n", firstName, secondName, new String(data, 0, len));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
