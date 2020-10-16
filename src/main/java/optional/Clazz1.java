/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-10-16 14:49
 */
package optional;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author LYH
 * @date 2020/10/16 14:49
 */
@Data
@Accessors(chain = true)
public class Clazz1 {

    private Clazz2 clazz2;
}