package jdk8;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 使用时区的日期时间API
 * @create 2018-12-12 9:41
 * @since 1.7
 */
public class Java8Tester12 {
    public static void main(String args[]){

        Java8Tester12 java8tester = new Java8Tester12();
        java8tester.testZonedDateTime();
    }

    private void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
