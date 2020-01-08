/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-10 10:54
 */
package testMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LYH
 * @date 2019/12/10 10:54
 */
public class TestMapSum {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("str", 12.3);
        map.put("str1", 6.7);

        // 求和
        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        map.forEach((k, v) -> sum.updateAndGet(v1 -> v1 + v));
        System.out.println(sum.get());
    }
}