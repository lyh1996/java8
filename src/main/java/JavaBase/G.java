package JavaBase;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-03-11 16:56
 * @since 1.7
 */
public class G {
    public static void main(String[] args) {
        //new JavaBase.De();
        Base a = new Base();
    }
}

class Base {
    private int i = 2;

    public Base() {
        this.display();
    }
    private void display() {
        System.out.println(i);
    }
}

class De extends Base {
    private int i = 22;
    public De(){
        this.i = 222;
    }
    public void display() {
        System.out.println(i+"——————————");
    }
}
