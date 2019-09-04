package AQS.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-08 14:35
 * @since 1.7
 */
public class SemaphoreDemo {
    /**
      * 打饭窗口
      * 2：   2个打饭窗口
      * true：公平队列-FIFO
      */
    static Semaphore semaphore = new Semaphore(2, true);

}
