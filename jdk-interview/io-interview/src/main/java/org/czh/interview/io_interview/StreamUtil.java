package org.czh.interview.io_interview;

import org.czh.interview.commons.validate.EmptyValidate;
import org.czh.interview.commons.validate.FlagAssert;

import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-05-10
 * email 916419307@qq.com
 */
public class StreamUtil {

    public static FileOutputStream outputStream = new FileOutputStream(FileDescriptor.out);
    public static FileWriter writer = new FileWriter(FileDescriptor.out);

    public static File getIoSourceArray(String sourceName) {

        return StreamUtil.getFile(getIoArrayPath(), sourceName, true);
    }

    public static File getIoTargetArray(String targetName) {
        return StreamUtil.getFile(getIoArrayPath(), targetName, false);
    }

    public static File getIoSourceFile(String sourceName) {

        return StreamUtil.getFile(getIoFilePath(), sourceName, true);
    }

    public static File getIoTargetFile(String targetName) {
        return StreamUtil.getFile(getIoFilePath(), targetName, false);
    }

    public static String getIoFilePath() {
        return "jdk-interview/io-interview/src/main/java/org/czh/interview/io_interview/file/txt";
    }

    public static String getIoArrayPath() {
        return "jdk-interview/io-interview/src/main/java/org/czh/interview/io_interview/array/txt";
    }

    public static File getFile(String path, String fileName, boolean exists) {
        File file = new File(path + File.separator + fileName);
        if (exists || file.exists()) {
            FlagAssert.isTrue(file.exists() && file.isFile());
        } else {
            try {
                boolean newFlag = file.createNewFile();
                FlagAssert.isTrue(newFlag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static int getByteArrayLength(long length) {
        if (length <= 1024) {
            return 1024;
        } else if (length <= 1024 * 1024) {
            return 4 * 1024;
        } else if (length <= 256 * 1024 * 1024) {
            return 16 * 1024;
        } else if (length <= 1024 * 1024 * 1024) {
            return 64 * 1024;
        } else {
            return 1024 * 1024;
        }
    }

    public static void close(Closeable... closeables) {
        if (EmptyValidate.isEmpty(closeables)) {
            return;
        }

        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
