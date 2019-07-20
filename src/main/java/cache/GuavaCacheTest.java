package cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 缓存工具类测试
 * @create 2019-06-17 11:00
 * @since 1.7
 */
public class GuavaCacheTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GuavaCache guavaCache = new GuavaCache();
        String key = "id";
        //不设置过期时间
        System.out.println("***********不设置过期时间**********");
        guavaCache.putIntoCache(key, "123");
        System.out.println("key:" + key + ", value:" + guavaCache.getCacheValue(key));



        /******************并发性能测试************/
        System.out.println("\n***********并发性能测试************");
        //创建有10个线程的线程池，将1000000次操作分10次添加到线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future[] futures = new Future[10];
        /********添加********/
        {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                futures[j] = executorService.submit(() -> {
                    for (int i = 0; i < 100000; i++) {
                        guavaCache.putIntoCache( Thread.currentThread().getId() + key + i, i);
                    }
                });
            }
            //等待全部线程执行完成，打印执行时间
            for (Future future : futures) {
                future.get();
            }
            System.out.printf("添加耗时：%dms\n", System.currentTimeMillis() - start);
        }

        /********查询********/
        {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                futures[j] = executorService.submit(() -> {
                    for (int i = 0; i < 100000; i++) {
                        guavaCache.getCacheValue(Thread.currentThread().getId() + key + i);
                    }
                });
            }
            //等待全部线程执行完成，打印执行时间
            for (Future future : futures) {
                future.get();
            }
            System.out.printf("查询耗时：%dms\n", System.currentTimeMillis() - start);
        }

        System.out.println("当前缓存容量：" + guavaCache.maximumsize);
    }
}
