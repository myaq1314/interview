package org.czh.interview.commons.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.czh.interview.commons.annotations.tag.MinTag;
import org.czh.interview.commons.annotations.tag.NotBlankTag;
import org.czh.interview.commons.annotations.tag.NotEmptyTag;
import org.czh.interview.commons.annotations.tag.NotNullTag;
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
 * date : 2021-06-01
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class SHAUtil {

    public static void main(String[] args) {
        String salt = SecretKeyUtil.matchReadByLast(EncryptConstant.SHAType.SHA_1.key);
        if (salt == null) {
            salt = getSalt(32);
            SecretKeyUtil.writeKey(EncryptConstant.SHAType.SHA_1.key, salt);
        }
        System.out.println(salt); // 844f77f9196859d501819313881b5e2c

        String src = "123456";
        System.out.println(src); // 123456

        String dst1 = encode(EncryptConstant.SHAType.SHA_1, src, salt);
        String dst12 = encode(EncryptConstant.SHAType.SHA_1, src, salt);
        System.out.println(dst1); // b1733f92e9372c4c33b7544e210ea6004a93033e
        FlagAssert.isTrue(verify(EncryptConstant.SHAType.SHA_1, src, dst1, salt));
        EqualsAssert.isEquals(dst1, dst12);

        String dst224 = encode(EncryptConstant.SHAType.SHA_224, src, salt);
        String dst2242 = encode(EncryptConstant.SHAType.SHA_224, src, salt);
        System.out.println(dst224); // 2b6db796983488d24bd5da59ff1a89ab822e75b9cb11f8a9fb55f14f
        FlagAssert.isTrue(verify(EncryptConstant.SHAType.SHA_224, src, dst224, salt));
        EqualsAssert.isEquals(dst224, dst2242);

        String dst256 = encode(EncryptConstant.SHAType.SHA_256, src, salt);
        String dst2562 = encode(EncryptConstant.SHAType.SHA_256, src, salt);
        System.out.println(dst256); // 1184305bdf1e454a12d6cacbfe200bbf0e6ff47271a466bc5f0dfc057ed977be
        FlagAssert.isTrue(verify(EncryptConstant.SHAType.SHA_256, src, dst256, salt));
        EqualsAssert.isEquals(dst256, dst2562);

        String dst384 = encode(EncryptConstant.SHAType.SHA_384, src, salt);
        String dst3842 = encode(EncryptConstant.SHAType.SHA_384, src, salt);
        System.out.println(dst384); // d12c737ea9c2b476b8181162546e06fa8bb268a67fda74761aeafe452674bc8d12c61c6386cc6ce9dd8fdecb2ef16a49
        FlagAssert.isTrue(verify(EncryptConstant.SHAType.SHA_384, src, dst384, salt));
        EqualsAssert.isEquals(dst384, dst3842);

        String dst512 = encode(EncryptConstant.SHAType.SHA_512, src, salt);
        String dst5122 = encode(EncryptConstant.SHAType.SHA_512, src, salt);
        System.out.println(dst512); // 38e3f9a4c26e74e954564f6cdf2d39efb137c78310cfd199f7bed37936b0c204993cc3b8ae239ce7a78d11448242708f327fef12c7230d88c94f75e7549a7325
        FlagAssert.isTrue(verify(EncryptConstant.SHAType.SHA_512, src, dst512, salt));
        EqualsAssert.isEquals(dst512, dst5122);
    }

    /*
        盐
     */
    public static String getSalt(@MinTag(1) int length) {
        return RandomUtil.getHexRandomByCircle(null, length);
    }

    /*
        加密
     */

    public static String encode(@NotBlankTag String src) {
        return encode(EncryptConstant.SHAType.SHA_1, src);
    }

    public static String encode(@NotNullTag EncryptConstant.SHAType shaType, @NotBlankTag String src) {
        return encode(shaType, src, null);
    }

    public static String encode(@NotNullTag EncryptConstant.SHAType shaType, @NotBlankTag String src, String salt) {
        try {
            MessageDigest shaMd = MessageDigest.getInstance(shaType.key);
            return dstArrayToString(shaMd.digest(srcStringToArray(src, salt)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("未知的加密算法");
        }
    }

    /*
        校验
     */

    public static boolean verify(@NotBlankTag String src, @NotBlankTag String dst) {
        return verify(EncryptConstant.SHAType.SHA_1, src, dst);
    }

    public static boolean verify(@NotNullTag EncryptConstant.SHAType shaType,
                                 @NotBlankTag String src,
                                 @NotBlankTag String dst) {
        return verify(shaType, src, dst, null);
    }

    public static boolean verify(@NotNullTag EncryptConstant.SHAType shaType,
                                 @NotBlankTag String src,
                                 @NotBlankTag String dst,
                                 String salt) {
        EmptyAssert.isNotBlank(dst);
        return Objects.equals(encode(shaType, src, salt), dst);
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
        return Hex.encodeHexString(dstBytes);
    }
}
