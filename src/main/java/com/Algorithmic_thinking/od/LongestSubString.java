package com.Algorithmic_thinking.od;

import java.util.Scanner;

/**
 * @author cgh
 * @create 2024/9/12
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * <p>
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：1\le s\le 150\1≤s≤150
 * 进阶：时间复杂度：O(n^3)\O(n
 * 3
 * ) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 * <p>
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 * <p>
 * 示例1
 * 输入：
 * asdfas
 * werasdfaswer
 * 复制
 * 输出：
 * 6
 *      a   s   d   a   s
 * w    0   0   0   0   0
 * e    0   0   0   0   0
 * r    0   0   0   0   0
 * a    1   0   0   0   0
 * s    0   2   0   0   0
 * d    0   0   3   0   0
 */
public class LongestSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(substring(s1, s2));
    }

    private static int substring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int max = 0;

        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Integer.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
