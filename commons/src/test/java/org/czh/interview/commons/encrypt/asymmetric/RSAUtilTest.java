package org.czh.interview.commons.encrypt.asymmetric;

import org.czh.interview.commons.encrypt.EncryptConstant;
import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;
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

    @Test
    public void testQueryKeyMap() {
        try {
            Map<String, String> keyMap256 = RSAUtil.queryKeyMap(256);
            System.out.println(keyMap256);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> keyMap512 = RSAUtil.queryKeyMap(512);
        System.out.println(keyMap512);

        Map<String, String> keyMap1024 = RSAUtil.queryKeyMap(1024);
        System.out.println(keyMap1024);

        Map<String, String> keyMap2048 = RSAUtil.queryKeyMap(2048);
        System.out.println(keyMap2048);

        Map<String, String> keyMap4096 = RSAUtil.queryKeyMap(4096);
        System.out.println(keyMap4096);

        Map<String, String> keyMap8192 = RSAUtil.queryKeyMap(8192);
        System.out.println(keyMap8192);

        Map<String, String> keyMap16384 = RSAUtil.queryKeyMap(16384);
        System.out.println(keyMap16384);

        Map<String, String> keyMap32768 = RSAUtil.queryKeyMap(32768);
        System.out.println(keyMap32768);

        Map<String, String> keyMap65536 = RSAUtil.queryKeyMap(65536);
        System.out.println(keyMap65536);

        try {
            Map<String, String> keyMap131072 = RSAUtil.queryKeyMap(131072);
            System.out.println(keyMap131072);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        Map<String, String> keyMap = RSAUtil.queryKeyMap(512);
        String publicKeyString = keyMap.get(EncryptConstant.getRSAPublicKey());
        String privateKeyString = keyMap.get(EncryptConstant.getRSAPrivateKey());
        System.out.println(publicKeyString); // MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKAUgLufFBpHXoDwDgsbtY3B7ICdmH6w7kDZBpe+7jbwWvtxP3V71pFY8bKb5i+/G5HsNLgsY7EQJ1uYLmqlc3kCAwEAAQ==
        System.out.println(privateKeyString); // MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAoBSAu58UGkdegPAOCxu1jcHsgJ2YfrDuQNkGl77uNvBa+3E/dXvWkVjxspvmL78bkew0uCxjsRAnW5guaqVzeQIDAQABAkAjWWO0CsTdqLTttBTlzxCgZRpcrHBoSZnTKBmUmMzxxHaW4KlpwDlmD1y34Y3z/R6O1E4PRTUiHeR/2bR8PUwBAiEA97lBw0zP2Ry41+pCTbedNfy/wExuf6T9cVZ65j5ebrECIQClbaTLpb3oHgFFqmEiWRYbJZwF+ef7+Z9mq5E/SzzTSQIhAOuOX3hEXAgJhcLaYL3h8T3a3sMOaqw5yT2yjB7QA5+hAiBtUgi+X3ghJXr3u8FW/oJCTFdQB7cLaAmzwptItYKrqQIhAOqzhZ/4Bi4IZgD5bJPZhvq1iD4JEVbXsa4r6qBjyJNi
        PublicKey publicKey = RSAUtil.getPublicKey(publicKeyString);
        PrivateKey privateKey = RSAUtil.getPrivateKey(privateKeyString);

        String src = "123456";
        System.out.println(src); // 123456

        /*
            公钥加密，私钥解密
            公钥加密，每次密文都不一样
         */
        String dst1 = RSAUtil.encodeToString(src, publicKey);
        System.out.println(dst1); // fONmPyqYkGjr1mtdXHk0oznHP+K4IlT7u6k83QV0v/XsDg876uBLSO+L4NA2QYGIH8chIaFtAY1WJ5mUoL3b/w==
        // 公钥加密，此处只能使用私钥解密
        String src1 = RSAUtil.decodeToString(dst1, privateKey);
        EqualsAssert.isEquals(src, src1);
        FlagAssert.isTrue(RSAUtil.verify(src1, dst1, privateKey));

        String dst2 = RSAUtil.encodeToString(src, publicKey);
        System.out.println(dst2); // YpBgzX5ok+xW9lL3guEVgeIIiYWBM6Joz3W1NxHqAM46HUAodezs3YIgp53sblSJvAv4XvQUShWZ5jEUxZxnTQ==
        // 公钥加密，此处只能使用私钥解密
        String src2 = RSAUtil.decodeToString(dst2, privateKey);
        EqualsAssert.isEquals(src, src2);
        FlagAssert.isTrue(RSAUtil.verify(src2, dst2, privateKey));

        /*
            私钥加密，公钥解密
            私钥加密，每次密文都一样
         */
        String dst3 = RSAUtil.encodeToString(src, privateKey);
        System.out.println(dst3); // KSXXh+AqHO9x3kalnQea0DBxi/d5W5Cb864UN1FD3WvIWvi4QLKA07Txg7bhxt+/VHRtlds4S6sme30PhfzvBQ==
        // 私钥加密，此处只能使用公钥解密
        String src3 = RSAUtil.decodeToString(dst3, publicKey);
        EqualsAssert.isEquals(src, src3);
        FlagAssert.isTrue(RSAUtil.verify(src3, dst3, publicKey));

        String dst4 = RSAUtil.encodeToString(src, privateKey);
        System.out.println(dst4); // KSXXh+AqHO9x3kalnQea0DBxi/d5W5Cb864UN1FD3WvIWvi4QLKA07Txg7bhxt+/VHRtlds4S6sme30PhfzvBQ==
        // 私钥加密，此处只能使用公钥解密
        String src4 = RSAUtil.decodeToString(dst4, publicKey);
        EqualsAssert.isEquals(src, src4);
        FlagAssert.isTrue(RSAUtil.verify(src4, dst4, publicKey));
    }

}
