package com.leetcode.junior.string;

/**
 * @author cgh
 * @create 2022-08-03 23:53
 * 反转字符串,双指针法
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] string = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};
        System.out.println(string);
        System.out.println("双指针反转");
        int left = 0;
        int right = string.length -1;
        while (left < right) {
           swap(string,left++,right--);
        }
        System.out.println(string);
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }
}
