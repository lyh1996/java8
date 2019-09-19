package dubbo.dubboSPI;

import java.util.ServiceLoader;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-18 16:39
 * @since 1.7
 */
public class TestSPi {
    public static void main(String[] args) {
        ServiceLoader<Rebort> serviceLoader = ServiceLoader.load(Rebort.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Rebort::sayHello);

    }
}
