package tool;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/5/28 9:52 上午
 */
public class Test {
    public static void main(String[] args) throws ParseException {

        /** ***********************List集合拼接成以逗号分隔的字符串 ********************************/
        // 如何把list集合拼接成以逗号分隔的字符串 a,b,c
        List<String> list = Arrays.asList("a", "b", "c");
        // 第一种方法，可以用stream流
        String join = list.stream().collect(Collectors.joining(","));
        System.out.println(join); // 输出 a,b,c
        // 第二种方法，其实String也有join方法可以实现这个功能
        String join1 = String.join(",", list);
        System.out.println(join); // 输出 a,b,c

        /********************************************/


        /********************比较两个字符串是否相等，忽略大小写************************/
        String strA = "";
        String strB = "";
        if (strA.equalsIgnoreCase(strB)) {
            System.out.println("相等");
        }
        /********************************************/


        /********************两个List集合取交集************************/
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("d");
        list1.retainAll(list2);
        System.out.println(list1); // 输出[a, b]

        // 并集
        Collection<String> union = CollectionUtils.union(list1, list2);
        // 交集
        Collection<String> intersection = CollectionUtils.intersection(list1, list2);
        // 交集的补集
        Collection<String> disjunction = CollectionUtils.disjunction(list1, list2);
        // 集合相减
        Collection<String> subtract = CollectionUtils.subtract(list1, list2);
        List<String> stings = (List<String>) subtract;

        /********************************************/


        /********************首字母转成大写************************/
        String str = "yideng";
        String capitalize = StringUtils.capitalize(str);
        System.out.println(capitalize); // 输出Yideng

        /********************************************/


        /********************重复拼接字符串************************/
        String str1 = StringUtils.repeat("ab", 2);
        System.out.println(str); // 输出abab

        /********************************************/


        /********************格式化日期************************/
        // Date类型转String类型
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date); // 输出 2021-05-01 01:01:01

        // String类型转Date类型
        Date date2 = DateUtils.parseDate("2021-05-01 01:01:01", "yyyy-MM-dd HH:mm:ss");

        // 计算一个小时后的日期
        Date date1 = DateUtils.addHours(new Date(), 1);

        /********************************************/


        /********************包装临时对象************************/
/*
        当一个方法需要返回两个及以上字段时，我们一般会封装成一个临时对象返回，现在有了Pair和Triple就不需要了
*/
        // 返回两个字段
        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "yideng");
        System.out.println(pair.getLeft() + "," + pair.getRight()); // 输出 1,yideng
// 返回三个字段
        ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "yideng", new Date());
        System.out.println(
                triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight()); // 输出 1,yideng,Wed Apr 07 23:30:00 CST 2021


        /********************************************/


        /********************Multimap 一个key可以映射多个value的HashMap************************/
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("key", 1);
        map.put("key", 2);
        Collection<Integer> values = map.get("key");
        System.out.println(map); // 输出 {"key":[1,2]}
        // 还能返回你以前使用的臃肿的Map
        Map<String, Collection<Integer>> collectionMap = map.asMap();

        /********************************************/


        /********************BiMap 一种连value也不能重复的HashMap************************/
        BiMap<String, String> biMap = HashBiMap.create();
        // 如果value重复，put方法会抛异常，除非用forcePut方法
        biMap.put("key", "value");
        // 强制塞进去 顶替之前的key
        biMap.forcePut("key", "value");
        System.out.println(biMap); // 输出 {"key":"value"}
        // 既然value不能重复，何不实现个翻转key/value的方法，已经有了
        BiMap<String, String> inverse = biMap.inverse();
        System.out.println(inverse); // 输出 {"value":"key"}

        /********************************************/


        /********************Multiset 一种用来计数的Set************************/
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("orange");
        System.out.println(multiset.count("apple")); // 输出 2
// 查看去重的元素
        Set<String> set = multiset.elementSet();
        System.out.println(set); // 输出 ["orange","apple"]
// 还能查看没有去重的元素
        Iterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
// 还能手动设置某个元素出现的次数
        multiset.setCount("apple", 5);

        /********************************************/


    }
}
