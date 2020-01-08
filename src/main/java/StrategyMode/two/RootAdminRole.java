/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 17:54
 */
package StrategyMode.two;

import StrategyMode.one.RoleOperation;

/**
 * @author LYH
 * @date 2019/12/19 17:54
 */
// 系统管理员(有A操作权限)
public class RootAdminRole implements RoleOperation {

    private String roleName;

    public RootAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return roleName + " has AAA permission";
    }
}