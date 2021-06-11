package org.czh.interview.jdk_interview.io_interview.file;

import org.czh.interview.jdk_interview.io_interview.StreamUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class FileReaderLearn {

    public static void main(String[] args) {
        write("gbk");
        write(StandardCharsets.UTF_8.name());
        read("gbk.txt", "GBK");
        read("utf-8.txt", "utf-8");
        copyByStreamReaderWrite("gbk.txt", "gbk", "copyGbkToGbkByStreamReaderWrite.txt", "gbk");
        copyByStreamReaderWrite("gbk.txt", "gbk", "copyGbkToUtf8ByStreamReaderWrite.txt", "utf8");
        copyByStreamReaderWrite("utf-8.txt", "utf8", "copyUtf8ToUtf8ByStreamReaderWrite.txt", "utf8");
        copyByStreamReaderWrite("utf-8.txt", "utf8", "copyUtf8ToGbkByStreamReaderWrite.txt", "gbk");
        copyByInputStreamReaderAndFileWriter("gbk.txt", "gbk", "copyGbkToUtf8ByInputStreamReaderAndFileWriter.txt");
        copyByInputStreamReaderAndFileWriter("utf-8.txt", "utf8", "copyUtf8ToUtf8ByInputStreamReaderAndFileWriter.txt");

        copyByBufferedReaderWrite("gbk.txt", "gbk", "copyGbkToGbkByBufferedReaderWrite.txt", "gbk");
        copyByBufferedReaderWrite("gbk.txt", "gbk", "copyGbkToUtf8ByBufferedReaderWrite.txt", "utf8");
        copyByBufferedReaderWrite("utf-8.txt", "utf8", "copyUtf8ToGbkByBufferedReaderWrite.txt", "gbk");
        copyByBufferedReaderWrite("utf-8.txt", "utf8", "copyUtf8ToUtf8ByBufferedReaderWrite.txt", "utf8");
    }

    private static void copyByBufferedReaderWrite(String sourceName,
                                                  String sourceCharset,
                                                  String targetName,
                                                  String targetCharset) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, sourceCharset);
            br = new BufferedReader(isr, 1024);

            fos = new FileOutputStream(targetFile, false);
            osw = new OutputStreamWriter(fos, targetCharset);
            bw = new BufferedWriter(osw, 1024);

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(bw, osw, fos, br, isr, fis);
        }
    }

    private static void copyByInputStreamReaderAndFileWriter(String sourceName,
                                                             String sourceCharset,
                                                             String targetName) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        InputStreamReader isr = null;
        FileWriter fw = null;
        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, sourceCharset.toUpperCase());
            // mac 默认 utf-8
            fw = new FileWriter(targetFile);

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            char[] chars = new char[length];
            int len;
            while ((len = isr.read(chars)) != -1) {
                fw.write(chars, 0, len);
                fw.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(isr, fw, fis);
        }
    }

    private static void copyByStreamReaderWrite(String sourceName,
                                                String sourceCharset,
                                                String targetName,
                                                String targetCharset) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        InputStreamReader isr = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, sourceCharset.toUpperCase());

            fos = new FileOutputStream(targetFile, false);
            osw = new OutputStreamWriter(fos, targetCharset.toUpperCase());

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            char[] chars = new char[length];
            int len;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
                osw.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(osw, fos, isr, fis);
        }
    }

    private static void read(String fileName, String charsetName) {
        File sourceFile = StreamUtil.getIoSourceFile(fileName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis, charsetName.toUpperCase());

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            char[] chars = new char[length];
            while (isr.read(chars) != -1) {
                System.out.println(new String(chars));
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(isr, fis);
        }
    }

    private static void write(String charsetName) {
        File targetFile = StreamUtil.getIoTargetFile(charsetName.toLowerCase() + ".txt");

        // 按照使用顺序，依次创建
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(targetFile);
            osw = new OutputStreamWriter(fos, charsetName.toUpperCase());

            // 保证偶数个汉字
            osw.write("源文件是" + charsetName.toUpperCase() + "格式");
            osw.flush();
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(osw, fos);
        }
    }
}
