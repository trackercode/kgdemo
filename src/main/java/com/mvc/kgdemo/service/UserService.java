package com.mvc.kgdemo.service;


import com.mvc.kgdemo.domain.User;
import com.mvc.kgdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User findOne(int id){
        return userDao.findOne(id);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
    public List<Map<String, Object>> queryUserBySex(Map map){
        return userDao.queryUserBySex(map);
    }
}
