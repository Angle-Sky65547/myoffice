package com.neuedu.jstu.myoffice.controller;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Employee;
import com.neuedu.jstu.myoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmInformationController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/eminformation/e-select",method = RequestMethod.GET)
    public String e_select(){
        return "/eminformation/e-select";
    }

    /**
     * 组合查询
     *
     * @param
     * @param name
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/eminformation/search_em", method = RequestMethod.GET)
    public String search_em(@RequestParam(name = "idcard", defaultValue = "") String idcard, String name, String departmentname,
                         Model model) {
        // 如果是字符类型，空字符串处理为null
        name = org.apache.commons.lang3.StringUtils.isBlank(name) ? null : name;
        departmentname = org.apache.commons.lang3.StringUtils.isBlank(departmentname) ? null : departmentname;
        // 调用业务逻辑接口实现类对象，返回所有部门信息对象集合
        List<Employee> employees = employeeService.search_em(idcard,name,departmentname);
        // 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
        ResultBean resultBean = new ResultBean(200, "查询返回信息", true, employees);
        System.out.println(resultBean.getCode());
        System.out.println(employees.toString());
        model.addAttribute("myoffice",resultBean);
        return "/eminformation/e-select";
    }

  /*  @RequestMapping(value = "/eminformation/e-selectreslut/{id}", method = RequestMethod.GET)
    public String updataDepartment(Integer id,Model model) {
        Employee employee = employeeService.selectByid(id);
        ResultBean resultBean = new ResultBean(200,"查询成功",true,employee);
        model.addAttribute("myoffices",resultBean);
        return "/department/e-selectreslut";
    }*/

  @RequestMapping(value = "/eminformation/e_selectreslut", method = RequestMethod.GET)
  public String updataDepartment(Integer id,Model model) {
      Employee employee = employeeService.selectByid(id);
      ResultBean resultBean = new ResultBean(200,"查询成功",true,employee);
      model.addAttribute("myoffices",resultBean);
      return "/eminformation/e_selectreslut";
  }


    @RequestMapping(value = "/eminformation/e_selectreslut/{id}", method = RequestMethod.GET)
    public String e_selectreslut(@PathVariable("id")Integer id, Model model) {
        Employee employee = employeeService.selectByid(id);
        ResultBean resultBean = new ResultBean(200,"查询成功",true,employee);
        model.addAttribute("myoffices",resultBean);
        return "/eminformation/e_selectreslut";
    }

}
