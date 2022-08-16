package com.leetcode.junior.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-08-16 23:28
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * eg1：输入：nums = [1,2,3,1]
 * 输出：true
 * <p>
 * eg2: 输入：nums = [1,2,3,4]
 * 输出：false
 */
public class RepeatableElements {
    //解法1：双重for遍历，耗时长，内存消耗大
    public static void main(String[] args) {
        boolean flag = false;
        int[] nums = {1, 2, 3, 4};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    //解法2：先对数组进行排序，排序后相等的两个元素肯定是相邻的，比较两个相邻的元素就行
    @Test
    public void solution2() {
        int[] nums = {1, 2, 3, 4};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                System.out.println(true);
            }
        }
        System.out.println(false);
    }
}
