package com.mvc.kgdemo.mapper;

import com.mvc.kgdemo.entity.AccountUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountUserMapper {

    List<AccountUser> findOneAccount(int id);
    List<AccountUser> findAllAccount();
}
