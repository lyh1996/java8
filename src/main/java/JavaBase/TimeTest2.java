package JavaBase;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-30 9:49
 * @since 1.7
 */
public class TimeTest2 {
    public static void main(String[] args) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(new Date());
        String year = "2.1";
        int num = (int) (Double.parseDouble(year) * 365);
        c.add(Calendar.DAY_OF_YEAR, +num);
        System.out.println(c.getTime());


        long time = System.currentTimeMillis();
        Instant instant1 = Instant.ofEpochMilli(time);
        ZoneId zone1 = ZoneId.systemDefault();
        LocalDateTime dateTime1 = LocalDateTime.ofInstant(instant1, zone1);


        Instant instant = Instant.ofEpochMilli(time+60000);
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zone);
        //当前的时间
        System.out.println(dateTime1);
        System.out.println(dateTime);


    }
}
