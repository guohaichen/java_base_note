package com.代码随想录.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author cgh
 * @create 2023-07-19
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class LeetCode349 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    //已试过hashmap,没做出来，改用hashSet,hashSet key不重复，value为new object;
    public static int[] intersection(int[] nums1, int[] nums2) {

        //存放其中一个数组的值
        HashSet<Integer> keyHashSet = new HashSet<>();
        //用来保存最后结果
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            keyHashSet.add(i);
        }
        for (int i : nums2) {
            //相同的值
            if (keyHashSet.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer integer : resultSet) {
            result[i++] = integer;
        }
        return result;
    }
}
