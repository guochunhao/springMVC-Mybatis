package com.chunhao.study.service.user;


import com.chunhao.study.model.user.User;
import com.chunhao.study.model.user.UserExt;

import java.util.List;

/**
 * Created by count on 17/3/17.
 */
public interface UserService
{
    List<User> findAll();

    int addUser(User record) throws Exception;

    int addUserExt(UserExt record) throws Exception;
}
