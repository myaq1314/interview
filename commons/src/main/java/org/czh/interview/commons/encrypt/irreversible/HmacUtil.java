package org.czh.interview.commons.encrypt.irreversible;

import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.encrypt.EncryptConstant;
import org.czh.interview.commons.encrypt.symmetric.Base64Util;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * date : 2021-06-02
 * email 916419307@qq.com
 */
@SuppressWarnings({"unused", "DuplicatedCode"})
public final class HmacUtil {

    /*
        获取 公钥
     */

    /**
     * gmFd3/krxThqhsuL/4BfBOOEtO2NKibUY1fScMeRIAAuiLoHphZg9Pw3fMUsQHdy9rhP4X3WEC5EShh3p06P5w==
     * 7F/+tIaFwfQigqxM1Ffu3mGG1/iX8OuTw5ttZgxIA87bbHBGLQz106XCzA/NP+fVafne97ktwV3lJktdlxGQ+g==
     */
    public static String getKey() {
        return getKey(getSecretKey());
    }

    public static String getKey(@NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotNull(secretKey);
        return keyArrayToString(secretKey.getEncoded());
    }

    public static SecretKey getSecretKey() {
        try {
            return KeyGenerator.getInstance(EncryptConstant.getHmacMD5()).generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        }
    }

    public static SecretKey getSecretKey(@NotBlankTag String key) {
        return new SecretKeySpec(keyStringToArray(key), EncryptConstant.getHmacMD5());
    }

    /*
        加密
     */

    public static String encodeToString(@NotBlankTag String src, @NotNullTag SecretKey secretKey) {
        return encodeToString(srcStringToArray(src), secretKey);
    }

    public static String encodeToString(@NotEmptyTag byte[] srcBytes, @NotNullTag SecretKey secretKey) {
        return dstArrayToString(encode(srcBytes, secretKey));
    }

    public static byte[] encode(@NotBlankTag String src, @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotBlank(src);
        return encode(srcStringToArray(src), secretKey);
    }

    public static byte[] encode(@NotEmptyTag byte[] srcBytes, @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotEmpty(srcBytes);
        EmptyAssert.isNotNull(secretKey);

        try {
            Mac mac = Mac.getInstance(EncryptConstant.getHmacMD5());
            mac.init(secretKey);
            return mac.doFinal(srcBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        } catch (InvalidKeyException e) {
            throw new CommonException("无效的公钥");
        }
    }

    /*
        校验
     */

    public static boolean verify(@NotBlankTag String src,
                                 @NotBlankTag String dst,
                                 @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encodeToString(src, secretKey), dst);
    }

    public static boolean verify(@NotBlankTag String src,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Arrays.equals(encode(src, secretKey), dstBytes);
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotBlankTag String dst,
                                 @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encodeToString(srcBytes, secretKey), dst);
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag SecretKey secretKey) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Arrays.equals(encode(srcBytes, secretKey), dstBytes);
    }

    /*
        字节数组 与 字符串 互转
     */
    private static byte[] keyStringToArray(@NotBlankTag String key) {
        EmptyAssert.isNotBlank(key);
        return Base64Util.decode(key);
    }

    private static String keyArrayToString(@NotEmptyTag byte[] keyBytes) {
        EmptyAssert.isNotEmpty(keyBytes);
        return Base64Util.encodeToString(keyBytes);
    }

    private static String dstArrayToString(@NotEmptyTag byte[] dstBytes) {
        return new BigInteger(dstBytes).toString(16);
    }

    private static byte[] srcStringToArray(@NotBlankTag String src) {
        return src.getBytes();
    }
}
