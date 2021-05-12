/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-17 15:25
 */
package defactAndTry;

import JavaBase.Result;
import com.github.rholder.retry.AttemptTimeLimiters;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author LYH
 * @date 2020/04/17 15:25
 */
public class Test {
    public static void main(String[] args) {

       /* Callable<Result> callable = new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                // 需要重试的业务代码
                return Result.failed("失败");
            }
        };*/
        Test test = new Test();
        Callable<Result> searchResultTask = () -> {
            //do something

            // 这里测试下成功
            return Result.failed("200", "失败");
        };
        Retryer<Result> retry = test.retryer();
        try {
            Result call = retry.call(searchResultTask);
            ;
            System.out.println("call: " + call);
        } catch (RetryException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public Retryer<Result> retryer() {
        //定义重试机制
        Retryer<Result> retry = RetryerBuilder.<Result>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                // 如果返回参数是null需要重试
                .retryIfResult(Predicates.isNull())
                // 如果返回结果不是 0000 需要重试
                //.retryIfResult(webResponse -> !ReturnCodeEnum.SUCCESS.getCode().equals(webResponse.getCode()))
                .retryIfResult(result -> !"200".equals(result.getErrorCode()))
                // TODO 后期配置项挪入到 apollo
                //等待策略 ：每次请求间隔5s
                .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS))
                //停止策略 : 尝试请求6次
                .withStopStrategy(StopStrategies.stopAfterAttempt(6))
                //时间限制 : 某次请求不得超过30s , 类似: TimeLimiter timeLimiter = new SimpleTimeLimiter();
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(30, TimeUnit.SECONDS))
                .withRetryListener(new WebResponseListener())
                .build();
        return retry;
    }
}
