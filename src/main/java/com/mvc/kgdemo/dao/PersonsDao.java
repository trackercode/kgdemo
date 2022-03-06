package com.mvc.kgdemo.dao;

import com.mvc.kgdemo.domain.Persons;
import com.mvc.kgdemo.vo.PersonsVO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonsDao {
    List<Map<String,Object>> findSex();

    List<Map<String,Object>> findAll(Map map);

    Page<Persons> findBySexAndEmailContains(Map map);

    Map<String,Object> findBySex(Map map);

    Persons findById(Map map);

    Persons findOne(int id);

    Persons updateById(Persons persons);

    //导出excle
    List<PersonsVO> queryListExport(Map<String, Object> map);



}
