package org.czh.interview.commons.encrypt;

import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.utils.RandomUtil;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EqualsAssert;
import org.czh.interview.commons.validate.FlagAssert;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author : czh
 * description :
 * date : 2021-05-29
 * email 916419307@qq.com
 */
@SuppressWarnings({"unused"})
public final class MD5Util {

    public static void main(String[] args) {
        String salt = SecretKeyUtil.matchReadByLast(EncryptConstant.getMD5());
        if (salt == null) {
            salt = getSalt(16);
            SecretKeyUtil.writeKey(EncryptConstant.getMD5(), salt);
        }
        System.out.println(salt); // f2f3b657310a4e30 16位

        String src = "123456";
        System.out.println(src); // 123456

        String dst32 = encode32(src, salt);
        String dst322 = encode32(src, salt);
        System.out.println(dst32); // 2a54aaaf9d6a56f14bcb9a08e84ee7be
        FlagAssert.isTrue(verify32(src, dst32, salt));
        EqualsAssert.isEquals(dst32, dst322);

        String dst16 = encode16(src, salt);
        String dst162 = encode16(src, salt);
        System.out.println(dst16); // 9d6a56f14bcb9a08
        FlagAssert.isTrue(verify16(src, dst16, salt));
        EqualsAssert.isEquals(dst16, dst162);
    }

    /**
     * 获取 盐
     *
     * @param length 盐长度
     */
    public static String getSalt(@MinTag(1) int length) {
        return RandomUtil.getHexRandomByCircle(null, length);
    }


    /**
     * 加密
     * 没有加盐
     *
     * @param src 需要加密的内容
     * @return 内容密文
     */
    public static String encode16(@NotBlankTag String src) {
        return encode16(src, null);
    }

    /**
     * 加盐加密
     *
     * @param src  需要加密的内容
     * @param salt 盐字符串
     * @return 内容密文
     */
    public static String encode16(@NotBlankTag String src, String salt) {
        return encode32(src, salt).substring(8, 24);
    }


    /**
     * 加密
     * 没有加盐
     *
     * @param src 需要加密的内容
     * @return 内容密文
     */
    public static String encode32(@NotBlankTag String src) {
        return encode32(src, null);
    }

    /**
     * 加盐加密
     *
     * @param src  需要加密的内容
     * @param salt 盐字符串
     * @return 内容密文
     */
    public static String encode32(@NotBlankTag String src, String salt) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(EncryptConstant.getMD5());
            md5.update(srcStringToArray(src, salt));
            return dstArrayToString(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        }
    }

    /*
        校验
     */

    public static boolean verify16(@NotBlankTag String src, @NotBlankTag String dst) {
        return verify16(src, dst, null);
    }

    public static boolean verify16(@NotBlankTag String src, @NotBlankTag String dst, String salt) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encode16(src, salt), dst);
    }

    public static boolean verify32(@NotBlankTag String src, @NotBlankTag String dst) {
        return verify32(src, dst, null);
    }

    public static boolean verify32(@NotBlankTag String src, @NotBlankTag String dst, String salt) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encode32(src, salt), dst);
    }

    /*
        字节数组 与 字符串 互转
     */
    public static byte[] srcStringToArray(@NotBlankTag String src, String salt) {
        EmptyAssert.isNotBlank(src);
        return salt == null ? src.getBytes() : (src + salt).getBytes();
    }

    public static String dstArrayToString(@NotEmptyTag byte[] dstBytes) {
        EmptyAssert.isNotEmpty(dstBytes);

        StringBuilder builder = new StringBuilder();
        for (byte dstByte : dstBytes) {
            int i = ((int) dstByte) & 0xff;
            if (i < 16) {
                builder.append("0");
            }
            builder.append(Integer.toHexString(i));
        }
        return builder.toString();
    }
}
