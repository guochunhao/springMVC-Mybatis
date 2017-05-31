package com.chunhao.study.service.jms;

import javax.jms.Destination;

/**
 * Created by count on 17/5/31.
 *
 * 发送者发送消息服务类
 */
public interface ProduceService
{
    void sendMessage(Destination destination, final String message);
}
