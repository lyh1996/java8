package Exception;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-24 8:16
 * @since 1.7
 */
public class Test {
    public static void main(String[] args) {
        try {
            Method1();

        }catch (MyException e) {
            System.out.println("进入自定义异常");
            System.out.println(e.getMessage());
        }catch (MyException2 e) {
            System.out.println("123");
        }catch (Exception e) {
            System.out.println("Exception异常");
        }
    }
    public static void Method1() {
        try{
            int i = 10/0;
        } catch (Exception e){
            System.out.println("进入异常方法");
            throw new MyException();
        }

    }
}
