package jdk8;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 直接在lambda表达式中访问外层的局部变量
 * @create 2018-12-10 9:29
 * @since 1.7
 */
public class Java8Tester4 {
    public static void main(String[] args) {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
    }
    public interface Converter<T1, T2> {
        void convert(int i);
    }
}
