package JavaBase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-22 19:15
 * @since 1.7
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap();
        map.put("1", "lyh");

        Map<String, Object> map2 = new HashMap<>();
        map.putAll(map2);

        map.forEach((k, v) -> System.out.println("键：" +k + "值："+v));
    }
}
