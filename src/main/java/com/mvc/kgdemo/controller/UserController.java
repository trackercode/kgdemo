package com.mvc.kgdemo.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mvc.kgdemo.common.constant.ResponseMsgConstant;
import com.mvc.kgdemo.common.page.PageInfo;
import com.mvc.kgdemo.common.page.PageTable;
import com.mvc.kgdemo.common.response.ReqInfo;
import com.mvc.kgdemo.service.UserService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/users")

//http://localhost:8088/users/getUser/41
public class UserController {
    @Autowired
    private UserService userService;

//    返回当个用户
    @RequestMapping("/getUser/{id}")
    public String getOneUser(@PathVariable int id){
        log.info("用户id： " + id);
        return userService.findOne(id).toString();
    }
//返回多个用户,参看postman中的kgdemo
    @RequestMapping("/getUser/sex")
    public PageTable getAllUser(@RequestBody ReqInfo inInfo){
        PageTable  pageTable=null;
        try {
            String rSex=inInfo.getCellStr("req_data", 0, "rSex");
            Map map = new HashMap();
            map.put("sex", rSex);
            int page=Integer.parseInt(inInfo.getBlock("req_data").getValue("page").toString());
            int size=Integer.parseInt(inInfo.getBlock("req_data").getValue("size").toString());
            //这句一定要写在sql执行之前,只对紧跟的第一条语句起作用
            Page<Map<String,Object>> startPage = PageHelper.startPage(page, size);
            List<Map<String,Object>> list = userService.queryUserBySex(map);
            pageTable= PageInfo.getPageTable(startPage, list);
        } catch (Exception e) {
            e.printStackTrace();
            pageTable=new PageTable();
            pageTable.setMsg(e.getMessage());
            pageTable.setCode(ResponseMsgConstant.ERROR.getCode());
        }
        return pageTable;
    }
}

