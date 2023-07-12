package com.leetcode;

/**
 * @author cgh
 * @create 2023-07-12
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 */
public class Seven {
    public static void main(String[] args) {
        int x = -2147483648;
//        int x = -2147483648; 溢出情况
        System.out.println(reverse(x));
    }

    /*
    利用数学的方法，每次循环中拿到原数字的个位数，相加并每次x10,就能完成新数字的进位；

     */
    public static int reverse(int x) {
        int res = 0;
        //考虑内存溢出（2^31大概21亿，如果个位数为9,翻转的时候就是90多亿了。）
        while (x != 0) {
            int temp = res;
            res = res * 10 + x % 10;
            x = x / 10;
            //解决溢出
            if (res / 10 != temp) {
                return 0;
            }
        }
        return res;
    }

}
