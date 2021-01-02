package com.bxbro.summer.test.lambda;

/**
 * Student过滤器
 * @author dong
 * @date 2020/12/29
 */
public interface StudentFilter {
    /**
    * 比较Student
    * @author dong
    * @date 2020/12/29
    * @param student
    * @return boolean
    */
    boolean compare(Student student);
}
