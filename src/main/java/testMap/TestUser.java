package testMap;

import JavaBase.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-24 18:43
 * @since 1.7
 */
public class TestUser {
    public static void main(String[] args) {
        User user = User.builder().age(12).name("lyh").build();
        User user2 = User.builder().age(11).build();
        User user4 = User.builder().age(13).build();
        User user3 = User.builder().age(12).name("lyh").build();
        User user5 = User.builder().age(13).build();
        User user6 = User.builder().age(16).build();

        List<User> list = Stream.of(user, user2, user3, user4, user5, user6).collect(Collectors.toList());

        list.forEach(System.out::println);


        //变成分组MAP
        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getAge));
        map.forEach((k,v) -> {
            System.out.println("键：" + k);
            System.out.println("值：" + v);
        });

        //特殊使用
        Map<Boolean, List<User>> isMap = list.stream().collect(Collectors.partitioningBy(u -> u.getAge() > 12  ));

        isMap.forEach((k,v) -> {
            System.out.println("键：" + k);
            System.out.println("值：" + v);
        });
        Set<Integer> set = getAllagesSET(list);
        set.forEach(System.out::println);



    }

    public static List<Integer> getAllages(List<User>userlist){
        return  userlist.stream().map(user -> user.getAge()).collect(Collectors.toList());
    }

    public static Set<Integer> getAllagesSET(List<User>userlist){
        return  userlist.stream().map(user -> user.getAge()).collect(Collectors.toSet());
    }

    public static Map<Integer,String> getUser2Map(List<User>userlist){

        return userlist.stream().collect(Collectors.toMap(User::getAge,User::getName));
    }

    public static Map<Integer,User> getUser2MapUser(List<User>userlist){

        return userlist.stream().collect(Collectors.toMap(User::getAge,User-> User));
    }

    /**
     * 比较优雅的写法是这样的
     * @param userlist
     * @return
     */
    public static Map<Integer,User> getUser2MapUser2(List<User>userlist){

        return userlist.stream().collect(Collectors.toMap(User::getAge, User -> User));
    }

    /**
     * 重复key的情况下 简单的使用后者覆盖前者的
     */
    public static Map<Integer,User> getUser2MapUser3(List<User>userlist){

        return userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity(),(key1,key2)->key2));
    }

    /**
     *指定map的具体实现
     * @param userlist
     * @return
     */
    public static Map<Integer,User> getUser2MapUser4(List<User>userlist){

        return userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity(),(key1,key2)->key2, LinkedHashMap::new));
    }

}
