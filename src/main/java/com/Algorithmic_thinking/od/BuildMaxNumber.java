package com.Algorithmic_thinking.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author cgh
 * @create 2024/9/11
 * 组成最大的数
 * 题目描述
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * <p>
 * 输入描述
 * <p>
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * <p>
 * 输出描述
 * <p>
 * 每组数据输出一个表示最大的整数。
 * <p>
 * 示例
 * <p>
 * 输入
 * <p>
 * 2
 * <p>
 * 12 123
 * <p>
 * 4
 * <p>
 * 7 13 4 246
 * <p>
 * 输出
 * <p>
 * 12312
 * <p>
 * 7424613
 */
public class BuildMaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            if (string.isEmpty()) {
                return;
            }
            int count = Integer.parseInt(string);
            String[] numbers = scanner.nextLine().split(" ");
            if (count != numbers.length) {
                return;
            }
            System.out.println(solution(numbers));
        }
    }

    public static String solution(String[] numbers) {
        //注意，这里用的是string的比较器，比较的是acsII码值，默认是升序，因为我们需要大的往前排，所以 采用了
        Arrays.sort(numbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();
        //如果第一个数为0，那么后面的数字都无效，直接返回0；

        for (String number : numbers) {
            sb.append(number);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
