package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.UserOtm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOtmDao {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<UserOtm> findAll();
}
