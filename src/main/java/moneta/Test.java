package moneta;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

/**
 * <p> write your description here
 *
 * @author 【LYH】（【罗玉华】luoyuhua@lingxing.com）
 * @date 2022/7/13 17:25
 */
public class Test {
    public static void main(String[] args) {
        CurrencyUnit currencyUnit = Monetary.getCurrency("CNY");
        Money money = Money.of(10, currencyUnit);
    }
}
