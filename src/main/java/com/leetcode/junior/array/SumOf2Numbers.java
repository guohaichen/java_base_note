package com.leetcode.junior.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cgh
 * @create 2022-09-15 15:42
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * eg:输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * eg:输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class SumOf2Numbers {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 15};
        int target = 26;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            //值位key，value为下标

            System.out.println(map.put(nums[i], i));
        }
        for (int i = 0; i < length; i++) {
            /* 常规解法 双for循环，用nums[i]+nums[j]==target可以得出两个数的下标；
            换个思路，已知nums[i] ，target - nums[i] 即可得到另一个数
            在第一次遍历数组时，我们已将数组的值为key，下标为value的形式存入了map，
            所以target - nums[i] 为我们想要拿到的key，通过这个key即可拿到下标，返回i和这个下标；
             */
            int oneNumber = target - nums[i];
            //  i != map.get(oneNumber)？——————> 以数组{3，5，3},target=6为例，
            // 第一次遍历时，i=3,而map中最终存的是{3，2},{3,0}这次被后来相同的key替换掉了
            if (map.containsKey(oneNumber) && (i != map.get(oneNumber))) {
                return new int[]{i, map.get(oneNumber)};
            }
        }
        throw new RuntimeException("no result");
    }
}
