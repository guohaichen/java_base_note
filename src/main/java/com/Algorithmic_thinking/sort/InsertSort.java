package com.Algorithmic_thinking.sort;

import java.util.Arrays;

import static com.Algorithmic_thinking.sort.Bubbling.swap;

/**
 * @author cgh
 * @create 2022-08-01 22:43
 * 插入排序
 * - 思路 和选择排序思路一样，分成两个子集；将未排序的元素在有序的子集中比较进行插入，
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        //i代表要插入元素的索引
        for (int i = 1; i < array.length; i++) {
            //j-1代表已排好序的子集，j=i，j就是将要插入的元素，需要将j元素从0->j-1个元素进行比较，插入
            for (int j = i; j > 0 ; j--) {
                if (array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
