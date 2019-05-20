package JavaBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-03-12 8:55
 * @since 1.7
 */
public class ListToRemoveTest {

    public static final int ABC = Integer.MAX_VALUE;
    public static final int ABCD = ABC - 2;
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<String>(){
            {add("a");
            add("b");
            add("c");
            add("a");
            add("a");
            add("d");
            }};

        /*for (int i =0; i < list.size(); i++) {
            if ("a".equals(list.get(i))) {
                list.remove(i);
            }
        }*/
        //移除元素法一
        //list = list.stream().filters -> !"a".equals(s)).collect(Collectors.toList());

        //移除元素法二
        //list.removeIf(s -> "a".equals(s));

        //移除元素法三
        /*for (int i = list.size()-1; i >= 0; i--) {
            if ("a".equals(list.get(i))) {
                list.remove(i);
            }
        }*/
       /* for (int i = 0; i < list.size(); i++) {
            if ("a".equals(list.get(i))) {
                list.remove(i);
                i--;
            }
        }*/

        //移除元素法四
       /* Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            if ("a".equals(iterator.next())) {
                iterator.remove();
            }
        }*/

        //移除元素法四
        /*直接使用
        ConcurrentLinkedDeque来创建数组可以直接使用for循环*/

        //移除元素法五

        /*for (String str : list) {
            if ("a".equals(str)) {
                list.remove(str);
                break;
            }
        }*/
       /* int count = 0;
        for(int i =ABCD ;i <= ABC; i++) {
            count++;
        }*/
           // System.out.println(count);
       // System.out.println(list);

        /*Integer total = 0;
        check(total);
        System.out.println(total);*/

        StringBuffer A = new StringBuffer("A");
        StringBuffer B = new StringBuffer("B");
        opera(A,B);
        System.out.println("---"+A +  " =====" +B);

        String C = "C";
        String D = "D";
        opera2(C,D);
        System.out.println("---"+C +  " =====" +D);


    }

    private static void opera2(String c, String d) {
        c+=d;
        d = c;
    }

    private static void opera(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }


   /* private static void check(Integer total) {
        if (total < 1)  {
            total +=1;
        }
    }*/
}
