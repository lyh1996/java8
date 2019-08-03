package list;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-03 17:36
 * @since 1.7
 */
public class ListToStringTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(2);
        list.add("lyh");
        list.add("lyh2");

        // 方法一 动态创建与 size 相同的数组，性能最好
        String[] array = list.toArray(new String[0]);
        // listStrings.toArray(new String[listStrings.size()]);
        System.out.println(Arrays.toString(array));


        //方法2
        String[] strss = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            strss[i] = list.get(i);
        }
        System.out.println(Arrays.toString(strss));
        System.out.println("转换"+String.join("",strss));

        // 方法二
        String arr = list.stream().map(JSON::toJSONString).collect(Collectors.joining("|"));
        System.out.println(arr);

        // 方法三
        String arr1 = String.join("|", list);
        System.out.println(arr1);

        // 方法三
        String str = Joiner.on("|").join(list);
        System.out.println(str);

        // 方法四
        String str1= StringUtils.join(list.toArray(), "|");
        System.out.println(str1);


    }
}
