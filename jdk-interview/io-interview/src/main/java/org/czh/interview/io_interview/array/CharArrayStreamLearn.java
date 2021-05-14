package org.czh.interview.io_interview.array;

import org.czh.interview.io_interview.StreamUtil;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-13
 * email 916419307@qq.com
 */
public class CharArrayStreamLearn {

    public static void main(String[] args) {
        CharArrayWriter caw1 = writeToCharArray("gbk.txt", "gbk");
        writeFromCharArray("CharArrayStreamLearn-writeGbkToGbkFromCharArray.txt", "gbk", caw1);
        writeFromCharArray("CharArrayStreamLearn-writeGbkToUtf8FromCharArray.txt", StandardCharsets.UTF_8.name(), caw1);
        StreamUtil.close(caw1);

        CharArrayWriter caw2 = writeToCharArray("utf-8.txt", "utf-8");
        writeFromCharArray("CharArrayStreamLearn-writeUtf8ToGbkFromCharArray.txt", "gbk", caw2);
        writeFromCharArray("CharArrayStreamLearn-writeUtf8ToUtf8FromCharArray.txt", StandardCharsets.UTF_8.name(), caw2);
        StreamUtil.close(caw2);
    }

    private static void writeFromCharArray(String targetName, String charsetName, CharArrayWriter caw) {
        File targetFile = StreamUtil.getIoTargetArray(targetName);

        FileOutputStream fos1 = null;
        OutputStreamWriter osw = null;
        CharArrayReader car = null;
        try {
            fos1 = new FileOutputStream(targetFile);
            osw = new OutputStreamWriter(fos1, charsetName);
            // 直接将缓冲区流数据，写入输出流
            caw.writeTo(osw);

            car = new CharArrayReader(caw.toCharArray());
            // 由byte数组输入流，读取数据，依次写入输出流
            int len;
            char[] chars = new char[1024];
            while ((len = car.read(chars)) != -1) {
                StreamUtil.writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(car, osw, fos1);
        }
    }

    private static CharArrayWriter writeToCharArray(String sourceName, String charsetName) {
        File sourceFile = StreamUtil.getIoSourceArray(sourceName);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        CharArrayWriter caw = null;
        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, charsetName);
            caw = new CharArrayWriter();

            char[] chars = new char[1024];
            int len;
            while ((len = isr.read(chars)) != -1) {
                caw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(isr, fis);
        }
        return caw;
    }
}
