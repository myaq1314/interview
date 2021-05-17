package org.czh.interview.io_interview.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class BioClient2 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            // 创建多个线程，模拟多个客户端连接服务端
            int finalI = i;
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        try {
                            socket.getOutputStream().write((new Date() + ": hello world " + finalI).getBytes());
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
