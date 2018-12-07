package com.wocloud.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * 功能描述:时间戳处理类
 *
 * @date: 2018/9/14 15:17
 */
public class DateTimeUtils {

    public static final DateTimeFormatter DATE_DF = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter DATETIME_DF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static final DateTimeFormatter DATETIME_HOUR = DateTimeFormatter.ofPattern("yyyyMMdd-HH");


    /**
     * 通过时间戳获取datetime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeFromEpoch(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    /**
     * 通过日期字符串获得LocalDate对象
     *
     * @param date yyyyMMdd
     * @return
     */
    public static LocalDate getDateFromYyyymmdd(String date) {
        return LocalDate.parse(date, DATE_DF);
    }

    /**
     * 通过时间戳获取yyyy/MM/dd HH:mm:ss格式的日期
     *
     * @param timestamp
     * @return
     */
    public static String formatEpoch2FullDateTime(long timestamp) {
        LocalDateTime theDateTime = getDateTimeFromEpoch(timestamp);
        return DATETIME_DF.format(theDateTime);
    }


    /**
     * 通过datetime获取yyyy/MM/dd HH:mm:ss格式的日期
     * @param dateTime
     * @return
     */
    public static String formatDateTime2FullDateTimeStr(LocalDateTime dateTime) {
        return DATETIME_DF.format(dateTime);
    }

    /**
     * 通过datetime获取yyyyMMdd格式的日期
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTime2Yyyymmdd(LocalDateTime dateTime) {
        return DATE_DF.format(dateTime);
    }


    /**
     * 通过时间戳获取yyyyMMdd格式的日期
     *
     * @param timestamp
     * @return
     */
    public static String formatEpoch2Yyyymmdd(long timestamp) {
        LocalDateTime theDateTime = getDateTimeFromEpoch(timestamp);
        return DATE_DF.format(theDateTime);
    }

    /**
     * 通过时间戳获取yyyyMMdd-HH格式的日期
     *
     * @param timestamp
     * @return
     */
    public static String formatEpoch2YyyymmddHH(long timestamp) {
        LocalDateTime theDateTime = getDateTimeFromEpoch(timestamp);
        return DATETIME_HOUR.format(theDateTime);
    }

    /**
     * 验证时间格式是否非法
     *
     * @param dateTime 时间字符串
     * @return 非法字符串 返回 true, 否则返回 false
     */
    public static boolean isDateTimeIllegal(String dateTime) {

        try {
            return LocalDate.parse(dateTime, DATETIME_DF) == null;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * 验证日期格式是否非法
     *
     * @param date 日期字符串
     * @return 非法字符串 返回 true, 否则返回 false
     */
    public static boolean isDateIllegal(String date) {
        try {
            return LocalDate.parse(date, DATE_DF) == null;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(formatEpoch2YyyymmddHH(1533740400000L));
    }
}
