package JavaBase;

import cn.hutool.core.bean.BeanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-05-14 17:26
 * @since 1.7
 */
public class ResultTest {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(12);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);

        Result3<Map<String, Object>> uumsResult = new Result3<>();
        uumsResult.setResult(map);

        //System.out.println(uumsResult);

        Result2 result2 = new Result2();
        //result2.setResult(uumsResult.getResult());
        BeanUtil.copyProperties(uumsResult, result2);

        System.out.println(result2.getResult());
        //BeanUtil.copyProperties();
    }
}
