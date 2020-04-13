package com.soft1851.springboot.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GreetingController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/12
 **/
@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting")
    public String hello(String name){
        return "Hello" +" "+ name;
    }
}