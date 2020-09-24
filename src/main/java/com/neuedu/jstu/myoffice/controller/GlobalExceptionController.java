package com.neuedu.jstu.myoffice.controller;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = {"com.neuedu.jstu.myoffice.controller","com.neuedu.jstu.myoffice.impl","com.neuedu.jstu.myoffice.dao"})
public class GlobalExceptionController {

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public ResultBean exceptionHandler1(RuntimeException ex){
//        return new ResultBean(555,"运行时异常",false,ex);
//
//    }

    @ExceptionHandler
    public String exceptionHandler1(RuntimeException ex, Model model){

        ResultBean resultBean = new ResultBean(555,"运行时异常",false,ex);
        model.addAttribute("myoffices",resultBean);
        return "/error/ex";
    }
}
