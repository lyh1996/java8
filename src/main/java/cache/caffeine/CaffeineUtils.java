/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-09 11:17
 */
package cache.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author LYH
 * @date 2020/09/09 11:17
 */
public class CaffeineUtils {
    /**
     * 手动加载  在每次get key的时候指定一个同步的函数，如果key不存在就调用这个函数生成一个值。
     *
     * @param key
     * @return
     */
    public Object manulOperator(String key) {
        Cache<String, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        //如果一个key不存在，那么会进入指定的函数生成value
        Object value = cache.get(key, t -> setValue(key).apply(key));
        cache.put("hello", value);

        //判断是否存在如果不存返回null
        Object ifPresent = cache.getIfPresent(key);
        //移除一个key
        cache.invalidate(key);
        return value;
    }

    public Function<String, Object> setValue(String key) {
        return t -> key + "value";
    }


}