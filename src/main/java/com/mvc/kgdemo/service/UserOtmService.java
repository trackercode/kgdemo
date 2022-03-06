package com.mvc.kgdemo.service;


import com.mvc.kgdemo.domain.UserOtm;
import com.mvc.kgdemo.dao.UserOtmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOtmService {

    @Autowired
    UserOtmDao userOtmDao;

    public List<UserOtm> findAllAccount(){
        return userOtmDao.findAll();
    }
}
