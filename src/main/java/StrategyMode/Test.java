package StrategyMode;

import java.math.BigDecimal;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-29 14:03
 * @since 1.7
 */
public class Test {

    public static void main(String[] args) {

        //选择并创建需要使用的策略对象
        Buyer strategy = new VipBuyer();

        //创建上下文
        Cashier cashier = new Cashier(strategy);
        //计算价格
        BigDecimal quote = cashier.quote(BigDecimal.valueOf(300));
        System.out.println("普通会员商品的最终价格为：" + quote.doubleValue());

        strategy = new SuperVipBuyer();
        cashier = new Cashier(strategy);
        System.out.println(123);
        quote = cashier.quote(BigDecimal.valueOf(300));
        System.out.println("超级会员商品的最终价格为：" + quote.doubleValue());
    }
}
