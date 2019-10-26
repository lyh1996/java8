package testMap;

import JavaBase.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-11 15:21
 * @since 1.7
 */
public class MapListTest {
    public static void main(String[] args) {

        Map<String, User> map = new TreeMap();

        User user1 = new User("1", "lyh1", 12);
        User user2 = new User("2", "lyh2", 12);
        map.put("user1", user1);
        map.put("user2", user2);
        //map转List
        List<User> list = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue).collect(Collectors.toList());

        list.forEach(System.out::println);

        //list转map
        Map<String, Object> map2 = list.stream().collect(Collectors.toMap(User::getUid, a -> a,(k1, k2)->k1));

        map2.forEach((k, v) -> System.out.println("键" + k +"值" + v ));
       /* List<JavaBase.Student> list2 = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .map(e -> new JavaBase.Student(e.getKey(), e.getValue())).collect(Collectors.toList());

        List<JavaBase.Student> list3 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(e -> new JavaBase.Student(e.getKey(), e.getValue())).collect(Collectors.toList());*/
    }


}
