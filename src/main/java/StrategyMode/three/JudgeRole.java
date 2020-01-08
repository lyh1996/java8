/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 18:04
 */
package StrategyMode.three;

import StrategyMode.one.RoleOperation;
import StrategyMode.two.NormalRole;
import StrategyMode.two.OrderAdminRole;
import StrategyMode.two.RootAdminRole;

/**
 * @author LYH
 * @date 2019/12/19 18:04
 */
public class JudgeRole {
    public String judge(RoleOperation roleOperation) {
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.execute();
    }

    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        String result1 = judgeRole.judge(new RootAdminRole("ROLE_ROOT_ADMIN"));
        System.out.println(result1);
        String result2 = judgeRole.judge(new OrderAdminRole("ROLE_ORDER_ADMIN"));
        System.out.println(result2);
        String result3 = judgeRole.judge(new NormalRole("ROLE_NORMAL"));
        System.out.println(result3);

    }
}