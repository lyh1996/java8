/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-03-18 13:51
 */

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author LYH
 * @date 2020/03/18 13:51
 */
public class TestDay {

    public static void main(String[] args) {

        // 计算两个日期之间相差的天数
        // "2020-1-1","2019-12-25"
/*        int day = TimeUtil.differentDays(TimeUtil.parseStringToDate("2020-8-24", "yyyy-MM-dd"), TimeUtil.parseStringToDate("2020-11-04", "yyyy-MM-dd"));
        System.out.println(day);

        LocalDate endDate = LocalDate.of(2020, Month.AUGUST, 24);
        LocalDate startDate = LocalDate.of(2020, Month.NOVEMBER, 4);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println(daysDiff);*/

      /*  LocalDate localDate = LocalDate.of(2020, Month.DECEMBER, 7);
        System.out.println(Period.between(localDate,
                LocalDateTime.now().plusDays(90).toLocalDate()).getDays()
        );

        System.out.println(LocalDateTime.now().plusDays(90).toLocalDate().toEpochDay() - localDate.toEpochDay());

        System.out.println(ChronoUnit.DAYS.between(localDate, LocalDateTime.now().plusDays(90).toLocalDate()));*/
        /*Integer str = null;
        List<Integer> list = Collections.singletonList(str);
        System.out.println(list);*/
       /* int zeroFill = 1;
        System.out.println(String.format("%0" + zeroFill + "d", 2));

        System.out.println(BeanUtil.getPropertyDescriptor(User.class, "uid"));

        User user = new User();
        user.setName("hha");
        String json = JSONUtil.toJsonStr(user);

        User user2 = new User();
        user2.setName("hha");
        String json2 = JSONUtil.toJsonStr(user2);
        System.out.println(StringUtils.equals(json, json2));*/
/*        String rex = "^[a-zA-Z0-9+\\- ]{8}$";
        String blankRex = "^ *$";
        String str = " ";
        System.out.println(Pattern.matches(rex, str));
        System.out.println(Pattern.matches(blankRex, str));*/
        //System.out.println(ReUtil.isMatch(PatternPool.EMAIL, "90124993550340096.10000237@lingxing.com"));
        LocalDate date = LocalDate.now();
        System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(date.getMonth().getValue());

    }
}
