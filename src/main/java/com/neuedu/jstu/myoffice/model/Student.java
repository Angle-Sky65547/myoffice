package com.neuedu.jstu.myoffice.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4230845381820787159L;
	private Integer id;
	private String name;

	public Student(Integer id, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.id = id;
	}

	public Student() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
