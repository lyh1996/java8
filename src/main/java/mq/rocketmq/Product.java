package mq.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

import java.util.Date;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-16 15:49
 * @since 1.7
 */
public class Product {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("rmq-instance");
        producer.setVipChannelEnabled(false);// // 必须设为false否则连接broker10909端口
        producer.start();
        System.out.println("开始发送数据");
        try {
            for (int i = 0; i < 3; i++) {
                Message msg = new Message("test1",// topic
                        "TagA",// tag
                        (new Date() + "这里是一条消息A" + i).getBytes()// body
                );
                Message msg2 = new Message("test2",// topic
                        "TagC",// tag
                        (new Date() + "这里是一条消息C" + i).getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                SendResult sendResult2 = producer.send(msg2);
                System.out.println("发送成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
