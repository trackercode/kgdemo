package com.mvc.kgdemo.service;


import com.mvc.kgdemo.domain.Persons;
import com.mvc.kgdemo.dao.PersonsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PersonsService {

    @Autowired
    PersonsDao personsDao;


    public List<Map<String, Object>> findAll(Map map){
        return personsDao.findAll(map);
    }

    public Persons findOne(int id){
        return personsDao.findOne(id);
    }

    public Persons updateById(Persons persons){
        return personsDao.updateById(persons);
    }

    public List<Map<String, Object>> findSex(){
        return personsDao.findSex();
    }


}
