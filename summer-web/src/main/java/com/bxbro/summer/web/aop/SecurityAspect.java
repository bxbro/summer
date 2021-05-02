package com.bxbro.summer.web.aop;

import com.bxbro.summer.web.annotation.SecurityAuth;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author dong
 * @description TODO
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
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //details里面可能存放了当前登录用户的详细信息，也可以通过cast后拿到
//        User user = (User) authenticationToken.getDetails();
        Object details = authenticationToken.getDetails();
        System.out.println(details.toString());
        String sessionId = ((WebAuthenticationDetails) details).getSessionId();
//        if (user == null) {
//            // fixme
//        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SecurityAuth auth = method.getAnnotation(SecurityAuth.class);
        String roleName = auth.roleName();

//        Collection<GrantedAuthority> authorities = user.getAuthorities();

        return joinPoint.proceed();
    }
}
