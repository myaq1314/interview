package org.czh.interview.commons.encrypt.irreversible;

import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;
import org.junit.Test;

import javax.crypto.SecretKey;

/**
 * @author : czh
 * description :
 * date : 2021-06-08
 * email 916419307@qq.com
 */
public class HmacUtilTest {

    @Test
    public void test() {
        String key = HmacUtil.getKey(HmacUtil.getSecretKey());
        System.out.println(key); // qRSubWiifx9/q/HQffdOGE1jljRe/1BbkEdxEZYOztucPApL1dswCDArlaLo2K5hQg5L3P++iq9W37ekimsYCQ==
        SecretKey secretKey = HmacUtil.getSecretKey(key);

        String src = "123456";
        System.out.println(src); // 123456

        String dst = HmacUtil.encodeToString(src, secretKey);
        String dst2 = HmacUtil.encodeToString(src, secretKey);
        System.out.println(dst); // 1b589c3a31995afd8aa74d21cfa6287e
        FlagAssert.isTrue(HmacUtil.verify(src, dst, secretKey));
        EqualsAssert.isEquals(dst, dst2);
    }

}
