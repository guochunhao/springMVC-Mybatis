package com.chunhao.study.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by count on 17/6/1.
 */
public class ConsumerSessionAwareListener implements SessionAwareMessageListener<TextMessage>
{
    @Resource
    private Destination queueDestination;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException
    {
        System.out.println("ConsumerSessionAwareListener 接收到一条消息");
        System.out.println("ConsumerSessionAwareListener 接收消息内容是" + textMessage.getText());

        MessageProducer producer = session.createProducer(queueDestination);

        TextMessage returnMessage = session.createTextMessage(": ConsumerSessionAwareListener 已经接收到信息");

        producer.send(returnMessage);
    }

}
