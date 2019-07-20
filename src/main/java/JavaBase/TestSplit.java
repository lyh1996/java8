package JavaBase;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-20 8:33
 * @since 1.7
 */
public class TestSplit {
    public static void main(String[] args) {
        //字符串转list<String>
        String str = "测试1,测试2，测试3，测试4";
        //此处为了将字符串中的空格去除做了一下操作
        List<String> list = Arrays.asList(str.split(",")).stream().map(s -> (s.trim())).collect(Collectors.toList());
        //list<String>转字符串（以逗号隔开）
        System.out.println(String.join(",", list));

        List<User> list1 = new ArrayList<>();

        User user = new User();
        user.setName("a");
        user.setAge(2);
        User user2 = new User();
        user2.setName("a");

        //list1.add(user);
        list1.add(user2);

        String names = list1.stream().map(JSON::toJSONString).collect(Collectors.joining("|"));
        System.out.println(names);

        List<String> list3 = Arrays.stream(names.split("\\|")).map(String::trim).collect(Collectors.toList());

        List<User> userList = Lists.newArrayList();
        list3.forEach(s -> {
            User user1 = JsonUtil.parseObject(s, User.class);
            userList.add(user1);
        });
        userList.add(user);
        userList.forEach(System.out::println);
        System.out.println(list3);


    }
}
