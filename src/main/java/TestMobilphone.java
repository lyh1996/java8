import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        String string = "1";
        List<Integer> list = Arrays.stream(string.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        System.out.println(list);
    }
}
