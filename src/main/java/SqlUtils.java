/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-10-13 21:38
 */

import org.apache.commons.lang3.StringUtils;

/**
 * @author LYH
 * @date 2020/10/13 21:38
 */
public class SqlUtils {

    //mysql的模糊查询时特殊字符转义
    public static String escapeChar(String before) {
        if (StringUtils.isNotBlank(before)) {
            before = before.replaceAll("\\\\", "\\\\\\\\");
            before = before.replaceAll("_", "\\\\_");
            before = before.replaceAll("%", "\\\\%");
        }
        return before;
    }
}