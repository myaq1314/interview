package org.czh.interview.jdk_interview.io_interview.array;

import org.czh.interview.jdk_interview.io_interview.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class ByteArrayStreamLearn {

    public static void main(String[] args) {
        ByteArrayOutputStream baos2 = writeToByteArray("gbk.txt");
        writeFromByteArray("ByteArrayStreamLearn-writeGbkFromByteArray.txt", baos2);
        StreamUtil.close(baos2);

        ByteArrayOutputStream baos1 = writeToByteArray("utf-8.txt");
        writeFromByteArray("ByteArrayStreamLearn-writeUtf8FromByteArray.txt", baos1);
        StreamUtil.close(baos1);
    }

    private static void writeFromByteArray(String targetName, ByteArrayOutputStream baos) {
        File targetFile = StreamUtil.getIoTargetArray(targetName);

        FileOutputStream fos1 = null;
        ByteArrayInputStream bais = null;
        try {
            fos1 = new FileOutputStream(targetFile);
            // 直接将缓冲区流数据，写入输出流
            baos.writeTo(fos1);

            bais = new ByteArrayInputStream(baos.toByteArray());
            // 由byte数组输入流，读取数据，依次写入输出流
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bais.read(bytes)) != -1) {
                StreamUtil.outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(bais, fos1);
        }
    }

    private static ByteArrayOutputStream writeToByteArray(String sourceName) {
        File sourceFile = StreamUtil.getIoSourceArray(sourceName);

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(sourceFile);
            baos = new ByteArrayOutputStream();

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fis);
        }
        return baos;
    }
}
