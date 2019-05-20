package JavaBase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description ConcurrentHashMap 的实现
 * @create 2019-02-20 9:51
 * @since 1.7
 */
class ConcurrentHashMapToTest {

    private Map<Integer,Integer> cache =new ConcurrentHashMap<>(15);

    public static void main(String[]args){
        ConcurrentHashMapToTest ch =    new ConcurrentHashMapToTest();
        System.out.println(ch.fibonaacci(80));
    }

    public int fibonaacci(Integer i){
        if(i==0||i ==1) {
            return i;
        }

        return cache.computeIfAbsent(i,(key) -> {
            System.out.println("fibonaacci : "+key);
            return fibonaacci(key -1)+fibonaacci(key - 2);
        });

    }
}
