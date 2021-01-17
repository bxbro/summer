package com.bxbro.summer.study.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author dong
 * @Date 2020/12/5
 */
public class LambdaTest {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 用例：创建线程
     */
    public static void test1() {
        // 写法一
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程");
            }
        });
        thread.start();

        // 写法二：lambda表达式替换了匿名内部类
        Thread thread1 = new Thread(()->{
            System.out.println("这也是一个线程");
        });
        thread1.start();
    }

    /**
     * 用例： List排序
     */
    public static void test2() {
        List<String> list = Arrays.asList("java", "C#", "javascript", "python", "vue");

        // 写法一
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String str: list) {
            System.out.println(str);
        }

        // 写法二
        Collections.sort(list, (a,b)->(a.length()-b.length()));
        list.forEach(System.out::println);
    }


}
