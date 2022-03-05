package com.mvc.kgdemo.controller;

import com.mvc.kgdemo.entity.Classes;
import com.mvc.kgdemo.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

//    http://localhost:8088/classes/findClassesWithTeacher/1
    //------------------------多对多【通过班级查询老师信息】 参看ClassesController.java-------------------------
//    一对多和多对多映射都是一样
//    多对多的写法其实就是一对多写法，写法都一样，只是数据库表关系不一样，sql语句查询的不一样
    @RequestMapping("findClassesWithTeacher/{cid}")
    public List<Classes> findClassesWithTeacher(@PathVariable int cid){
        return classesService.findClassesWithTeacher(cid);
    }

}
