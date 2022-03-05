package com.mvc.kgdemo.mapper;

import com.mvc.kgdemo.entity.AccountUser;
import com.mvc.kgdemo.entity.AccountUser2;
import com.mvc.kgdemo.entity.AccountUserBind;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountUserBindMapper {

    List<AccountUserBind> findOneAccount(int id);

    List<AccountUser2> findAllAccount2();
}
