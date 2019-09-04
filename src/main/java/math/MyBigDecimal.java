package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description BigDecimal的使用
 * @create 2019-09-03 14:34
 * @since 1.7
 */
public class MyBigDecimal {
    // 猪肉单价(单位 ：kg)
    private static final BigDecimal MEAT_PRICE = new BigDecimal("19.88");

    // 大米单价(单位: kg)
    private static final BigDecimal RICE_PRICE = new BigDecimal(3.33D);

    // 清风卷纸（12包装） 单价
    private static final BigDecimal QINGFENG_ROLL_PAPER_PRICE = BigDecimal.valueOf(25D);

    // 维达卷纸（20包装） 单价
    private static final BigDecimal VINDA_ROLL_PAPER_PRICE = BigDecimal.valueOf(50D);

    public static void main(String[] args) {
        // 购物卡余额：100
        BigDecimal amount =  BigDecimal.valueOf(100D);

        // 总价初始化为0
        BigDecimal totalprice = BigDecimal.ZERO;

        // 猪肉净含量
        double weightOfMeat = 2.25D;

        // 大米净含量
        double weightOfRice = 25.35D;

        // 卷纸数量
        int quantityOfVinda = 1;

        // 猪肉总价 44.9550
        BigDecimal meatTotalPrice = MEAT_PRICE.multiply(BigDecimal.valueOf(weightOfMeat)).setScale(2, RoundingMode.HALF_UP);

        // 大米总价：84.42  通过设置setScale设置保留2位小数，并且设置舍入模式为4舍五入
        BigDecimal riceTotalPrice = RICE_PRICE.multiply(BigDecimal.valueOf(weightOfRice)).setScale(2, RoundingMode.HALF_UP);

        // 维达卷纸总价50.00
        BigDecimal vindaRollPaperPrice = VINDA_ROLL_PAPER_PRICE.multiply(BigDecimal.valueOf(quantityOfVinda)).setScale(2, RoundingMode.HALF_UP);

        // 通过add（加法）计算总价为totalPrice:179.38
        totalprice = totalprice.add(meatTotalPrice).add(riceTotalPrice).add(vindaRollPaperPrice);

        // 通过subtract（减法）计算差价diff：
        BigDecimal differencePrice = amount.subtract(totalprice);
        if (differencePrice.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("请付款：" + differencePrice.abs() + "元，购物卡余额：0元");
        } else {
            System.out.println("购物卡余额:" +differencePrice + "元");
        }

        // 通过除法divid计算一包清风纸的价格，设置才哟个四舍五入的模式保留2位小数，并使用double.value的方式转换成double类型的
        double qingFengSingle = QINGFENG_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(12), 2,RoundingMode.HALF_UP).doubleValue();

        // 通过divid（除法）计算一包维达纸的价格
        double vindaSingle = VINDA_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(20)).setScale(2, RoundingMode.HALF_UP).doubleValue();

        int result = Double.compare(qingFengSingle, vindaSingle);

        if (result < 0) {
            System.out.println("一包清风纸价钱"+qingFengSingle + "元， 小于一包维达纸的价钱"+vindaSingle +"所以购买清风更加划算");
        } else if (result == 0) {
            System.out.println("一包清风纸价钱"+qingFengSingle + "元， 等于一包维达纸的价钱"+vindaSingle);
        } else {
            System.out.println("一包清风纸价钱"+qingFengSingle + "元， 大于一包维达纸的价钱"+vindaSingle +"所以购买维达更加划算");
        }

    }

}
