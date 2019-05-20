package jdk8;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2018-12-10 9:22
 * @since 1.7
 */
public class Java8Tester3 {
    final static String salutation = "Hello!";
    public static void main(String [] args) {
        GreetingService greetingService = message ->
                System.out.print(salutation + message);
        greetingService.sayMessage("Runoob");

    }

    interface GreetingService {
        void sayMessage(String message);
    }
}
