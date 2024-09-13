package com.Algorithmic_thinking.od;


import java.util.Scanner;

/**
 * @author cgh
 * @create 2024/9/13
 * 对字符串中的所有单词进行倒排。
 * <p>
 * 说明：
 * <p>
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * <p>
 * 2、非构成单词的字符均视为单词间隔符；
 * <p>
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * <p>
 * 4、每个单词最长20个字母；
 * <p>
 * 数据范围：字符串长度满足 1 \le n \le 10000 \1≤n≤10000
 * 输入描述：
 * 输入一行，表示用来倒排的句子
 * <p>
 * 输出描述：
 * 输出句子的倒排结果
 * <p>
 * 示例1
 * 输入：
 * I am a student
 * 复制
 * 输出：
 * student a am I
 * 复制
 * 示例2
 * 输入：
 * $bo*y gi!r#l
 * 复制
 * 输出：
 * l r gi y bo
 */
public class WordsReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();

        reverse(str);
    }


    public static void reverse(String str) {
        char[] array = str.toCharArray();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //判断是否是字母
            if (Character.isLetter(array[i])) {
                string.append(array[i]);
            } else {
                string.append(" ");
            }
        }

        String s1 = string.toString();
        String[] s = s1.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = s.length - 1; i >= 0; i--) {
            result.append(s[i]).append(" ");
        }
        System.out.println(result);
    }
}
