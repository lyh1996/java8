package list;

import JavaBase.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 两个同样的List的操作，补全另一个list对象的信息
 * @create 2019-04-23 8:02
 * @since 1.7
 */
public class TwoListOperate {
    public static void main(String[] args) {

        List<User> list1 = new ArrayList<User>(){{
            add(new User("1", "lyh1",18));
            add(new User("2", "lyh2",19));
            add(new User("3", "lyh3",20));
        }};

        List<User> list2 = new ArrayList<>();
        User user = new User();
        user.setUid("1");
        user.setAge(20);
        list2.add(user);


        //输出
        list1.forEach(System.out::println);
        System.out.println("--------------分割线---------------");
        list2.forEach(System.out::println);

        //根据uid补全list2中的对象信息
       for (JavaBase.User listUser : list2) {
            String uid1 = listUser.getUid();
            Optional<User> optStu = list1.stream().filter(user1 -> user1.getUid().equals(uid1)).findFirst();
            listUser.setName(optStu.get().getName());
            }



        System.out.println("处理后结果：");
        //list1.forEach(System.out::println);
        System.out.println("--------------分割线---------------");
        list2.forEach(System.out::println);
    }
}
