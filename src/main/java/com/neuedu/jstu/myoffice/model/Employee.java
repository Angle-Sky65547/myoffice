package com.neuedu.jstu.myoffice.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private static final long serialVersionUID = -4912601001678979980L;
    private Integer id;

    private String name;

    private Integer sex;

    private Date birth;

    private String idcard;

    private Integer departmentid;

    private String departmentname;

    private Integer stationid;

    private String stationname;

    private Date employdate;

    private Date workdate;

    private Integer form;

    private String source;

    private String politics;

    private String folk;

    private String nation;

    private String phone;

    private String email;

    private String height;

    private String blood;

    private String status;

    private String homeplace;

    private String seat;

    private String eduback;

    private String edudegree;

    private String graschool;

    private String speciality;

    private Date gradate;

    private Integer tag;

    public Employee(Integer id, String name, Integer sex, Date birth, String idcard, Integer departmentid, String departmentname, Integer stationid, String stationname, Date employdate, Date workdate, Integer form, String source, String politics, String folk, String nation, String phone, String email, String height, String blood, String status, String homeplace, String seat, String eduback, String edudegree, String graschool, String speciality, Date gradate, Integer tag) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.idcard = idcard;
        this.departmentid = departmentid;
        this.departmentname = departmentname;
        this.stationid = stationid;
        this.stationname = stationname;
        this.employdate = employdate;
        this.workdate = workdate;
        this.form = form;
        this.source = source;
        this.politics = politics;
        this.folk = folk;
        this.nation = nation;
        this.phone = phone;
        this.email = email;
        this.height = height;
        this.blood = blood;
        this.status = status;
        this.homeplace = homeplace;
        this.seat = seat;
        this.eduback = eduback;
        this.edudegree = edudegree;
        this.graschool = graschool;
        this.speciality = speciality;
        this.gradate = gradate;
        this.tag = tag;
    }

    public Employee() {
        super();
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public Date getEmploydate() {
        return employdate;
    }

    public void setEmploydate(Date employdate) {
        this.employdate = employdate;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics == null ? null : politics.trim();
    }

    public String getFolk() {
        return folk;
    }

    public void setFolk(String folk) {
        this.folk = folk == null ? null : folk.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace == null ? null : homeplace.trim();
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat == null ? null : seat.trim();
    }

    public String getEduback() {
        return eduback;
    }

    public void setEduback(String eduback) {
        this.eduback = eduback == null ? null : eduback.trim();
    }

    public String getEdudegree() {
        return edudegree;
    }

    public void setEdudegree(String edudegree) {
        this.edudegree = edudegree == null ? null : edudegree.trim();
    }

    public String getGraschool() {
        return graschool;
    }

    public void setGraschool(String graschool) {
        this.graschool = graschool == null ? null : graschool.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public Date getGradate() {
        return gradate;
    }

    public void setGradate(Date gradate) {
        this.gradate = gradate;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", idcard='" + idcard + '\'' +
                ", departmentid=" + departmentid +
                ", departmentname='" + departmentname + '\'' +
                ", stationid=" + stationid +
                ", stationname='" + stationname + '\'' +
                ", employdate=" + employdate +
                ", workdate=" + workdate +
                ", form=" + form +
                ", source='" + source + '\'' +
                ", politics='" + politics + '\'' +
                ", folk='" + folk + '\'' +
                ", nation='" + nation + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", height='" + height + '\'' +
                ", blood='" + blood + '\'' +
                ", status='" + status + '\'' +
                ", homeplace='" + homeplace + '\'' +
                ", seat='" + seat + '\'' +
                ", eduback='" + eduback + '\'' +
                ", edudegree='" + edudegree + '\'' +
                ", graschool='" + graschool + '\'' +
                ", speciality='" + speciality + '\'' +
                ", gradate=" + gradate +
                ", tag=" + tag +
                '}';
    }
}