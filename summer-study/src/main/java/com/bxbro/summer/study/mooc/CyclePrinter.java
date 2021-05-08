package com.bxbro.summer.study.mooc;

import java.util.Scanner;

/**
 * @author dong
 * @description 循环打印
 * @date 2021/5/4
 */
public class CyclePrinter {

    public static void main(String[] args) {
        System.out.println("please input:");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        long start = System.currentTimeMillis();

        print2(k);

        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }

    public static void print1(int k) {
        for (int i=1;i<=k;i++) {
            System.out.println(i);
        }
    }

    /**
     * 当 k=100000，报异常了  java.lang.StackOverflowError
     * @param k
     */
    public static void print2(int k) {
        if (k > 0) {
            print2(k -1);
        }
        System.out.println(k);
    }
}
