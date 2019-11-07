package com.ym.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matao
 * @create 2019-11-07 10:59
 */

@RestController
public class ExceptionController {

    @RequestMapping("/getUser")
    public String getUser(int i){
        int j;
        j = 1/i;
        return "success" + j;
    }

    @RequestMapping("/getMember")
    public String getMember(String name,String age){
        return "测试一下,使用AOP统一处理web请求日志";
    }
}
