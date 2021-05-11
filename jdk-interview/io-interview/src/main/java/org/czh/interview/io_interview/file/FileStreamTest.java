package org.czh.interview.io_interview.file;

import org.czh.interview.io_interview.StreamUtil;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-05-11
 * email 916419307@qq.com
 */
public class FileStreamTest {

    public static void main(String[] args) {
//        readByFileInputStreamReadByteArray();
        testWrite();
    }

    private static void readByFileInputStreamReadByteArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(FileDescriptor.out);

            byte[] bytes = new byte[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos, fis);
        }
    }

    private static void testWrite() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("testWrite.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileOutputStream fos2 = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);
            fos2 = new FileOutputStream(fos.getFD());

            byte[] bytes = new byte[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = fis.read(bytes)) != -1) {
//                fos.write(bytes, 0, len);
                fos2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos, fis);
        }
    }
}
