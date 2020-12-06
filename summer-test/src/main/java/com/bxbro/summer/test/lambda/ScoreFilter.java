package com.bxbro.summer.test.lambda;

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
