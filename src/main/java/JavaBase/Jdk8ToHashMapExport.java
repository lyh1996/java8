package JavaBase;

import java.util.HashMap;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-03-12 14:49
 * @since 1.7
 */
public class Jdk8ToHashMapExport {
    public static void main(String[] args) {

        boolean a = true;

        if (a) {
            System.out.println(1122);
        }
        System.out.println(a);

        HashMap<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");

        map.forEach((k, v) -> System.out.println("键" + k +"值" + v ));

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
    }

}
