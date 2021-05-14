package org.czh.interview.io_interview.piped;

import lombok.AllArgsConstructor;
import org.czh.interview.io_interview.StreamUtil;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author : czh
 * description :
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class ThreadPipedReaderLearn {

    public static void main(String[] args) {
        connect1();
        connect2();
        connect3();
        connect4();
    }

    private static void connect1() {
        try {
            // 建立输入输出流
            PipedReader pr = new PipedReader();
            // 绑定输入输出流
            PipedWriter pw = new PipedWriter(pr);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pw, "绑定输入输出流，方法1");
            Consumer consumer = new Consumer(pr);

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
            PipedWriter pw = new PipedWriter();
            // 绑定输入输出流
            PipedReader pr = new PipedReader(pw);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pw, "绑定输入输出流，方法2");
            Consumer consumer = new Consumer(pr);

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
            PipedReader pr = new PipedReader();
            PipedWriter pw = new PipedWriter();
            // 绑定输入输出流
            pr.connect(pw);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pw, "绑定输入输出流，方法3");
            Consumer consumer = new Consumer(pr);

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
            PipedReader pr = new PipedReader();
            PipedWriter pw = new PipedWriter();
            // 绑定输入输出流
            pw.connect(pr);

            // 分配输入输出流到子线程
            Producer producer = new Producer(pw, "绑定输入输出流，方法4");
            Consumer consumer = new Consumer(pr);

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

        private final PipedWriter pw;
        private final String context;

        @Override
        public void run() {
            try {
                pw.write(context.toCharArray());
            } catch (IOException e) {
                System.err.printf("IO异常 %s \n", e.getCause());
            } finally {
                StreamUtil.close(pw);
            }
        }
    }

    /**
     * 消费线程
     */
    @AllArgsConstructor
    public static class Consumer extends Thread {
        // 输入流, 默认缓冲区大小为1024
        private final PipedReader pr;

        @Override
        public void run() {
            char[] buf = new char[1024];
            try {
                int len = pr.read(buf);
                System.out.println("缓冲区的内容为: " + new String(buf, 0, len));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(pr);
            }
        }
    }
}
