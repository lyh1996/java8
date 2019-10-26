package treeSet;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 11:14
 * @since 1.7
 */
//为了简化代码，这里没有hashCode和equals方法，用的话可以直接将上面的Person类中的hashCode和equals复制过来
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    public Person() {
        super();

    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]\n";
    }
    @Override
    public int compareTo(Person o) {
        //return 0;
        //return 1;
        return -1;
    }

}
