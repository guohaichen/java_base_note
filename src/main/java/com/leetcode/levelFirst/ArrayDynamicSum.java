package com.leetcode.levelFirst;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-09-27 11:11
 * leetcode1480 一位数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 */
public class ArrayDynamicSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
    }
}
