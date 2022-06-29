package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
//import com.atguigu.mybatis.mapper.UserMapper;
//import org.apache.ibatis.annotations.Mapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DynamicSQLMapperTest {
    @Test
    public void testDeleMoreByArray() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //int result = mapper.deleteMoreByArray(new Integer[]{6,7,8});
        User result = mapper.findUserById(2);
        System.out.println(result);

    }
}
