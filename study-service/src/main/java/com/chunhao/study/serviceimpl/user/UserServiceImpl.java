package com.chunhao.study.serviceimpl.user;

import com.chunhao.study.mapper.user.UserExtMapper;
import com.chunhao.study.mapper.user.UserMapper;
import com.chunhao.study.model.user.User;
import com.chunhao.study.model.user.UserExt;
import com.chunhao.study.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private UserExtMapper userExtMapper;

    @Override
    public List<User> findAll()
    {
        return userMapper.selectByExample(null);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addUser(User record) throws Exception
    {

        try
        {
            int i = userMapper.insertSelective(record);
            i = 1 / 0;

            UserExt userExt = new UserExt();
            i = addUserExt(userExt);

            return i;
        } catch (Exception e)
        {
            throw new Exception("插入失败");
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addUserExt(UserExt record) throws Exception
    {
        try
        {
            record.setCompany("天源");
            record.setCoordinate("123");
            record.setUserId(12);

            int i = userExtMapper.insertSelective(record);

            i = 1 / 0;
            return i;
        } catch (Exception e)
        {
            throw new Exception("插入失败");
        }
    }

}
