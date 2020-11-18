/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-03-18 13:51
 */

import JavaBase.TimeUtil;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author LYH
 * @date 2020/03/18 13:51
 */
public class TestDay {

    public static void main(String[] args) {

        // 计算两个日期之间相差的天数
        // "2020-1-1","2019-12-25"
        int day = TimeUtil.differentDays(TimeUtil.parseStringToDate("2020-8-24", "yyyy-MM-dd"), TimeUtil.parseStringToDate("2020-11-04", "yyyy-MM-dd"));
        System.out.println(day);

        LocalDate endDate = LocalDate.of(2020, Month.AUGUST, 24);
        LocalDate startDate = LocalDate.of(2020, Month.NOVEMBER, 4);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println(daysDiff);
    }
}
