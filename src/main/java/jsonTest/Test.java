/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-14 18:31
 */
package jsonTest;

import cn.hutool.json.JSONUtil;

/**
 * @author LYH
 * @date 2020/09/14 18:31
 */
public class Test {
    public static void main(String[] args) {

        Company company = new Company();
        company.setUsername("LYH");
        company.setUserName("123");

        System.out.println(JSONUtil.toJsonStr(company));
    }
}