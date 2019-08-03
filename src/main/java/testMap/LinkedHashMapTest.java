package testMap;

import java.util.LinkedHashMap;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description LinkedHashMap测试
 * @create 2019-04-15 16:17
 * @since 1.7
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        String abc = " abc   abc   ";

        System.out.println(abc.trim().length());
        String str = abc.replaceAll(" ", "").trim();

        System.out.println(str.length());

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1","3");
        linkedHashMap.put("3","4");
        linkedHashMap.put("2","5");

        linkedHashMap.forEach((k, v) -> System.out.println("键" + k +"值" + v ));
    }
}
