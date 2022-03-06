package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.AccountUser2;
import com.mvc.kgdemo.domain.AccountUserBind;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountUserBindDao {

    List<AccountUserBind> findOneAccount(int id);

    List<AccountUser2> findAllAccount2();
}
