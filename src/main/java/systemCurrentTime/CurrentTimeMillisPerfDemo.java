package systemCurrentTime;

import cn.hutool.core.date.SystemClock;

import java.util.concurrent.CountDownLatch;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-31 9:11
 * @since 1.7
 */
public class CurrentTimeMillisPerfDemo {
    private static final int COUNT = 100;

    public static void main(String[] args) throws Exception {
        long beginTime = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            //System.currentTimeMillis();
            //CurrentTimeMillisClock.getInstance().now();
            SystemClock.now();
        }

        long elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() serial calls: " + elapsedTime + " ms");

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    startLatch.await();
                    //System.currentTimeMillis();
                    //CurrentTimeMillisClock.getInstance().now();
                    SystemClock.now();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown();
                }
            }).start();
        }

        beginTime = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        elapsedTime = System.nanoTime() - beginTime;
        System.out.println("100 System.currentTimeMillis() parallel calls: " + elapsedTime + " ns");
    }
}
