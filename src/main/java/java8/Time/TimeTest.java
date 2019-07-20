package java8.Time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 在Java8中，我们可以使用以下类来计算日期时间差异：
 * @create 2019-07-09 8:56
 * @since 1.7
 */
public class TimeTest {

    public static void main(String[] args) {

        // 程序开始时间
        Instant startTime =Instant.now();

        // 主要是Period类方法getYears（），getMonths（）和getDays（）来计算.
        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(1996, Month.MARCH, 3);
        System.out.println("BirthDate : " + birthDate);

        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());

        System.out.println();
        System.out.println("------------------华丽分割线-------------------------------");

        // 提供了使用基于时间的值（如秒，纳秒）测量时间量的方法
        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);

        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());

        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());


        System.out.println("------------------华丽分割线-------------------------------");

        // ChronoUnit类可用于在单个时间单位内测量一段时间，例如天数或秒。
        LocalDate startDate = LocalDate.of(1996, Month.MARCH, 3);
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.now();
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);

        // 程序结束时间
        Instant endTime = Instant.now();
        long millis = ChronoUnit.MILLIS.between(startTime, endTime);
        long micros = ChronoUnit.MICROS.between(startTime, endTime);
        long seconds = ChronoUnit.SECONDS.between(startTime, endTime);
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime);
        long hours = ChronoUnit.HOURS.between(startTime, endTime);

        System.out.println("程序消耗时间(毫秒)" + millis);
        System.out.println("程序消耗时间(微秒)" + micros);
        System.out.println("程序消耗时间(秒)" + seconds);
        System.out.println("程序消耗时间(分钟)" + minutes);
        System.out.println("程序消耗时间(小时)" + hours);
    }

}
