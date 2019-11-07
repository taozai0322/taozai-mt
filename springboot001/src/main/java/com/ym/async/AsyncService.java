package com.ym.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author matao
 * @create 2019-11-07 19:00
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public String user(){
        log.info("2：{}");
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        log.info("3：{}");
        return "测试异步Async执行....";
    }

}
