package testSET;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 8:41
 * @since 1.7
 */
public class TestToString {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        // 循环遍历

       Iterator<Integer> integers = set.iterator();
       while(integers.hasNext()) {
           int num = (int) ((Iterator) integers).next();
           if (num==2) {
               integers.remove();
           }
       }

       for (Integer in :set) {
           System.out.println(in);
          /* if (in==3) {
               integers.remove();
               break;
           }*/
       }

        System.out.println(set);
    }
}
