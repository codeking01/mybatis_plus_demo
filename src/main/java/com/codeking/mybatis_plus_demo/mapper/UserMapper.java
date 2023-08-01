package com.codeking.mybatis_plus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.codeking.mybatis_plus_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /*@Insert("<script>" +
            "INSERT INTO user(userName,age,email) VALUES " +
            "<foreach collection='list' item='user' separator=','>" +
            "(#{user.userName},#{user.age},#{user.email})" +
            "</foreach> " +
            "ON DUPLICATE KEY UPDATE userName = VALUES(userName)" +
            "</script>")*/
    void insertOrUpdateBatch(@Param("list") List<User> list);

    User getUserById(@Param("id") Long list);

    default void deleteUserByID(@Param("Id") Long id) {
        User user = this.selectById(id);
        user.setOpStatus(false);
        //this.update(user, Wrappers.<User>lambdaUpdate().eq(User::getId,id));
        this.updateById(user);
    }

    void deleteUserByUpdateID(Long id);


    // 根据邮件去查看
    default User getEmail(Integer email) {
        return this.selectOne(Wrappers.<User>lambdaQuery()
                .eq(User::getEmail, email));
    }

}