package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class DateConvertorTest {

    @Test
    public void getFormatterTest() {
        DateFormat formatter = DateConvertor.getFormatter();
        DateFormat formatter1 = DateConvertor.getFormatter("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        EqualsAssert.allEquals(formatter, formatter1, formatter2);
    }

    @Test
    public void convertToTextTest() {
        Date date = new Date();

        String text = DateConvertor.convertToText(date);
        String text1 = DateConvertor.convertToText(date, "yyyy-MM-dd HH:mm:ss");

        DateFormat formatter2 = DateConvertor.getFormatter("yyyy-MM-dd HH:mm:ss");
        String text2 = DateConvertor.convertToText(date, formatter2);

        EqualsAssert.allEquals(text, text1, text2);
    }

    @Test
    public void convertToLDateTest() {
        Date date = new Date();

        LocalDate localDate = DateConvertor.convertToLDate(date);
        String text = LDateConvertor.convertToText(localDate);

        String text2 = DateConvertor.convertToText(date, DateConstant.DATE_STANDARD());
        EqualsAssert.isEquals(text, text2);
    }

    @Test
    public void convertToLDTime() {
        Date date = new Date();

        LocalDateTime localDateTime = DateConvertor.convertToLDTime(date);
        String text = LDTimeConvertor.convertToText(localDateTime);

        String text2 = DateConvertor.convertToText(date);
        EqualsAssert.isEquals(text, text2);
    }

    @Test
    public void convertToLTimeTest() {
        Date date = new Date();

        LocalTime localTime = DateConvertor.convertToLTime(date);
        String text = LTimeConvertor.convertToText(localTime);

        String text2 = DateConvertor.convertToText(date, DateConstant.TIME_STANDARD());
        EqualsAssert.isEquals(text, text2);
    }
}
