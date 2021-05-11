package org.czh.interview.io_interview.file;

import org.czh.interview.io_interview.StreamUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : czh
 * description :
 * date : 2021-05-11
 * email 916419307@qq.com
 */
@SuppressWarnings("DuplicatedCode")
public class FileStreamDemo {

    public static void main(String[] args) {
        readByFileInputStreamReadByteArray();
        readByBufferedInputStreamReadByteArray();
        readByFileChannelReadByteArray();
        readByInputStreamReaderCharArray();
        readByBufferedReaderReadLine();
        readByDataInputStream();
        readByReaderReadCharArray();
    }

    private static void readByReaderReadCharArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByReaderReadCharArray.txt");

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(sourceFile);
            fw = new FileWriter(targetFile);


            char[] chars = new char[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
                fw.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fr, fw);
        }
    }

    private static void readByDataInputStream() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByDataInputStream.txt");

        FileInputStream fis = null;
        DataInputStream dis = null;

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fis = new FileInputStream(sourceFile);
            dis = new DataInputStream(fis);

            fos = new FileOutputStream(targetFile);
            dos = new DataOutputStream(fos);

            byte[] bytes = new byte[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = dis.read(bytes)) != -1) {
                dos.write(bytes, 0, len);
                dos.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(dos, fos, dis, fis);
        }
    }

    private static void readByBufferedReaderReadLine() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByBufferedReaderReadLine.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            fos = new FileOutputStream(targetFile);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            String line;
            int index = 0;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line).append("\n");
                index++;
                if (index >= StreamUtil.getByteArrayLength(sourceFile.length() / 32)) {
                    bw.write(builder.toString());
                    bw.flush();
                    index = 0;
                    builder = new StringBuilder();
                }
            }
            bw.write(builder.toString());
            bw.flush();
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(bw, osw, fos, br, isr, fis);
        }
    }


    private static void readByInputStreamReaderCharArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByInputStreamReaderCharArray.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(sourceFile);
            isr = new InputStreamReader(fis);

            fos = new FileOutputStream(targetFile);
            osw = new OutputStreamWriter(fos);

            char[] chars = new char[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = isr.read(chars)) != -1) {
                osw.write(chars, 0, len);
                osw.flush();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(osw, fos, isr, fis);
        }
    }

    private static void readByFileChannelReadByteArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByFileChannelReadByteArray.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            FileChannel fic = fis.getChannel();

            fos = new FileOutputStream(targetFile);
            FileChannel foc = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(StreamUtil.getByteArrayLength(sourceFile.length()));
            while (fic.read(buffer) != -1) {
                buffer.flip();
                foc.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(fos, fis);
        }
    }

    private static void readByBufferedInputStreamReadByteArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByBufferedInputStreamReadByteArray.txt");

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(sourceFile);
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(targetFile);
            bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[StreamUtil.getByteArrayLength(sourceFile.length())];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(bos, fos, bis, fis);
        }
    }

    private static void readByFileInputStreamReadByteArray() {
        File sourceFile = StreamUtil.getIoSourceFile("Source.txt");
        File targetFile = StreamUtil.getIoTargetFile("readByFileInputStreamReadByteArray.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);

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
}
