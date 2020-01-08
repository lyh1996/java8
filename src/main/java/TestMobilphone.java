import JavaBase.User;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-10-25 13:57
 * @since 1.7
 */
public class TestMobilphone {

    public static void main(String[] args) {
      /*  String str = "15874716591";
        str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str);

        String string = "1";
        List<Integer> list = Arrays.stream(string.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        System.out.println(list);*/
        /*System.out.println(DateUtil.lastMonth());

        User u = new User();
        u.setName("");
        if (StringUtils.isNotBlank(u.getName())) {
            System.out.println("哈哈哈");
        }
        List<User> list = Lists.newArrayList();*/
        Date time = DateUtil.offsetDay(new DateTime(), -30);
        System.out.println( DateUtil.format(time, "yyyy-MM-dd") );
        System.out.println( DateUtil.format(getBeginDayOfLastMonth(), "yyyy-MM-dd"));
        System.out.println( DateUtil.format(getEndDayOfLastMonth(), "yyyy-MM-dd"));

        User user = new User();
        System.out.println(user==null);

        Integer a = null;
        Integer b = 12;
        System.out.println(b.equals(a));

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
