/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-22 15:11
 */
package cache.test;

/**
 * @author LYH
 * @date 2020/04/22 15:11
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyLruCacheWithExpireTime<Integer, String> myLruCache = new MyLruCacheWithExpireTime<>(3);
        myLruCache.put(1, "Java", 3);
        myLruCache.put(2, "C++", 3);
        myLruCache.put(3, "Python", 1500);
        System.out.println(myLruCache.size());//3
        Thread.sleep(2);
        System.out.println(myLruCache.size());//2
    }
}