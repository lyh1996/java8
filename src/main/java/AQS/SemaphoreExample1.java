package AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 需要一次性拿一个许可的情况
 * @create 2019-04-30 8:53
 * @since 1.7
 */
public class SemaphoreExample1 {
    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(20);
        /*public Semaphore(int permits) {
            sync = new NonfairSync(permits);
        }

    public Semaphore(int permits, boolean fair) {
    ////公平模式： 调用acquire的顺序就是获取许可证的顺序，遵循FIFO；
    //非公平模式： 抢占式的
            sync = fair ? new FairSync(permits) : new NonfairSync(permits);
        }*/

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda 表达式的运用
                try {
                    semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
                    test(threadnum);
                    semaphore.release();// 释放一个许可

                    //semaphore.acquire(5);// 获取5个许可，所以可运行线程数量为20/5=4
                    //test(threadnum);
                    //semaphore.release(5);// 获取5个许可，所以可运行线程数量为20/5=4
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
