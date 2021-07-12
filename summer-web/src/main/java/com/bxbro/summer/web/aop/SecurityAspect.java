package com.bxbro.summer.web.aop;

import com.bxbro.summer.web.annotation.SecurityAuth;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author dong
 * @description 权限校验 切面类
 * @date 2021/4/9
 */
@Aspect
@Component
public class SecurityAspect {

    @Pointcut("@annotation(com.bxbro.summer.web.annotation.SecurityAuth)")
    public void annotationAspect() {

    }

    @Around("annotationAspect()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        // 拿到响应
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        // 拿到当前登录的用户
        // fixme 如果在登录的时候有通过ThreadLocal来存用户的信息，则可以从ThreadLocal里获取当前登录的用户

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SecurityAuth auth = method.getAnnotation(SecurityAuth.class);
        String roleCodes = auth.roleCodes();

        // fixme 判断当前登录的用户的角色，是否在roleCodes中


        return joinPoint.proceed();
    }
}
