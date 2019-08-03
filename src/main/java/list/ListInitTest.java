package list;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 两个List对象直接使用=赋值的问题
 * @create 2019-03-6 15:03
 * @since 1.7
 */
public class ListInitTest {
    public static void main(String[] args) {
        //初始化
        //1.构造 List 后使用 List.add 初始化
        List<String> stringList = new LinkedList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

//2.使用 {{}} 双括号语法
        List<String> stringList1 = new LinkedList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
/*这种方式相对方便了一些。
外层的 {} 定义了一个 LinkedList 的匿名内部类。内层的 {} 的定义了一个实例初始化代码块。 这个代码块在初始化内部类时执行。所以这里相当于定义了一个匿名内部类，并使用 add 添加元素来初始化。
这种方式有几个缺点：
使用匿名内部类，会有效率上的损失。当然在大多数情况下，这点效率都是可接受的。
静态内部类持有所在外部类的引用。如果需要将 List 返回给到其他地方使用，可能造成内存泄漏。*/

//3.使用 Arrays.asList
        List<String> stringList2 = Arrays.asList("a", "b", "c");
/*这种方式使用了 java.util.Arrays 的静态方法。写法上比之前的两种都更简洁，也没有构造匿名内部类的效率问题。
但也有几点需要注意：
Arrays.asList 返回的是 Arrays 的静态内部类（静态内部类不持有所在外部类的引用）。
这个内部类继承自 AbstractList，实现了 RandomAccess，内部使用了一个数组来存储元素。但是不支持增删元素。这点需要注意。如果只是使用 Arrays.asList 来初始化常量，那么这点就不算什么问题了。
Arrays.asList 的参数如果是基本类型的数组时，需要留意返回值可能和你预期的不同。*/

//4. 使用 Stream (JDK8)
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());

//5. 使用 Lists （JDK9）
        List<String> list1 = Lists.newArrayList("a", "b", "c");

        //赋值：

//法一
        //ArrayList B　＝new ArrayList<>(A);

//法三
        //ArrayList B　＝A.clone();

//法二
       // ArrayList B　＝new ArrayList<String>();
       // B.addAll(A);

//法四
        //for (String s : A)
        //    B.add(s);


    }
}
