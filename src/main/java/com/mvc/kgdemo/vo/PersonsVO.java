package com.mvc.kgdemo.vo;

import com.mvc.kgdemo.common.annotation.Excel;
import lombok.Data;

@Data
public class PersonsVO {

    @Excel(name = "编号")
    private long id;

    @Excel(name = "创建时间")
    private String createDatetime;

    @Excel(name = "用户名称")
    private String username;

    @Excel(name = "电子邮件")
    private String email;

    @Excel(name = "电话")
    private String phone;

    @Excel(name = "性别")
    private String sex;

    @Excel(name = "地址")
    private String zone;
}
