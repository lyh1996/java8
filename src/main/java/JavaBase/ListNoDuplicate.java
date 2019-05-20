package JavaBase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-19 14:25
 * @since 1.7
 */
public class ListNoDuplicate {
    public static void main(String[] args) {
        List<String> strList = Stream.of("1", "2","1").collect(Collectors.toList());

        //循环输出
        strList.forEach(System.out::println);

        System.out.println("去重后");
        //去重
        strList = strList.stream().distinct().collect(Collectors.toList());
        strList.forEach(System.out::println);
    }
}
