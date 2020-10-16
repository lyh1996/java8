/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-01 18:11
 */
package StrategyMode;

import StrategyMode.two.JudgeRole;

/**
 * @author LYH
 * @date 2020/09/01 18:11
 */
public class TestTwo {
    public static void main(String[] args) {
        JudgeRole j = new JudgeRole();
        System.out.println(j.judge("ROLE_ROOT_ADMIN"));
    }
}