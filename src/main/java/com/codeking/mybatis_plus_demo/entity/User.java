package com.codeking.mybatis_plus_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author CodeKing
 * @since 2023/7/7  17:21
 */
@TableName(value = "user")
@Data
public class User {
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    private String userName;
    private Integer age;
    private String email;
    @TableLogic(value = "1", delval = "0")
    private Boolean opStatus;

    public User(Long id, String userName, Integer age, String email, Boolean opStatus) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.opStatus = opStatus;
    }

    public User() {
    }

    public User(String userName, Integer age, String email) {
        this.userName = userName;
        this.age = age;
        this.email = email;
    }

    public User(Long id, String userName, Integer age, String email) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.email = email;
    }
}
