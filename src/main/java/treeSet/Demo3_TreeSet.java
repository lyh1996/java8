package treeSet;

import java.util.TreeSet;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 11:51
 * @since 1.7
 */
public class Demo3_TreeSet {
    /**
     * @param args
     * TreeSet集合是用来对象元素进行排序的,同样他也可以保证元素的唯一
     */
    public static void main(String[] args) {
        demo1();
    }
    public static void demo1() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(1);
        ts.add(1);
        ts.add(2);
        ts.add(2);
        ts.add(3);
        ts.add(3);
        System.out.println("TreeSet存储Integer类型的元素: " + ts);
    }
}
