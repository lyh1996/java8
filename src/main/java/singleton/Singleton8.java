package singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 633805 CAS（AtomicReference）实现单例模式
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-24 15:01
 * @since 1.7
 */
public class Singleton8 {
    private static final AtomicReference<Singleton8> INSTANCE = new AtomicReference<Singleton8>();

    private Singleton8() {}

    public static Singleton8 getInstance() {
        for (;;) {
            Singleton8 singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new Singleton8();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
