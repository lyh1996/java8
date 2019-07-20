package testMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-06 12:17
 * @since 1.7
 */
public class TestCompare {

    public static void main(String[] args) {
        C c = new C();
        c.setAge(12);
        C c2 = new C();
        c2.setAge(8);

        List<C> list = Stream.of(c, c2).collect(Collectors.toList());

        B b = new B();
        b.setId("12");
        b.setList(list);
        B b2 = new B();
        b2.setId("2");
        b2.setList(list);

        List<B> list2 = Stream.of(b, b2).collect(Collectors.toList());

        list2.forEach(System.out::println);


        List<Integer> ss = list2.stream().flatMap(tag -> tag.getList().stream())
                .collect(Collectors.collectingAndThen(
                        Collectors
                        .groupingBy(C::getAge,Collectors.toSet()),
                        strMap -> strMap
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Set<C>>comparingByKey().reversed())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList())
                ));

        ss.forEach(System.out::println);

        int a = 5;

        System.out.println(a ==0 ? 1 : a==2 ? 3 :4);

    }
}
