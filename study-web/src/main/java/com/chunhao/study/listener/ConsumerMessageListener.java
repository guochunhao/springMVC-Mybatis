package com.chunhao.study.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by count on 17/5/31.
 *
 * MessageListener是最原始的消息监听器，
 * 它是JMS规范中定义的一个接口。其中定义了一个用于处理接收到的消息的onMessage方法，
 * 该方法只接收一个Message参数。
 */
public class ConsumerMessageListener implements MessageListener
{
    @Override
    public void onMessage(Message message)
    {
        TextMessage textMessage = (TextMessage) message;

        try
        {
            System.out.println("ConsumerMessageListener 接收消息：" + textMessage.getText());

            System.out.println("开始进行接收到消息之后的业务逻辑处理");

        } catch (JMSException e)
        {
            e.printStackTrace();
        }

    }
}
