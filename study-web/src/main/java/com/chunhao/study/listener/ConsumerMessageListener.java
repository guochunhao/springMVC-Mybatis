package com.chunhao.study.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by count on 17/5/31.
 */
public class ConsumerMessageListener implements MessageListener
{
    @Override
    public void onMessage(Message message)
    {
        TextMessage textMessage = (TextMessage) message;

        try
        {
            System.out.println("接收消息：" + textMessage.getText());

            System.out.println("开始进行接收到消息之后的业务逻辑处理");

        } catch (JMSException e)
        {
            e.printStackTrace();
        }

    }
}
