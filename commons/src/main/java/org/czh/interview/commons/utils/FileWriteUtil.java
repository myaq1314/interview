package org.czh.interview.commons.utils;

import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-06-01
 * email 916419307@qq.com
 */
public final class FileWriteUtil {

    public static void write(@NotBlankTag String path, boolean append, String context) {
        if (EmptyValidate.isNull(context)) {
            return;
        }

        try (FileWriter fileWriter = new FileWriter(FileUtil.writeFileAndCreate(path, true), append)) {
            fileWriter.write(context);
            fileWriter.flush();
        } catch (IOException e) {
            throw new CommonException("写入文件失败");
        }
    }

    public static void write(@NotNullTag FileWriter fw, String context) throws IOException {
        if (EmptyValidate.isNull(context)) {
            return;
        }

        EmptyAssert.isNotNull(fw);
        fw.write(context);
        fw.flush();
    }
}
