package com.bxbro.summer.compute.task;

import org.springframework.stereotype.Component;

/**
 * @author dong
 * @description TODO
 * @date 2021/8/8
 */
@Component
public class ComputeTask {

    public Integer compute(Integer a, Integer b) {
        return a+b;
    }
}
