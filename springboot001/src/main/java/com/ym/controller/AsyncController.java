package com.ym.controller;

import com.ym.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matao
 * @create 2019-11-07 19:04
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/async")
    public String user(){
        log.info("1：{}");
        String user = asyncService.user();
        log.info("4：{}");
        return "RESULT:" + user;
    }
}
