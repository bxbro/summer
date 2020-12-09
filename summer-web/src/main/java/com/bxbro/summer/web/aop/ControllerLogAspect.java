package com.bxbro.summer.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description controller日志切面
 * @Author dong
 * @Date 2020/12/9
 */
@Component
@Aspect
@Order(0)
public class ControllerLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.bxbro.summer.web.controller..*.*(..))")
    public void WebRequest() {
    }

    @Before("WebRequest()")
    public void beforeMethod(JoinPoint joinPoint){
        logger.info("调用了前置通知");
    }

    //@After: 后置通知
    @After("WebRequest()")
    public void afterMethod(JoinPoint joinPoint){
        logger.info("调用了后置通知");
    }

    //@AfterRunning: 返回通知 rsult为返回内容
    @AfterReturning(value="WebRequest()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        logger.info("调用了返回通知");
    }

    //@AfterThrowing: 异常通知
    @AfterThrowing(value="WebRequest()",throwing="e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e){
        logger.info("调用了异常通知");
    }

    //@Around：环绕通知
    @Around("WebRequest()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        threadLocal.set(System.currentTimeMillis());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.warn("[Thread:{}] - URL = {}, METHOD = {}, ARGS = {}", Thread.currentThread().getId(), request.getRequestURL(), request.getMethod(), pjp.getArgs());
        logger.warn("[Thread:{}] - 请求方法 : {}:", Thread.currentThread().getId(), pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());

        Object rvt = pjp.proceed(pjp.getArgs());

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        if(logger.isWarnEnabled()) {
            //LOGGER.warn("[Thread:{}] - 请求处理完毕, 状态 : {}, 耗时（毫秒）: {}, 结果 : {}", Thread.currentThread().getId(), response.getStatus(), System.currentTimeMillis() - threadLocal.get(), JSON.toJSONString(rvt));
            logger.warn(" [Thread:{}] - 请求处理完毕, 状态 : {}, 耗时（毫秒）: {}",  Thread.currentThread().getId(), response.getStatus(), System.currentTimeMillis() - threadLocal.get());
        }
        threadLocal.remove();

        return rvt;
    }


}
