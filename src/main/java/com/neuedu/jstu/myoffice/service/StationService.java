package com.neuedu.jstu.myoffice.service;

import com.neuedu.jstu.myoffice.model.Department;
import com.neuedu.jstu.myoffice.model.Station;

import java.util.List;

public interface StationService {
    /**
     * 新增岗位信息
     * @param station
     * @return
     */
    boolean insert(Station station);

    /**
     * 修改岗位信息
     * @param station
     * @return
     */
    boolean updata(Station station);

    /**
     * 批量删除信息
     * @param idList
     * @return
     */
    boolean deleteBath(Integer[] idList);

    /**
     * 根据部门编号查询部门信息
     *
     * @param id 部门编号
     * @return 部门信息对象
     */
    Station selectByid(Integer id);

    /**
     * 查询所有部门信息
     *
     * @return 部门信息对象集合
     */
    List<Station> selectAll();

    /**
     * 根据部门编号，名称，类型查询
     *
     * @param id   部门编号
     * @param name 名称
     * @param type 类型
     * @return 部门信息对象集合
     */
    List<Station> search(Integer id, String name, String type);
}
