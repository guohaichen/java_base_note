package com.Algorithmic_thinking.recursion;

/**
 * @author cgh
 * @create 2024/5/14
 * 递归解决
 * 斐波那契数列
 * 因数学家莱昂纳多·斐波那契（Leonardo Fibonacci）以兔子繁殖为例子而引入，故又称“兔子数列”，其数值为：1、1、2、3、5、8、13、21、34
 * 在数学上，这一数列以如下递推的方法定z义：F(0)=1，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）。
 * 节约内存方式有：使用数组保存，降维等（因为只需要n-2,n-1的值），
 */
public class Fibonacci {
    public static void main(String[] args) {

        System.out.print(fibonacci(9) + "\t");
    }

    /*public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }*/
    public static int fibonacci(int n) {
        //定义一个数组存访
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n < 2) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
