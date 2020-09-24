package com.neuedu.jstu.myoffice.model;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{
    /**
	 * 实体类Department：需要实现序列化接口，保证数据传递的稳定性和安全性
	 * 有时为了方便观察输出结果，会重写toString方法，正式发布时，可以删除
	 */
	private static final long serialVersionUID = -8776781013279019632L;

	private Integer id;

    private String name;

    private String type;

    private String telephone;

    private String fax;

    private String description;

    private String predepartment;

    private Date date;

    public Department( String name, String type, String telephone, String fax, String description, String predepartment, Date date) {
     
        this.name = name;
        this.type = type;
        this.telephone = telephone;
        this.fax = fax;
        this.description = description;
        this.predepartment = predepartment;
        this.date = date;
    }

    
    public Department(Integer id, String name, String type, String telephone, String fax, String description, String predepartment, Date date) {
    	this(name, type, telephone, fax, description, predepartment, date);
    	this.id = id;
       
    }

    public Department() {
        super();
    }
    
    @Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", type=" + type + ", telephone=" + telephone + ", fax="
				+ fax + ", description=" + description + ", predepartment=" + predepartment + ", date=" + date + "]";
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
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPredepartment() {
        return predepartment;
    }

    public void setPredepartment(String predepartment) {
        this.predepartment = predepartment == null ? null : predepartment.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}