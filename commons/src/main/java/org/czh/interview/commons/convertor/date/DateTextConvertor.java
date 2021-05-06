package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.exceptions.CommonException;
import org.czh.interview.commons.validate.EmptyAssert;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class DateTextConvertor {

    /*
      -----------------------------date text convert to date-------------------------------
     */
    public static Date convertToDate(String dateText) {
        return convertToDate(dateText, DateConvertor.getFormatter());
    }

    public static Date convertToDate(String dateText, String pattern) {
        return convertToDate(dateText, DateConvertor.getFormatter(pattern));
    }

    public static Date convertToDate(String dateText, DateFormat formatter) {
        EmptyAssert.isNotBlank(dateText);
        EmptyAssert.isNotNull(formatter);

        try {
            return formatter.parse(dateText);
        } catch (ParseException e) {
            throw new CommonException("不匹配的日期时间文本 和 日期时间格式");
        }
    }

    /*
      -----------------------------date text convert to local date time-------------------------------
     */

    public static LocalDateTime convertToLDTime(String dateText) {
        return convertToLDTime(dateText, LDTimeConvertor.getFormatter());
    }

    public static LocalDateTime convertToLDTime(String dateText, String pattern) {
        return convertToLDTime(dateText, LDTimeConvertor.getFormatter(pattern));
    }

    public static LocalDateTime convertToLDTime(String dateText, DateTimeFormatter formatter) {
        EmptyAssert.isNotBlank(dateText);
        EmptyAssert.isNotNull(formatter);

        try {
            return LocalDateTime.parse(dateText, formatter);
        } catch (DateTimeParseException e) {
            throw new CommonException("不匹配的日期时间文本 和 日期时间格式");
        }
    }

    /*
      -----------------------------date text convert to local date-------------------------------
     */

    public static LocalDate convertToLDate(String dateText) {
        return convertToLDate(dateText, LDateConvertor.getFormatter());
    }

    public static LocalDate convertToLDate(String dateText, String pattern) {
        return convertToLDate(dateText, LDateConvertor.getFormatter(pattern));
    }

    public static LocalDate convertToLDate(String dateText, DateTimeFormatter formatter) {
        EmptyAssert.isNotBlank(dateText);
        EmptyAssert.isNotNull(formatter);

        try {
            return LocalDate.parse(dateText, formatter);
        } catch (DateTimeParseException e) {
            throw new CommonException("不匹配的日期文本 和 日期格式");
        }
    }

    /*
      -----------------------------date text convert to local time-------------------------------
     */

    public static LocalTime convertToLTime(String dateText) {
        return convertToLTime(dateText, LTimeConvertor.getFormatter());
    }

    public static LocalTime convertToLTime(String dateText, String pattern) {
        return convertToLTime(dateText, LTimeConvertor.getFormatter(pattern));
    }

    public static LocalTime convertToLTime(String dateText, DateTimeFormatter formatter) {
        EmptyAssert.isNotBlank(dateText);
        EmptyAssert.isNotNull(formatter);

        try {
            return LocalTime.parse(dateText, formatter);
        } catch (DateTimeParseException e) {
            throw new CommonException("不匹配的时间文本 和 时间格式");
        }
    }
}
