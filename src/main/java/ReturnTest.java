/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-22 15:54
 * @since 1.7
 */
public class ReturnTest {

    public static void main(String[] args) {
        ReturnTest returnTest = new ReturnTest();
        System.out.println( returnTest.add() );
    }

    public int add() {
        int num = 0;
        try {
            num = 10/0;
        } catch (Exception e) {
            num = 5;
        }
        return num;
    }

}
