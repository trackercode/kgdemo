package com.mvc.kgdemo.controller;



import com.alibaba.fastjson.JSONObject;
import com.mvc.kgdemo.dao.TimeAreaDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/timearea")

//http://localhost:8088/timearea/find
public class TimeAreaController {
    @Autowired
    TimeAreaDao timeAreaDao;

/*
  db2中时间字段作为查询条件并且时间字段中有null值时的 ibatis 会出错。
  mybatis在mysql中不会出现这个问题
 */

    @RequestMapping("/find")
    public String findByTime(){
        Map<String, Object> map = new HashMap();
        map.put("starttime", "2022-01-01");
        map.put("endtime", "2022-10-26");
        List<Map<String, Object>> timeAreaMap = timeAreaDao.queryByTime(map);
        String result = JSONObject.toJSONString(timeAreaMap);
        System.out.println("timeAreaMap: "+ result);
        return result;
    }

}

