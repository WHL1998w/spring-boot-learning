package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthTokenAspect
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/4/13
 **/
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    /**
     * 配置加上自定义注解的方法为切点
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {

    }
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        if (roleNames.length <= 1) {
            //只需要认证（登录）
            String id = request.getHeader("id");
            //id不为空,调用目标方法
            if (id != null) {
                return pjp.proceed();
            }
            //id为空,证明用户没有登录
            return "请先登录";

        } else {
            //验证身份
            String role = request.getHeader("role");
            log.info(role);
            for (String roleName : roleNames
            ) {
                if (roleName.equals(role)) {
                    return pjp.proceed();
                }
            }
            return "权限不足，无法访问";
        }
    }
}