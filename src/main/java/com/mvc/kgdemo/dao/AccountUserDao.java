package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.AccountUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountUserDao {

    List<AccountUser> findOneAccount(int id);
    List<AccountUser> findAllAccount();
}
