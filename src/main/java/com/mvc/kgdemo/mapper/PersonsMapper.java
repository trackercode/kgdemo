package com.mvc.kgdemo.mapper;

import com.mvc.kgdemo.entity.Persons;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonsMapper {
    List<Map<String,Object>> findSex();

    List<Map<String,Object>> findAll(Map map);

    Page<Persons> findBySexAndEmailContains(Map map);

    Map<String,Object> findBySex(Map map);

    Persons findById(Map map);

    Persons findOne(int id);

    Persons updateById(Persons persons);

}
