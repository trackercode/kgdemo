package com.mvc.kgdemo.service;

import com.mvc.kgdemo.entity.AccountUser;
import com.mvc.kgdemo.mapper.AccountUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUserService {
    @Autowired
    AccountUserMapper accountUserMapper;

    public List<AccountUser> findOneAccount(int id){
        return accountUserMapper.findOneAccount(id);
    }

    public List<AccountUser> findAllAccount(){
        return accountUserMapper.findAllAccount();
    }
}
