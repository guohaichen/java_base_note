package com.Algorithmic_thinking.sort;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-07-26 21:39
 * 冒泡排序：
 * 1. 依次比较数组中两个相邻元素的大小，若a[j]>a[j+1]，交换两个元素的位置，两两都比较，直到比较至最后一个元素，都比较一遍成为一轮冒泡，结果是让该数组中最大的元素移至最后；
 * 2. 重复比较，直到整个数组有序；
 */
public class Bubbling {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            //优化点: 最大元素每次在排序后已经在数组末尾，可减少比较次数,增加一个标记位，在一次循环中，相邻两个元素没有发生位移，则将标志位为true,不会置为false，跳出循环
//            for (int j = 0; j < array.length-1; j++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 比较相邻的两个元素，
                if (array[j] > array[j + 1]) {
                    swap(array,j,j+1);
                    flag = false;
                }
            }
            System.out.println("遍历第" + i + "次结果:\t" + Arrays.toString(array));
            if (flag) {
                break;
            }
        }
        System.out.println("遍历完成:        \t" + Arrays.toString(array));
    }
    //交换元素，抽取成方法
    static void swap(int[] array, int pre, int next) {
        int temp = array[next];
        array[next] = array[pre];
        array[pre] = temp;
    }
}
