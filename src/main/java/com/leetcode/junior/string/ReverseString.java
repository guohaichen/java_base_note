package com.leetcode.junior.string;

/**
 * @author cgh
 * @create 2022-08-03 23:53
 * 反转字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] string = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        reverseString(string);
        System.out.println("双指针反转");
        System.out.println(string);
    }

    static void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        while (left < right) {
           swap(s,left++,right--);
        }
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }
}
