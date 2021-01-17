package com.bxbro.summer.study.lambda.service.impl;

import com.bxbro.summer.study.lambda.model.Student;
import com.bxbro.summer.study.lambda.service.StudentFilter;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/5
 */
public class ScoreFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 80;
    }
}
