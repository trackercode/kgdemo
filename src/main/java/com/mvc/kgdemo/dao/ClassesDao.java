package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.Classes;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesDao {
    List<Classes> findClassesWithTeacher(int cid);
}
