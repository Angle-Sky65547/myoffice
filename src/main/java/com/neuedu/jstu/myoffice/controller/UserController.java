package com.neuedu.jstu.myoffice.controller;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.User;
import com.neuedu.jstu.myoffice.service.UserService;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/eminformation/searchpro", method = RequestMethod.GET)
    public String search(@RequestParam(name = "id", defaultValue = "") Integer id, String name, String eduback,
                         Model model) {
        // 调用业务逻辑接口实现类对象，返回所有部门信息对象集合
        List<User> users = userService.search(id, name, eduback);
        // 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
        ResultBean resultBean = new ResultBean(200, "查询返回员工信息", true, users);
        model.addAttribute("myofficesu", resultBean);
        return "eminformation/user";
    }

    @RequestMapping(value = "/eminformation/user",method = RequestMethod.GET)
    public String managerDepartments(Model model) {
        List<User> users = userService.selectAll();
        ResultBean resultBean = new ResultBean(200,"所有员工信息",true,users);
        model.addAttribute("myofficesu", resultBean);
        return "eminformation/user";
    }
    @RequestMapping(value = "/eminformation/deletepro", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean batchDelete(@RequestParam("ids[]")Integer[] ids){
        boolean flag = userService.deleteBatch(ids);
        ResultBean resultBean = new ResultBean();
        if(flag){
            resultBean.setCode(200);
            resultBean.setMessage("删除部门信息成功");
            resultBean.setSuccess(true);
        }
        else {
            resultBean.setCode(500);
            resultBean.setMessage("删除部门信息失败");
            resultBean.setSuccess(false);
        }
        return resultBean;
    }

    @RequestMapping(value = "/eminformation/updateUser", method = RequestMethod.GET)
    public String updataPost(Integer id, Model model) {
        User user = userService.selectByid(id);
        ResultBean resultBean = new ResultBean(200, "查询成功", true, user);
        model.addAttribute("myofficesu", resultBean);
        System.out.println(resultBean.getCode());
        System.out.println(resultBean.toString());
        System.out.println(resultBean.getData().toString()+"123123123");
        System.out.println(user.toString()+"------------");
        return "/eminformation/updateUser";
    }




    @RequestMapping(value = "eminformation/save", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean save(User user) {
        ResultBean resultBean = new ResultBean();
        boolean flag = userService.update(user);
        if (flag) {
            resultBean.setCode(200);
            resultBean.setMessage("修改成功！");
            resultBean.setSuccess(true);
        } else {
            resultBean.setCode(500);
            resultBean.setMessage("修改失败！");
            resultBean.setSuccess(false);
        }

        return resultBean;
    }

}
