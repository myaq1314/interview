package org.czh.interview.commons.encrypt.asymmetric;

import org.czh.interview.commons.encrypt.EncryptConstant;
import org.czh.interview.commons.encrypt.symmetric.Base64Util;
import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

/**
 * @author : czh
 * description :
 * date : 2021-06-08
 * email 916419307@qq.com
 */
public class RSAUtilTest {

    private String src;
    private byte[] srcBytes;
    private Map<String, String> keyStringMap;
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private String publicKeySrc;
    private byte[] publicKeySrcBytes;
    private String privateKeySrc;
    private byte[] privateKeySrcBytes;

    @Before
    public void before() {
        src = "123456";
        srcBytes = src.getBytes();
        this.keyStringMap = RSAUtil.queryKeyStringMap(512);
        this.privateKey = RSAUtil.getPrivateKey(keyStringMap.get(EncryptConstant.getRSAPrivateKey()));
        this.publicKey = RSAUtil.getPublicKey(keyStringMap.get(EncryptConstant.getRSAPublicKey()));
        this.publicKeySrc = RSAUtil.encodeToString(src, this.publicKey);
        this.publicKeySrcBytes = Base64Util.decode(this.publicKeySrc);
        this.privateKeySrc = RSAUtil.encodeToString(src, this.privateKey);
        this.privateKeySrcBytes = Base64Util.decode(this.privateKeySrc);
    }

    @Test
    public void testQueryKeyMap() {
        System.out.println(keyStringMap);

        Map<String, String> keyMap1024 = RSAUtil.queryKeyStringMap(1024);
        System.out.println(keyMap1024);

        Map<String, String> keyMap2048 = RSAUtil.queryKeyStringMap(2048);
        System.out.println(keyMap2048);
    }

    @Test
    public void testGetKey() {
        String privateKeyString = this.keyStringMap.get(EncryptConstant.getRSAPrivateKey());
        System.out.println(privateKeyString);
        String privateKeyString2 = Base64Util.encodeToString(this.privateKey.getEncoded());
        EqualsAssert.isEquals(privateKeyString, privateKeyString2);

        String publicKeyString = this.keyStringMap.get(EncryptConstant.getRSAPublicKey());
        System.out.println(publicKeyString);
        String publicKeyString2 = Base64Util.encodeToString(this.publicKey.getEncoded());
        EqualsAssert.isEquals(publicKeyString, publicKeyString2);
    }

    @Test
    public void testEncodeAndDecode() {
        String dst1 = RSAUtil.encodeToString(this.src, this.privateKey);
        String src1 = RSAUtil.decodeToString(dst1, this.publicKey);
        EqualsAssert.isEquals(this.src, src1);

        String dst2 = RSAUtil.encodeToString(this.src, this.publicKey);
        String src2 = RSAUtil.decodeToString(dst2, this.privateKey);
        EqualsAssert.isEquals(this.src, src2);

        String dst3 = RSAUtil.encodeToString(this.srcBytes, this.privateKey);
        byte[] srcBytes3 = RSAUtil.decode(dst3, this.publicKey);
        EqualsAssert.isEquals(this.srcBytes, srcBytes3);

        String dst4 = RSAUtil.encodeToString(this.srcBytes, this.publicKey);
        byte[] srcBytes4 = RSAUtil.decode(dst4, this.privateKey);
        EqualsAssert.isEquals(this.srcBytes, srcBytes4);

        byte[] dstBytes5 = RSAUtil.encode(this.src, this.privateKey);
        String src5 = RSAUtil.decodeToString(dstBytes5, this.publicKey);
        EqualsAssert.isEquals(this.src, src5);

        byte[] dstBytes6 = RSAUtil.encode(this.src, this.publicKey);
        String src6 = RSAUtil.decodeToString(dstBytes6, this.privateKey);
        EqualsAssert.isEquals(this.src, src6);

        byte[] dstBytes7 = RSAUtil.encode(this.srcBytes, this.privateKey);
        byte[] srcBytes7 = RSAUtil.decode(dstBytes7, this.publicKey);
        EqualsAssert.isEquals(this.srcBytes, srcBytes7);

        byte[] dstBytes8 = RSAUtil.encode(this.srcBytes, this.publicKey);
        byte[] srcBytes8 = RSAUtil.decode(dstBytes8, this.privateKey);
        EqualsAssert.isEquals(this.srcBytes, srcBytes8);
    }

    @Test
    public void testVerify() {
        FlagAssert.isTrue(RSAUtil.verify(this.src, this.privateKeySrc, this.publicKey));
        FlagAssert.isTrue(RSAUtil.verify(this.src, this.publicKeySrc, this.privateKey));
        FlagAssert.isTrue(RSAUtil.verify(this.src, this.privateKeySrcBytes, this.publicKey));
        FlagAssert.isTrue(RSAUtil.verify(this.src, this.publicKeySrcBytes, this.privateKey));
        FlagAssert.isTrue(RSAUtil.verify(this.srcBytes, this.privateKeySrc, this.publicKey));
        FlagAssert.isTrue(RSAUtil.verify(this.srcBytes, this.publicKeySrc, this.privateKey));
        FlagAssert.isTrue(RSAUtil.verify(this.srcBytes, this.privateKeySrcBytes, this.publicKey));
        FlagAssert.isTrue(RSAUtil.verify(this.srcBytes, this.publicKeySrcBytes, this.privateKey));
    }
}
