package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author : czh
 * description : 日期转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class DateConvertor {

    /*
      -----------------------------date get format-------------------------------
     */

    public static DateFormat getFormatter() {
        return getFormatter(DateConstant.DATETIME_STANDARD());
    }

    public static DateFormat getFormatter(String pattern) {
        EmptyAssert.isNotBlank(pattern, "日期格式文本无效");
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            EmptyAssert.isNotNull(formatter);
            return formatter;
        } catch (IllegalArgumentException e) {
            throw new CommonException("日期格式文本无效");
        }
    }

    /*
      -----------------------------date convert to text-------------------------------
     */

    public static String convertToText(Date date) {
        return convertToText(date, getFormatter());
    }

    public static String convertToText(Date date, String pattern) {
        return convertToText(date, getFormatter(pattern));
    }

    public static String convertToText(Date date, DateFormat formatter) {
        EmptyAssert.allNotNull(date, formatter);

        return formatter.format(date);
    }

    /*
      -----------------------------date convert to local date-------------------------------
     */

    public static LocalDate convertToLDate(Date date) {
        return convertToLDTime(date).toLocalDate();
    }

    /*
      -----------------------------date convert to local date time-------------------------------
     */
    public static LocalDateTime convertToLDTime(Date date) {
        EmptyAssert.isNotNull(date);

        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /*
      -----------------------------date convert to local time-------------------------------
     */
    public static LocalTime convertToLTime(Date date) {
        return convertToLDTime(date).toLocalTime();
    }
}
