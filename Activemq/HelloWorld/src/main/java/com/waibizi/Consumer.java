package com.waibizi;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author 吴典秋
 * @Date 2020/6/7 1:41
 * @Description: 消费者
 * @Version 1.0
 */
public class Consumer {
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
        MessageConsumer consumer = session.createConsumer(destination);
        //接收消息(没有消息就持续等待)
        Message message = consumer.receive();
        if (message instanceof TextMessage){
            System.out.println("接收到的文本消息为"+((TextMessage)message).getText());
        }else{
            System.out.println(message);
        }
        consumer.close();
        session.close();
        connection.close();
    }
}
