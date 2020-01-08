/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-19 18:03
 */
package StrategyMode.three;

import StrategyMode.one.RoleOperation;

/**
 * @author LYH
 * @date 2019/12/19 18:03
 */
public class RoleContext {

    // 可更换的策略，传入不同的策略对象，业务即相应变化
    private RoleOperation operation;

    public RoleContext(RoleOperation operation) {
        this.operation = operation;
    }

    public String execute() {
        return operation.op();
    }
}