/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 17:47
 */
package StrategyMode.one;

/**
 * @author LYH
 * @date 2019/12/19 17:47
 */
public class Test {

    public String judge(String roleName) {
        // 一行代码搞定！之前的if/else没了！
        return RoleEnum.valueOf(roleName).op();
    }
}