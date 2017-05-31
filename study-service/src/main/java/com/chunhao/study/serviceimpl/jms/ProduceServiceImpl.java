package com.chunhao.study.serviceimpl.jms;

import com.chunhao.study.service.jms.ProduceService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by count on 17/5/31.
 *
 * 调用配置文件配置好的 jmdTemplate 模板的 send 方法
 */
@Service
public class ProduceServiceImpl implements ProduceService
{
    @Resource
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(Destination destination, final String message)
    {
        jmsTemplate.send(destination, new MessageCreator()
        {
            @Override
            public Message createMessage(Session session) throws JMSException
            {
                return session.createTextMessage(message);
            }
        });
    }
}
