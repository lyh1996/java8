package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2018-12-10 9:39
 * @since 1.7
 */

public class Java8Tester5 {

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Java8Tester5 create(final Supplier<Java8Tester5> supplier) {
        return supplier.get();
    }

    public static void collide(final Java8Tester5 java8Tester5) {
        System.out.println("Collided  " + java8Tester5.toString());
    }
    public void follow(final Java8Tester5 another) {
        System.out.println("Following the "+ another.toString());
    }

    public void repair() {
        System.out.println("Repaired  "+this.toString());
    }



    public static void main(String[] args) {
        //构造器的引用 它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final Java8Tester5 java8Tester5 = Java8Tester5.create(Java8Tester5 :: new);
        final List<Java8Tester5> java8Tester5s = Arrays.asList(java8Tester5);

        //静态方法的引用 它的语法是Class::static_method，实例如下：
        java8Tester5s.forEach(Java8Tester5 :: collide);

        //特定类的任意对象的方法的引用 它的语法是Class::method实例如下：
        java8Tester5s.forEach(Java8Tester5 :: repair);

        //特定对象方法的引用 它的语法是instance::method实例如下：
        final Java8Tester5 police = Java8Tester5.create(Java8Tester5 :: new);
        java8Tester5s.forEach(police :: follow );
    }

}
