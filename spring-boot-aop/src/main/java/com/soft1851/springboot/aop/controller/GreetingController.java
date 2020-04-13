package com.soft1851.springboot.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GreetingController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/12
 **/
@RestController
public class GreetingController {

    @RequestMapping(value = "/hello")
    public String hello(String name, HttpServletRequest request){
        if (request.getHeader("token").equals("50236548")){
            return "Hello" +" "+ name;
        }else {
            return "请求头错误";
        }
    }
}