package StrategyMode;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 超级会员
 * @create 2019-08-29 10:38
 * @since 1.7
 */
public class SuperVipBuyer  implements Buyer {

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.8));
    }
}
