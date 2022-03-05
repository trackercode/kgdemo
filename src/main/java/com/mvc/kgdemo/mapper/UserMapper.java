package com.mvc.kgdemo.mapper;

import com.mvc.kgdemo.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public interface UserMapper {

    User findOne(int id);
    List<User> findAll();
    List<Map<String, Object>> queryUserBySex(Map map);
}
