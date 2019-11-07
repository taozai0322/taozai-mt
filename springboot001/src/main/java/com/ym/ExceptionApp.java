package com.ym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author matao
 * @create 2019-11-07 10:54
 */
@SpringBootApplication
@EnableAsync
public class ExceptionApp {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionApp.class,args);
    }
}
