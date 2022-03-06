package com.mvc.kgdemo.service;

import com.mvc.kgdemo.domain.AccountUser2;
import com.mvc.kgdemo.domain.AccountUserBind;
import com.mvc.kgdemo.dao.AccountUserBindDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserBindService {
    @Autowired
    AccountUserBindDao accountUserBindDao;

    public List<AccountUserBind> findOneAccount(int id) {
        return accountUserBindDao.findOneAccount(id);
    }

    public List<AccountUser2> findAllAccount2(){
        return accountUserBindDao.findAllAccount2();
    }
}
