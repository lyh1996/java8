package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-28 14:12
 * @since 1.7
 */
public class AddAllTest {

    public static void main(String[] args) {

/*
        User user = User.builder().name("lyh").build();
        User user2 = User.builder().name("lyh2").build();

        List<User> moreUser = Lists.newArrayList();
        List<User> moreUser2 = Lists.newArrayList();
        for (int i =0; i < 1000000; i++) {
            moreUser.add(user);
            moreUser2.add(user2);
        }



        Long start = System.currentTimeMillis();

        System.out.println("Stream    测试");

        List<User> moreUser3 ;

        moreUser3 = Stream.of(moreUser.stream(), moreUser2.stream()).flatMap(Function.identity()).collect(Collectors.toList());

        System.out.println("大小" + moreUser3.size());

        System.out.println(System.currentTimeMillis() - start);


        Long start2 = System.currentTimeMillis();

        System.out.println("AddAll    测试");

        moreUser.addAll(moreUser2);

        System.out.println("大小" + moreUser.size());

        System.out.println(System.currentTimeMillis() - start2);
*/


/*
        List<Student> userList = Stream.of(user).collect(Collectors.toList());
        List<Student> userList2 = Stream.of(user).collect(Collectors.toList());

       // userList.addAll(userList2);
        userList = Stream.of(userList.stream(), userList2.stream()).flatMap(Function.identity()).distinct().collect(Collectors.toList());;


        userList.forEach(System.out::println);*/
    }
}
