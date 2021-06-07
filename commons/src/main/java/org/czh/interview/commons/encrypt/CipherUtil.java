package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.annotations.tag.MaxTag;
import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;
import org.czh.interview.commons.validate.FlagAssert;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @author : czh
 * description : 对称加密
 * date : 2021-06-07
 * email 916419307@qq.com
 */
public final class CipherUtil {

    public static byte[] doFinalEncode(@NotEmptyTag byte[] contentBytes,
                                       @NotBlankTag String transformation,
                                       @NotNullTag Key key) {
        try {
            return doFinal(contentBytes, transformation, Cipher.ENCRYPT_MODE, key, null);
        } catch (Exception e) {
            throw new CommonException("加密失败");
        }
    }

    public static byte[] doFinalDecode(@NotEmptyTag byte[] contentBytes,
                                       @NotBlankTag String transformation,
                                       @NotNullTag Key key) {
        try {
            return doFinal(contentBytes, transformation, Cipher.DECRYPT_MODE, key, null);
        } catch (Exception e) {
            throw new CommonException("解密失败");
        }
    }

    public static byte[] doFinalEncode(@NotEmptyTag byte[] contentBytes,
                                       @NotBlankTag String transformation,
                                       @NotNullTag Key key,
                                       AlgorithmParameterSpec algParamSpec) {
        try {
            return doFinal(contentBytes, transformation, Cipher.ENCRYPT_MODE, key, algParamSpec);
        } catch (Exception e) {
            throw new CommonException("口令加密失败");
        }
    }

    public static byte[] doFinalDecode(@NotEmptyTag byte[] contentBytes,
                                       @NotBlankTag String transformation,
                                       @NotNullTag Key key,
                                       AlgorithmParameterSpec algParamSpec) {
        try {
            return doFinal(contentBytes, transformation, Cipher.DECRYPT_MODE, key, algParamSpec);
        } catch (Exception e) {
            throw new CommonException("口令解密失败");
        }
    }

    private static byte[] doFinal(@NotEmptyTag byte[] contentBytes,
                                  @NotBlankTag String transformation,
                                  @MinTag(1) @MaxTag(4) int mode,
                                  @NotNullTag Key key,
                                  AlgorithmParameterSpec algParamSpec) throws Exception {
        EmptyAssert.isNotEmpty(contentBytes);
        EmptyAssert.isNotBlank(transformation);
        FlagAssert.isTrue(mode >= 1 && mode <= 4, "Invalid operation mode");
        EmptyAssert.isNotNull(key);

        Cipher cipher = Cipher.getInstance(transformation);
        if (EmptyValidate.isNull(algParamSpec)) {
            cipher.init(mode, key);
        } else {
            cipher.init(mode, key, algParamSpec);
        }
        return cipher.doFinal(contentBytes);
    }
}
