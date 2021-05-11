package org.czh.interview.io_interview.piped;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class ThreadPipedStreamDemo {

    public static void main(String[] args) {
        try {
            // 建立输入输出流
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);
            // 绑定输入输出流
            Producer producer = new Producer(pos);
            Consumer consumer = new Consumer(pis);

            pis.connect(pos);
            pos.connect(pis);

            // 向缓冲区写数据
            producer.start();
            // 读取缓冲区数据
            consumer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生产者线程
     */
    @AllArgsConstructor
    public static class Producer extends Thread {

        private final PipedOutputStream pos;

        @Override
        public void run() {
            writeMessage();
        }

        private void writeMessage() {
            StringBuilder builder = new StringBuilder("Hello World!!!");
            try {
                pos.write(builder.toString().getBytes());
                pos.close();
            } catch (IOException e) {
                System.err.printf("IO异常 %s \n", e.getCause());
            }
        }
    }

    /**
     * 消费线程
     */
    @AllArgsConstructor
    public static class Consumer extends Thread {
        // 输入流, 默认缓冲区大小为1024
        private final PipedInputStream pis;

        @Override
        public void run() {
            readMessage();
        }

        private void readMessage() {
            byte[] buf = new byte[1024];
            try {
                int len = pis.read(buf);
                System.out.println("缓冲区的内容为: " + new String(buf, 0, len));
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
