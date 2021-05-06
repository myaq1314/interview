package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class DateTextConvertorTest {

    @Test
    public void convertToDateTest() {
        Date date = new Date();

        // yyyy-MM-dd HH:mm:ss
        String text1 = DateConvertor.convertToText(date);
        // yyyy-MM-dd HH:mm:ss SSS
        String text2 = DateConvertor.convertToText(date, DateConstant.DATETIME_STANDARD_MILLIS());

        Date date1 = DateTextConvertor.convertToDate(text1);
        Date date2 = DateTextConvertor.convertToDate(text1, DateConvertor.getFormatter());

        Date date3 = DateTextConvertor.convertToDate(text2, DateConstant.DATETIME_STANDARD_MILLIS());

        EqualsAssert.allEquals(date1, date2);
        EqualsAssert.allEquals(date, date3);
    }

    @Test
    public void convertToLDTimeTest() {
        Date date = new Date();

        // yyyy-MM-dd HH:mm:ss
        String text = DateConvertor.convertToText(date);

        LocalDateTime localDateTime1 = DateTextConvertor.convertToLDTime(text);
        LocalDateTime localDateTime2 = DateTextConvertor.convertToLDTime(text, DateConstant.DATETIME_STANDARD());
        LocalDateTime localDateTime3 = DateTextConvertor.convertToLDTime(text, LDTimeConvertor.getFormatter());

        String text1 = LDTimeConvertor.convertToText(localDateTime1);
        String text2 = LDTimeConvertor.convertToText(localDateTime2, DateConstant.DATETIME_STANDARD());
        String text3 = LDTimeConvertor.convertToText(localDateTime3, LDTimeConvertor.getFormatter());

        EqualsAssert.allEquals(text, text1, text2, text3);
    }

    @Test
    public void convertToLDateTest() {
        Date date = new Date();

        // yyyy-MM-dd
        String text = DateConvertor.convertToText(date, DateConstant.DATE_STANDARD());

        LocalDate localDate1 = DateTextConvertor.convertToLDate(text);
        LocalDate localDate2 = DateTextConvertor.convertToLDate(text, DateConstant.DATE_STANDARD());
        LocalDate localDate3 = DateTextConvertor.convertToLDate(text, LDateConvertor.getFormatter());

        String text1 = LDateConvertor.convertToText(localDate1);
        String text2 = LDateConvertor.convertToText(localDate2, DateConstant.DATE_STANDARD());
        String text3 = LDateConvertor.convertToText(localDate3, LDateConvertor.getFormatter());

        EqualsAssert.allEquals(text, text1, text2, text3);
    }

    @Test
    public void convertToLTimeTest() {
        Date date = new Date();

        // HH:mm:ss
        String text = DateConvertor.convertToText(date, DateConstant.TIME_STANDARD());

        LocalTime localTime1 = DateTextConvertor.convertToLTime(text);
        LocalTime localTime2 = DateTextConvertor.convertToLTime(text, DateConstant.TIME_STANDARD());
        LocalTime localTime3 = DateTextConvertor.convertToLTime(text, LTimeConvertor.getFormatter());

        String text1 = LTimeConvertor.convertToText(localTime1);
        String text2 = LTimeConvertor.convertToText(localTime2, DateConstant.TIME_STANDARD());
        String text3 = LTimeConvertor.convertToText(localTime3, LTimeConvertor.getFormatter());

        EqualsAssert.allEquals(text, text1, text2, text3);
    }
}
