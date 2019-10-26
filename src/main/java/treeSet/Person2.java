package treeSet;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 12:00
 * @since 1.7
 */
public class Person2 implements Comparable<Person2> {
    private String name;
    private int age;
    @Override
    //按照年龄排序
    public int compareTo(Person2 o) {
        int num = this.age - o.age; //按照年龄比较 return num;     //return num == 0 ? this.name.compareTo(o.name) : num;//姓名是比较的次要条件
        return num;
    }
}
