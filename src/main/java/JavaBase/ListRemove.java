package JavaBase;

import java.util.ArrayList;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-01-11 10:19
 * @since 1.7
 */
public class ListRemove {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("r");
        list.add("a");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("t");
        list.add("a");

        //方法一：
        /*for (int i=0; i<list.size(); i++) {
            if ("a".equals(list.get(i))) {
                list.remove(i);
                i--;
            }
        }*/

      //方法三
       /* Iterator<String> stringIterable =list.iterator();
        while (stringIterable.hasNext()) {
            if ("a".equals(stringIterable.next())) {
                stringIterable.remove();
            }
        }*/



      //方法二:
        //list.removeIf(s -> s.contains("a"));

        //方法四
       /* for (int i=list.size()-1; i>=0; i--) {
            if ("a".equals(list.get(i))) {
                list.remove(i);
            }
        }*/

        for (String listStr : list) {
            System.out.println(listStr);

        }

    }

}
