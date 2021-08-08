package com.bxbro.summer.compute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dong
 * @description TODO
 * @date 2021/8/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ComputeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComputeApplication.class, args);
    }
}
