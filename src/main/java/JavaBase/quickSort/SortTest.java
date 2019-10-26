package JavaBase.quickSort;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-07-17 14:47
 * @since 1.7
 */
public class SortTest {

    public static void main(String[] args) {

      /*  Student user1 = new Student("1", "lyh1", 21);

        Map<String, Student> map = new HashMap<>();

        map.put(user1.getUid(), user1);

        List<Student> list = new ArrayList<>();
        list.add(map.get("1"));

        list.forEach(user -> user.setName("hello"));

        list.forEach(System.out::println);

        map.forEach((K, V) -> System.out.printf("值---》%s", V));*/

      File file = new File("D:/a.txt");
        String a = FileUtil.extName(file);
        System.out.println(a);


        // 冒泡排序
        int[] num = {1, 2, 5, 7, 0, 3};

        // 冒泡
        //bubbleSort(num);
        // 选择
        selectSort(num);

        for (int i =0; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }

    /**
     * 冒泡排序
     * @param a
     */
    public static void bubbleSort(int[]a) {

        int size = a.length;
        int temp;

        for (int i=0; i<size -1; i++) {
            for (int j =i+1; j< size ; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                }
            }
        }

        public static void selectSort(int[] a) {
        int size = a.length;
        int temp;
        for (int i =0; i<size; i++) {
            int min =i;
            for (int j = i + 1; j <size; j++) {
                if (a[min] > a[j]) {
                     min = j;
                }
            }
            if (min!=i) {
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
        }
}
