/*
import JavaBase.User;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

*/
/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2021/7/7 3:21 下午
 * <p>
 * 核心线程 8 最大线程 60 保活时间10s 存储队列 1024 有守护线程 拒绝策略:将超负荷任务回退到调用者  最多接收61个任务
 *//*

public class TestJson {
    */
/**
 * 核心线程 8 最大线程 60 保活时间10s 存储队列 1024 有守护线程 拒绝策略:将超负荷任务回退到调用者  最多接收61个任务
 *//*

    private static ExecutorService executor = new ThreadPoolExecutor(8, 60,
            10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
            new ThreadFactoryBuilder().setNameFormat("User_Async_FutureTask-%d").setDaemon(true).build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        List<String> result = Lists.newArrayList();
        List<Future<List<String>>> futures = new ArrayList<>();
        TestThread testThread = new TestThread();
        testThread.setI(0);
        // 需要查询的次数
        int count = 11;
        int queryNum = (int) Math.ceil((double) count / 5);
        System.out.println("需要查询的次数" + queryNum);
        for (int i = 1; i <= queryNum; i++) {
            TestThread testThread1 = new TestThread();
            testThread1.setI(i);
            Future<List<String>> future =
                    executor.submit(() -> getStr(testThread1));
            futures.add(future);
        }

        futures.forEach(listFuture -> {
            try {
                result.addAll(listFuture.get());
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println(result);

    }

    public static List<String> getStr(TestThread testThread) {
        return Arrays.asList("test" + testThread.getI());
    }
}
*/
