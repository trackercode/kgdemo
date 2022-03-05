package com.mvc.kgdemo.service;

import com.mvc.kgdemo.entity.AccountUser;
import com.mvc.kgdemo.entity.Classes;
import com.mvc.kgdemo.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    ClassesMapper classesMapper;

    public List<Classes> findClassesWithTeacher(int cid){
        return classesMapper.findClassesWithTeacher(cid);
    }
}
