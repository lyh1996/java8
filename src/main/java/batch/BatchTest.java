/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-01-08 15:14
 */
package batch;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author LYH
 * @date 2020/01/08 15:14
 */
public class BatchTest {
    public static void main(String[] args) {
        int count = 1, pageSize = 100;

        do {
            // 根据分页查询数据
            if (CollectionUtils.isEmpty(Lists.newArrayList())) {
                return;
            }
            count++;
        } while (true);

    }
}