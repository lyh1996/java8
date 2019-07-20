package JavaBase;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.NumberUtil;

import java.nio.charset.Charset;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-10 9:26
 * @since 1.7
 */
public class serialNoTest {
    public static void main(String[] args) {
        String serialNo = "0007";
        // 流水号转二进制
        Integer num = Integer.parseInt(serialNo);

        String str = NumberUtil.getBinaryStr(num);

        char[] chars = HexUtil.encodeHex(serialNo, Charset.defaultCharset());
        System.out.println(chars);

        System.out.println(str);

    }
}
