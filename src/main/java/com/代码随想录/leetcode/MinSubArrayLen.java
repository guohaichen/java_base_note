package com.代码随想录.leetcode;

/**
 * @author cgh
 * @create 2023-02-10 17:31
 * leetcode209
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(solutionDirect(nums, target));
        System.out.println(getMinSubArrayLen(nums, target));
    }

    //滑动窗口
    public static int getMinSubArrayLen(int[] array, int target) {
        // i 代表 数组下标指针，j 代表 滑动窗口
        int sum = 0;
        int subLength;
        int i = 0;
        int minSubLength = Integer.MAX_VALUE;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];
            while (sum >= target) {
                subLength = j - i + 1;
                //滑动窗口的重要实现，减去i元素，配合i++
                sum = sum - array[i];
                //指针后移
                i++;
                minSubLength = Math.min(subLength, minSubLength);
            }
        }
        return minSubLength == Integer.MAX_VALUE ? 0 : minSubLength;
    }

    //暴力求解 O(n^2)
    static int solutionDirect(int[] array, int target) {
        int subLength;
        int minSubLength = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum >= target) {
                    //获取子序列长度
                    subLength = j - i + 1;
                    //保留最小长度
                    minSubLength = Math.min(minSubLength, subLength);
                    // 符合条件，最小子序列，避免后续无效的j自增
                    break;
                }
            }
        }
        // 没有符合条件的返回0
        return minSubLength == Integer.MAX_VALUE ? 0 : minSubLength;
    }

}
