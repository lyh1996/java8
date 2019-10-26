package treeSet;

import java.util.TreeSet;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 11:52
 * @since 1.7
 */
public class Demo3_TreeSet2 {
    /**
     * @param args
     * TreeSet集合是用来对象元素进行排序的,同样他也可以保证元素的唯一
     * 当compareTo方法返回0的时候集合中只有一个元素
     * 当compareTo方法返回正数的时候集合会怎么存就怎么取
     * 当compareTo方法返回负数的时候集合会倒序存储
     */
    public static void main(String[] args) {
        demo2();
    }
    public static void demo2() {
        //因为TreeSet要对元素进行排序，那你排序的依据是什么，姓名还是年龄还是其它的，得告诉它，怎么告诉?
        //需要让Person类实现Comparable接口重写compareTo方法
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));

        System.out.println(ts);
    }
}
