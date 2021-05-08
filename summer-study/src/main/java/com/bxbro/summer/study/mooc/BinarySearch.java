package com.bxbro.summer.study.mooc;

/**
 * @author dong
 * @description 二分查找
 * @date 2021/5/5
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {0,2,8,9,11,17,24,36,74};
        int x=24;
        binarySearch(array, x);
    }

    public static void binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length-1;
        int pos = 0;

        while(left < right) {
            int mid = (left + right) / 2;

            if (x > array[mid]) {
                left = mid +1;

            }else if (x < array[mid]) {
                right = mid;

            }else {
                pos = mid;
                break;
            }
        }
        System.out.println("查找到元素x的位置是："+pos);
    }
}
