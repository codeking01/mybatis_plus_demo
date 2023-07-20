package com.codeking.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeking.mybatis_plus_demo.entity.NoDataResponse;
import com.codeking.mybatis_plus_demo.entity.User;
import com.codeking.mybatis_plus_demo.mapper.UserMapper;
import com.codeking.mybatis_plus_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
        //userService.saveOrUpdate(new User("NoDataResponse", 18, "NoDataResponse@qq.com"));
        //userService.saveOrUpdate(new User("NoDataResponse", 19, "NoDataResponse@qq.com"));
        //userService.saveOrUpdate(new User("NoDataResponse", 20, "NoDataResponse@qq.com"));
        userService.saveOrUpdate(new User(1L, "uuuu", 20, "NoDataResponse@qq.com"));
    }

    @Test
    public void testInsert() {
        int insert = userMapper.insert(new User("NoDataResponse12", 18, "NoDataResponse12@qq.com"));
        System.out.println("insert:" + insert);
    }

    @Test
    public void testSaveOrUpdateBatch() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1L, "testUpdate", 20, "NoDataResponse@qq.com"));
        list.add(new User(1L, "testUpdate", 18, "NoDataResponse@qq.com"));
        list.add(new User(1L, "123456", 25, "NoDataResponse@qq.com"));
        userService.saveOrUpdateBatch(list);
    }

    @Test
    public void testInsertOrUpdateBatch() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("testUpdate1", 20, "444"));
        list.add(new User("testUpdate1", 18, "777"));
        list.add(new User("testUpdate3", 18, "uuuu"));
        list.add(new User("testUpdate2", 18, "qqq"));
        list.add(new User("testUpdate4", 2999, "sss"));
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

    @Test
    public void testPrintln2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "testUpdate1");
        System.out.println("结果：*****************");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(1, 10);
        Page<User> userPage = userMapper.selectPage(page, null);
        //System.out.println(userPage);
        //获取分页数据
        List<User> list = userPage.getRecords();
        list.forEach(System.out::println);
        //System.out.println("当前页："+page.getCurrent());
        //System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        //System.out.println("总页数："+page.getPages());
        //System.out.println("是否有上一页："+page.hasPrevious());
        //System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void NoDataResponse() {
        NoDataResponse noDataResponse = new NoDataResponse();
        System.out.println(noDataResponse);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "testUpdate1");
        queryWrapper.eq("age", 88);
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("****");
        //todo list内容转化为json

        System.out.println(list);
    }
}