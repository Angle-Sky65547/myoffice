package com.neuedu.jstu.myoffice.service.impl;

import com.neuedu.jstu.myoffice.dao.ManagementMapper;
import com.neuedu.jstu.myoffice.service.ManagementService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    private ManagementMapper managementMapper;

    public boolean login(String name,String password){
        //业务判断
        if(StringUtils.isBlank(name)||StringUtils.isBlank(password)){
            return false;
        }
        if(name.trim().length()<5 || password.trim().length()<5){
            return false;
        }
        int count = managementMapper.login(name,password);
        if(1==count){
            return true;
        }
        return false;
    }
}
