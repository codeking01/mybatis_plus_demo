package com.codeking.mybatis_plus_demo;

import com.codeking.mybatis_plus_demo.entity.User;
import com.codeking.mybatis_plus_demo.mapper.UserMapper;
import com.codeking.mybatis_plus_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelectList() {
        //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        System.out.println("result: ");
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testSaveOrUpdate() {
        //userService.saveOrUpdate(new User("test", 18, "test@qq.com"));
        //userService.saveOrUpdate(new User("test", 19, "test@qq.com"));
        //userService.saveOrUpdate(new User("test", 20, "test@qq.com"));
        userService.saveOrUpdate(new User(1L,"uuuu", 20, "test@qq.com"));
    }

    @Test
    public void testSaveOrUpdateBatch() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1L,"testUpdate", 20, "test@qq.com"));
        list.add(new User(1L,"testUpdate", 18, "test@qq.com"));
        list.add(new User(1L,"123456", 25, "test@qq.com"));
        userService.saveOrUpdateBatch(list);
    }

    @Test
    public void testInsertOrUpdateBatch() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("testUpdate", 20, "test@qq.com"));
        list.add(new User("testUpdate", 18, "test@qq.com"));
        userMapper.insertOrUpdateBatch(list);
    }

    @Test
    public void testGetUserById() {
        System.out.println(userMapper.getUserById(1L));
    }


    @Test
    public void testPrintln() {
        System.out.println("start");
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }

}