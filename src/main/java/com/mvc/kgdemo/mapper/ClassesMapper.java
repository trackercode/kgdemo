package com.mvc.kgdemo.mapper;

import com.mvc.kgdemo.entity.Classes;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {
    List<Classes> findClassesWithTeacher(int cid);
}
