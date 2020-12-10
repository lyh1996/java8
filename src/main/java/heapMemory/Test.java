/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-11-27 14:09
 */
package heapMemory;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author LYH
 * @date 2020/11/27 14:09
 */
public class Test {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}