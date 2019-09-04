package AQS.semaphore;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-08 14:27
 * @since 1.7
 */

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Student implements Runnable {

    //学生姓名
    private String name;

    //打饭许可
    private Semaphore semaphore;
    /**
     *      * 打饭方式
     *      * 0    一直等待直到打到饭
     *      * 1    等了一会不耐烦了，回宿舍吃泡面了
     *      * 2    打饭中途被其他同学叫走了，不再等待
     *      
     */

    private int type;


    public Student(String name, Semaphore semaphore, int type) {
        this.name = name;
        this.semaphore = semaphore;
        this.type = type;
    }

    /**
     *      * <p>打饭</p>
     *      *
     *      * @author hanchao 2018/3/31 19:49
     *      
     **/

    @Override
    public void run() {
        //根据打饭情形分别进行不同的处理
        switch (type) {
            //打饭时间
            //这个学生很有耐心，它会一直排队直到打到饭
            case 0:
                //排队
                semaphore.acquireUninterruptibly();
                //进行打饭
                try {
                    Thread.sleep(RandomUtil.randomLong(1000, 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //将打饭机会让后后面的同学
                semaphore.release();
                //打到了饭
                System.out.println(name + " 终于打到了饭.");
                break;

            //这个学生没有耐心，等了1000毫秒没打到饭，就回宿舍泡面了
            case 1:
                //排队
                try {
                    //如果等待超时，则不再等待，回宿舍吃泡面
                    if (semaphore.tryAcquire(RandomUtil.randomLong(6000, 16000), TimeUnit.MILLISECONDS)) {
                        //进行打饭
                        try {
                            Thread.sleep(RandomUtil.randomLong(1000, 3000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //将打饭机会让后后面的同学
                        semaphore.release();
                        //打到了饭
                        System.out.println(name + " 终于打到了饭.");
                    } else {
                        //回宿舍吃泡面
                        System.out.println(name + " 回宿舍吃泡面.");
                    }
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
                break;

            //这个学生也很有耐心，但是他们班突然宣布聚餐，它只能放弃打饭了
            case 2:
                //排队
                try {
                    semaphore.acquire();
                    //进行打饭
                    try {
                        Thread.sleep(RandomUtil.randomLong(1000, 3000));
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                    //将打饭机会让后后面的同学
                    semaphore.release();
                    //打到了饭
                    System.out.println(name + " 终于打到了饭.");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    //被叫去聚餐，不再打饭
                    System.out.println(name + " 全部聚餐，不再打饭.");
                }
                break;
            default:
                break;
        }
    }
}

