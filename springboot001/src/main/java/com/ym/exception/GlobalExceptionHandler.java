package com.ym.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全部捕获异常案例
 * 1、捕获返回json
 * 2、捕获返回页面
 * @author matao
 * @create 2019-11-07 11:01
 */
@ControllerAdvice(basePackages = "com.ym.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorResult(){
        // 实际开发中，怎么 将错误记录在日志中。
        Map<String, Object> errorResultMap = new HashMap<String, Object>();
        errorResultMap.put("errorCode", "500");
        errorResultMap.put("errorMsg", "全局捕获异常系统错误!");
        return errorResultMap;
    }
}
