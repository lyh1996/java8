package clone;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 深度克隆的案例也比较好理解，在深克隆中，无论原型对象的成员变量是值类型还是引用类型，都将复制一份给克隆对象，深克隆将原型对象的所有引用对象也复制一份给克隆对象。
 * @create 2019-09-20 14:36
 * @since 1.7
 */
public class DeepClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student();
        student1.setNumber(1234);
        student1.setAddress(new Address("广州"));
        Student student2 = (Student) student1.clone();
        student2.setNumber(4444);
        student1.setAddress(new Address("深圳"));
        System.out.println("学生1：" + student1.toString());
        System.out.println("学生2：" + student2.toString());
    }
}
