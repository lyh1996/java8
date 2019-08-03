package singleton;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 双重校验锁的实现方式，静态成员变量singleton必须通过volatile来修饰，保证其初始化不被重排，否则可能被引用到一个未初始化完成的对象。
 * @create 2019-05-24 14:46
 * @since 1.7
 */
public class Singleton5 {

    private volatile static Singleton5 singleton5;
    private Singleton5 (){}

    public static Singleton5 getSingleton() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                if (singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }
}
