package JavaBase;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;

import java.nio.charset.Charset;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description Base64原理
 * @create 2019-03-08 7:42
 * @since 1.7
 */
public class Base64Test {
    public static void main(String[] args) {
         /*
         一个字节8个位  普通的汉字两个字节   最大字节为3个字节   例如蒙古文  藏文
         base64基于最大  3个字节的(一个字节八个位)    3*8=24   -----》4*6=24    由于6,8的最小公倍数是24 所以Base64采用6个位的计算  范围就是   000000 （0）  ~  111111  （63）
         每个结果一个字符  总共64 具体组成为 a-z（26）   A-Z（26）  0-9（10）   / +（2个符）    总共64

         第一步：找到中文在操作系统中字符编码的十进制代码（可以采用excel里面的Code函数计算十进制）   cmd中输入chcp  找到系统的编码代号默认936即gb2312
         第二步：十进制转换成二进制
         第三步：对二进制重新编码（六位一组）然后再每组前面加0 凑成8位一个字节 再  变成十进制
         第四步：从Base64编码表中查找其对应的字符

               十进制          二进制
          德   46530      1011010111000010
          邦   45294      1011000011101110
           德邦二进制组合（二进制）                                               10110101110000101011000011101110
          二进制编排（六位区分然后前面补0凑成8位一个字节）                00101101   00011100  00001010   00110000  00111011  00000010
          十进制                                                        45         28         10         48       59         2
           Base64表对照查找                                             t          c          K          w         7         g

           最后产生的字节数一定要是4的倍数，不是就用==代替   例如德邦两个字最后只产生6个字节所以后面需要两个==（因为Base64编码时，是将3个字节转变为4个字节，最终得到的字节数必然是4的倍数）
            */
        try {
            //编码
            String result= Base64Encoder.encode("德邦",Charset.forName("gb2312")) ;

            System.out.println(result);

            //解码
            String  decode = Base64Decoder.decodeStr("tcKw7g==", Charset.forName("gb2312"));
            System.out.println(decode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
