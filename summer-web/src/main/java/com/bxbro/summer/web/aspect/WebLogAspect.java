package com.bxbro.summer.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 日志切面
 * @Author dong
 * @Date 2020/12/9
 */
@Component
@Aspect
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.bxbro.summer.web.controller..*.*(..))")
    public void Pointcut() {
    }

    @Before("Pointcut()")
    public void beforeMethod(JoinPoint joinPoint){
        logger.info("调用了前置通知");
    }

    //@After: 后置通知
    @After("Pointcut()")
    public void afterMethod(JoinPoint joinPoint){
        logger.info("调用了后置通知");
    }
    //@AfterRunning: 返回通知 rsult为返回内容
    @AfterReturning(value="Pointcut()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        logger.info("调用了返回通知");
    }
    //@AfterThrowing: 异常通知
    @AfterThrowing(value="Pointcut()",throwing="e")
    public void afterReturningMethod(JoinPoint joinPoint, Exception e){
        logger.info("调用了异常通知");
    }

    //@Around：环绕通知
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("around执行方法之前");
        Object object = pjp.proceed();
        logger.info("around执行方法之后--返回值：" +object);
        return object;
    }


}
