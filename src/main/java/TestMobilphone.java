import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-10-25 13:57
 * @since 1.7
 */
public class TestMobilphone {

    public static void main(String[] args) {
        Map<String, String> hashMap = Maps.newHashMap();
        System.out.println(new ArrayList<>(hashMap.values()));

    }

    //获取上月的开始时间
    public static Date getBeginDayOfLastMonth() {
        //开始时间 -- 上月一号
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        return startCalendar.getTime();
    }

    //获取上月的结束时间
    public static Date getEndDayOfLastMonth() {
        Calendar endcCalendar = Calendar.getInstance();
        endcCalendar.set(Calendar.DAY_OF_MONTH, 1);
        endcCalendar.add(Calendar.DATE, -1);
        return endcCalendar.getTime();
    }
}
