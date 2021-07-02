package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-20 11:11
 * @since 1.7
 */
public class SplitUser {
    public static void main(String[] args) {/*
        User user = User.builder().age(12).name("lyh").build();
        User user2 = User.builder().age(11).build();
        User user4 = User.builder().age(13).build();
        User user3 = User.builder().age(12).name("lyh").build();
        User user5 = User.builder().age(13).build();
        User user6 = User.builder().age(16).build();

        List<User> list = Stream.of(user, user2, user4).collect(Collectors.toList());
        List<User> list2 = Stream.of(user3, user5, user6).collect(Collectors.toList());

        *//*list.forEach(System.out::println);
        list2.forEach(System.out::println);*//*

        list2.forEach(s -> {
            list.removeIf(entity -> entity.getAge().equals(s.getAge()));
        });
        //list.forEach(System.out::println);
        //list2.forEach(System.out::println);

        List<User> list3 = Stream.of(list.stream(), list2.stream()).flatMap(Function.identity()).collect(Collectors.toList());

        list3.forEach(System.out::println);

        String str= "a|b|c";

        String[] strlist = str.split("\\|", 1);
        for (int i =0 ;i < strlist.length; i++) {
            System.out.println(strlist[i]);
        }


        System.out.println("---------------分割线------------------");
        List<User> listuser = Stream.of(user, user3).collect(Collectors.toList());

        List<User> aa = listuser.stream().distinct().collect(Collectors.toList());

        aa.forEach(System.out::println);


        listuser = listuser.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));
        listuser.forEach(System.out::println);

*/

    }
}
