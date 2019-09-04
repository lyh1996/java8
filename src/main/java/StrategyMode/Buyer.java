package StrategyMode;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 首先抽象业务处理器
 * @create 2019-08-21 15:31
 * @since 1.7
 */
public interface Buyer {

    /**
     * 计算应付价格
     */
    public BigDecimal calPrice(BigDecimal orderPrice);
}
