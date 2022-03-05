package com.mvc.kgdemo.entity;

import java.util.List;

public class Classes {
    private Integer cid;
    private String cname;
    private List<Teacher> teachers;
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    @Override
    public String toString() {
        return "Classes [cid=" + cid + ", cname=" + cname + ", teachers=" + teachers + "]";
    }

}
