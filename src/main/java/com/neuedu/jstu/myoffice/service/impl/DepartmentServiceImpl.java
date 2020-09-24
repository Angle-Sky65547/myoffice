package com.neuedu.jstu.myoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;
import com.neuedu.jstu.myoffice.dao.DepartmentMapper;
import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.service.DepartmentService;

/**
 * 业务逻辑层接口中的所有方法 实现方法：简单判断 第三方 正则表达式 调用其他业务逻辑接口实现对象的方法参与.... 满足业务判断后，向数据访问层提交，
 * 通过属性注入的方法获取数据访问对象 使用注解@service，启动时，spring自动将其实例化
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public boolean insert(Department department) {
		// 1 为空判断
		if (null == department) {
			return false;
		}
		// 2.不为空时，判断属性为空是否（查看表中哪些属性不能为空的）
		// 使用第三方类库org.apache.commons.lang3.StringUtils的方法判断字符串null
		if (StringUtils.isBlank(department.getName())) {
			return false;
		}
		// 3.判断对象的属性在数据中是否唯一，例如身份证号码，手机号码
		// 实现方法：数据访问层需要专门提供一个方法来查询身份证，手机号码的唯一性
		// 4.插入的数据是从表类型时，需要判断外键在主表中是否存在

		// 5.特定的业务需求例如年龄必须大于18岁
		// 业务满足后，向数据访问层提交
		int line = departmentMapper.insertSelective(department);
		if (1 == line) {
			return true;
		}

		return false;
	}

	@Override
	public boolean update(Department department) {
		// 1 为空判断
		if (null == department) {
			return false;
		}
		// 2.不为空时，判断属性为空是否（查看表中哪些属性不能为空的）
		// 使用第三方类库org.apache.commons.lang3.StringUtils的方法判断字符串null
		if (StringUtils.isBlank(department.getName())) {
			return false;
		}
		// 3.判断对象的属性在数据中是否唯一，例如身份证号码，手机号码
		// 实现方法：数据访问层需要专门提供一个方法来查询身份证，手机号码的唯一性
		// 4.修改的数据是从表类型时，需要判断外键在主表中是否存在
		// 5.特定的业务需求例如年龄必须大于18岁
		// 业务满足后，向数据访问层提交

		int line = departmentMapper.updateByPrimaryKey(department);
		if (1 == line) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteBatch(Integer[] idList) {
		if(null == idList || 0 == idList.length){
			return false;
		}
		for(Integer id:idList){
			if(id<1){
				return false;
			}
		}
		//调用数据访问层方法实现批量删除
		int line = departmentMapper.batchDelete(idList);
		if(line >= 1){
			return true;
		}
		return false;
	}

	@Override
	public Department selectByid(Integer id) {
		// 通常情况下，查询没有业务约束
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> selectAll() {
		// 通常情况下，查询没有业务约束
		return departmentMapper.selectAll();
	}

	@Override
	public List<Department> search(Integer id, String name, String type) {
		//3个参数都是模糊查询，所以不需要合法性判断
		//如果不是模糊查询，则需要进行判断 如id == null 不合法
		return departmentMapper.search(id,name,type);
	}

}
