package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class LDTimeConvertorTest {

    @Test
    public void getFormatterTest() {
        DateTimeFormatter formatter = LDTimeConvertor.getFormatter();
        DateTimeFormatter formatter1 = LDTimeConvertor.getFormatter("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        EqualsAssert.allEquals(formatter.toString(), formatter1.toString(), formatter2.toString());
    }

    @Test
    public void convertToTextTest() {
        Date date = new Date();
        LocalDateTime localDateTime = DateConvertor.convertToLDTime(date);

        String text1 = LDTimeConvertor.convertToText(localDateTime);
        String text2 = LDTimeConvertor.convertToText(localDateTime, DateConstant.DATETIME_STANDARD());
        String text3 = LDTimeConvertor.convertToText(localDateTime, LDTimeConvertor.getFormatter());

        EqualsAssert.allEquals(text1, text2, text3);
    }

    @Test
    public void convertToDateTest() {
        Date date = new Date();
        String text1 = DateConvertor.convertToText(date, DateConstant.DATETIME_STANDARD());

        LocalDateTime localDateTime = DateConvertor.convertToLDTime(date);
        String text2 = LDTimeConvertor.convertToText(localDateTime, DateConstant.DATETIME_STANDARD());

        Date date3 = LDTimeConvertor.convertToDate(localDateTime);
        String text3 = DateConvertor.convertToText(date3, DateConstant.DATETIME_STANDARD());

        EqualsAssert.allEquals(text1, text2, text3);
    }

    @Test
    public void convertToLDateTest() {
        Date date = new Date();
        LocalDateTime localDateTime = DateConvertor.convertToLDTime(date);

        LocalDate localDate = DateConvertor.convertToLDate(date);
        LocalDate localDate1 = LDTimeConvertor.convertToLDate(localDateTime);
        EqualsAssert.isEquals(localDate, localDate1);
    }

    @Test
    public void convertToLTimeTest() {
        Date date = new Date();
        LocalDateTime localDateTime = DateConvertor.convertToLDTime(date);

        LocalTime localTime = DateConvertor.convertToLTime(date);
        LocalTime localTime1 = LDTimeConvertor.convertToLTime(localDateTime);
        EqualsAssert.isEquals(localTime, localTime1);
    }
}
