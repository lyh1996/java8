package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 线程的六种状态
 * @create 2019-09-05 16:02
 * @since 1.7
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程状态为等待状态

        new Thread(() -> {
            while (true) {
                synchronized (ThreadTest.class) {
                    try {
                        ThreadTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            },"Thread_Wait").start();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread_Sleep").start();


        new Thread(new Block(), "bolock01_thread").start();
        new Thread(new Block(), "bolock02_thread").start();

    }

    static class Block extends Thread {
        @Override
        public void run() {
            synchronized (Block.class) {
                while(true) {
                    try {
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
