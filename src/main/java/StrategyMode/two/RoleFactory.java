/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 17:58
 */
package StrategyMode.two;

import StrategyMode.one.RoleOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LYH
 * @date 2019/12/19 17:58
 */
public class RoleFactory {
    static Map<String, RoleOperation> roleOperationMap = new HashMap<>();

    // 在静态块中先把初始化工作全部做完
    static {
        roleOperationMap.put("ROLE_ROOT_ADMIN", new RootAdminRole("ROLE_ROOT_ADMIN"));
        roleOperationMap.put("ROLE_ORDER_ADMIN", new OrderAdminRole("ROLE_ORDER_ADMIN"));
        roleOperationMap.put("ROLE_NORMAL", new NormalRole("ROLE_NORMAL"));
    }

    public static RoleOperation
    getOp(String roleName) {
        return roleOperationMap.get(roleName);
    }
}