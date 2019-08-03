package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-03 15:40
 * @since 1.7
 */
public class SubList {
    public static void main(String[] args) {
        List<String> sourceList = new ArrayList<String>() {{
            add("H");
            add("O");
            add("L");
            add("L");
            add("I");
            add("S");
        }};

        List subList = sourceList.subList(2, 5);

        System.out.println("sourceList ： " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到List ：");
        System.out.println("subList ： " + subList);

        sourceList.add("666");

        System.out.println("sourceList.add(666) 得到List ：");
        System.out.println("sourceList ： " + sourceList);
        System.out.println("subList ： " + subList);
        System.out.println("sourceList ： " + sourceList);
    }
}
