package com.代码随想录.leetcode;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2023-02-03 13:45
 * leetcode977 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sorted(nums);
        System.out.println(Arrays.toString(result));
    }

    //双指针法
     private static int[] sorted(int[] nums) {
        int length = nums.length - 1;
        int[] result = new int[nums.length];
        int left = 0;
        int index = length;
        int right = length;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right]*nums[right]) {
                result[index--] = nums[right]*nums[right];
                right--;
                //todo
            } else {
                result[index--] =nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }
}
