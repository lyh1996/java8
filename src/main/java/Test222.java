/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-07-18 17:34
 */

/**
 * _       _
 * (_\     /_)
 * ))   ((
 * .-"""""""-.
 * /^\/  _.   _.  \/^\
 * \(   /__\ /__\   )/
 * \,  \o_/_\o_/  ,/
 * \    (_)    /
 * `-.'==='.-'
 * __) - (__
 * /  `~~~`  \
 * /  /     \  \
 * \ :       ; /
 * \|==(*)==|/
 * :       :
 * \  |  /
 * ___)=|=(___
 * jgs {____/ \____}
 */

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author LYH
 * @date 2020/07/18 17:34
 */
public class Test222 {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        //list1.retainAll(list2);
        //System.out.println(list1); // 输出[a, b]

       /* // 并集
        Collection<String> union = CollectionUtils.union(list1, list2);
        System.out.println(union);
        // 交集
        Collection<String> intersection = CollectionUtils.intersection(list1, list2);
        System.out.println(intersection);
        // 交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(list1, list2);
        System.out.println(disjunction);
        // 集合相减
        Collection<String> subtract = CollectionUtils.subtract(list1, list2);
        System.out.println(subtract);
        Collection<String> subtract2 = CollectionUtils.subtract(list2, list1);
        System.out.println(subtract2);
        List<String> stings = (List<String>) subtract;*/
/*        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + "s", i++);
        }
        System.out.println(hashMap);
        Integer num = null;
        HashMap<String, String> strMap = new HashMap<>();
        strMap.put("1", Objects.isNull(num) ? "" : String.valueOf(num));
        System.out.println(strMap);*/
        TestThread testThread = new TestThread();
        List<TestThread> list = Lists.newArrayList();
        List<String> onLineDeviceIds =
                list.stream().filter(smart -> Objects.equals(smart.getStr(), 1)).map(TestThread::getStr)
                        .collect(Collectors.toList());

        System.out.println(onLineDeviceIds);


    }

    public static String handle(String str) {
        String regex = "(\\w{4})(.*)(\\w{4})";
        Matcher m = Pattern.compile(regex).matcher(str);
        if (m.find()) {
            String rep = m.group(2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rep.length(); i++) {
                sb.append("*");
            }
            return str.replaceAll(rep, sb.toString());
        }
        return str;
    }
}