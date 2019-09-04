package threadPool;

import java.util.concurrent.Callable;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对任务的抽象
 * @create 2019-08-09 8:08
 * @since 1.7
 */
public class GetContentTask implements Callable<String> {

    private String name;

    private Integer sleepTimes;

    public GetContentTask(String name, Integer sleepTimes) {
        this.name = name;
        this.sleepTimes = sleepTimes;
    }
    @Override
    public String call() throws Exception {
        // 假设这是一个比较耗时的操作
        Thread.sleep(sleepTimes * 1000);
        return "this is content : hello " + this.name;
    }
}
