package com.Algorithmic_thinking.sort;

import java.util.Arrays;

import static com.Algorithmic_thinking.sort.Bubbling.swap;

/**
 * @author cgh
 * @create 2022-08-01 20:37
 * 选择排序、
 * - 思路：
 * 将已排好序的元素放在元素前面，每次只对未排序的元素进行排序，就是选择排序；
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
