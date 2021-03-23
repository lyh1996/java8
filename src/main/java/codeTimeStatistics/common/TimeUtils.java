/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 10:26
 */
package codeTimeStatistics.common;

/**
 * @author LYH
 * @date 2021/03/22 10:26
 */
public class TimeUtils {

    /**
     * @return 当前毫秒数
     */
    public static long nowMs() {
        return System.currentTimeMillis();
    }

    /**
     * 当前毫秒与起始毫秒差
     *
     * @param startMillis 开始纳秒数
     * @return 时间差
     */
    public static long diffMs(long startMillis) {
        return startMillis - nowMs();
    }
}