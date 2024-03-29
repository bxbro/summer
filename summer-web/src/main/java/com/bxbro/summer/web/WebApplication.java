package com.bxbro.summer.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  web应用启动类
 * </p>
 * @author dong
 * @since 2021/1/3
 * @version 1.0.0
 */
@MapperScan("com.bxbro.summer.web.mapper")
@EnableScheduling
@SpringCloudApplication
@EnableHystrixDashboard
@EnableFeignClients(basePackages = "com.bxbro.summer.web.service.feign")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
