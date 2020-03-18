package classSystemOUT;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-25 15:44
 * @since 1.7
 */
public class Test {

    public static void main(String[] args) {
        Lyh2 lyh2 = new Lyh2();
        lyh2.run();

        System.out.println("-----------------");

        //Lyh2 lyh21 = new Lyh2();
        // 父类的静态代码块---》  子类的静态代码块---》 父类普通代码块---》 父类构造方法---》子类普通代码块---》 子类构造方法---》子类普通方法
    }
}
