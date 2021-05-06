package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EmptyAssert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public final class LTimeConvertor {

    /*
      -----------------------------local time get formatter-------------------------------
     */

    /**
     * 默认的本地时间格式：HH:mm:ss
     */
    public static DateTimeFormatter getFormatter() {
        return getFormatter(DateConstant.TIME_STANDARD());
    }

    public static DateTimeFormatter getFormatter(String pattern) {
        return LDTimeConvertor.getFormatter(pattern);
    }

    /*
      -----------------------------local time convert to text-------------------------------
     */
    public static String convertToText(LocalTime localTime) {
        return convertToText(localTime, getFormatter());
    }

    public static String convertToText(LocalTime localTime, String pattern) {
        return convertToText(localTime, getFormatter(pattern));
    }

    public static String convertToText(LocalTime localTime, DateTimeFormatter formatter) {
        EmptyAssert.allNotNull(localTime, formatter);

        return formatter.format(localTime);
    }
}
