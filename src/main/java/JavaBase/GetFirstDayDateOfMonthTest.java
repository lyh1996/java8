package JavaBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-10 10:30
 * @since 1.7
 */
public class GetFirstDayDateOfMonthTest {
    public static void main(String[] args) {


        Date date = getFirstDayDateOfMonth(new Date());

        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(date));

    }

    public static Date getFirstDayDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int last = cal.getActualMinimum(5);
        cal.set(5, last);
        return cal.getTime();
    }
}
