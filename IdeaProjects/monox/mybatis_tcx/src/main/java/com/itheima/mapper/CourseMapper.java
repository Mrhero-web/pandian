package com.itheima.mapper;

import com.itheima.dao.Course;
import com.itheima.dao.StudentDao;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {

//    @Select("select * from tb_course where c_id in (select sc_c_id from tb_select_course where sc_s_id = #{id})")
//    @Results({@Result(id =true, property = "id",column = "c_id"),
//            @Result(property = "name",column = "c_name"),
//            @Result(property ="credit",column = "c_credit")})
    List<Course> selectCourseByStudentId(Integer id);

    //List<Course> selectCourseByStudentId(Integer id);

}
