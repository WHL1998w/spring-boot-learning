package com.soft1851.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @Description 自定义的web日志注解
 * @author wanguanle
 * @date 2020/4/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 调用的接口名称
     * @return
     */
    String name();

    /**
     * 标识该日志是否需要持久化存储
     * @return
     */
    boolean isSaved() default false;
}
