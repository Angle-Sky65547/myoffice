package com.neuedu.jstu.myoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpExceptionController {

    @RequestMapping(value = "/error/404")
    public String httpHandler(){
        return "/error/404";
    }
}
