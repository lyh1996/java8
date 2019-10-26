package clone;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 浅克隆  什么是浅度克隆？说白了就是在进行对象克隆的时候，没有对引用类型的成员变量进行复制。
 * @create 2019-09-20 14:25
 * @since 1.7
 */
public class ShallowClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student();
        student1.setNumber(1234);
        Student student2 = (Student) student1.clone();
        student2.setNumber(4444);
        System.out.println("学生1：" + student1.getNumber());
        System.out.println("学生2：" + student2.getNumber());


    }
}
