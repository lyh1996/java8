package jdk8;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2018-12-10 14:08
 * @since 1.7
 */
public class Java8Tester7 {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}

interface Vehicle {
    default void print() {
        System.out.println("我是一辆车！！");
    }

    static void blowHorn() {
        System.out.println("按喇叭！！");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车！！");
    }
}
