/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-10-25 13:57
 * @since 1.7
 */
public class TestMobilphone {

    public static void main(String[] args) {
        String str = "15874716591";
        str = str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(str);
    }
}
