package JavaBase;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.BloomFilterUtil;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 使用HuTool测试布隆过滤器
 * @create 2019-04-17 15:28
 * @since 1.7
 */
public class BloomFileterToolTest {

    public static void main(String[] args) {

        BitMapBloomFilter bitMapBloomFilter = BloomFilterUtil.createBitMap(32);
        System.out.println(bitMapBloomFilter.add("122211111"));
        System.out.println(bitMapBloomFilter.add("222222"));
        System.out.println(bitMapBloomFilter.add("3222"));
        System.out.println(bitMapBloomFilter.add("4222"));
        System.out.println(bitMapBloomFilter.add("5222"));
        System.out.println(bitMapBloomFilter.add("622"));
        System.out.println(bitMapBloomFilter.add("12222"));
        System.out.println(bitMapBloomFilter.contains("1"));
        /*DecimalFormat df = new DecimalFormat( "0.0000");
        double d1 = 1.0;
        double d2 = 4.56789;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));*/

    }
}
