package org.czh.interview.io_interview.bio;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class BioClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9000);
            // 向服务端发送数据
            socket.getOutputStream().write("HelloServer".getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();
            System.out.println("向服务端发送数据结束");

            byte[] bytes = new byte[1024];
            // 接收服务端回传的数据
            int length = socket.getInputStream().read(bytes);

            if (length != -1) {
                System.out.println("接收到服务端的数据" + new String(bytes));
            } else {
                System.out.println("服务端没有写回数据");
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
