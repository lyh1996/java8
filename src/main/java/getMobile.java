import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/7/5 10:20 下午
 */
public class getMobile {

    public static final String REGEX_MOBILE = "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}";

    public static String regexMobile(String content) {
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(content);
        String paramStr = content;
        while (m.find()) { //一定需要先查找再调用group获取电话号码
            // mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")
            paramStr = paramStr.replaceAll(m.group(), m.group().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
        }
        return paramStr;
    }

    public static void main(String[] args) {
        String str = "访客（86-15874716591）";
        str = str.replace("86-", "");
        System.out.println(str);
        System.out.println(regexMobile(str));
    }
}
