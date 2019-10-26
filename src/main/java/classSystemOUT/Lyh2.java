package classSystemOUT;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-25 15:42
 * @since 1.7
 */
public class Lyh2 extends Lyh1 {

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类普通代码块");
    }


    Lyh2(){
        System.out.println("子类构造方法");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("子类普通方法");
    }
}
