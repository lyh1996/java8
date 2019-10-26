package clone;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-20 15:05
 * @since 1.7
 */
public class Test {
    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.setNumber(1234);
        Student1 student2 = student1;
        student2.setNumber(4444);
        System.out.println("学生1：" + student1.getNumber());
        System.out.println("学生2：" + student2.getNumber());
    }
}
