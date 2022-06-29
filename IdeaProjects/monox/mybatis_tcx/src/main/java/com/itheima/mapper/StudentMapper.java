package com.itheima.mapper;

import com.itheima.dao.ClassDao;
import com.itheima.dao.StudentDao;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
//    @Select("select * from student where cid = #{cid}")
//    @Results({@Result(id = true, property = "id", column = "id"),
//              @Result(property = "name",column = "name"),
//              @Result(property = "age",column = "age"),
//              @Result(property = "cid", column = "cid")})
//    List<StudentDao> selectStudentById(Integer id);

//    @Select("select * from tb_student where s_id = #{id}")
//    @Results({@Result(id =true, property = "id",column = "s_id"),
//            @Result(property = "name",column = "s_name"),
//            @Result(property ="sex",column = "s_sex"),
//            @Result(property ="age",column = "s_age"),
//            @Result(property ="coursesList",column = "id",
//            many = @Many(select = "com.itheima.mapper.CourseMapper.selectCourseByStudentId"))})
        StudentDao selectStudentById(Integer id);

    //StudentDao selectStudentById(Integer id);


}
