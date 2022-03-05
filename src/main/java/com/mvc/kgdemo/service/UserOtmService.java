package com.mvc.kgdemo.service;


import com.mvc.kgdemo.entity.AccountUser;
import com.mvc.kgdemo.entity.UserOtm;
import com.mvc.kgdemo.mapper.UserOtmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOtmService {

    @Autowired
    UserOtmMapper userOtmMapper;

    public List<UserOtm> findAllAccount(){
        return userOtmMapper.findAll();
    }
}
