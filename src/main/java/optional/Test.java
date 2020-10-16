/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-10-16 14:48
 */
package optional;

/**
 * @author LYH
 * @date 2020/10/16 14:48
 */
public class Test {
    public static void main(String[] args) {

        Clazz1 axin = new Clazz1();

        Clazz2 clazz2 = new Clazz2();

        axin.setClazz2(clazz2);

        clazz2.setAddress("hahh");

        // 1. 基本调用

        String value1 = OptionalBean.ofNullable(axin)

                .getBean(Clazz1::getClazz2)

                .getBean(Clazz2::getAddress).get();

        System.out.println(value1);

        // 2. 扩展的 isPresent方法 用法与 Optional 一样

       /* boolean present = OptionalBean.ofNullable(axin)

                .getBean(User::getSchool)

                .getBean(User.School::getAdress).isPresent();

        System.out.println(present);

        // 3. 扩展的 ifPresent 方法

        OptionalBean.ofNullable(axin)

                .getBean(User::getSchool)

                .getBean(User.School::getAdress)

                .ifPresent(adress -> System.out.println(String.format("地址存在:%s", adress)));

        // 4. 扩展的 orElse

        String value2 = OptionalBean.ofNullable(axin)

                .getBean(User::getSchool)

                .getBean(User.School::getAdress).orElse("家里蹲");

        System.out.println(value2);

        // 5. 扩展的 orElseThrow

        try {

            String value3 = OptionalBean.ofNullable(axin)

                    .getBean(User::getSchool)

                    .getBean(User.School::getAdress).orElseThrow(() -> new RuntimeException("空指针了"));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }*/

    }
}