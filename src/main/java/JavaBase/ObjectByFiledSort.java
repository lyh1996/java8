package JavaBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对象根据属性排序
 * @create 2019-02-21 11:49
 * @since 1.7
 */
public class ObjectByFiledSort {
    public static void main(String[] args) {

        //构造user对象
        User user1 = new User("1", "lyh",21);

        User user2 = new User("2", "abc",18);

        List<User> list = new ArrayList<User>();

        list.add(user1);
        list.add(user2);

        list.forEach(System.out::println);

        //方法一 根据年龄进行排序

       List<User> sortList =  list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        //打印
        sortList.forEach(System.out::println);

        //方法二  根据年龄进行排序
        Collections.sort(list, (Comparator) (o1, o2) -> {
            User u1 = (User) o1;
            User u2 = (User) o2;
            return u1.getAge().compareTo(u2.getAge());
        });

        //打印
        list.forEach(System.out::println);

    }
}
