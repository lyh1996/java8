package singleton;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 单例的最简单写法  不加锁  将该类的构造函数定义为私有方法，这样其他处的代码就无法通过调用该类的构造函数来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例
 * @create 2019-05-24 8:31
 * @since 1.7
 */
public class Singleton3 {

    private static Singleton3 singleton3;

    private void Singleton3() {

    }

    public static Singleton3 getSingleton3() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }

}
