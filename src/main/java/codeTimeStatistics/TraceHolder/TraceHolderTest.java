/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 19:21
 */
package codeTimeStatistics.TraceHolder;

import codeTimeStatistics.stopWatch.TraceWatch;
import com.alibaba.fastjson.JSON;

import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2021/03/22 19:21
 */
public class TraceHolderTest {

    public static void main(String[] args) {
        TraceWatch traceWatch = new TraceWatch();

        TraceHolder.run(traceWatch, "function1", i -> {
            try {
                TimeUnit.SECONDS.sleep(1); // 模拟业务代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        String result = TraceHolder.run(traceWatch, "function2", () -> {
            try {
                TimeUnit.SECONDS.sleep(1); // 模拟业务代码
                return "YES";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "NO";
            }
        });

        TraceHolder.run(traceWatch, "function1", i -> {
            try {
                TimeUnit.SECONDS.sleep(1); // 模拟业务代码
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(JSON.toJSONString(traceWatch.getTaskMap()));
    }
}