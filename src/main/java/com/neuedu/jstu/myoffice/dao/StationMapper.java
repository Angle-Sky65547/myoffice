package com.neuedu.jstu.myoffice.dao;

import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);

    List<Station> selectAll();

    List<Station> search(@Param("id") Integer id, @Param("name") String name, @Param("type") String type);

    int batchDelete(Integer[] ids);
}