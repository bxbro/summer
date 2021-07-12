package com.bxbro.summer.study.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dong
 * @description TODO
 * @date 2021/5/29
 */
public class LambdaTest3 {

    public static void main(String[] args) {

        Predicate<String> pre = (username)->{
            return "admin".equals(username);
        };
        System.out.println(pre.test("manager"));


        List emptyList = Collections.EMPTY_LIST;
        Collections.sort(new ArrayList<>(), new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });


    }
}
