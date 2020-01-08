/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 17:56
 */
package StrategyMode.two;

import StrategyMode.one.RoleOperation;

/**
 * @author LYH
 * @date 2019/12/19 17:56
 */
// 普通用户(有C操作权限)
public class NormalRole implements RoleOperation {

    private String roleName;

    public NormalRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return roleName + " has CCC permission";
    }
}