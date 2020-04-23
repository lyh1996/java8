/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2020-04-17 15:33
 */
package defactAndTry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 重试监听器
 *
 * @author LYH
 * @date 2020/04/17 15:33
 */
public class WebResponseListener implements RetryListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public <WebResponse> void onRetry(Attempt<WebResponse> attempt) {
        // 第几次重试,(注意:第一次重试其实是第一次调用)
        logger.info("retry time : [{}]", attempt.getAttemptNumber());

        // 距离第一次重试的延迟
        logger.info("retry delay : [{}]", attempt.getDelaySinceFirstAttempt());

        if (attempt.getAttemptNumber() == 3) {
            if (attempt.hasException()) {
                //TODO 若第几次调用还是存在错误  发送告警邮件或者发送告警短信
            }
        }
        // 重试结果: 是异常终止, 还是正常返回
        logger.info("hasException={}", attempt.hasException());
        logger.info("hasResult={}", attempt.hasResult());

        // 是什么原因导致异常
        if (attempt.hasException()) {
            logger.info("causeBy={}", attempt.getExceptionCause().toString());
        } else {
            // 正常返回时的结果
            logger.info("result={}", attempt.getResult());
        }

        logger.info("log listen over.");

    }

}