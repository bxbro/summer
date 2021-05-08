package com.bxbro.summer.study.mooc;

import java.util.Scanner;

/**
 * @author dong
 * @description 打印沙漏
 *
 * 浙大陈越老师 数据结构自测题第一题
 *
 * @date 2021/5/4
 */
public class SandGlassPrinter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        // 正整数N
        int N = scanner.nextInt();
        // 符号
        String symbol = scanner.next();

        int a = (N - 1) / 2;
        int b = (N - 1) % 2;

        int layer = 1;
        int count = 0;
        for (int i = 3; ; i = i + 2) {
            count += i;
            if (count > a) {
                count = count - i;
                break;
            }
            layer ++;
        }
        int mostLayer = layer;
        int n = 0;
        while (layer > 0) {
            int number = 3 + (layer - 2) * 2;
            for (int j = 0; j < number; j++) {
                System.out.print(symbol);
            }
            layer--;
            n++;
            System.out.println();
            if (layer > 0) {
                for (int l=0;l<n;l++) {
                    System.out.print(" ");
                }
            }
        }

        int k = 1;
        while (k < mostLayer) {
            int number2 = 3 + (k - 1) * 2;
            for (int m = 0; m < number2; m++) {
                System.out.print(symbol);
            }
            k++;
            System.out.println();
        }

        System.out.println((b+(a-count)*2));
    }
}
