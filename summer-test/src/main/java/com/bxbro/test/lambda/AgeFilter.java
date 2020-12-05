package com.bxbro.test.lambda;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/5
 */
public class AgeFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getAge() > 18;
    }
}
