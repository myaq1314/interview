package org.czh.interview.commons.encrypt.asymmetric;

import org.apache.commons.collections4.map.HashedMap;
import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.encrypt.CipherUtil;
import org.czh.interview.commons.encrypt.EncryptConstant;
import org.czh.interview.commons.encrypt.symmetric.Base64Util;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.FlagAssert;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * 公钥加密，私钥解密；或者是 私钥加密，公钥解密
 * 不能自己加密，自己解密
 * 即不能公钥加密，公钥解密
 * 也不能私钥加密，私钥解密
 * date : 2021-06-07
 * email 916419307@qq.com
 */
public final class RSAUtil {

    /**
     * 获取公钥、私钥
     *
     * @param keySize 密钥长度，必须是64的倍数，范围在512到65536之间，默认 1024
     * @return RSAPrivateKey 私钥Key；RSAPublicKey 公钥Key
     */
    public static Map<String, String> queryKeyMap(@MinTag(1) int keySize) {
        FlagAssert.isTrue(keySize > 0);

        Map<String, String> keyMap = new HashedMap<>(2);

        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptConstant.getRSA());
            keyPairGenerator.initialize(keySize);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CommonException("未知的加密方式");
        }
        keyMap.put(EncryptConstant.getRSAPrivateKey(), keyArrayToString(keyPair.getPrivate().getEncoded()));
        keyMap.put(EncryptConstant.getRSAPublicKey(), keyArrayToString(keyPair.getPublic().getEncoded()));

        return keyMap;
    }

    public static PrivateKey getPrivateKey(@NotBlankTag String privateKeyString) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.getRSA());
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyStringToArray(privateKeyString));
            return keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new CommonException("未知的加密方式");
        } catch (InvalidKeySpecException e) {
            throw new CommonException("无效的私钥");
        }
    }

    public static PublicKey getPublicKey(@NotBlankTag String publicKeyString) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(EncryptConstant.getRSA());
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyStringToArray(publicKeyString));
            return keyFactory.generatePublic(x509KeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new CommonException("未知的加密方式");
        } catch (InvalidKeySpecException e) {
            throw new CommonException("无效的公钥");
        }
    }

    /*
        加密
     */

    public static String encodeToString(@NotBlankTag String src, @NotNullTag Key key) {
        return encodeToString(srcStringToArray(src), key);
    }

    public static String encodeToString(@NotEmptyTag byte[] srcBytes, @NotNullTag Key key) {
        return dstArrayToString(encode(srcBytes, key));
    }

    public static byte[] encode(@NotBlankTag String src, @NotNullTag Key key) {
        return encode(srcStringToArray(src), key);
    }

    public static byte[] encode(@NotEmptyTag byte[] srcBytes, @NotNullTag Key key) {
        return CipherUtil.doFinalEncode(srcBytes, EncryptConstant.getRSACipher(), key);
    }

    /*
        解密
     */

    public static String decodeToString(@NotBlankTag String dst, @NotNullTag Key key) {
        return decodeToString(dstStringToArray(dst), key);
    }

    public static String decodeToString(@NotEmptyTag byte[] dstBytes, @NotNullTag Key key) {
        return srcArrayToString(decode(dstBytes, key));
    }

    public static byte[] decode(@NotBlankTag String dst, @NotNullTag Key key) {
        return decode(dstStringToArray(dst), key);
    }

    public static byte[] decode(@NotEmptyTag byte[] dstBytes, @NotNullTag Key key) {
        return CipherUtil.doFinalDecode(dstBytes, EncryptConstant.getRSACipher(), key);
    }

    /*
        校验
     */
    public static boolean verify(@NotBlankTag String src,
                                 @NotBlankTag String dst,
                                 @NotNullTag Key key) {
        EmptyAssert.isNotBlank(src);
        return Objects.equals(src, decodeToString(dst, key));
    }

    public static boolean verify(@NotBlankTag String src,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag Key key) {
        EmptyAssert.isNotBlank(src);
        return Objects.equals(src, decodeToString(dstBytes, key));
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotBlankTag String dst,
                                 @NotNullTag Key key) {
        EmptyAssert.isNotEmpty(srcBytes);
        return Arrays.equals(srcBytes, decode(dst, key));
    }

    public static boolean verify(@NotEmptyTag byte[] srcBytes,
                                 @NotEmptyTag byte[] dstBytes,
                                 @NotNullTag Key key) {
        EmptyAssert.isNotEmpty(srcBytes);
        return Arrays.equals(srcBytes, decode(dstBytes, key));
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
