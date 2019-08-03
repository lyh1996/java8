package JavaBase.thread;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 线程的调度是根据cpu的算法，如果线程的运算量不大，cpu算法调度线程不一定会平均分配给每个内核的。那意思是如果运算量大的话，就会使用到其他的内核
 * @create 2019-07-31 9:10
 * @since 1.7
 */
public class CpuThreadTest {

    private static final int num = 1000 * 1000;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        }, "线程1").start();

        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        }, "线程2").start();

        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        }, "线程3").start();

        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                System.out.println(i);
            }
        }, "线程4").start();
    }
}
