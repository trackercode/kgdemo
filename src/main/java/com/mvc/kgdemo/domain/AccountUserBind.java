package com.mvc.kgdemo.domain;

import java.io.Serializable;

public class AccountUserBind implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
    //从表实体应该包含一个主表实体的对象引用
    private User user;


    public Integer getId() {
        return id;
    }


    public Integer getUid() {
        return uid;
    }


    public Double getMoney() {
        return money;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public void setMoney(Double money) {
        this.money = money;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AccountUserBind{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }

}

