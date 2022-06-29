package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
    * Mybatis面向接口编程的两个一致。
    * 映射文件 UserMapper.xml的 namespace要与接口UserMapper接口的全类名保持一致。
    * 映射文件 UserMapper.xml的SQL语句的 id 要与接口UserMapper接口的方法名一致。
    * 表--实体类--mapper接口--映射文件
    * */
/*
* 添加员工信息
* */
    //int insertUser();
    /*
    * 修改用户信息
    * */
    //void updateUser();
    /*
    * 通过ID查询user对象
    * */
    //User getUserById(int id);
    /*
    * 根据ID删除用户信息
    *
    * */
    //void deleteUserById(int i);
    /*
    * 查询所有用户信息
    *
    * */
    //List<User> getAllUsers();
    /*
     * 根据id查询用户信息
     *
     * */
    //User getUserByUsername(String username);
    /*
    * 验证登录
    * */
    //User checkLogin(String uname , int password);
    /*
     * 验证登录,参数为 map
     * */
    //User checkLoginByMap(Map<String ,Object> map);
    /*
    * 添加用户信息
    *
    * */
    //int insertUser(User user);
    /*
    * 验证登录（使用@param）
    * */
   // User checkLoginByParam(@Param("uname") String uname , @Param("password") Integer password);
   // public void addUser(User user);
    //User findUserByNameAndAge(User user);
    //User findUserByNameOrAge(User user);
    @Select("select * from users where id = #{id}")
    User findUserById( int userid);

}
