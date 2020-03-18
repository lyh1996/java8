/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2019-12-25 9:44
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LYH
 * @date 2019/12/25 9:44
 */
public class Test {

    public static void main(String[] args) throws IOException {
/*
        HashMap rsMap = Maps.newHashMap();
        List<String> roleKeys = (List<String>) Optional.ofNullable(rsMap.get("roleKeys")).orElse(null);
        if (CollectionUtils.isEmpty(roleKeys)) {
            System.out.println("我是空的啊");
        }

        Integer a = 1;
        int aa = 128;
        Integer aaa = new Integer(128);
        System.out.println(a == aa);
        System.out.println(aa == aaa);

        String str = "a:1,b:2,c:3,d:4";
        String recourse = str.replaceAll(":", ",");
        String recources = str.replace(':', ',');

        System.out.println(recourse);
        System.out.println(recources);*/

        // 判断一个数是否是奇数的方法
        Test test = new Test();
        int num = 0;
        // 获取输入的方式1
       /* Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();*/

        // 获取输入的方式2
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        num = bufferedReader.read();
        boolean ret = test.isOdd(num);
        System.out.println(ret ? "奇数" : "偶数");

        // & 与 &&  | 与 ||
        // 0011 | 1001 = 1011 ====>  11
        System.out.println(3 | 9);
        System.out.println(3 & 9);

        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++)
            count++;

        System.out.println(count);

        /*Integer.MAX_VALUE是2147483647
                所以start是2147483547
        end是2147483647

                但是for循环在i=2147483647时，仍然符合i<=Integer.MAX_VALUE
        此时，i++后，i的值是-2147483648，是个负数！！！

        很显然，-2147483648也是<=Integer.MAX_VALUE的，
        那么这时候可以看出for循环是个死循环，且不会报错，
        循环内部count变量也是int类型，所以同理也不会报错
                print语句永远不会执行到*/

    }

    private boolean isOdd(int num) {
        // eg 3 & 1 =======   0011
        //                    0001
        //                    0001
        return (num & 1) == 1;
    }
}