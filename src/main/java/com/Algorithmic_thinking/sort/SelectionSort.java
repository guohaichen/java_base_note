package com.Algorithmic_thinking.sort;

import java.util.Arrays;

import static com.Algorithmic_thinking.sort.Bubbling.swap;

/**
 * @author cgh
 * @create 2022-08-01 20:37
 * 选择排序
 * 思路：
 *      1. 将数组分成分成两个子集，已排序的和未排序的，每一轮从未排序中数组找到最小元素，并放入排序子集中；
 *      2. 反复以上步骤，直到整个数组有序；
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        //i代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < array.length - 1; i++) {
            //temp代表最小元素的索引
            int temp = i;
            for (int j = i + 1; j < array.length; j++) {
                //在剩余j个元素中找到最小的元素，
                if (array[temp] > array[j]) {
                    temp = j;
                }
            }
            if (i != temp) {
                swap(array, i, temp);
            }
            System.out.println("第"+i+"轮:\t"+"交换的元素:"+array[i]+"\t"+Arrays.toString( array));
        }
    }
}
