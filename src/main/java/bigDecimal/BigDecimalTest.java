package bigDecimal;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-04-18 9:30
 * @since 1.7
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        Double a = 12.5;
        Double b = 5.5;
        double c = 5.05;
        double c2 = 1.01;

        //测试减法
        System.out.println(c-c2);
        //测试除法
        System.out.println(c2/c);

        //测试加法
        System.out.println(a+b);
        System.out.println(new BigDecimal("0.2"));
        System.out.println(0.3 - 0.1);
        BigDecimal num1 = new BigDecimal("5");
        BigDecimal num2 = new BigDecimal("5");

        //加法
        BigDecimal num3 = num1.add(num2);
        System.out.println(num3);

        //比较大小
        if (num1.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("小于0");
        }
        if (num1.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("大于0");
        }
        if (num1.compareTo(BigDecimal.ZERO)==0) {
            System.out.println("等于0");
        }
        if (num1.compareTo(new BigDecimal(Double.toString(c)))==0) {
            System.out.println("c和num比较等于0");
        }
        BigDecimal pp1 = new BigDecimal("1");
        BigDecimal pp2 = new BigDecimal("3");

        // 乘法
        BigDecimal pp3 =  (pp1.multiply(pp2));
        System.out.println(pp3 + "%");
        // 除法
        BigDecimal pp4 = pp1.divide(pp3, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("除数为："+pp4);
    }
}
