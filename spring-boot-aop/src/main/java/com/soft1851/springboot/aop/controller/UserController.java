package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wanghuanle
 * @date ：2020/4/7
 * @description：TODO
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

}
