package com.mvc.kgdemo.service;


import com.mvc.kgdemo.entity.Persons;
import com.mvc.kgdemo.mapper.PersonsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PersonsService {

    @Autowired
    PersonsMapper personsMapper;


    public List<Map<String, Object>> findAll(Map map){
        return personsMapper.findAll(map);
    }

    public Persons findOne(int id){
        return personsMapper.findOne(id);
    }

    public Persons updateById(Persons persons){
        return personsMapper.updateById(persons);
    }

    public List<Map<String, Object>> findSex(){
        return personsMapper.findSex();
    }

}
