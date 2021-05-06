package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : czh
 * description : 本地时间转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class LDTimeConvertor {

    /*
      -----------------------------local date time get format-------------------------------
     */

    public static DateTimeFormatter getFormatter() {
        return getFormatter(DateConstant.DATETIME_STANDARD());
    }

    public static DateTimeFormatter getFormatter(String pattern) {
        EmptyAssert.isNotBlank(pattern, "日期格式文本无效");
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            EmptyAssert.isNotNull(formatter);
            return formatter;
        } catch (IllegalArgumentException e) {
            throw new CommonException("日期格式文本无效");
        }
    }

    /*
      -----------------------------local date time convert to text-------------------------------
     */
    public static String convertToText(LocalDateTime localDateTime) {
        return convertToText(localDateTime, getFormatter());
    }

    public static String convertToText(LocalDateTime localDateTime, String pattern) {
        return convertToText(localDateTime, getFormatter(pattern));
    }

    public static String convertToText(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        EmptyAssert.allNotNull(localDateTime, formatter);

        return formatter.format(localDateTime);
    }

    /*
      -----------------------------local date time convert to date-------------------------------
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        EmptyAssert.isNotNull(localDateTime);

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /*
      -----------------------------local date time  convert to local date-------------------------------
     */

    public static LocalDate convertToLDate(LocalDateTime localDateTime) {
        EmptyAssert.isNotNull(localDateTime);

        return localDateTime.toLocalDate();
    }
    
    /*
      -----------------------------local date time convert to local time-------------------------------
     */

    public static LocalTime convertToLTime(LocalDateTime localDateTime) {
        EmptyAssert.isNotNull(localDateTime);

        return localDateTime.toLocalTime();
    }
}
