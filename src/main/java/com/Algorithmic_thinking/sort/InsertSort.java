package com.Algorithmic_thinking.sort;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-08-01 22:43
 * 插入排序
 * 算法步骤：类似打扑克
 * 取第一个元素，该元素被认为是已排序的
 * 取出下一个元素，和前面已排序的数组进行对比，从后向前扫描进行对比，
 * 如果小于前面已排序的数组，则进行交换，直至有序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    SwapUtil.swap(array, j - 1, j);
                }
            }
        }
        System.out.println("result:\t" + Arrays.toString(array));
    }
}
