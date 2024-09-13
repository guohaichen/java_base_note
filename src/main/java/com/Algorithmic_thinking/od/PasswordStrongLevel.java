package com.Algorithmic_thinking.od;

import java.util.Scanner;

/**
 * @author cgh
 * @create 2024/9/11
 */
public class PasswordStrongLevel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String pd = in.nextLine();
    }


    public static int solution(String pwd) {
        int sum = 0;
        if (pwd.isEmpty()) {
            return 0;
        }
        if (pwd.length() <= 4) {
            sum += 5;
        } else if (pwd.length() <= 7) {
            sum += 10;
        } else {
            sum += 25;
        }


        return sum;
    }
}
