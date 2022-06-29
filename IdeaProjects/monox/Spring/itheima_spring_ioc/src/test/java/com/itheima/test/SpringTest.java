package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User1;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
@Test
public void test1(){

    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml") ;
    UserDao userDao = (UserDao) app.getBean("userDao");
    userDao.save();
//    UserDao userDao2 = (UserDao) app.getBean("userDao");
//    System.out.println(userDao);
//    System.out.println(userDao2);

//    UserService userService = (UserService) app.getBean("userService");
//    User1 user1 = (User1)app.getBean("user1");
//    System.out.println(user1);
//    Boolean login = userService.login("306高仁杰", "1930090306");
//    if(login){
//        System.out.println("登录失败");
//    }else{
//        System.out.println("登录成功");
//    }

}
}
