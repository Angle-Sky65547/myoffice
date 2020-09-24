package com.neuedu.jstu.myoffice.bean;

import java.io.Serializable;

/**
 * 统一返回数据类型ResultBean
 * @author Administrator
 *
 */
public class ResultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5559432799894942205L;
	private Integer code;//编号：200成功，其他失败
	private String message;//消息：成功或错误的信息
	private boolean success;//成功与否的标志
	private Object data;//后端返回给前端的页面数据
	
	
	public ResultBean() {
		
	}

	public ResultBean(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	public ResultBean(Integer code, String message, boolean success) {
		this(code, message);
		this.success = success;
		
	}
	

	public ResultBean(Integer code, String message, boolean success, Object data) {
		this(code, message, success);
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultBean{" +
				"code=" + code +
				", message='" + message + '\'' +
				", success=" + success +
				", data=" + data +
				'}';
	}
}
