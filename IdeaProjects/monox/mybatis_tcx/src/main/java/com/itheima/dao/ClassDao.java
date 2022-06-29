package com.itheima.dao;

import java.util.List;

public class ClassDao {
    private Integer id;
    private String className;
    private List<StudentDao> studentsList;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ClassDao{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }
}
