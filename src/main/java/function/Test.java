/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-28 14:55
 */
package function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author LYH
 * @date 2020/09/28 14:55
 */
public class Test {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.compose(g);
        System.out.println(h.apply(1));

        BiFunction<Integer, Integer, Integer> ff = (x1, x2) -> x1 + x2 + 1;
        BiFunction<Integer, Integer, Integer> hh = ff.andThen(g);
        Integer apply = hh.apply(1, 2);
        System.out.println(apply);

    }
}