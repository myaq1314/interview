package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * date : 2021-06-05
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class PBEEncrypt {

    public static void main(String[] args) {
        String password = "password";
        Key key = getKey(password);

        String saltString = getSaltString();
        EncryptKeyUtil.writeKey(EncryptConstant.getPBE(), saltString);

        String saltString2 = EncryptKeyUtil.readLastKey();
        System.out.println(saltString2); // 4xT6HDtDSjM=
        AlgorithmParameterSpec algParamSpec = getAlgParamSpec(saltString2);

        String src = "123456";
        System.out.println(src); // 123456

        String dst = encodeToString(src, key, algParamSpec);
        String dst2 = encodeToString(src, key, algParamSpec);
        System.out.println(dst); // sM3bYV6JutM=
        FlagAssert.isTrue(verify(src, dst, key, algParamSpec));
        EqualsAssert.isEquals(dst, dst2);

        String src2 = decodeToString(dst, key, algParamSpec);
        String src3 = decodeToString(dst, key, algParamSpec);
        System.out.println(src); // 123456
        EqualsAssert.isEquals(src, src2);
        EqualsAssert.isEquals(src2, src3);
    }

    /*
        获取盐
     */
    public static String getSaltString() {
        return getSaltString(getSaltArray());
    }

    public static String getSaltString(@NotEmptyTag byte[] saltBytes) {
        EmptyAssert.isNotEmpty(saltBytes);
        return Base64Encrypt.encodeToString(saltBytes);
    }

    public static byte[] getSaltArray() {
        SecureRandom random = new SecureRandom();
        return random.generateSeed(8);
    }

    public static byte[] getSaltArray(@NotBlankTag String saltString) {
        EmptyAssert.isNotBlank(saltString);
        return Base64Encrypt.decode(saltString);
    }

    public static AlgorithmParameterSpec getAlgParamSpec() {
        return getAlgParamSpec(getSaltArray());
    }

    public static AlgorithmParameterSpec getAlgParamSpec(@NotBlankTag String saltString) {
        return getAlgParamSpec(getSaltArray(saltString));
    }

    public static AlgorithmParameterSpec getAlgParamSpec(@NotEmptyTag byte[] saltBytes) {
        EmptyAssert.isNotEmpty(saltBytes);
        return new PBEParameterSpec(saltBytes, 100);
    }

    /*
        使用口令，获取 公钥
     */

    public static Key getKey(@NotBlankTag String password) {
        EmptyAssert.isNotBlank(password);

        try {
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance(EncryptConstant.getPBECipher());
            return factory.generateSecret(pbeKeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new CommonException("未知的编码方式");
        } catch (InvalidKeySpecException e) {
            throw new CommonException("无效的公钥");
        }
    }

    /*
        加密
     */

    public static String encodeToString(@NotBlankTag String src,
                                        @NotNullTag Key key,
                                        @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return dstArrayToString(encode(src, key, algParamSpec));
    }

    public static String encodeToString(@NotEmptyTag byte[] srcBytes,
                                        @NotNullTag Key key,
                                        @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return dstArrayToString(encode(srcBytes, key, algParamSpec));
    }

    public static byte[] encode(@NotBlankTag String src,
                                @NotNullTag Key key,
                                @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return encode(srcStringToArray(src), key, algParamSpec);
    }

    public static byte[] encode(@NotEmptyTag byte[] srcBytes,
                                @NotNullTag Key key,
                                @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotEmpty(srcBytes);

        try {
            Cipher cipher = EncryptUtil.getPBECipher(Cipher.ENCRYPT_MODE, key, algParamSpec);
            return cipher.doFinal(srcBytes);
        } catch (BadPaddingException e) {
            throw new CommonException("未知的编码方式");
        } catch (IllegalBlockSizeException e) {
            throw new CommonException("无效的源字符串");
        }
    }

    /*
        解密
     */

    public static String decodeToString(@NotBlankTag String dst,
                                        @NotNullTag Key key,
                                        @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return decodeToString(dstStringToArray(dst), key, algParamSpec);
    }

    public static String decodeToString(@NotEmptyTag byte[] dstBytes,
                                        @NotNullTag Key key,
                                        @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return srcArrayToString(decode(dstBytes, key, algParamSpec));
    }

    public static byte[] decode(@NotBlankTag String dst,
                                @NotNullTag Key key,
                                @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return decode(dstStringToArray(dst), key, algParamSpec);
    }

    public static byte[] decode(@NotEmptyTag byte[] dstBytes,
                                @NotNullTag Key key,
                                @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotEmpty(dstBytes);

        try {
            Cipher cipher = EncryptUtil.getPBECipher(Cipher.DECRYPT_MODE, key, algParamSpec);
            return cipher.doFinal(dstBytes);
        } catch (BadPaddingException e) {
            throw new CommonException("未知的编码方式");
        } catch (IllegalBlockSizeException e) {
            throw new CommonException("无效的源字符串");
        }
    }

    /*
        校验
     */
    public static boolean verify(@NotBlankTag String src,
                                 @NotBlankTag String dst,
                                 @NotNullTag Key key,
                                 @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encodeToString(src, key, algParamSpec), dst);
    }

    public static boolean verify(@NotBlankTag String src,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag Key key,
                                 @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Arrays.equals(encode(src, key, algParamSpec), dstBytes);
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotBlankTag String dst,
                                 @NotNullTag Key key,
                                 @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encodeToString(srcBytes, key, algParamSpec), dst);
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag Key key,
                                 @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Arrays.equals(encode(srcBytes, key, algParamSpec), dstBytes);
    }

    /*
        字节数组 与 字符串 互转
     */

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
        return Base64Encrypt.decode(dst);
    }

    private static String dstArrayToString(@NotEmptyTag byte[] dstBytes) {
        EmptyAssert.isNotEmpty(dstBytes);
        return Base64Encrypt.encodeToString(dstBytes);
    }
}
