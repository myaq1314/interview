package org.czh.interview.jdk_interview.io_interview.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class BioServer {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                System.out.println("等待连接。。。");
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端" + clientSocket.getRemoteSocketAddress() + "连接了！");
                handle(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket clientSocket) {
        try {
            byte[] bytes = new byte[1024];
            int read = clientSocket.getInputStream().read(bytes);
            System.out.println("read 客户端" + clientSocket.getRemoteSocketAddress() + "数据完毕");
            if (read != -1) {
                System.out.println("接收到客户端的数据：" + new String(bytes, 0, read));
            }

            clientSocket.getOutputStream().write("HelloClient".getBytes(StandardCharsets.UTF_8));
            clientSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
