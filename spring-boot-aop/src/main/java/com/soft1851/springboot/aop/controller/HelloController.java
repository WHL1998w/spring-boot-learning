package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/9
 **/
@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class HelloController {

    @RequestMapping(value = "hello")
    @ControllerWebLog(name = "getHello",isSaved = true)
    public String getHello(String arg1,int arg2){
        log.info("控制层获得参数：" + arg1);
        log.info("控制层获得参数："+ arg2);
        //休眠，模拟接口耗时
        try {
            Thread.sleep(6000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "hello spring boot";
    }
}