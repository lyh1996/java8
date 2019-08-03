package singleton;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 懒汉模式  锁的粒度太大
 * @create 2019-05-24 14:40
 * @since 1.7
 */
public class Singleton4 {
    private static Singleton4 singleton4;
    private void Singleton4() {}

    public static synchronized Singleton4 getInstance() {
        if (singleton4 == null) {
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}
