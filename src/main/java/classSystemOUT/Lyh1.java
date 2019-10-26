package classSystemOUT;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-25 15:38
 * @since 1.7
 */
public class Lyh1 {
    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类普通代码块");
    }


    public Lyh1() {
        System.out.println("父类构造方法");
    };


    public void run() {
        System.out.println("父类普通方法");
    }
}
