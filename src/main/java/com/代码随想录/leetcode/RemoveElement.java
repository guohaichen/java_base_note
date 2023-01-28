package com.代码随想录.leetcode;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2023-01-28 19:33
 * leeetcode 27 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        System.out.println(removeElement(array, value));
        System.out.println(Arrays.toString(array));
    }

    // 解法思路 双指针，一个指针用来遍历数组，一个指针用来实际控制下标，给数组赋值
    static int removeElement(int[] array, int val) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[index] = array[i];
                //指针后移
                index++;
            }
        }
        return index;
    }
}
