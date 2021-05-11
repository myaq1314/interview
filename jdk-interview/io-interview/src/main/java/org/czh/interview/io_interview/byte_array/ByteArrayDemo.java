package org.czh.interview.io_interview.byte_array;

import org.czh.interview.io_interview.StreamUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-05-11
 * email 916419307@qq.com
 */
public class ByteArrayDemo {

    public static void main(String[] args) throws IOException {


    }

    private static void readToBaosWriteByteArray() {
        File sourceFile = getSourceFile("Source.txt");
        File targetFile = getTargetFile("readToBaosWriteByteArray.txt");

        FileInputStream fis = null;
        ByteArrayInputStream bais = null;

        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        try {
            fis = new FileInputStream(sourceFile);
            baos = new ByteArrayOutputStream();

            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = fis.read(bytes1)) != -1) {
                baos.write(bytes1, 0, len1);
            }

            fos = new FileOutputStream(targetFile);
            bais = new ByteArrayInputStream(baos.toByteArray());
            baos.flush();

            byte[] bytes2 = new byte[1024 * 10];
            int len2;
            while ((len2 = bais.read(bytes2)) != -1) {
                fos.write(bytes2, 0, len2);
            }
        } catch (IOException e) {
            System.err.printf("IO异常 %s \n", e.getCause());
        } finally {
            StreamUtil.close(baos, fos, bais, fis);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static File getSourceFile(String sourceName) {

        return StreamUtil.getFile(StreamUtil.getIoByteArrayPath(), sourceName, true);
    }

    @SuppressWarnings("SameParameterValue")
    private static File getTargetFile(String targetName) {
        return StreamUtil.getFile(StreamUtil.getIoByteArrayPath(), targetName, false);
    }
}
