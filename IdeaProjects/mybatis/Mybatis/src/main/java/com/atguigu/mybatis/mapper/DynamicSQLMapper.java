package com.atguigu.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

public interface DynamicSQLMapper {
    /*
     * 通过数组实现批量删除
     * */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
}
