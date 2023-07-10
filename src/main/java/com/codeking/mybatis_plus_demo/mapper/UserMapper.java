package com.codeking.mybatis_plus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.mybatis_plus_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /*@Insert("<script>" +
            "INSERT INTO user(name,age,email) VALUES " +
            "<foreach collection='list' item='user' separator=','>" +
            "(#{user.name},#{user.age},#{user.email})" +
            "</foreach> " +
            "ON DUPLICATE KEY UPDATE name = VALUES(name)" +
            "</script>")*/
    void insertOrUpdateBatch(@Param("list") List<User> list);
    User getUserById(@Param("id") Long list);


}