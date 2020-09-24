package com.neuedu.jstu.myoffice.service;

import com.neuedu.jstu.myoffice.model.User;

import java.util.List;

/**
 * 业务逻辑层接口DepartmentService：根据用户的需求，确定具体的部门信息的业务操作行为
 * 除增删改查，还会增加新的方法，甚至会调用其他业务的方法
 * 对于调用者而言，知道接口的行为后，就可以编码，无需知道细节，实现了团队协作开发
 * 
 *
 */
public interface UserService {
/**
 * 新增部门信息
 * @param user 部门信息对象
 * @return 成功与否的标志
 */
	boolean insert(User user);
	
	/**
	 * 修改部门信息
	 * @param user 部门信息对象
	 * @return 成功与否的标志
	 */
	boolean update(User user);
	
	/**
	 * 批量删除部门信息
	 * @param idList 部门编号数组
	 * @return 成功与否的标志
	 */
	boolean deleteBatch(Integer[] idList);
	
	
	/**
	 * 根据部门编号查询部门信息
	 * @param id 部门编号
	 * @return 部门信息对象
	 */
	User selectByid(Integer id);
	
	/**
	 * 查询所有部门信息
	 * @return 部门信息对象集合
	 */
	List<User> selectAll();
	List<User> search(Integer id, String name, String eduback);
}
