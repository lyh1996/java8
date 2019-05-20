import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 时间工具类
 * @create 2019-05-14 19:05
 * @since 1.7
 */
public class TimeUtil {

    private static final String LONG_PATTERN="yyyy-MM-dd HH:mm:ss";
    private static final String SHORT_PATTERN="yyyy-MM-dd";

    /**
     * 将日期转换为字符串
     */
    public static String parse( Date d, String pattern){
        DateFormat df=null;
        if( pattern!=null && !"".equals(pattern) ){
            df=new SimpleDateFormat(pattern);
        }else{
            df=new SimpleDateFormat(LONG_PATTERN);
        }
        return df.format( d );
    }

    /**
     * 将字符串转为日期
     */
    public static Date parseStringToDate(String str, String pattern){
        DateFormat df = null;
        if( pattern!=null && !"".equals(pattern) ){
            df=new SimpleDateFormat( pattern );
        }else{
            df=new SimpleDateFormat( LONG_PATTERN );
        }
        Date d=null;
        try {
            d=df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;

    }
    /**
     * 判断给定时间与当前时间相差多少天
     */
    public static long getDistanceDays(String date) {
        DateFormat df = new SimpleDateFormat(SHORT_PATTERN);
        long days = 0;
        try {
            //String转Date
            Date time = df.parse(date);
            //获取当前时间
            Date now = new Date();
            long time1 = time.getTime();
            long time2 = now.getTime();
            long diff = time1 - time2;
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //正数表示在当前时间之后，负数表示在当前时间之前
        return days;
    }

    /**
     * 判断time是否在from，to之内
     * @param time 指定日期
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }
}
