package org.czh.interview.commons.utils;

import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.FlagAssert;

import java.io.File;
import java.io.IOException;

/**
 * @author : czh
 * description :
 * date : 2021-06-01
 * email 916419307@qq.com
 */
public final class FileUtil {

    public static File readFile(@NotBlankTag String path) {
        EmptyAssert.isNotBlank(path);

        File file = new File(path);
        FlagAssert.isTrue(file.exists(), "文件不存在");
        FlagAssert.isTrue(file.isFile(), "路径指向的不是一个文件");
        FlagAssert.isTrue(file.canRead(), "文件不可读");
        return file;
    }

    public static File writeFileAndCreate(@NotBlankTag String path, boolean create) {
        EmptyAssert.isNotBlank(path);

        File file = new File(path);
        if (file.exists()) {
            FlagAssert.isTrue(file.isFile(), "路径指向的不是一个文件");
            FlagAssert.isTrue(file.canWrite(), "文件不可写");
            return file;
        }

        if (!create) {
            return file;
        }
        try {
            FlagAssert.isTrue(file.createNewFile(), "创建文件失败");
            FlagAssert.isTrue(file.canWrite(), "文件不可写");
            return file;
        } catch (IOException e) {
            throw new CommonException("创建文件失败");
        }
    }
}
