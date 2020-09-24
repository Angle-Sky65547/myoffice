package com.neuedu.jstu.myoffice.service.impl;

import com.neuedu.jstu.myoffice.dao.StationMapper;
import com.neuedu.jstu.myoffice.model.Station;
import com.neuedu.jstu.myoffice.service.StationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper stationMapper;

    @Override
    public boolean insert(Station station) {
        //为空判断
        if(null == station){
            return false;
        }
        // 2.不为空时，判断属性是否为空
        if(StringUtils.isBlank(station.getName())){
            return  false;
        }
        int line = stationMapper.insertSelective(station);
        if(1 == line){
            return  true;
        }

        return false;
    }

    @Override
    public boolean updata(Station station) {
        //为空判断
        if(null == station){
            return false;
        }
        // 2.不为空时，判断属性是否为空
        if(StringUtils.isBlank(station.getName())){
            return  false;
        }
        int line = stationMapper.updateByPrimaryKey(station);
        if(1 == line){
            return  true;
        }

        return false;
    }

    @Override
    public boolean deleteBath(Integer[] idList) {
        // 业务逻辑判断
        if (null == idList || 0 == idList.length) {
            return false;
        }
        for (Integer id : idList) {
            if (id < 1) {
                return false;
            }
        }

        // 调用数据访问层的方法批量删除
        int line = stationMapper.batchDelete(idList);
        if (line >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public Station selectByid(Integer id) {
        return stationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Station> selectAll() {
        return stationMapper.selectAll();
    }

    @Override
    public List<Station> search(Integer id, String name, String type) {
        // 3个参数都是模糊查询，所以不需要合法判断
        // 如果不是模糊查询，必须进行参数值的合法判断，如id == null
        return stationMapper.search(id, name, type);
    }
}
