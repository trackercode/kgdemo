package com.mvc.kgdemo.service;


import com.mvc.kgdemo.entity.User;
import com.mvc.kgdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findOne(int id){
        return userMapper.findOne(id);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }
    public List<Map<String, Object>> queryUserBySex(Map map){
        return userMapper.queryUserBySex(map);
    }
}
