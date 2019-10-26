import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-09-19 18:23
 * @since 1.7
 */
public class Test2 {
    /*爸爸去哪儿中的3对父子站成一排，各自父子之间不能相邻，比如石头不能和郭涛挨着，以此类推，共有几种站法？*/
    public static void main(String[] args) {

        Set<Integer> valueSet = new HashSet<>();
        perm(new int[]{1,2,3,4,5,6},0,5, valueSet);
        //迭代器
        for (Iterator iterator = valueSet.iterator();
             iterator.hasNext();) {
            int r = (int) iterator.next();
            String rs = String.valueOf(r);
            if (rs.contains("12")||rs.contains("21")||rs.contains("34")||rs.contains("43")||rs.contains("56")||rs.contains("65")) {
                iterator.remove();
            }
        }
        System.out.println(valueSet.size());
    }

    public static void perm(int[] array, int start, int end, Set<Integer> valueSet) {
        if(start==end) {
            System.out.println(Arrays.toString(array));
            valueSet.add(Integer.parseInt(ArrayUtil.join(array, "")));
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(array,start,i);
                perm(array,start+1,end, valueSet);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array,start,i);
            }
        }
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
