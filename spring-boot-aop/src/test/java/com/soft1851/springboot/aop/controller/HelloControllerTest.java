package com.soft1851.springboot.aop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@WebAppConfiguration
class HelloControllerTest {

    /**
     * 用于模拟调用controller的接口发起请求
     */
    private MockMvc mockMvc;
    //预加载内容，用来初始话对HiController的模拟
    @BeforeEach
    public  void  setUp() throws  Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }
    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/hello")
                .param("arg1","wanghuanle")
                .param("arg2", "22"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello spring boot"))
                .andDo(MockMvcResultHandlers.print());

    }
}