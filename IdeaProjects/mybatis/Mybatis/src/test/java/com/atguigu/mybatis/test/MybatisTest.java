package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    /*@Test
    public void testUpdate() throws IOException {*/
        /*InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);*/
        //mapper.updateUser();
        //List<User> allUsers = mapper.getAllUsers();
        //allUsers.forEach(x-> System.out.println(x));
        //User userById = mapper.getUserById();
        /*User userById = mapper.getUserByUsername("李四");
        System.out.println(userById);
        User user = mapper.checkLogin("李四", 2);
        Map<String ,Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password","123456");
        User userByMap = mapper.checkLoginByMap(map);
        mapper.insertUser(new User(5,"李武",18,123456));
        User userByParam = mapper.checkLoginByParam("李武",123456);
        System.out.println(userById);*/
//        User user = new User();
//        user.setid(4);
//        user.setname("田春晓");
//        user.setage(18);
//        user.setPosition("董事长");
       /* int result  = mapper.insertUser();
        System.out.println("result:"+result);*/



    @Test
    public void testMybatis() throws IOException {
        //加载核心配置文件
//        //Resources.getResourceAsStream();
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        //获取SqlsessionFactoryBuilder
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        //获取sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        //获取sqlsession
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        //获取mapper接口对象
//        //返回 x.class , 即x的对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        /*int result = mapper.insertUser();
        System.out.println("result:" + result);*/
//        User user = new User();
//        mapper.updateUser();
//        user = mapper.getUserById(4);
//        System.out.println(user);
        //mapper.deleteUserById(4);
//        User user = new User();
//        user.setname("小明");
//        user.setage(18);
//        user.setPosition("老街");
        //System.out.println("{id=1,name = \"小明\",age=18,position=\"老街\"}");
/*        List<User> users = sqlSession.selectList("com.atguigu.mapper.UserMapper.findUserByNameAndAge");

        for (User user1 : users) {
            System.out.println(user1);
        }*/
      /*  List<User> users2 = sqlSession.selectList("com.atguigu.mapper.UserMapper.findUserByNameOrAge");
        for (User user2 : users2) {
            System.out.println(user2);
        }*/
        //sqlSession.close();



//        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
//SqlSession sqlSession = sqlSessionFactory.openSession();
//创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

//通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句
        //int result = userMapper.insertUser();
//sqlSession.commit();
        User result = userMapper.findUserById(6);
        System.out.println(result);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User result2 = userMapper2.findUserById(6);
        System.out.println(result2);

    }

    }
