package com.mvc.kgdemo.service;

import com.mvc.kgdemo.entity.AccountUser2;
import com.mvc.kgdemo.entity.AccountUserBind;
import com.mvc.kgdemo.mapper.AccountUserBindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserBindService {
    @Autowired
    AccountUserBindMapper accountUserBindMapper;

    public List<AccountUserBind> findOneAccount(int id) {
        return accountUserBindMapper.findOneAccount(id);
    }

    public List<AccountUser2> findAllAccount2(){
        return accountUserBindMapper.findAllAccount2();
    }
}
