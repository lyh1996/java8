/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 10:44
 */
package codeTimeStatistics.stopWatch;

import cn.hutool.json.JSONUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2021/03/22 10:44
 */
public class TraceWatchTest {

    public static void main(String[] args) throws InterruptedException {
        TraceWatch traceWatch = new TraceWatch();

        traceWatch.start("function1");
        TimeUnit.SECONDS.sleep(1); // 模拟业务代码
        traceWatch.stop();

        traceWatch.start("function2");
        TimeUnit.SECONDS.sleep(1); // 模拟业务代码
        traceWatch.stop();

        traceWatch.record("function1", 1); // 直接记录耗时

        System.out.println(JSONUtil.toJsonStr(traceWatch.getTaskMap()));
    }
}