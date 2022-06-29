package com.itheima.mapper;

import com.itheima.dao.ClassDao;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassMapper {
    @Select("select * from class where id = #{id}")
    @Results({@Result(id =true, property = "id",column = "id"),
              @Result(property = "className",column = "className"),
              @Result(property ="studentsList",column = "id",
                      many = @Many(select = "com.itheima.mapper.StudentMapper.selectStudentByCid"))})
    ClassDao selectClassById(Integer id);

}
