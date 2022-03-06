package com.mvc.kgdemo.controller;


import com.mvc.kgdemo.domain.AccountUser;
import com.mvc.kgdemo.domain.AccountUser2;
import com.mvc.kgdemo.domain.AccountUserBind;
import com.mvc.kgdemo.domain.UserOtm;
import com.mvc.kgdemo.service.AccountUserBindService;
import com.mvc.kgdemo.service.AccountUserService;
import com.mvc.kgdemo.service.UserOtmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/account")

//http://localhost:8088/account/getAccount/41
public class AccountUserController {
    @Autowired
    private AccountUserService accountUserService;

    @Autowired
    private AccountUserBindService accountUserBindService;

    @Autowired
    private UserOtmService userOtmService;
//---------------------------------------------一对一---------------------------------------------------
    //方式1(继承)： 查询某个人所拥有的账户
    @RequestMapping("getAccount/{id}")
    public List<AccountUser> getOneAccount(@PathVariable int id){
        log.info("用户id： " + id);
        return accountUserService.findOneAccount(id);
    }
    //方式1（继承）: 查询所有人的所有账户（临时字段别名）
    @RequestMapping("getAccount/all")
    public List<AccountUser2> getAllAccount(){
        return accountUserBindService.findAllAccount2();
    }


    //方式2（引用）：查询某个人所拥有的账户
    @RequestMapping("getAccountBind/{id}")
    public List<AccountUserBind> getAllAccountBind(@PathVariable int id){
        return accountUserBindService.findOneAccount(id);
    }

//-------------------------------------------  一对多  -------------------------------------------------
//    一对多和多对多映射都是一样
//    查询所有用户，同时获取到用户下所有账户的信息
//    用户信息和他的账户信息为一对多关系，并且查询过程中如果用户没有账户信息，
//    此时也要将用户信息查询出来，我们想到了左外连接查询比较合适。
@RequestMapping("getAccountOtm/all")
public List<UserOtm> getAllOtmAccount(){
    return userOtmService.findAllAccount();
}

//------------------------多对多【通过班级查询老师信息】 参看ClassesController.java-------------------------
}

