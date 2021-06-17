package org.czh.interview.amuse_interview;

import org.czh.interview.commons.constant.DateConstant;
import org.czh.interview.commons.convertor.date.DateTextConvertor;
import org.czh.interview.commons.convertor.date.LDateConvertor;
import org.czh.interview.commons.validate.EmptyAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author : czh
 * description :
 * date : 2021-06-16
 * email 916419307@qq.com
 */
public final class DateCalculate {

    public static void main(String[] args) {
        LocalDate nowDate = getNow();
//        LocalDate nowDate = DateTextConvertor.convertToLDate("2023-06-16");
        String nowDateString = LDateConvertor.convertToText(nowDate);
        System.out.printf("当前时间为 %s \n\n", nowDateString);

        // 告知不再续租时间点
        printDays(nowDate, "2021-06-20", "距离告知不再续租剩余天数： %s \n", "已经告知不再续租 \n");

        // 准备面试还剩下天数
        printDays(nowDate, "2021-06-30", "准备面试阶段还剩余天数： %s \n", "面试已经充足准备 \n");

        // 房租到期还剩下天数
        printDays(nowDate, "2021-07-31", "距离房租到期还剩余天数： %s \n", "已经搬家完成 \n");

        // 距离回家买车剩余天数
        printDays(nowDate, "2021-11-30", "距离回家买车还剩余天数： %s \n", "已经回家买车 \n");
    }

    private static void printDays(LocalDate startDate,
                                  String endDateString,
                                  String beforeEndDateContentString,
                                  String afterEndDateContentString) {
        EmptyAssert.isNotNull(startDate);
        EmptyAssert.isNotBlank(endDateString);
        EmptyAssert.allNotNull(beforeEndDateContentString, afterEndDateContentString);

        LocalDate endDate = DateTextConvertor.convertToLDate(endDateString);
        if (startDate.isBefore(endDate)) {
            System.out.printf(beforeEndDateContentString, calculateDays(startDate, endDate));
        } else {
            System.out.printf(afterEndDateContentString);
        }
    }

    private static LocalDate getNow() {
        return LocalDate.now();
    }

    private static long calculateDays(String startDateString,
                                      String endDateString) {
        return calculateDays(startDateString, endDateString, DateConstant.DATE_STANDARD());
    }

    private static long calculateDays(String startDateString,
                                      String endDateString,
                                      String pattern) {
        return calculateDays(startDateString, endDateString, LDateConvertor.getFormatter(pattern));
    }


    private static long calculateDays(String startDateString,
                                      String endDateString,
                                      String startPattern,
                                      String endPattern) {
        return calculateDays(
                startDateString,
                endDateString,
                LDateConvertor.getFormatter(startPattern),
                LDateConvertor.getFormatter(endPattern)
        );
    }

    private static long calculateDays(String startDateString,
                                      String endDateString,
                                      DateTimeFormatter formatter) {
        return calculateDays(startDateString, endDateString, formatter, formatter);
    }

    private static long calculateDays(String startDateString,
                                      String endDateString,
                                      DateTimeFormatter startFormatter,
                                      DateTimeFormatter endFormatter) {
        return calculateDays(
                DateTextConvertor.convertToLDate(startDateString, startFormatter),
                DateTextConvertor.convertToLDate(endDateString, endFormatter)
        );
    }

    private static long calculateDays(LocalDate startDate, LocalDate endDate) {
        EmptyAssert.allNotNull(startDate, endDate);
        return endDate.toEpochDay() - startDate.toEpochDay();
    }
}
