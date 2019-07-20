package JavaBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 两个List对象直接使用=赋值的问题
 * @create 2019-03-6 15:03
 * @since 1.7
 */
public class ListInitTest {
    public static void main(String[] args) {
        List list1 ;
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list1 = list2;

        list1.add(1);
        //System.out.println(list1);
        System.out.println(list2);
        list1.stream().forEach(System.out::println);

        String[] a = {"a","b"};
        List<String> str = Stream.of(a).collect(Collectors.toList());
        str.add("c");

         str.forEach(System.out::println);

        System.out.println("---------------分割线----------------");
        String[] b = {"a","b"};
        List<String> str1 = Arrays.asList(b);
        str1.add("c");

        str1.forEach(System.out::println);



    }
}
