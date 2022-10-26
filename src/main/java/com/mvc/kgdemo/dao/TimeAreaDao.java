package com.mvc.kgdemo.dao;


import com.mvc.kgdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TimeAreaDao {
    List<Map<String, Object>> queryByTime(Map map);
}
