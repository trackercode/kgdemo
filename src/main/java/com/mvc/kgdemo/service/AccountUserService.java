package com.mvc.kgdemo.service;

import com.mvc.kgdemo.domain.AccountUser;
import com.mvc.kgdemo.dao.AccountUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserService {
    @Autowired
    AccountUserDao accountUserDao;

    public List<AccountUser> findOneAccount(int id){
        return accountUserDao.findOneAccount(id);
    }

    public List<AccountUser> findAllAccount(){
        return accountUserDao.findAllAccount();
    }
}
