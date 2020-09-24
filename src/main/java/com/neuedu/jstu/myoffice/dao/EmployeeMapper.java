package com.neuedu.jstu.myoffice.dao;

import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Employee;
import com.neuedu.jstu.myoffice.model.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> search(@Param("id") Integer id, @Param("name") String name, @Param("type") String type);

    List<Employee> search_em(@Param("idcard") String idcard, @Param("name") String name, @Param("departmentName") String departmentName);

    List<Employee> selectAll();

    Employee selectByid(Integer id);
}