package StrategyMode;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-29 14:02
 * @since 1.7
 */
public class Cashier {

    /**
     * 会员,策略对象
     */
    private Buyer buyer;

    public Cashier(Buyer buyer) {
        this.buyer = buyer;
    }

    public BigDecimal quote(BigDecimal orderPrice) {
        return this.buyer.calPrice(orderPrice);
    }
}
