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
@SuppressWarnings("unused")
public class FileDescriptorLearn {

    public static void main(String[] args) {
        systemInOut();
//        write();
//        read();
    }

    public static void read() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File source1File = StreamUtil.getIoSourceFile("Source.txt");

        FileInputStream fis = null;
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;

        try {
            fis = new FileInputStream(sourceFile);
            fis1 = new FileInputStream(source1File);
            fis2 = new FileInputStream(fis.getFD());

            System.out.println(fis.getFD()); // 32
            System.out.println(fis1.getFD()); // 33
            System.out.println(fis2.getFD()); // 32

        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fis2, fis1, fis);
        }
    }

    public static void write() {
        File targetFile = StreamUtil.getIoTargetFile("FileDescriptorLearn_write.txt");

        FileOutputStream fos = null;
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;
        try {
            fos = new FileOutputStream(targetFile);
            fos1 = new FileOutputStream(targetFile);
            fos2 = new FileOutputStream(fos.getFD());

            System.out.println(fos.getFD()); // 32
            System.out.println(fos1.getFD()); // 33
            System.out.println(fos2.getFD()); // 32
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos2, fos1, fos);
        }
    }

    public static void systemInOut() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileOutputStream fos2 = null;
        try {
            fis = new FileInputStream(FileDescriptor.in);
            fos = new FileOutputStream(FileDescriptor.out);
            fos2 = new FileOutputStream(FileDescriptor.err);


            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                fos.flush();
                fos2.write(bytes, 0, len);
                fos2.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos2, fos, fis);
        }
    }
}
