package StrategyMode;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 普通会员
 * @create 2019-08-29 10:41
 * @since 1.7
 */
public class VipBuyer implements Buyer {
    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.9));
    }
}
