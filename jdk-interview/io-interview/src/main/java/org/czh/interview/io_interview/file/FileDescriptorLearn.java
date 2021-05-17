package org.czh.interview.io_interview.file;

import org.czh.interview.io_interview.StreamUtil;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : czh
 * description :
 * date : 2021-05-11
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public class FileDescriptorLearn {

    public static void main(String[] args) {
//        systemInOut();
//        systemReadWrite();
//        writeByte();
//        writeChar();
//        readByte();
//        readChar();
        readAndWriteByte();
    }

    public static void readAndWriteByte() {
        File sourceFile = StreamUtil.getIoSourceFile("source.txt");

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(sourceFile, true);

            int time = 0;
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                time++;
                fos.write(bytes, 0, len);
                fos.flush();
                if (time > 10) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fos, fis);
        }
    }

    public static void readChar() {
        File sourceFile = StreamUtil.getIoSourceFile("source.txt");

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        FileReader fr1 = null;
        FileReader fr2 = null;
        try {
            fis = new FileInputStream(sourceFile);
            fr1 = new FileReader(fis.getFD());
            fr2 = new FileReader(sourceFile);

            System.out.println(fis.getFD()); // 32
            System.out.println(fr1); // 32
            System.out.println(fr2); // 33

        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fr2, fr1, fis);
        }
    }

    public static void readByte() {
        File sourceFile = StreamUtil.getIoSourceFile("source.txt");

        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        try {
            fis = new FileInputStream(sourceFile);
            fis1 = new FileInputStream(sourceFile);
            fis2 = new FileInputStream(fis.getFD());

            System.out.println(fis.getFD()); // 32
            System.out.println(fis1.getFD()); // 33
            System.out.println(fis2.getFD()); // 32

            byte[] temps = new byte[1024];
            int count = 0;

            while (true) {
                byte[] bytes = new byte[8];
                int read = fis.read(bytes);
                if (read != -1) {
                    System.arraycopy(bytes, 0, temps, count, read);
                    count += read;
                } else {
                    break;
                }

                int read1 = fis2.read(bytes);
                if (read1 != -1) {
                    System.arraycopy(bytes, 0, temps, count, read1);
                    count += read1;
                } else {
                    break;
                }
            }

            System.out.println(new String(temps));

        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fis2, fis1, fis);
        }
    }

    public static void writeChar() {
        File targetFile = StreamUtil.getIoTargetFile("FileDescriptorLearn_writeChar.txt");

        // 按照使用顺序，依次创建
        FileOutputStream fos = null;
        FileWriter fw = null;
        FileWriter fw1 = null;
        try {
            fos = new FileOutputStream(targetFile);
            fw = new FileWriter(fos.getFD());
            fw1 = new FileWriter(targetFile);

            System.out.println(fos.getFD()); // 32
            System.out.println(fw); // 32
            System.out.println(fw1); // 33
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fw1, fw, fos);
        }
    }

    public static void writeByte() {
        File targetFile = StreamUtil.getIoTargetFile("FileDescriptorLearn_writeByte.txt");

        // 按照使用顺序，依次创建
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
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fos2, fos1, fos);
        }
    }

    public static void systemReadWrite() {
        // 按照使用顺序，依次创建
        FileReader fr = null;
        FileWriter fw = null;
        FileWriter fw2 = null;
        try {
            // 控制台输入
            fr = new FileReader(FileDescriptor.in);
            // 控制台输出（白色字体）
            fw = new FileWriter(FileDescriptor.out);
            // 控制台输出异常文本（红色字体）
            fw2 = new FileWriter(FileDescriptor.err);

            char[] chars = new char[1024];
            int len;
            // 换行时，读取
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
                // 字符流，必须 flush或者 close 将流刷出
                fw.flush();
                fw2.write(chars, 0, len);
                // 字符流，必须 flush或者 close 将流刷出
                fw2.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fw2, fw, fr);
        }
    }

    public static void systemInOut() {
        // 按照使用顺序，依次创建
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileOutputStream fos2 = null;
        try {
            // 控制台输入
            fis = new FileInputStream(FileDescriptor.in);
            // 控制台输出（白色字体）
            fos = new FileOutputStream(FileDescriptor.out);
            // 控制台输出异常文本（红色字体）
            fos2 = new FileOutputStream(FileDescriptor.err);

            byte[] bytes = new byte[1024];
            int len;
            // 换行时，读取
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
                fos2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            // 按照创建顺序，倒叙依次关闭
            StreamUtil.close(fos2, fos, fis);
        }
    }
}
