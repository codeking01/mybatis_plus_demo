package com.codeking.mybatis_plus_demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.mybatis_plus_demo.entity.User;
import com.codeking.mybatis_plus_demo.mapper.UserMapper;
import com.codeking.mybatis_plus_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author CodeKing
 * @since 2023/7/7  17:41
 */
@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}