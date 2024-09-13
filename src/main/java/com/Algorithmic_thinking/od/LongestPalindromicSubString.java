package com.Algorithmic_thinking.od;

import java.util.Scanner;

/**
 * @author cgh
 * @create 2024/9/12
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * 数据范围：字符串长度1\le s\le 350\1≤s≤350
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 * <p>
 * 输出描述：
 * 返回最长回文子串的长度
 * <p>
 * 示例1
 * 输入：
 * cdabbacc
 * 复制
 * 输出：
 * 4
 * 复制
 * 说明：
 * abba为最长的回文子串
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        System.out.print(getLongest(str));
    }


    public static int count;

    public static int getLongest(String str) {
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length - 1; i++) {
            //以中间开始回文
            solution(array, i, i);
            //对称
            solution(array, i, i + 1);
        }
        return count;
    }

    public static void solution(char[] str, int l, int r) {
        while (l >= 0 && r < str.length && str[l] == str[r]) {
            l--;
            r++;
        }
        l++;
        r--;
        if (count < (r - l + 1)) {
            count = r - l + 1;
        }

    }
}
