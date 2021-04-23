/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-04-23 9:21
 */
package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LYH
 * @date 2021/04/23 9:21
 */
public class LRUCache {
    /*使用LinkedHashMap*/

    int capacity;

    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        // 如果没有找到的话
        if (!map.containsKey(key)) {
            return -1;
        }

        // 找到的话 就刷新数据
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);

        // 如果超出capacity，删除最久没有用的那一个，即第一个，或者可以写removeEldestEntry方法
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        for (int i = 0; i < 10; i++) {
            lruCache.map.put(i, i);
            System.out.println(lruCache.map.size());
        }

        System.out.println(lruCache.map);
        lruCache.put(10, 200);
        System.out.println(lruCache.map);
    }

}