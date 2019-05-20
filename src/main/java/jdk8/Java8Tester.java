package jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2018-12-07 9:39
 * @since 1.7
 */
public class Java8Tester {
    public static void main(String[] args) {

        List<String> name1 = new ArrayList<String>();
        name1.add("Google ");
        name1.add("Runoob ");
        name1.add("Taobao ");
        name1.add("Baidu ");
        name1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Tester tester = new Java8Tester();

        System.out.println("使用Java7语法");
        tester.sortUsingJava7(name1);
        System.out.println(name1);

        System.out.println("使用Java8语法");
        tester.sortUsingJava8(names2);
        System.out.println(names2);

     }



    /**
     * @description:
     * @method:   sortUsingJava7
     * @author:   633805  LYh
     * @version:
     * @see     对类、属性、方法的说明 参考转向
     * @param name1
     * @return: void
     * @exception:
     * @date: 2018/12/7 9:44
     */
    private void sortUsingJava7(List<String> name1) {
        Collections.sort(name1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    /**
     * @description:
     * @method:   sortUsingJava8
     * @author:   633805  LYh
     * @version:
     * @see     对类、属性、方法的说明 参考转向
     * @param names2
     * @return: void
     * @exception:
     * @date: 2018/12/7 9:45
     */
    private void sortUsingJava8(List<String> names2) {
        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
    }
    
}
