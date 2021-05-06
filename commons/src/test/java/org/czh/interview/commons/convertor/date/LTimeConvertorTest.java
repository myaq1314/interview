package org.czh.interview.commons.convertor.date;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.validate.EqualsAssert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : czh
 * description :
 * date : 2021-05-06
 * email 916419307@qq.com
 */
public class LTimeConvertorTest {

    @Test
    public void getFormatterTest() {
        DateTimeFormatter formatter = LTimeConvertor.getFormatter();
        DateTimeFormatter formatter1 = LTimeConvertor.getFormatter("HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");

        EqualsAssert.allEquals(formatter.toString(), formatter1.toString(), formatter2.toString());
    }

    @Test
    public void convertToTextTest() {
        Date date = new Date();
        LocalTime localTime = DateConvertor.convertToLTime(date);

        String text1 = LTimeConvertor.convertToText(localTime);
        String text2 = LTimeConvertor.convertToText(localTime, DateConstant.TIME_STANDARD());
        String text3 = LTimeConvertor.convertToText(localTime, LTimeConvertor.getFormatter());

        EqualsAssert.allEquals(text1, text2, text3);
    }

    @Test
    public void convertToDateTest() {
        Date date = new Date();
        String text1 = DateConvertor.convertToText(date, DateConstant.TIME_STANDARD());

        LocalTime localTime = DateConvertor.convertToLTime(date);
        String text2 = LTimeConvertor.convertToText(localTime, DateConstant.TIME_STANDARD());

        EqualsAssert.allEquals(text1, text2);
    }
}
