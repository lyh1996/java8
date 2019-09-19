import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-02 15:58
 * @since 1.7
 */
public class UnicodeTest {
    public String a;
    public static void main(String[] args) throws UnknownHostException, UnsupportedEncodingException {
     /*  BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue.take());
        System.out.println(queue.size());*/


        String str = "<RESPONSE xmlns=\"\"><RESPONSECODE>1</RESPONSECODE><RESPONSEMESSAGE>&#x4EA4;&#x6613;&#x6210;&#x529F;&#xFF01;</RESPONSEMESSAGE><PORT>9800</PORT><OPERATORNO>001111</OPERATORNO><TRADESERIALNUMBER>615300F464F548759215E158A8893410</TRADESERIALNUMBER><JCSJ>&#x4E3B;&#x52A8;&#x8109;&#x5185;&#x5F84;&#xFF1A;23mm&#x3002; &#x5DE6;&#x623F;&#x5F84;&#xFF1A;29mm&#x3002;&#x53F3;&#x5BA4;&#x6D41;&#x51FA;&#x9053;&#x5F84;&#xFF1A;26mm&#x3002; &#x5BA4;&#x95F4;&#x9694;&#x539A;&#x5EA6;&#xFF1A;9mm&#x3002; \n" +
                "&#x5DE6;&#x5FC3;&#x5BA4;&#x8212;&#x5F20;&#x672B;&#x5F84;&#xFF1A;36mm&#x3002;&#x5DE6;&#x5BA4;&#x540E;&#x58C1;&#x539A;&#x5EA6;: 8mm&#x3002; &#x53F3;&#x5BA4;&#x5F84;&#xFF1A;20mm&#x3002; EF=65%  FS=34%\n" +
                "1&#x3001;&#x5FC3;&#x810F;&#x5404;&#x623F;&#x5BA4;&#x5185;&#x5F84;&#x6B63;&#x5E38;&#xFF0C; \n" +
                "2&#x3001;&#x5BA4;&#x95F4;&#x9694;&#x3001;&#x5DE6;&#x5BA4;&#x540E;&#x58C1;&#x539A;&#x5EA6;&#x53CA;&#x8FD0;&#x52A8;&#x6B63;&#x5E38;&#x3002; \n" +
                "3&#x3001;&#x5404;&#x74E3;&#x819C;&#x5F62;&#x6001;&#x3001;&#x6D3B;&#x52A8;&#x548C;&#x8840;&#x6D41;&#x6B63;&#x5E38;&#x3002; \n" +
                "4&#x3001;&#x4E3B;&#x52A8;&#x8109;&#x3001;&#x4E3B;&#x80BA;&#x52A8;&#x8109;&#x5185;&#x5F84;&#x53CA;&#x8840;&#x6D41;&#x6B63;&#x5E38; \n" +
                "</JCSJ><ZDYJ>&#x4E8C;&#x7EF4;&#x8D85;&#x58F0;&#x5FC3;&#x52A8;&#x56FE;&#x53CA;&#x5F69;&#x8272;&#x8840;&#x6D41;&#x68C0;&#x67E5;&#x672A;&#x89C1;&#x5F02;&#x5E38;&#x3002;\n" +
                "</ZDYJ></RESPONSE>";

        //str = unescape(str);
        // 定义正则表达式来搜索中文字符的转义符号
        Pattern compile = compile("&#.*?;");
        // 测试用中文字符
        Matcher matcher = compile.matcher(str);
        // 循环搜索 并转换 替换
        while (matcher.find()) {
            String group = matcher.group();
            // 获得16进制的码
            String hexcode = "0" + group.replaceAll("(&#|;)", "");
            // 字符串形式的16进制码转成int并转成char 并替换到源串中
            str = str.replaceAll(group, (char) Integer.decode(hexcode).intValue() + "");
        }
        System.out.println(str);
    }

    //&#x编码转换成汉字（java）
    public static String  unescape (String src){
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int  lastPos=0,pos=0;
        char ch;
        src = src.replace("&#x","%u").replace(";","");
        while (lastPos<src.length()){
            pos = src.indexOf("%",lastPos);
            if (pos == lastPos){
                if (src.charAt(pos+1)=='u'){
                    ch = (char)Integer.parseInt(src.substring(pos+2,pos+6),16);
                    tmp.append(ch);
                    lastPos = pos+6;
                }else{
                    ch = (char)Integer.parseInt(src.substring(pos+1,pos+3),16);
                    tmp.append(ch);
                    lastPos = pos+3;
                }
            } else{

                if (pos == -1){
                    tmp.append(src.substring(lastPos));
                    lastPos=src.length();
                } else{
                    tmp.append(src.substring(lastPos,pos));
                    lastPos=pos;
                }
            }
        }
        return tmp.toString();
    }



}
