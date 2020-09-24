package com.neuedu.jstu.myoffice.controller;


import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "department/demo_data",method = RequestMethod.GET)
    public ResultBean managerDepartments(Model model){
        List<Department> departments = departmentService.selectAll();
        ResultBean resultBean = new ResultBean(200,"所有部门信息",true,departments);
        return resultBean;
    }
}
