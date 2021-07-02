package cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-06-17 14:01
 * @since 1.7
 */
public abstract class SuperBaseGuavaCache<K, V> {

    private static final Logger log = LoggerFactory.getLogger(SuperBaseGuavaCache.class);

    public

    /**
     * 缓存对象
     */ LoadingCache<K, V> cache;

    /**
     * 缓存最大容量，默认为10
     */
    protected Integer maximumsize = 1000000;

    /**
     * 缓存失效时间
     */
    protected Long duration = 10L;

    /**
     * 缓存失效单位，默认为5s
     */
    protected TimeUnit timeUnit = TimeUnit.SECONDS;

    /**
     * 返回loading cache (单列模式的)
     *
     * @return loadingCache<K, V>
     */
    private LoadingCache<K, V> getCache() {
        if (cache == null) {
            synchronized (SuperBaseGuavaCache.class) {
                if (cache == null) {
                    CacheBuilder<Object, Object> tempCache = null;
                    if (duration > 0 && timeUnit != null) {
                        tempCache = CacheBuilder.newBuilder().expireAfterWrite(duration, timeUnit);
                    }
                    //设置最大缓存大小
                    if (maximumsize > 0) {
                        tempCache.maximumSize(maximumsize);
                    }
                    //加载缓存
                    cache = tempCache.build(new CacheLoader<K, V>() {
                        //缓存不存在或者过期时调用
                        @Override
                        public V load(K key) throws Exception {
                            //不允许返回null值
                            V target = getLoadData(key) != null ? getLoadData(key) : getLoadDataIfNull(key);
                            return target;

                        }
                    });
                }
            }
        }
        return cache;
    }

    /**
     * 返回加载到内存中的数据,一般从数据库中加载
     *
     * @param key key值
     * @return V
     */
    abstract V getLoadData(K key);

    /**
     * 调用getLoadData返回null值时自定义加载到内存的值
     *
     * @param key key值
     * @return V
     */
    abstract V getLoadDataIfNull(K key);

    /**
     * 清除缓存（可以批量清除，也可以清除全部）
     *
     * @param keys 需要清除缓存的key值
     */
    public void batchInvalidate(List<K> keys) {
        if (keys != null) {
            getCache().invalidateAll(keys);
            log.info("批量清除缓存, keys为:{}", keys);
        } else {
            getCache().invalidateAll();
            log.info("清除了所有缓存");
        }
    }

    /**
     * 清除某个key的缓存
     */
    public void invalidateOne(K key) {
        getCache().invalidate(key);
        log.info("清除了guava cache 中的缓存， key为: {}", key);
    }

    /**
     * 写入缓存
     *
     * @param key   键
     * @param value 键对应的值
     */
    public void putIntoCache(K key, V value) {
        getCache().put(key, value);
    }

    /**
     * 获取某个key对应的缓存
     *
     * @param key
     * @return V
     */
    public V getCacheValue(K key) {
        V cacheValue = null;
        try {
            cacheValue = getCache().get(key);
        } catch (Throwable t) {
            log.error("获取guava cache中的缓存出错, {}", t);
            return null;
        }
        return cacheValue;

    }
}
