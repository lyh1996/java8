/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-03-16 10:58
 */
package bigDecimal;

import java.math.BigDecimal;

/**
 * @author LYH
 * @date 2020/03/16 10:58
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal price = BigDecimal.ZERO;
        // 通常建议优先使用(String)构造函数
        BigDecimal amount = new BigDecimal("6.66");
        // 0.06
        System.out.println(ArithUtil.add(0.05, 0.01));
        // 0.58
        System.out.println(ArithUtil.sub(0.1, 0.42));
        // 401.5
        System.out.println(ArithUtil.mul(4.015, 100));
        // 1.233
        System.out.println(ArithUtil.div(123.3, 100));
        // 4.02
        System.out.println(ArithUtil.round(4.015, 2));
        // BigDecimal 比较大小使用compareTo方法
        // public int compareTo(BigDecimal val);
    }

}