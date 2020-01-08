/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 18:01
 */
package StrategyMode.two;

/**
 * @author LYH
 * @date 2019/12/19 18:01
 */
public class JudgeRole {

    public String judge(String roleName) {
// 一行代码搞定！之前的 if/else也没了！
        return RoleFactory.getOp(roleName).op();
    }
}