package JavaBase.singleton;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 饿汉模式
 * @create 2019-05-24 14:49
 * @since 1.7
 */
public class Singleton6 {

    private static Singleton6 singleton6 = new Singleton6();
    private Singleton6() {}

    public static Singleton6 getInstance() {
        return singleton6;
    }


    //第二种   饿汉变种
     /*   private  Singleton6 instance = null;
        static {
            instance = new Singleton6();
        }
        private Singleton6 (){}
        public static Singleton6 getInstance() {
            return this.instance;
        }*/
}
