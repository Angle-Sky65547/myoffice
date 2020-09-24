package com.neuedu.jstu.myoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.jstu.myoffice.model.Student;
/**
 * 首页控制器：响应用户请求，显示相关页面
 * @Controller：响应用户的请求，返回指定页面或JSON数据
 * @RestController：响应用户请求，返回JSON数据，符合restfull风格，最终可以实现前后端分离项目，但需要使用JWT等技术配合，
 * 					前端使用nginx部署（HTML），后端使用tomcat部署（SSM或SpringBoot框架项目，不带页面）
 * @ControllerAdvice：特殊的控制器，实现诸如全局异常处理等场景
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = {"","/index"},method = RequestMethod.GET)
	public String index() {
		//完整的返回值（前缀 + 页面名称 + 后缀）："/WEB-INF/templates/"+ index + "html"
		return "index";
	}
	
	@RequestMapping(value = "/left",method = RequestMethod.GET)
	public String left() {
		//完整的返回值（前缀 + 页面名称 + 后缀）："/WEB-INF/templates/"+ index + "html"
		return "left";
	}
	
	
	@RequestMapping(value = "/content",method = RequestMethod.GET)
	public String content() {
		//完整的返回值（前缀 + 页面名称 + 后缀）："/WEB-INF/templates/"+ index + "html"
		return "content";
	}
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	@ResponseBody
	public Student hello() {
		Student student = new Student(1,"李文");
		return  student;
	}
}
