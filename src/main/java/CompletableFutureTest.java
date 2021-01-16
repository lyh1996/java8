/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-12-30 15:43
 */

import JavaBase.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LYH
 * @date 2020/12/30 15:43
 */
public class CompletableFutureTest {

   /* public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            int i =1/0;
            return 1;
        });
        f1.get();
        System.out.println("CompletableFuture Test");
    }*/

   /* public static void main(String[] args) {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            int i =1/0;
            return 1;
        });
        CompletableFuture.allOf(f1).join();
        System.out.println("CompletableFuture Test");
    }*/

    public static void main(String[] args) {
        //3、如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        User test = new User("test3", "hah", 12, 12.0);
        AtomicReference<User> atomicReference2 = new AtomicReference<>(test);
        Boolean bool = atomicReference2.compareAndSet(test, new User("test4", "hah", 12, 12.0));
        System.out.println(atomicReference2.get());
    }
}