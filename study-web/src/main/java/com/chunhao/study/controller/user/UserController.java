package com.chunhao.study.controller.user;

import com.chunhao.study.common.BaseController;
import com.chunhao.study.model.user.User;
import com.chunhao.study.result.base.ResultObject;
import com.chunhao.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by count on 17/3/27.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 查询用户集合
     *
     * @param user
     * @param response
     */
    @RequestMapping("/list")
    public void listUser(User user, HttpServletResponse response)
    {
        logger.info("查询用户集合开始");

        List<User> allUser = userService.findAll();

        ResultObject resultObject = new ResultObject();

        resultObject.setObject(allUser);

        printJson(resultObject, response);

    }
}
