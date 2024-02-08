package com.leetcode.junior.array;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cgh
 * @create 2022-09-15 14:47
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * eg:输入: [2,2,1]
 * 输出: 1
 * eg:输入: [4,1,2,1,2]
 * 输出: 4
 */
public class OneTimesNumber implements Serializable {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 2, 3, 4, 5, 1, 6};
//        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    //解法1，利用Set
    private static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //对于 已添加过的元素，删除，最后set只剩下一个不重复的元素，
            if (!set.add(num)) {
                set.remove(num);
            }
        }

        return set.iterator().next();
    }

    //解法2、使用异或
    /*
    - 异或运算，相异为真，相同为假， a^a=0,a^0=a
    异或运算还满足交换律
     */
    private static int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            //因为异或运算，出现相同2次的数会为0，留下的便是出现1次的数
            result = num ^ result;
//            result ^= num;
        }
        return result;
    }
}
