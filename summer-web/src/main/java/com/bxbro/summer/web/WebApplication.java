package com.bxbro.summer.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 *  web应用启动类
 * </p>
 * @author dong
 * @since 2021/1/3
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.bxbro.summer.web.mapper")
@EnableScheduling
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
