package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 11:55
 * @since 1.7
 */
public class Test_TreeSet {
    public static void main(String[] args) {
        //demo1();
        demo2();
    }
    private static void demo2() {
        // 需求:将字符串按照长度排序, （利用匿名内部类对象, 长度从大到小, 长度相同按照字母倒序）
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num = s2.length() - s1.length(); // 长度为主要条件
                return num == 0 ? s2.compareTo(s1) : num; // 内容为次要条件
            }
        });
        ts.add("aaaaaaaa");
        ts.add("z");
        ts.add("wc");
        ts.add("nba");
        ts.add("cba");
        System.out.println(ts);
    }
    private static void demo1() {
        // 需求:将字符串按照长度排序，（传递一个自定义的比较器对象）
        TreeSet<String> ts = new TreeSet<>(new CompareByLen()); // Comparator c = new CompareByLen();
        ts.add("aaaaaaaa");
        ts.add("z");
        ts.add("wc");
        ts.add("nba");
        ts.add("cba");
        System.out.println(ts);
    }
}
class CompareByLen /* extends Object */implements Comparator<String> {//实现一个比较器类
    @Override

    public int compare(String s1, String s2) { // 按照字符串的长度比较
        int num = s1.length() - s2.length(); // 长度为主要条件
        return num == 0 ? s1.compareTo(s2) : num; // 内容为次要条件
    }
}

