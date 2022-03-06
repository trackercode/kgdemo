package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public interface UserDao {

    User findOne(int id);
    List<User> findAll();
    List<Map<String, Object>> queryUserBySex(Map map);
}
