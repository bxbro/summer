package com.bxbro.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/11/21
 */
@RestController
@RequestMapping("/api/v1/test")
public class HelloController {


    @GetMapping("/summer")
    public String sayHello() {
        return "Hello Miss Summer~";
    }

}
