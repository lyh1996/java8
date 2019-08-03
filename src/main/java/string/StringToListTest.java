package string;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description String ----转换List
 * @create 2019-08-03 8:02
 * @since 1.7
 */
public class StringToListTest {

    public static void main(String[] args) {

        String str = "1234444";
        String str1 = "lyh";

        // 方法一
        List<String> list = new ArrayList<>();
        list.add(str);
        System.out.println("方法一----》" + list);

        // 方法二
        List<String> list1 = Lists.newArrayList(str);
        list1.add(str1);
        System.out.println("方法二----》" + list1);

        // 方法三
        List<String> list2 = Stream.of(str).collect(Collectors.toList());
        list2.add(str1);
        System.out.println("方法三----》" + list2);

        // 方法四 不可增删改查
        List<String> list3 = Collections.singletonList(str);
        // list3.add(str1);
        System.out.println("方法四----》" + list3);


        String string = "lyh1,lyh2,lyh3,";

        // 方法一
        List<String> list4 = Arrays.stream(string.split(",")).map(String::trim).collect(Collectors.toList());
        list4.add("lyh");
        System.out.println("拆分法一:" + list4);

        // 方法二 不能更改操作
        String[] strings = string.split(",");
        List<String> list5 = Arrays.asList(strings);
        //list5.add("123");
        System.out.println("拆分法二:" + list5);

        // 方法三
        List<String> list6 = Lists.newArrayList();
        list6.addAll(Arrays.asList(strings));
        list6.add("123");
        System.out.println("拆分法三:" + list6);

        // 方法四 利用Guava的Splitter  不能操作
        List<String> list7 = Splitter.on(",").trimResults().splitToList(string);
        // list7.add("123");
        list7 = list7.stream().filter(StringUtils::isNoneBlank).collect(Collectors.toList());
        System.out.println("拆分法四:" + list7);


    }
}
