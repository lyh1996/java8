/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 19:22
 */
package codeTimeStatistics.TraceHolder;

import codeTimeStatistics.stopWatch.TraceWatch;

import java.util.function.IntConsumer;
import java.util.function.Supplier;

/**
 * @author LYH
 * @date 2021/03/22 19:22
 */
public class TraceHolder {

    /**
     * 有返回值调用
     */
    public static <T> T run(TraceWatch traceWatch, String taskName, Supplier<T> supplier) {
        try {
            traceWatch.start(taskName);

            return supplier.get();
        } finally {
            traceWatch.stop();
        }
    }

    /**
     * 无返回值调用
     */
    public static void run(TraceWatch traceWatch, String taskName, IntConsumer function) {
        try {
            traceWatch.start(taskName);

            function.accept(0);
        } finally {
            traceWatch.stop();
        }
    }
}