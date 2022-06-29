package com.itheima.mapper;
import com.itheima.pojo.User;

import java.util.List;

public interface userMapper {
    /*User findStudentByNameAndMajor(User user);
    List<User> findStudentById();
    void updateStudent();*/
    List<User> findStudent(User user);
    List<User> findStudentById(List<Integer> list);
    int updateStudent(User user);

}
