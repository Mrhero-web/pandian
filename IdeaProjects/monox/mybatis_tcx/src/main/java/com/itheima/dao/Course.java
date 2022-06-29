package com.itheima.dao;

import java.util.List;

public class Course {
    private String name;
    private int  credit;
    private int id;
    private List<StudentDao> studentsList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StudentDao> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentDao> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", credit=" + credit +
                ", id=" + id +
                ", studentsList=" + studentsList +
                '}';
    }
}
