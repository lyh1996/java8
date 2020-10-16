/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-09-09 11:17
 */
package cache.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2020/09/09 11:17
 */
public class CaffeineUtils3 {
    /**
     * 异步加载
     * <p>
     * AsyncLoadingCache是继承自LoadingCache类的，异步加载使用Executor去调用方法并返回一个CompletableFuture。异步加载缓存使用了响应式编程模型。
     * 如果要以同步方式调用时，应提供CacheLoader。要以异步表示时，应该提供一个AsyncCacheLoader，并返回一个CompletableFuture。
     *
     * @param key
     * @return
     */
    public Object asyncOperator(String key) {
        AsyncLoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .buildAsync(k -> setAsyncValue(key).get());

        return cache.get(key);
    }

    public CompletableFuture<Object> setAsyncValue(String key) {
        return CompletableFuture.supplyAsync(() -> {
            return key + "value";
        });
    }

}