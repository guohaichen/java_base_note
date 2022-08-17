package com.leetcode.junior.array;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-08-17 20:45
 * 旋转数组
 * 将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出:        [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate1(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    //解法1:创建一个临时数组
    static void rotate1(int[] nums, int key) {
        int[] temp = new int[nums.length];
        //拷贝一份数组
        System.arraycopy(nums, 0, temp, 0, nums.length);
        // (i+key)%nums.length key为偏移量，key肯定会超outOfIndex，对数组length求余
        for (int i = 0; i < nums.length; i++) {
            nums[(i+key)%nums.length] = temp[i];
        }
    }
}
