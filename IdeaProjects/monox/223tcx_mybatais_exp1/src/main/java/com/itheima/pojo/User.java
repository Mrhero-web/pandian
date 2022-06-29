package com.itheima.pojo;

public class User {
    private Integer id ;
    private String name;
    private String major;
     private String xuehao;
public User(){}
    public User(Integer id,String name,String major,String xuehao){
        this.id = id;
        this.name = name;
        this.major = major;
        this.xuehao = xuehao;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", xuehao='" + xuehao + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

}
