package com.bxbro.summer.compute.controller;

import com.bxbro.summer.compute.task.ComputeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @description TODO
 * @date 2021/8/8
 */
@RestController
@RequestMapping("/compute")
public class ComputeController {

    @Autowired
    private ComputeTask computeTask;

    @GetMapping
    public Integer getComputeResult(@RequestParam("a")Integer a, @RequestParam("b")Integer b) {

        return computeTask.compute(a, b);
    }
}
