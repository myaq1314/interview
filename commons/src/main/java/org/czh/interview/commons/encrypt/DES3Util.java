package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : czh
 * description : 3DES 即3重DES，使用频率低，效率低
 * date : 2021-06-05
 * email 916419307@qq.com
 */
@SuppressWarnings({"unused", "DuplicatedCode"})
public final class DES3Util {

    public static void main(String[] args) {
        String key = SecretKeyUtil.matchReadByLast(EncryptConstant.getDES3());
        if (key == null) {
            key = getKey(getSecretKey());
            SecretKeyUtil.writeKey(EncryptConstant.getDES3(), key);
        }
        System.out.println(key); // GRMgdcETHBWYjwvxyP5kq1fqAvFF+9nZ
        SecretKey secretKey = getSecretKey(key);

        String src = "123456";
        System.out.println(src); // 123456

        String dst = encodeToString(src, secretKey);
        String dst2 = encodeToString(src, secretKey);
        System.out.println(dst); // YvgtC3p2krw=
        FlagAssert.isTrue(verify(src, dst, secretKey));
        EqualsAssert.isEquals(dst, dst2);

        String src2 = decodeToString(dst, secretKey);
        String src3 = decodeToString(dst, secretKey);
        System.out.println(src2); // 123456
        EqualsAssert.isEquals(src, src2);
        EqualsAssert.isEquals(src2, src3);
    }

    /*
        获取公钥
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
            SecretKey secretKey = KeyGenerator.getInstance(EncryptConstant.getDES3()).generateKey();
            SecretKeyFactory factory = SecretKeyFactory.getInstance(EncryptConstant.getDES3());
            return factory.generateSecret(new DESedeKeySpec(secretKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            throw new CommonException("未知的加密方式");
        } catch (InvalidKeyException | InvalidKeySpecException e) {
            throw new CommonException("无效的公钥");
        }
    }

    public static SecretKey getSecretKey(@NotBlankTag String key) {
        byte[] keyBytes = keyStringToArray(key);
        return new SecretKeySpec(keyBytes, EncryptConstant.getDES3());
    }

    /*
        加密
     */

    public static String encodeToString(@NotBlankTag String src, @NotNullTag SecretKey secretKey) {
        return dstArrayToString(encode(src, secretKey));
    }

    public static String encodeToString(@NotEmptyTag byte[] srcBytes, @NotNullTag SecretKey secretKey) {
        return dstArrayToString(encode(srcBytes, secretKey));
    }

    public static byte[] encode(@NotBlankTag String src, @NotNullTag SecretKey secretKey) {
        return encode(srcStringToArray(src), secretKey);
    }

    public static byte[] encode(@NotEmptyTag byte[] srcBytes, @NotNullTag SecretKey key) {
        return CipherUtil.doFinalEncode(srcBytes, EncryptConstant.getDES3Cipher(), key);
    }

    /*
        解密
     */

    public static String decodeToString(@NotBlankTag String dst, @NotNullTag SecretKey secretKey) {
        return decodeToString(dstStringToArray(dst), secretKey);
    }

    public static String decodeToString(@NotEmptyTag byte[] dstBytes, @NotNullTag SecretKey secretKey) {
        return srcArrayToString(decode(dstBytes, secretKey));
    }

    public static byte[] decode(@NotBlankTag String dst, @NotNullTag SecretKey secretKey) {
        return decode(dstStringToArray(dst), secretKey);
    }

    public static byte[] decode(@NotEmptyTag byte[] dstBytes, @NotNullTag SecretKey secretKey) {
        return CipherUtil.doFinalDecode(dstBytes, EncryptConstant.getDES3Cipher(), secretKey);
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

    private static byte[] srcStringToArray(@NotBlankTag String src) {
        EmptyAssert.isNotBlank(src);
        return src.getBytes();
    }

    private static String srcArrayToString(@NotEmptyTag byte[] srcBytes) {
        EmptyAssert.isNotEmpty(srcBytes);
        return new String(srcBytes);
    }

    private static byte[] dstStringToArray(@NotBlankTag String dst) {
        EmptyAssert.isNotBlank(dst);
        return Base64Util.decode(dst);
    }

    private static String dstArrayToString(@NotEmptyTag byte[] dstBytes) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Base64Util.encodeToString(dstBytes);
    }
}
