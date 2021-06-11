package org.czh.interview.jdk_interview.io_interview.piped;

import lombok.AllArgsConstructor;
import org.czh.interview.jdk_interview.io_interview.StreamUtil;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class ThreadPipedStreamLearn {

    public static void main(String[] args) {
        connect1();
        connect2();
        connect3();
        connect4();
    }

    private static void connect1() {
        try {
            // 建立输入输出流
            PipedInputStream pis = new PipedInputStream(31);
            // 绑定输入输出流
            PipedOutputStream pos = new PipedOutputStream(pis);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pos, "绑定输入输出流，方法1");
            Consumer consumer = new Consumer(pis);

            // 向缓冲区写数据
            producer.start();
            // 读取缓冲区数据
            consumer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connect2() {
        try {
            // 建立输入输出流
            PipedOutputStream pos = new PipedOutputStream();
            // 绑定输入输出流
            PipedInputStream pis = new PipedInputStream(pos, 31);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pos, "绑定输入输出流，方法2");
            Consumer consumer = new Consumer(pis);

            // 向缓冲区写数据
            producer.start();
            // 读取缓冲区数据
            consumer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connect3() {
        try {
            // 建立输入输出流
            PipedInputStream pis = new PipedInputStream(31);
            PipedOutputStream pos = new PipedOutputStream();
            // 绑定输入输出流
            pis.connect(pos);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pos, "绑定输入输出流，方法3");
            Consumer consumer = new Consumer(pis);

            // 向缓冲区写数据
            producer.start();
            // 读取缓冲区数据
            consumer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connect4() {
        try {
            // 建立输入输出流
            PipedInputStream pis = new PipedInputStream(31);
            PipedOutputStream pos = new PipedOutputStream();
            // 绑定输入输出流
            pos.connect(pis);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pos, "绑定输入输出流，方法4");
            Consumer consumer = new Consumer(pis);

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
        private final String context;

        @Override
        public void run() {
            try {
                pos.write(context.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.err.printf("IO异常 %s \n", e.getCause());
            } finally {
                StreamUtil.close(pos);
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
            try {
                byte[] buf = new byte[1024];
                for (int i = 0; i < 3; i++) {
                    int len;
                    if ((len = pis.read(buf)) != -1) {
                        System.out.println("缓冲区的内容为: " + new String(buf, 0, len));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(pis);
            }
        }
    }
}
