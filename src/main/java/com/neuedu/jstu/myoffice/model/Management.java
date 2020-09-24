package com.neuedu.jstu.myoffice.model;

import java.io.Serializable;

public class Management implements Serializable {

    private static final long serialVersionUID = 5482086273899547726L;
    private Integer id;

    private String password;

    private String name;

    public Management(Integer id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }


    public Management() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Management{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}