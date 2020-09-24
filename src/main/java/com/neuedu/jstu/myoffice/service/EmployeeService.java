package com.neuedu.jstu.myoffice.service;

import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {
    /**
     * 根据id 查询信息
     * @param id
     * @return
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * 条件查询
     * @param idcard
     * @param name
     * @param departmentname
     * @return
     */
   List<Employee> search_em(String idcard,String name,String departmentname);

    /**
     * 根据编号查询信息
     * @param id
     * @return
     */
    Employee selectByid(Integer id);

    /**
     * 修改信息
     * @param employee 部门信息对象
     * @return 成功与否的标志
     */
    boolean update(Employee employee);
}
