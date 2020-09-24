package com.neuedu.jstu.myoffice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.service.DepartmentService;

/**
 * 控制器DepartmentController：负责响应用户关于部门相关操作的请求 接收前端HTML页面的请求，并向业务逻辑层请求（业务逻辑
 * 层向数据访问层请求），根据返回的结果，再向前端返回页面或json数据 统一返回数据类型，方便前端页面数据调用和绑定的统一
 * 
 * @author Administrator
 *
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf.setLenient(true);
//		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
//	}

	/**
	 * 显示所有部门信息
	 * 
	 * @return
	 */

	@RequestMapping(value = "/department/managerDepartments", method = RequestMethod.GET)
	public String managerDepartments(Model model) {
		// 调用业务逻辑接口实现类对象，返回所有部门信息对象集合
		List<Department> departments = departmentService.selectAll();
		// 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
		ResultBean resultBean = new ResultBean(200, "所有部门信息", true, departments);
		model.addAttribute("myoffices", resultBean);
		return "/department/managerDepartments";
	}

	/**
	 * 根据部门编号，名称，类型组合查询
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/department/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "id", defaultValue = "") Integer id, String name, String type,
			Model model) {
		// 如果是字符类型，空字符串处理为null
		name = org.apache.commons.lang3.StringUtils.isBlank(name) ? null : name;
		type = org.apache.commons.lang3.StringUtils.isBlank(type) ? null : type;
		// 调用业务逻辑接口实现类对象，返回所有部门信息对象集合
		List<Department> departments = departmentService.search(id, name, type);
		// 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
		ResultBean resultBean = new ResultBean(200, "查询返回部门信息", true, departments);
		model.addAttribute("myoffices", resultBean);
		return "/department/managerDepartments";
	}

	/**
	 * 显示新增部门页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/department/createDepartment", method = RequestMethod.GET)
	public String createDepartment() {
		return "/department/createDepartment";
	}

	@RequestMapping(value = "/department/updataDepartment", method = RequestMethod.GET)
	public String updataDepartment(Integer id,Model model) {
		Department department = departmentService.selectByid(id);
		ResultBean resultBean = new ResultBean(200,"查询成功",true,department);
		model.addAttribute("myoffices",resultBean);
		return "/department/updataDepartment";
	}

	@RequestMapping(value = "/department/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean batchDelete(@RequestParam("ids[]")Integer[] ids)
	{
		boolean flag = departmentService.deleteBatch(ids);
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

	@RequestMapping(value = "department/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean update(Department department) {
		ResultBean resultBean = new ResultBean();
		boolean flag = false;
		if(null == department.getId()){
			flag= departmentService.insert(department);
			if (flag) {
				resultBean.setCode(200);
				resultBean.setMessage("新增部门成功！" +department.getId()); //和消息一起返回
				resultBean.setSuccess(true);
				resultBean.setData(department.getId()); //作为独一的数据返回 或做为department对象一起返回
			} else {
				resultBean.setCode(500);
				resultBean.setMessage("新增部门失败！");
				resultBean.setSuccess(false);
			}
		}else {
			flag = departmentService.update(department);
			if (flag) {
				resultBean.setCode(200);
				resultBean.setMessage("修改部门成功！" +department.getId()); //和消息一起返回
				resultBean.setSuccess(true);
				resultBean.setData(department.getId()); //作为独一的数据返回 或做为department对象一起返回
			} else {
				resultBean.setCode(500);
				resultBean.setMessage("修改部门失败！");
				resultBean.setSuccess(false);
			}
		}

		return resultBean;
	}
	@RequestMapping(value = "/department/updataDepartment/{id}", method = RequestMethod.GET)
		public String updateDepartment(@PathVariable("id")Integer id,Model model) {
		Department department = departmentService.selectByid(id);
		ResultBean resultBean = new ResultBean(200,"查询成功",true,department);
		model.addAttribute("myoffices",resultBean);
		return "/department/updataDepartment";
	}

	@RequestMapping("department/demo")
	public String demo(){
		return "/department/demo";
	}
}
