/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-16 10:28
 */
package lombokTest;

import lombok.Builder;
import lombok.Data;

/**
 * @author LYH
 * @date 2020/04/16 10:28
 */
@Data
@Builder
public class User {

    private Integer userId;

    private String UserName;

    /**
     * 经纬度
     */
    private Double latitude;
}