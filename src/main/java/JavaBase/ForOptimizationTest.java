package JavaBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-02 20:37
 * @since 1.7
 */
public class ForOptimizationTest {

    public static void main(String[] args) {


        List<User> list1 = new ArrayList<>();



        List<User> list2 = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i =0 ; i< 5000; i++){
            User user = User.builder().name("lyh"+i).age(12 + i).build();

            list1.add(user);
        }

        for (int i =0 ; i< 5000; i++) {

            User user2 = User.builder().age(12 + i).build();

            list2.add(user2);
        }

        //方法一
        /*for (Student us : list1 ) {

            for(Student user : list2) {
                if (user.getAge() == us.getAge()) {
                    user.setName(us.getName());
                }
            }
        }*/

        //方法二
        /*for(int i =0 ; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).getAge().equals(list2.get(j).getAge())) {
                    list2.get(j).setName(list1.get(i).getName());
                }
            }
        }*/

        //方法三
        /*int i, j, leni, lenj;
        for( i =0 , leni = list1.size(); i < leni; i++) {
            for ( j = 0, lenj = list2.size(); j < lenj; j++) {
                if (list1.get(i).getAge().equals(list2.get(j).getAge())) {
                    list2.get(j).setName(list1.get(i).getName());
                }
            }
        }*/

        //方法四
        /*Map<Integer, Student> map = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i).getAge(), list1.get(i));
        }

        for (int j =0; j < list2.size(); j ++) {
            //Map<Student, Integer> map1 = new HashMap<>();
            //map1.put(list2.get(j), list2.get(j).getAge());

            if (map.get(list2.get(j).getAge()) != null) {
                list2.get(j).setName( map.get(list2.get(j).getAge()).getName() );
            }
        }*/

        //方法五
        Map<Integer, User> map = list1.stream().collect(Collectors.toMap(User::getAge, Function.identity() , (key1, key2) -> key2));

        list2 = list2.stream().map(user -> {
            Integer age = user.getAge();
            User user1 = map.get(age);
            user.setName(user1.getName());
            return user;
        }).collect(Collectors.toList());

        list1.addAll(list2);

        list1.forEach(System.out::println);

        System.out.println(list1.size());

        System.out.println(System.currentTimeMillis() - start);


    }
}
