package com.codeking.mybatis_plus_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CodeKing
 * @since 2023/7/9  22:57
 */
@RestController
public class helloController {

    @GetMapping("hello")
    public String hello(){
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        return "hello";
    }
}
