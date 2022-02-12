package com.itheima.dao.impl;

import itheima.dao.UserDao;
import org.springframework.stereotype.Component;

/*<bean id ="userDao" class ="itheima.dao.impl.UserDaoImpl"></bean>*/
@Component("userDao")
public class UserDaoImpl implements UserDao {
    public  void save(){
        System.out.println("save running...");
    }
}
