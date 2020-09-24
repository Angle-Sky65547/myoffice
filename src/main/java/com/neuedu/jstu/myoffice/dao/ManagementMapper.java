package com.neuedu.jstu.myoffice.dao;

import com.neuedu.jstu.myoffice.model.Management;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKey(Management record);

    int login(@Param("name")String name, @Param("password")String password);
}