package com.chunhao.study.controller.jms;

import com.alibaba.fastjson.JSON;
import com.chunhao.study.common.BaseController;
import com.chunhao.study.model.user.User;
import com.chunhao.study.result.base.Result;
import com.chunhao.study.service.jms.ProduceService;
import com.chunhao.study.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by count on 17/5/31.
 */
@Controller
@RequestMapping("/jms")
public class JmsTestController extends BaseController
{
    @Autowired
    private ProduceService produceService;

    @Autowired
    @Qualifier("sessionAwareQueueDestination")
    private Destination sessionAwareQueueDestination;

    /**
     * 测试 sessionAwareListener
     */
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Resource
    private UserService userService;

    @RequestMapping("/testJmsSend")
    public void testSend(HttpServletResponse response)
    {

        List<User> allUser = userService.findAll();

        String jsonUser = JSON.toJSONString(allUser);
        System.out.println("发送内容为：" + jsonUser);

        try
        {
            produceService.sendMessage(destination, jsonUser);
            printJson(new Result(1, "jms 发送成功!"), response);

        } catch (Exception e)
        {
            e.printStackTrace();
            printJson(new Result(0, "jms 发送失败!"), response);
        }


    }

    @RequestMapping("/receiveBySessionAware")
    public void receiveBySessionAware(HttpServletResponse response)
    {

        List<User> allUser = userService.findAll();

        String jsonUser = JSON.toJSONString(allUser);
        System.out.println("发送内容为：" + jsonUser);

        try
        {
            produceService.sendMessage(sessionAwareQueueDestination, jsonUser);
            printJson(new Result(1, jsonUser), response);

        } catch (Exception e)
        {
            e.printStackTrace();
            printJson(new Result(0, "jms 发送失败!"), response);
        }


    }
}
