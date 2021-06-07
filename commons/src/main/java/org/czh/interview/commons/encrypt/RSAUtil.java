package org.czh.interview.commons.encrypt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.HashedMap;
import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
import org.czh.interview.commons.convertor.MapConvertor;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EqualsAssert;
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

    public static void main(String[] args) {
        String keys = SecretKeyUtil.matchReadByLast(EncryptConstant.getRSA());
        String publicKeyString;
        String privateKeyString;
        if (keys != null) {
            JSONObject jsonObject = JSON.parseObject(keys);
            publicKeyString = jsonObject.getString(EncryptConstant.getRSAPublicKey());
            privateKeyString = jsonObject.getString(EncryptConstant.getRSAPrivateKey());
        } else {
            Map<String, String> keyMap = queryKeyStringMap(512);
            SecretKeyUtil.writeKey(EncryptConstant.getRSA(), MapConvertor.convertToJsonString(keyMap));
            publicKeyString = keyMap.get(EncryptConstant.getRSAPublicKey());
            privateKeyString = keyMap.get(EncryptConstant.getRSAPrivateKey());
        }
        System.out.println(publicKeyString); // MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKAUgLufFBpHXoDwDgsbtY3B7ICdmH6w7kDZBpe+7jbwWvtxP3V71pFY8bKb5i+/G5HsNLgsY7EQJ1uYLmqlc3kCAwEAAQ==
        System.out.println(privateKeyString); // MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAoBSAu58UGkdegPAOCxu1jcHsgJ2YfrDuQNkGl77uNvBa+3E/dXvWkVjxspvmL78bkew0uCxjsRAnW5guaqVzeQIDAQABAkAjWWO0CsTdqLTttBTlzxCgZRpcrHBoSZnTKBmUmMzxxHaW4KlpwDlmD1y34Y3z/R6O1E4PRTUiHeR/2bR8PUwBAiEA97lBw0zP2Ry41+pCTbedNfy/wExuf6T9cVZ65j5ebrECIQClbaTLpb3oHgFFqmEiWRYbJZwF+ef7+Z9mq5E/SzzTSQIhAOuOX3hEXAgJhcLaYL3h8T3a3sMOaqw5yT2yjB7QA5+hAiBtUgi+X3ghJXr3u8FW/oJCTFdQB7cLaAmzwptItYKrqQIhAOqzhZ/4Bi4IZgD5bJPZhvq1iD4JEVbXsa4r6qBjyJNi
        PublicKey publicKey = getPublicKey(publicKeyString);
        PrivateKey privateKey = getPrivateKey(privateKeyString);

        String src = "123456";
        System.out.println(src); // 123456

        /*
            公钥加密，私钥解密
            公钥加密，每次密文都不一样
         */
        String dst1 = encodeToString(src, publicKey);
        System.out.println(dst1); // fONmPyqYkGjr1mtdXHk0oznHP+K4IlT7u6k83QV0v/XsDg876uBLSO+L4NA2QYGIH8chIaFtAY1WJ5mUoL3b/w==
        // 公钥加密，此处只能使用私钥解密
        String src1 = decodeToString(dst1, privateKey);
        EqualsAssert.isEquals(src, src1);
        FlagAssert.isTrue(verify(src1, dst1, privateKey));

        String dst2 = encodeToString(src, publicKey);
        System.out.println(dst2); // YpBgzX5ok+xW9lL3guEVgeIIiYWBM6Joz3W1NxHqAM46HUAodezs3YIgp53sblSJvAv4XvQUShWZ5jEUxZxnTQ==
        // 公钥加密，此处只能使用私钥解密
        String src2 = decodeToString(dst2, privateKey);
        EqualsAssert.isEquals(src, src2);
        FlagAssert.isTrue(verify(src2, dst2, privateKey));

        /*
            私钥加密，公钥解密
            私钥加密，每次密文都一样
         */
        String dst3 = encodeToString(src, privateKey);
        System.out.println(dst3); // KSXXh+AqHO9x3kalnQea0DBxi/d5W5Cb864UN1FD3WvIWvi4QLKA07Txg7bhxt+/VHRtlds4S6sme30PhfzvBQ==
        // 私钥加密，此处只能使用公钥解密
        String src3 = decodeToString(dst3, publicKey);
        EqualsAssert.isEquals(src, src3);
        FlagAssert.isTrue(verify(src3, dst3, publicKey));

        String dst4 = encodeToString(src, privateKey);
        System.out.println(dst4); // KSXXh+AqHO9x3kalnQea0DBxi/d5W5Cb864UN1FD3WvIWvi4QLKA07Txg7bhxt+/VHRtlds4S6sme30PhfzvBQ==
        // 私钥加密，此处只能使用公钥解密
        String src4 = decodeToString(dst4, publicKey);
        EqualsAssert.isEquals(src, src4);
        FlagAssert.isTrue(verify(src4, dst4, publicKey));
    }

    /*
        获取 公钥、私钥
     */

    public static Map<String, String> queryKeyStringMap() {
        return queryKeyStringMap(1024);
    }

    public static Map<String, String> queryKeyStringMap(@MinTag(1) int keySize) {
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
