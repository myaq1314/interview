package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.annotations.tag.MaxTag;
import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.FlagAssert;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @author : czh
 * description :
 * date : 2021-06-04
 * email 916419307@qq.com
 */
public final class EncryptUtil {

    public static MessageDigest getMD5() {
        return getMessageDigest(EncryptConstant.getMD5());
    }

    public static MessageDigest getSHA(@NotNullTag EncryptConstant.SHAType shaType) {
        EmptyAssert.isNotNull(shaType);
        return getMessageDigest(shaType.key);
    }

    public static MessageDigest getMessageDigest(@NotBlankTag String algorithm) {
        EmptyAssert.isNotBlank(algorithm);

        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        }
    }

    public static Mac getHmacMD5(@NotNullTag Key key) {
        EmptyAssert.isNotNull(key);

        Mac mac = getMac(key.getAlgorithm());
        try {
            mac.init(key);
        } catch (InvalidKeyException e) {
            throw new CommonException("无效的公钥");
        }
        return mac;
    }

    public static Mac getMac(@NotBlankTag String algorithm) {
        EmptyAssert.isNotBlank(algorithm);

        try {
            return Mac.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        }
    }

    public static Cipher getDESCipher(@MinTag(1) @MaxTag(4) int mode, @NotNullTag Key key) {
        return getCipher(EncryptConstant.getDESCipher(), mode, key);
    }

    public static Cipher getDES3Cipher(@MinTag(1) @MaxTag(4) int mode, @NotNullTag Key key) {
        return getCipher(EncryptConstant.getDES3Cipher(), mode, key);
    }

    public static Cipher getAESCipher(@MinTag(1) @MaxTag(4) int mode, @NotNullTag Key key) {
        return getCipher(EncryptConstant.getAESCipher(), mode, key);
    }

    public static Cipher getCipher(@NotBlankTag String transformation,
                                   @MinTag(1) @MaxTag(4) int mode,
                                   @NotNullTag Key key) {
        EmptyAssert.isNotBlank(transformation);
        FlagAssert.isTrue(mode >= 1 && mode <= 4, "Invalid operation mode");
        EmptyAssert.isNotNull(key);

        try {
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(mode, key);
            return cipher;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new CommonException("未知的编码方式");
        } catch (InvalidKeyException e) {
            throw new CommonException("无效的公钥");
        }
    }

    public static Cipher getPBECipher(@MinTag(1) @MaxTag(4) int mode,
                                      @NotNullTag Key key,
                                      @NotNullTag AlgorithmParameterSpec algParamSpec) {
        return getCipher(EncryptConstant.getPBECipher(), mode, key, algParamSpec);
    }

    public static Cipher getCipher(@NotBlankTag String transformation,
                                   @MinTag(1) @MaxTag(4) int mode,
                                   @NotNullTag Key key,
                                   @NotNullTag AlgorithmParameterSpec algParamSpec) {
        EmptyAssert.isNotBlank(transformation);
        FlagAssert.isTrue(mode >= 1 && mode <= 4, "Invalid operation mode");
        EmptyAssert.isNotNull(key);
        EmptyAssert.isNotNull(algParamSpec);

        try {
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(mode, key, algParamSpec);
            return cipher;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new CommonException("未知的编码方式");
        } catch (InvalidKeyException e) {
            throw new CommonException("无效的公钥");
        } catch (InvalidAlgorithmParameterException e) {
            throw new CommonException("无效的盐");
        }
    }
}
