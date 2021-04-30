package org.czh.interview.commons.handler;

import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

import java.util.regex.Pattern;

/**
 * @author : czh
 * description :
 * date : 2021-04-29
 * email 916419307@qq.com
 */
public final class TextHandler {

    public static Integer matchNum(String text) {
        EmptyAssert.isNotBlank(text);
        String num = Pattern.compile("[^0-9]").matcher(text).replaceAll("");
        EmptyAssert.isNotBlank(num, "字符串没有提取到数字");

        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new CommonException("字符串提取数字失败", e);
        }
    }

    public static String trimNum(String text) {
        EmptyAssert.isNotNull(text);
        return Pattern.compile("[\\d]").matcher(text).replaceAll("").trim();
    }

    public static void main(String[] args) {
        System.out.println(matchNum("list9"));
        System.out.println(matchNum("set11"));
        System.out.println(matchNum("set1\t1\n"));
        System.out.println(matchNum("s\te2ddt1\t33dd1\n"));

        System.out.println(trimNum("list9"));
        System.out.println(trimNum("set11"));
        System.out.println(trimNum("set1\t1\n"));
        System.out.println(trimNum("s\te2ddt1\t33dd1\n"));
    }
}
