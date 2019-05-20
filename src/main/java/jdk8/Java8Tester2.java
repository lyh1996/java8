package jdk8;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2018-12-10 9:03
 * @since 1.7
 */
public class Java8Tester2 {
    public static void main(String args[]) {

        Java8Tester2 tester2 = new Java8Tester2();

        //类型声明
        MathOperation addition = (int a, int b) -> a + b;

        //不用类型声明
        MathOperation subtraction = (a, b) -> a -b;

        //大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {return a * b; };

        //没有大括号及返回语句
        MathOperation division = (int a, int b) -> a/b;

        System.out.println("10 + 5 = " + tester2.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester2.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester2.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester2.operate(10, 5, division));

        //不用括号
        GreetingService greetingService = message ->
                System.out.println("Hello" + message);

        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello" + message);

        greetingService.sayMessage("Runoob");
        greetingService2.sayMessage("Google");

    }
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}


