package com.leetcode.levelFirst;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2022-09-27 9:20
 * leetcode 724
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * eg1:
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * eg2:
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 */
public class CenterIndex {
    /* 解题思路：
    1. 遍历整个数组可以得知总和 sum
    2. 假定数组下标为i，这时判断 i数组的总和 == i数组右边的总和，如果相等，则返回i;
    2.1 leftSum == sum - nums[i] - rightSum;  ====> 2*leftSum ==sum-sum[i],省去遍历数组右边的总和时间复杂度 */
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {2, 1, -1};
        System.out.println(pivotIndex(nums));
    }

    static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            //判断i左边总和是否等于i右边总和
            if (2 * leftSum == sum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
