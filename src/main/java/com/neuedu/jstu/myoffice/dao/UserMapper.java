package com.neuedu.jstu.myoffice.dao;


import com.neuedu.jstu.myoffice.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> selectAll();
    List<User> search(@Param("id")Integer id, @Param("name")String name, @Param("eduback")String eduback);
    int batchDelete(Integer[] ids);
}