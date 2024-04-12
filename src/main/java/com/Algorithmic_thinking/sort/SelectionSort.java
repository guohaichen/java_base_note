package com.Algorithmic_thinking.sort;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-08-01 20:37
 * 思路：
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 重复第 2 步，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {22, 53, 4, 3, 1, 6, 8, 124, 532, 24, 464, 9, 47};
        //i代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < array.length - 1; i++) {
            //minIndex
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                //在剩余j个元素中找到最小的元素，
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                SwapUtil.swap(array, i, minIndex);
            }
            System.out.println("第" + i + "轮:\t" + "交换的元素:" + array[i] + "\t" + Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
}
