package com.mvc.kgdemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mvc.kgdemo.common.constant.ResponseMsgConstant;
import com.mvc.kgdemo.common.page.PageInfo;
import com.mvc.kgdemo.common.page.PageTable;
import com.mvc.kgdemo.common.response.ReqInfo;
import com.mvc.kgdemo.common.utils.DateUtils;
import com.mvc.kgdemo.common.utils.poi.ExcelUtil;
import com.mvc.kgdemo.dao.PersonsDao;
import com.mvc.kgdemo.domain.Persons;
import com.mvc.kgdemo.service.PersonsService;
import com.mvc.kgdemo.vo.PersonsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/persons")

//http://localhost:8082/users/getUser/41
public class PersonsController {
    @Autowired
    private PersonsService personsService;

    @Autowired
    private PersonsDao personsDao;


//返回多个用户,参看postman中的kgdemo
    @RequestMapping("/query")
    public PageTable getAllUser(@RequestBody ReqInfo inInfo){
        PageTable  pageTable=null;
        try {
            String rSex=inInfo.getCellStr("req_data", 0, "sex");
            String rEmail=inInfo.getCellStr("req_data", 0, "email");
            Map map = new HashMap();
            map.put("sex", rSex);
            map.put("email", rEmail);
            int page=Integer.parseInt(inInfo.getBlock("req_data").getValue("page").toString());
            int size=Integer.parseInt(inInfo.getBlock("req_data").getValue("size").toString());
            //这句一定要写在sql执行之前,只对紧跟的第一条语句起作用
            Page<Map<String,Object>> startPage = PageHelper.startPage(page, size);
            List<Map<String,Object>> listData = personsService.findAll(map);
            pageTable= PageInfo.getPageTable(startPage, listData);
        } catch (Exception e) {
            e.printStackTrace();
            pageTable=new PageTable();
            pageTable.setMsg(e.getMessage());
            pageTable.setCode(ResponseMsgConstant.ERROR.getCode());
        }
        return pageTable;
    }

    //    返回当个用户
    @RequestMapping("/detail/{id}")
    public String getOnePersons(@PathVariable int id){
        log.info("用户id： " + id);
        Persons persons = personsService.findOne(id);
        return JSONObject.toJSONString(persons);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@PathVariable int id, @RequestBody Persons data) {
        Persons user = personsService.findOne(id);
        user.setPhone(data.getPhone());
        user.setZone(data.getZone());
        user=personsService.updateById(user);
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("/sex")
    public List<Map<String,Object>> findSex(){
        return personsService.findSex();
    }

    @PostMapping("/exportExcel")
    public void exportExcel(@RequestBody ReqInfo inInfo, HttpServletResponse response) throws IOException {
        PageTable  pageTable=null;
        try {
            String rSex=inInfo.getCellStr("req_data", 0, "sex");
            String rEmail=inInfo.getCellStr("req_data", 0, "email");
            Map queryMap = new HashMap();
            queryMap.put("sex", rSex);
            queryMap.put("email", rEmail);
            int page=Integer.parseInt(inInfo.getBlock("req_data").getValue("page").toString());
            int size=Integer.parseInt(inInfo.getBlock("req_data").getValue("size").toString());
            //这句一定要写在sql执行之前,只对紧跟的第一条语句起作用
            PageHelper.startPage(page, size);
            List<PersonsVO> dataList = personsDao.queryListExport(queryMap);
            ExcelUtil<PersonsVO> util = new ExcelUtil<PersonsVO>(PersonsVO.class);
            util.exportExcel(response, dataList, "厂内发运查询导出" + DateUtils.getCurrentDayyyyMMddHHmmss());
            inInfo.setMsg("查询成功，返回[" + dataList.size() + "]条信息！");
        } catch (Exception e) {
            e.printStackTrace();
            inInfo.setStatus(-1);
            inInfo.setMsg("检索失败!" + e.getMessage());
        }
    }

}

