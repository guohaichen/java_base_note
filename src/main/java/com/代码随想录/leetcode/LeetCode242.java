package com.代码随想录.leetcode;

import java.util.HashMap;

/**
 * @author cgh
 * @create 2023-07-19
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class LeetCode242 {
    public static void main(String[] args) {
        String str1 = "rat";
        String str2 = "car";
        System.out.println(isAnagram(str1, str2));
    }

    //思路就是将其中一个字符串放入hashMap中步长+1，再将另一个字符串也放入hashMap，步长-1，
    // 如果对应key的value为0，则删除该键，最后判断hashMap是否为空就可以了
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            //对重复出现的字符进行自增,getOrDefault，key空默认为0
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
            if (hashMap.get(c) == 0) {
                hashMap.remove(c);
            }
        }
        return hashMap.isEmpty();
    }
}
