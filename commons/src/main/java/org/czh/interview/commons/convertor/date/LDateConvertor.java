package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EmptyAssert;
import org.czh.interview.commons.validate.EmptyValidate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : czh
 * description : 本地日期转换器
 * date : 2021-04-28
 * email 916419307@qq.com
 */
@SuppressWarnings("unused")
public final class LDateConvertor {

    /*
      -----------------------------local date get format-------------------------------
     */

    /**
     * 默认的本地日期格式：yyyy-MM-dd
     */
    public static DateTimeFormatter getFormatter() {
        return getFormatter(DateConstant.DATE_STANDARD());
    }

    public static DateTimeFormatter getFormatter(String pattern) {
        return LDTimeConvertor.getFormatter(pattern);
    }

    /*
      -----------------------------local date convert to text-------------------------------
     */
    public static String convertToText(LocalDate localDate) {
        return convertToText(localDate, getFormatter());
    }

    public static String convertToText(LocalDate localDate, String pattern) {
        return convertToText(localDate, getFormatter(pattern));
    }

    public static String convertToText(LocalDate localDate, DateTimeFormatter formatter) {
        EmptyAssert.allNotNull(localDate, formatter);

        return formatter.format(localDate);
    }

    /*
      -----------------------------local date convert to date-------------------------------
     */
    public static Date convertToDate(LocalDate localDate) {
        return LDTimeConvertor.convertToDate(convertToLDTime(localDate));
    }

    /*
      -----------------------------local date convert to local date time-------------------------------
     */

    public static LocalDateTime convertToLDTime(LocalDate localDate) {
        return convertToLDTime(localDate, null);
    }

    public static LocalDateTime convertToLDTime(LocalDate localDate, LocalTime localTime) {
        EmptyAssert.isNotNull(localDate);

        if (EmptyValidate.isNull(localTime)) {
            return localDate.atStartOfDay();
        }

        return localDate.atTime(localTime);
    }
}
