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
public class LDateConvertorTest {

    @Test
    public void getFormatterTest() {
        DateTimeFormatter formatter = LDateConvertor.getFormatter();
        DateTimeFormatter formatter1 = LDateConvertor.getFormatter("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        EqualsAssert.allEquals(formatter.toString(), formatter1.toString(), formatter2.toString());
    }

    @Test
    public void convertToTextTest() {
        Date date = new Date();
        LocalDate localDate = DateConvertor.convertToLDate(date);

        String text1 = LDateConvertor.convertToText(localDate);
        String text2 = LDateConvertor.convertToText(localDate, "yyyy-MM-dd");
        String text3 = LDateConvertor.convertToText(localDate, LDateConvertor.getFormatter());

        EqualsAssert.allEquals(text1, text2, text3);
    }

    @Test
    public void convertToDateTest() {
        Date date = new Date();
        String text1 = DateConvertor.convertToText(date, DateConstant.DATE_STANDARD());

        LocalDate localDate = DateConvertor.convertToLDate(date);
        String text2 = LDateConvertor.convertToText(localDate, DateConstant.DATE_STANDARD());

        Date date3 = LDateConvertor.convertToDate(localDate);
        String text3 = DateConvertor.convertToText(date3, DateConstant.DATE_STANDARD());

        EqualsAssert.allEquals(text1, text2, text3);
    }

    @Test
    public void convertToLDTimeTest() {
        Date date = new Date();
        String text1 = DateConvertor.convertToText(date, DateConstant.DATE_STANDARD());
        Date date2 = DateTextConvertor.convertToDate(text1, DateConstant.DATE_STANDARD());

        LocalDate localDate = DateConvertor.convertToLDate(date);
        LocalTime localTime = DateConvertor.convertToLTime(date);

        LocalDateTime localDateTime = LDateConvertor.convertToLDTime(localDate);
        LocalDateTime localDateTime1 = LDateConvertor.convertToLDTime(localDate, localTime);

        String text2 = DateConvertor.convertToText(date2);
        String text3 = LDTimeConvertor.convertToText(localDateTime);
        EqualsAssert.isEquals(text2, text3);


        String text4 = DateConvertor.convertToText(date);
        String text5 = LDTimeConvertor.convertToText(localDateTime1);
        EqualsAssert.isEquals(text4, text5);
    }
}
