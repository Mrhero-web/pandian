package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

public  class staticFactory {
    public static UserDao  getUserDao() {
        return new UserDaoImpl();
    }
}
