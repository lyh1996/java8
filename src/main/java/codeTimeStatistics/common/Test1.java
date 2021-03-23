/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 10:25
 */
package codeTimeStatistics.common;

import java.util.concurrent.TimeUnit;

/**
 * 时间差统计
 *
 * @author LYH
 * @date 2021/03/22 10:25
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        final long startMs = TimeUtils.nowMs();

        TimeUnit.SECONDS.sleep(5); // 模拟业务代码

        System.out.println("timeCost: " + TimeUtils.diffMs(startMs));
    }
}