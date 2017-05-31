package com.chunhao.study.serviceimpl.user;

import com.chunhao.study.mapper.user.UserMapper;
import com.chunhao.study.model.user.User;
import com.chunhao.study.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by count on 17/3/17.
 */
@Service
public class UserServiceImpl implements UserService
{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll()
    {
        return userMapper.selectByExample(null);
    }

}
