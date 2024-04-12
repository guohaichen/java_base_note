package com.Algorithmic_thinking.sort;

/**
 * @author cgh
 * @create 2024/4/12
 * 工具类，两两交换
 */
public class SwapUtil {
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
