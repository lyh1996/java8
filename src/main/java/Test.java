import JavaBase.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-17 14:47
 * @since 1.7
 */
public class Test {

    public static void main(String[] args) {

        User user1 = new User("1", "lyh1", 21);

        Map<String, User> map = new HashMap<>();

        map.put(user1.getUid(), user1);

        List<User> list = new ArrayList<>();
        list.add(map.get("1"));

        list.forEach(user -> user.setName("hello"));

        list.forEach(System.out::println);

        map.forEach((K, V) -> System.out.printf("值---》%s", V));

    }
}
