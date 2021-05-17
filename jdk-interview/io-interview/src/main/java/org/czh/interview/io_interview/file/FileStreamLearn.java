package org.czh.interview.io_interview.file;

import org.czh.interview.io_interview.StreamUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-12
 * email 916419307@qq.com
 */
public class FileStreamLearn {

    public static void main(String[] args) {
        write("gbk");
        write(StandardCharsets.UTF_8.name());
        read("gbkStream.txt", "gbk");
        read("utf-8Stream.txt", "utf-8");

        copyByFileStream("gbkStream.txt", "FileStreamLearn-copyGbkToGbkByFileStream.txt");
        copyByFileStream("utf-8Stream.txt", "FileStreamLearn-copyUtf8ToUtf8ByFileStream.txt");

        copyByChannel("gbkStream.txt", "FileStreamLearn-copyGbkToGbkByChannel.txt");
        copyByChannel("utf-8Stream.txt", "FileStreamLearn-copyUtf8ToUtf8ByChannel.txt");

        copyByDataStream("gbkStream.txt", "FileStreamLearn-copyGbkToGbkByDataStream.txt");
        copyByDataStream("utf-8Stream.txt", "FileStreamLearn-copyUtf8ToUtf8ByDataStream.txt");
    }

    private static void copyByDataStream(String sourceName, String targetName) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        FileInputStream fis = null;
        DataInputStream dis = null;

        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fis = new FileInputStream(sourceFile);
            dis = new DataInputStream(fis);

            fos = new FileOutputStream(targetFile);
            dos = new DataOutputStream(fos);

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            byte[] bytes = new byte[length];
            int len;
            while ((len = dis.read(bytes)) != -1) {
                dos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(dos, fos, dis, fis);
        }
    }

    private static void copyByChannel(String sourceName, String targetName) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            FileChannel fic = fis.getChannel();

            fos = new FileOutputStream(targetFile);
            FileChannel foc = fos.getChannel();
            fic.transferTo(0, fic.size(), foc);
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos, fis);
        }
    }

    private static void copyByFileStream(String sourceName, String targetName) {
        File sourceFile = StreamUtil.getIoSourceFile(sourceName);
        File targetFile = StreamUtil.getIoTargetFile(targetName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            byte[] bytes = new byte[length];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fos, fis);
        }
    }

    private static void read(String fileName, String charsetName) {
        File sourceFile = StreamUtil.getIoSourceFile(fileName);

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(sourceFile);

            int length = StreamUtil.getByteArrayLength(sourceFile.length());
            byte[] bytes = new byte[length];
            while (fis.read(bytes) != -1) {
                System.out.println(new String(bytes, charsetName));
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fis);
        }
    }

    private static void write(String charsetName) {
        File targetFile = StreamUtil.getIoTargetFile(charsetName.toLowerCase() + "Stream.txt");

        // 按照使用顺序，依次创建
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetFile);

            // 保证偶数个汉字
            fos.write(("源文件是" + charsetName.toUpperCase() + "格式").getBytes(charsetName));
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fos);
        }
    }
}
