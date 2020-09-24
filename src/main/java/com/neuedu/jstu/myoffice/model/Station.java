package com.neuedu.jstu.myoffice.model;

import java.io.Serializable;

/**
 *
 */
public class Station implements Serializable {
    private static final long serialVersionUID = -134498886082940474L;
    private Integer id;

    private String name;

    private String type;

    private Integer number;

    public Station(Integer id, String name, String type, Integer number) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public Station() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}