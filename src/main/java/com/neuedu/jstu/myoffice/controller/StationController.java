package com.neuedu.jstu.myoffice.controller;

import com.neuedu.jstu.myoffice.bean.ResultBean;
import com.neuedu.jstu.myoffice.model.Employee;
import com.neuedu.jstu.myoffice.model.Station;
import com.neuedu.jstu.myoffice.service.EmployeeService;
import com.neuedu.jstu.myoffice.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 控制器DepartmentController：负责响应用户关于岗位相关操作的请求 接收前端HTML页面的请求，并向业务逻辑层请求（业务逻辑
 * 层向数据访问层请求），根据返回的结果，再向前端返回页面或json数据 统一返回数据类型，方便前端页面数据调用和绑定的统一
 * 
 * @author Administrator
 *
 */
@Controller
public class StationController {
	@Autowired
	private StationService stationService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/post/employeesPost", method = RequestMethod.GET)
	public String employeesPost(Integer id,Model model) {

		// 调用业务逻辑接口实现类对象，返回所有岗位信息对象集合
		Employee employee = employeeService.selectByPrimaryKey(id);
		// 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
		ResultBean resultBean = new ResultBean(200, "员工信息", true, employee);
		model.addAttribute("myoffice3", resultBean);
		return "/post/employeesPost";
	}

	/**
	 * 显示所有岗位信息信息
	 * 
	 * @return
	 */

	@RequestMapping(value = "/post/managerPost", method = RequestMethod.GET)
	public String managerPost(Model model) {

		// 调用业务逻辑接口实现类对象，返回所有岗位信息对象集合
		List<Station> station = stationService.selectAll();
		// 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
		ResultBean resultBean = new ResultBean(200, "所有岗位信息", true, station);
		model.addAttribute("myoffice2", resultBean);
		return "/post/managerPost";
	}

	/**
	 * 根据岗位编号，名称，类型组合查询
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/post/search", method = RequestMethod.GET)
	public String search(@RequestParam(name = "id", defaultValue = "") Integer id, String name, String type,
			Model model) {
		// 如果是字符类型，空字符串处理为null
		name = org.apache.commons.lang3.StringUtils.isBlank(name) ? null : name;
		type = org.apache.commons.lang3.StringUtils.isBlank(type) ? null : type;

		// 调用业务逻辑接口实现类对象，返回所有岗位信息对象集合
		List<Station> stations = stationService.search(id, name, type);
		// 将数据通过统一数据类型对象，传递至前端，thymeleaf是前后端支持，在后端的时候就进行了模板渲染
		ResultBean resultBean = new ResultBean(200, "查询返回岗位信息", true,stations );
		model.addAttribute("myoffice2", resultBean);
		return "/post/managerPost";
	}

	/**
	 * 显示新增岗位页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/post/createPost", method = RequestMethod.GET)
	public String createPost() {
		return "/post/createPost";
	}


	/**
	 * 显示修改岗位页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/post/updataPost", method = RequestMethod.GET)
	public String updataPost(Integer id, Model model) {
		Station station = stationService.selectByid(id);
		ResultBean resultBean = new ResultBean(200, "查询成功", true, station);
		model.addAttribute("myoffice2", resultBean);
		return "/post/updataPost";
	}


	/**
	 * 批量删除岗位数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "post/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean batchDelete(@RequestParam("ids[]") Integer[] ids) {
		boolean flag = stationService.deleteBath(ids);
		ResultBean resultBean = new ResultBean();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setMessage("删除岗位成功！");
			resultBean.setSuccess(true);
		} else {
			resultBean.setCode(500);
			resultBean.setMessage("删除岗位失败！");
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

//

	@RequestMapping(value = "post/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean save(Station station) {
		ResultBean resultBean = new ResultBean();

		boolean flag = stationService.insert(station);
		if (flag) {
			resultBean.setCode(200);
			resultBean.setMessage("修改岗位成功！");
			resultBean.setSuccess(true);
		} else {
			resultBean.setCode(500);
			resultBean.setMessage("修改岗位失败！");
			resultBean.setSuccess(false);
		}

		return resultBean;
	}


	@RequestMapping(value = "post/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean update(Station station) {
		ResultBean resultBean = new ResultBean();
		boolean flag = stationService.updata(station);
		if (flag) {
			resultBean.setCode(200);
			resultBean.setMessage("修改岗位成功！");
			resultBean.setSuccess(true);
		} else {
			resultBean.setCode(500);
			resultBean.setMessage("修改岗位失败！");
			resultBean.setSuccess(false);
		}

		return resultBean;
	}
}
