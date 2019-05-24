
import java.util.Calendar;
import java.util.Date;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-14 19:21
 * @since 1.7
 */
public class TimeTEst {
    public static void main(String[] args) {
        //创建时间  2018-10-18 09:25:30
        Date createTime = TimeUtil.parseStringToDate("2016-05-17 00:00:00", null);
        System.out.println(createTime.after(new Date()));
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.add(Calendar.DATE, +Integer.parseInt("3"));
        //倒计时结束后的时间
        Date scrap_year = date.getTime();
        System.out.println("三年后时间" + scrap_year);
        //判断是否在倒计时年之内
        Boolean is_scrap_year = TimeUtil.belongCalendar(new Date(), createTime, scrap_year);

        if(is_scrap_year) {
            //判断给定时间与当前时间相差多少天
            Date now = new Date();
            long time1 = scrap_year.getTime();
            long time2 = now.getTime();
            long diff = time1 - time2;
            long days = diff / (1000 * 60 * 60 * 24);
            System.out.println("期限" + days);
            if (days <= Integer.parseInt("14")) {
                System.out.println("快到期限" + days);
            }
        } else {
            //超过年限
            System.out.println("超过年限");
        }

        //时间戳测试
        long time1 = System.currentTimeMillis();
        long time2 = TimeUtil.parseStringToDate("2019-05-17 00:00:00", null).getTime();
        long days = time1 - time2;
        long day = days / (1000 * 60 * 60 * 24);
        System.out.println("sssss" +day);


        Date date1 = new Date();
        //获取达到报废年限后的日期
        //Calendar date = Calendar.getInstance();
        date.setTime(date1);
        // 将时分秒,毫秒域清零
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        //得到清0后的创建时间
        date1 = date.getTime();
        System.out.println(date1);
        date.setTime(new Date());
        date.add(Calendar.YEAR, -Integer.parseInt("3"));
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        Date scrapYear = date.getTime();
        System.out.println(scrapYear);

        long dayss = TimeUtil.getDistanceDays(scrapYear);
        System.out.println(dayss);

        
    }
}
