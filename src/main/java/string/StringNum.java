/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-19 9:08
 */
package string;

import java.util.HashMap;

/**
 * 需要统计一个字符串中各个单词出现的频率，然后从中找出频率最高的单词
 *
 * @author LYH
 * @date 2021/03/19 9:08
 */
public class StringNum {
    public static void main(String[] args) {

        // jdk1.8之前的写法
/*        HashMap<Character, Integer> result1 = new HashMap<>(32);
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            Integer curVal = result1.get(curChar);
            if (curVal == null) {
                curVal = 1;
            } else {
                curVal += 1;
            }
            result1.put(curChar, curVal);
        }*/
        String str = "ajfokajflagnhoanfakofuafufalkfn";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char charStr = str.charAt(i);
            hashMap.compute(charStr, (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v += 1;
                }
                return v;
            });
        }

        hashMap.forEach((k, v) -> System.out.println("键" + k + "值" + v));

        // map遍历的


    }
}