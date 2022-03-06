package com.mvc.kgdemo.service;

import com.mvc.kgdemo.domain.Classes;
import com.mvc.kgdemo.dao.ClassesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    ClassesDao classesDao;

    public List<Classes> findClassesWithTeacher(int cid){
        return classesDao.findClassesWithTeacher(cid);
    }
}
