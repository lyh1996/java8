/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-16 10:26
 */
package lombokTest;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author LYH
 * @date 2020/04/16 10:26
 */
@Data
@Accessors(chain = true)
public class Demo {
    private String userName;

    private Integer userId;

    /**
     * 经纬度
     */
    private double latitude;
}