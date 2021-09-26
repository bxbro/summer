package com.bxbro.summer.common.aop;

import com.bxbro.summer.common.exception.SummerException;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.common.constant.SystemEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description controller日志切面
 * @Author dong
 * @Date 2020/12/9
 */
@Component
@Aspect
@Order(0)
public class ControllerLogAspect {

    private static final Logger logger
            = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("execution(* com.bxbro.summer.web.controller..*.*(..))")
    public void webRequest() {
    }


    @Around("webRequest()")
    public Object around(ProceedingJoinPoint pjp) {
        // 全局统一处理异常
        Object res = null;
        try {
            res = pjp.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof SummerException) {
                SummerException summerException = (SummerException) throwable;
                return BaseResponse.fail(summerException.getCode(), summerException.getMessage());
            }
            throwable.printStackTrace();
            return BaseResponse.fail(SystemEnum.FAIL.getCode(),"系统内部错误");
        }
        return res;
    }


}
