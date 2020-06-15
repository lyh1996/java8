package list;

import JavaBase.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description Jdk8编程对List对象数组拆分和合并
 * @create 2019-02-27 7:52
 * @since 1.7
 */
public class ListObjectSplit {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();

        List<User> list1 = new ArrayList<>();

        List<User> list2 = new ArrayList<>();

        User user1 = new User("1", "lyh1", 21, 1.0);

        User user2 = new User("2", "lyh2", 21, 1.0);
        User user3 = new User("2", "lyh2", 22, 1.0);

        list1.add(user1);

        list2.add(user2);

        list2.add(user3);

        list.addAll(list1);
        list.addAll(list2);

        //list.forEach(System.out::println);

        List<User> userList1 = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();

        userList1 = list.stream().filter(User -> User.getName().equals("lyh1")&& "2".equals(User.getUid())).collect(Collectors.toList());
        userList1.forEach(System.out::println);
        System.out.println("-----------------------------");
        userList2 = list.stream().filter(User -> User.getName().equals("lyh2")&& "2".equals(User.getUid())).collect(Collectors.toList());
        userList2.forEach(System.out::println);
        System.out.println("-----------------------------");
        List<User> list3 = new ArrayList<>();

        //list3 = userList1.stream().collect(Collectors.joining(userList2));
        //list3.stream().flatMap(Function.identity())
        list3 = Stream.of(userList1.stream(), userList2.stream()).flatMap(Function.identity()).collect(Collectors.toList());

        list3.forEach(System.out::println);


    }
}
