/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-16 10:29
 */
package lombokTest;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author LYH
 * @date 2020/04/16 10:29
 */
public class Test {
    public static void main(String[] args) {
        //List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> list = Lists.newArrayList();
        list.clear();
        list.add("lyh");

        if (CollectionUtils.isNotEmpty(list) && list != null) {
            System.out.println(list);
        }

    }
}