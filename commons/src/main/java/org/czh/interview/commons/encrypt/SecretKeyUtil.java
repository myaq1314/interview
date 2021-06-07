package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.convertor.date.DateConvertor;
import org.czh.interview.commons.utils.FileReadUtil;
import org.czh.interview.commons.utils.FileWriteUtil;

import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-06-05
 * email 916419307@qq.com
 */
public final class SecretKeyUtil {

    private static final String keyFilePath = "./commons/src/main/resources/salt.txt";

    public static void writeKey(String title, String key) {
        StringBuilder builder = new StringBuilder(DateConvertor.convertToText(new Date(), DateConstant.DATETIME_STANDARD_MILLIS()));
        builder.append("\t\t");
        int count = title.length() / 4;
        if (title.length() % 4 != 0) {
            count += 1;
        }
        builder.append(title);
        for (int i = 0; i < 6 - count; i++) {
            builder.append("\t");
        }
        builder.append(key);
        builder.append("\n");
        FileWriteUtil.write(keyFilePath, true, builder.toString());
    }

    public static String readLastKey() {
        String lastLine = FileReadUtil.readLastLine(keyFilePath);
        return lastLine.substring(lastLine.lastIndexOf("\t") + "\t".length()).trim();
    }

    public static String matchReadByLast(String match) {
        String lastLine = FileReadUtil.matchReadByLast(keyFilePath, "\t" + match + "\t");
        if (lastLine == null) {
            return null;
        }
        return lastLine.substring(lastLine.lastIndexOf("\t") + "\t".length()).trim();
    }
}
