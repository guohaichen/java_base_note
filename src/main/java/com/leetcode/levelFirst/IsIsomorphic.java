package com.leetcode.levelFirst;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cgh
 * @create 2022-09-27 11:27
 * leetcode205 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "eggqwe";
        String t = "addyua";
//        System.out.println(isIsomorphic(s, t));
        System.out.println(solution(s, t));
    }

    //解法1
    static boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //哈希表双向映射
    static boolean solution(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            //双向映射，sMap中 e->a  tMap中 e->a；
            //sMap.containsKey(sChar)是必要的，否则第一次会空指针异常，而且如果不包含key，直接put效率更高
            if ((sMap.containsKey(sChar) && sMap.get(sChar) != tChar) || (tMap.containsKey(tChar) && tMap.get(tChar) != sChar)) {
                return false;
            }
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;
    }
}
