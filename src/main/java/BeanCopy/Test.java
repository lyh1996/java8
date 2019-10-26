package BeanCopy;


import JavaBase.User;
import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeanUtils;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-24 8:29
 * @since 1.7
 */
public class Test {

    public static void main(String[] args)  {
        CopyTest1 test1 = new CopyTest1();
        test1.outerName = "hahaha";
        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
        innerClass.InnerName = "hohoho";
        test1.innerClass = innerClass;
        User user = new User();
        user.setUid("12");
        user.setName("aaa");
        user.setAge(12);
        test1.user = user;
        System.out.println(test1.toString());

        CopyTest2 test2 = new CopyTest2();
        BeanUtils.copyProperties(test1, test2);
        System.out.println(test2.toString());

        // 内部类的复制
        /*1.Spring的BeanUtils的CopyProperties方法需要对应的属性有getter和setter方法；
        2.如果存在属性完全相同的内部类，但是不是同一个内部类，即分别属于各自的内部类，则spring会认为属性不同，不会copy；
        3.泛型只在编译期起作用，不能依靠泛型来做运行期的限制；*/
        CopyTest2 test3 = new CopyTest2();
        test3.innerClass = new CopyTest2.InnerClass();
        BeanUtils.copyProperties(test1, test3);
        BeanUtils.copyProperties(test1.innerClass, test3.innerClass);

        System.out.println(test3.toString());

        // 使用BeanCopy
        CopyTest2 test4 = new CopyTest2();
        BeanUtil.copyProperties(test1, test4);
        System.out.println(test4.toString());



    }
}
