/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-10-14 16:58
 */
package test;

import JavaBase.User;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LYH
 * @date 2020/10/14 16:58
 */
public class Test {
    public static void main(String[] args) {
        List<User> list = new LinkedList<>();
        User user = null;
        list.add(user);
        System.out.println(CollectionUtils.isNotEmpty(list));
    }

    public static void getInfo() {

    }
}