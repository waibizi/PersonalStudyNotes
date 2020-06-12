package com.waibizi;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author 吴典秋
 * @Date 2020/6/7 0:28
 * @Description: 生产者
 * @Version 1.0
 */
public class Producer {
    public static void main(String[] args) throws JMSException {
        //获取MQ的连接工程
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory
                ("admin", "admin",
                        "tcp://192.168.72.128:61617");
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话工厂
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        //创建点对点发送的队列
        Destination destination = session.createQueue("waibizi");
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        //设置生产者的模式，有两种可选 持久化 / 不持久化(这里选择不持久化)
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //创建一条文本消息
        String text = "Hello World";
        TextMessage message = session.createTextMessage(text);
        for (int i = 0;i<1;i++){
            //发送消息
            producer.send(message);
        }
        //关闭连接
        producer.close();
        session.close();
        connection.close();
    }
}
