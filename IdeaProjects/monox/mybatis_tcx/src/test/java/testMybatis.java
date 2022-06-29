import com.itheima.dao.StudentDao;
import com.itheima.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class testMybatis {
   @Test
    public void test() throws IOException {
       InputStream is = Resources.getResourceAsStream("com/itheima/mapper/mybatis-config.xml");
       SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
       SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
       SqlSession sqlSession = sqlSessionFactory.openSession(true);
       //ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
       //ClassDao res = classMapper.selectClassById(2);
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      StudentDao res = studentMapper.selectStudentById(1);
       System.out.println(res.toString());
   }
}
