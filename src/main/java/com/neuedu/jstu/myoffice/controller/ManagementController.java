package com.neuedu.jstu.myoffice.controller;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.Management;
import com.neuedu.jstu.myoffice.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ManagementController {
    @Autowired
    private ManagementService managementService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "checklogin",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean checkLogin(String name, String password, HttpSession session){
        ResultBean resultBean = new ResultBean(200,"登录成功",true);
        boolean flag = managementService.login(name,password);
        if(flag){
            //登过查询，获取用户详细信息
            Management management = new Management();
            management.setName(name);
            resultBean.setData(management);
            //保存至session中
            session.setAttribute("myoffices",resultBean);
        }
        else {
            resultBean = new ResultBean(200,"登录名或密码错误，登录失败",false);
            session.removeAttribute("myoffices");
        }
        return resultBean;
    }

    @RequestMapping(value = "exit",method = RequestMethod.GET)
    public String exit(HttpSession session){
        session.removeAttribute("myoffices");
        return "login";
    }
}
