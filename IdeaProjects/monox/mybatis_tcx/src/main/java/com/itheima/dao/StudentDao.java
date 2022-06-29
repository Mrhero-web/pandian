package com.itheima.dao;

import java.util.List;

public class StudentDao {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private List<Course> coursesList;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //private Integer cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Integer getCid() {
//        return cid;
//    }
//
//    public void setCid(Integer cid) {
//        this.cid = cid;
//    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", coursesList=" + coursesList +
                '}';
    }
}
