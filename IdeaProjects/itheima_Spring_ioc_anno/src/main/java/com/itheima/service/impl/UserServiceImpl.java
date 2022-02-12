package com.itheima.service.impl;

import itheima.dao.UserDao;
import itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*<bean id = "userService" class = "itheima.service.impl.UserServiceImpl">
<property name="userDao" ref="userDao"></property>
</bean>*/
@Component("userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    @Qualifier("userDao")

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
