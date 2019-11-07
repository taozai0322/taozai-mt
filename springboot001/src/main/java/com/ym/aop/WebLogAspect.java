package com.ym.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author matao
 * @create 2019-11-07 16:43
 */
@Aspect      //@Aspect  作用是把当前类标识为一个切面供应器读取
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(* com.ym.controller.*.*(..))")
    public void webLog(){

    }

    /**
     * 使用aop前置通知拦截请求参数的信息
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接收请求后，记录请求内容，
        ServletRequestAttributes attributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录如下的内容
        log.info("URL:{}",request.getRequestURL().toString());
        log.info("HTTP_METHOD:{}",request.getMethod());
        log.info("IP:{}",request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while(enu.hasMoreElements()){
            String name = (String)enu.nextElement();
            String value = request.getParameter(name);
            log.info("name：{}",name,"value:{}",value);
        }
    }

    /**
     * 后置通知
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void  doAfterReturning(Object ret) throws Throwable{
        //处理完请求后，返回内容
        log.info("RESPONSE:{}",ret);
    }
}
