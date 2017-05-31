package com.chunhao.study.mapper.user;

import com.chunhao.study.model.user.UserExt;
import com.chunhao.study.model.user.UserExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExtMapper {
    int countByExample(UserExtExample example);

    int deleteByExample(UserExtExample example);

    int deleteByPrimaryKey(Integer extId);

    int insert(UserExt record);

    int insertSelective(UserExt record);

    List<UserExt> selectByExample(UserExtExample example);

    UserExt selectByPrimaryKey(Integer extId);

    int updateByExampleSelective(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByExample(@Param("record") UserExt record, @Param("example") UserExtExample example);

    int updateByPrimaryKeySelective(UserExt record);

    int updateByPrimaryKey(UserExt record);
}