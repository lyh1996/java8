package dubbo.dubboSPI;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-18 16:37
 * @since 1.7
 */
public class RebortImpl implements Rebort{
    @Override
    public void sayHello() {
        System.out.println("我这是第一个实现类");
    }
}
