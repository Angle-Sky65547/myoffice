package com.neuedu.jstu.myoffice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.jstu.myoffice.model.Department;
/**
 * 数据访问层接口DepartmentMapper：定义对表Department的具体的操作方法，具体得到实现SQL语句由XML文件决定，通过方法名进行关联
 * 必须使用注解@Repositary标识
 *
 */
@Repository
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);
    
    int updateByPrimaryKey(Department record);
    
    List<Department> selectAll();
    List<Department> search(@Param("id")Integer id,@Param("name")String name,@Param("type")String type);
    int batchDelete(Integer[] ids); //Integer[]-->array,List<Integer>-->list
}
  