package com.neuedu.jstu.myoffice.service.impl;

import com.neuedu.jstu.myoffice.dao.EmployeeMapper;
import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Employee;
import com.neuedu.jstu.myoffice.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectByPrimaryKey(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> search_em(String idcard, String name, String departmentname) {
        return employeeMapper.search_em(idcard,name,departmentname);
    }

    @Override
    public Employee selectByid(Integer id) {
        // 通常情况下，查询没有业务约束
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Employee employee) {
        // 1 为空判断
        if (null == employee) {
            return false;
        }
        // 2.不为空时，判断属性为空是否（查看表中哪些属性不能为空的）
        // 使用第三方类库org.apache.commons.lang3.StringUtils的方法判断字符串null
        if (StringUtils.isBlank(employee.getName())) {
            return false;
        }
        // 3.判断对象的属性在数据中是否唯一，例如身份证号码，手机号码
        // 实现方法：数据访问层需要专门提供一个方法来查询身份证，手机号码的唯一性
        // 4.修改的数据是从表类型时，需要判断外键在主表中是否存在
        // 5.特定的业务需求例如年龄必须大于18岁
        // 业务满足后，向数据访问层提交

        int line = employeeMapper.updateByPrimaryKey(employee);
        if (1 == line) {
            return true;
        }
        return false;
    }
}
