package AQS;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 需要一次性拿一个许可的情况   控制并发数量
 * @create 2019-04-30 8:53
 * @since 1.7
 */
public class SemaphoreExample1 {
    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 参数含义：
         *      corePoolSize : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
         *      maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
         *      keepAliveTime : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
         *      unit : keepAliveTime 的时间单位
         *      workQueue : 存放待处理任务的队列，该队列只接收 Runnable 接口
         *      threadFactory : 线程创建工厂
         *      handler : 当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法，参考 ThreadPoolExecutor 类中的内部策略类
         */
        // 创建线程工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("lyh-pool-%d")
                .build();
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        //ExecutorService threadPool = Executors.newFixedThreadPool(300);
        ExecutorService threadPool = new ThreadPoolExecutor(200, 300, 3,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
                threadFactory,
                new ThreadPoolExecutor.DiscardOldestPolicy());
        /*
        使用直接提交策略，也即SynchronousQueue。首先SynchronousQueue是无界的，也就是说他存数任务的能力是没有限制的，但是由于该Queue本身的特性，在某次添加元素后必须等待其他线程取走后才能继续添加。在这里不是核心线程便是新创建的线程
        使用无界队列策略，即LinkedBlockingQueue
        有界队列，使用ArrayBlockingQueue*/
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
        System.out.println(Thread.currentThread().getName() +"==>:"+ threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
