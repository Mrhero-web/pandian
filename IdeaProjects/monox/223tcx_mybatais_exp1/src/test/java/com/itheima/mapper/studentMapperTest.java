package com.itheima.mapper;


import com.itheima.pojo.User;
import com.itheima.mapper.userMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class studentMapperTest {
/*    @Test
    public void testStudentMapper() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        userMapper mapper = sqlSession.getMapper(userMapper.class);
       // int result = mapper.deleteMoreByArray(new Integer[]{6,7,8});
        //System.out.println(result);

        User user = mapper.findStudentByNameAndMajor(new User(1,"null","null","1930090223"));
        System.out.println(user);
    }*/

    static SqlSession session = null;
    static userMapper  s = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis数据库,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper = new
                SqlSessionFactoryBuilder().build(reader);
        //创建SqlSession实例
        session = sqlMapper.openSession();
        s = session.getMapper(userMapper.class);
    }
    @Test
    public void testFindStudent() {
        User user = new User();
            //1.姓名查询
        //student.setName("李四");
        //2.姓名为空，专业不为空
        //student.setMajor("软件工程");
        //3.姓名，专业均为空
        List<User> students = s.findStudent(user);
        for (User student2 : students) {
            System.out.println(student2.toString());
        }
        session.close();
    }

    @Test
    public void testFindStudentById() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<User> students = s.findStudentById(list);
        for (User student2 : students) {
            System.out.println(student2.toString());
        }
        session.close();
    }

    @Test
    public void testUpdateStudent() {
        User student = new User();
        student.setId(1);
        student.setName("jasmine");
        student.setXuehao("193000101");
        int t  = s.updateStudent(student);
        session.commit();
        System.out.println(t);
        session.close();
    }


}
