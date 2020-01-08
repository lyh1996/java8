/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 17:55
 */
package StrategyMode.two;

import StrategyMode.one.RoleOperation;

/**
 * @author LYH
 * @date 2019/12/19 17:55
 */
// 订单管理员(有B操作权限)
public class OrderAdminRole implements RoleOperation {

    private String roleName;

    public OrderAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return roleName + " has BBB permission";
    }
}