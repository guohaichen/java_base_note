package com.Algorithmic_thinking.knapsack;

import java.util.Arrays;

/**
 * @author cgh
 * @create 2024/5/16
 * 背包问题
 */
public class KnapsackProblem {
     /*
        1. n个物品都是固体，有重量和价值
        2. 现在你要取走不超过 10克 的物品
        3. 每次可以不拿或全拿，问最高价值是多少

            编号 重量(g)  价值(元)                        简称
            1   4       1600           黄金一块   400    A
            2   8       2400           红宝石一粒 300    R
            3   5       30             白银一块          S
            0   1       1_000_000      钻石一粒          D
        1_001_630   这是贪心算出来的错误结果，每轮拿最大价值的，（价值/重量） 黄金的重量400/g > 红宝石300/g，所以在拿了钻石后选择拿黄金，随后拿白银

        1_002_400   动态规划
     */

    /*
        1   2   3   4   5   6   7   8   9   10
                    a
                    a               r
                    a               r
        d               da          da  dr  dr
     */

    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 10_000),
        };

        int value = select(items, 10);
        System.out.println(value);
    }

    /**
     * @param items 物品集合
     * @param total 总量
     * @return
     */
    static int select(Item[] items, int total) {
        //第一步 先将第一行填充
        Item item0 = items[0];
        //抽象二维数组
        int[][] dp = new int[items.length][total + 1];
        for (int i = 0; i <= total; i++) {
            //如果能装下
            if (item0.weight <= i) {
                dp[0][i] = item0.value;
            } else {
                //装不下
                dp[0][i] = 0;
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println("--------------------");
        //从第二个物品开始装背包
        for (int i = 1; i < items.length; i++) {
            Item it = items[i];
            for (int j = 0; j <= total; j++) {
                //装得下，还得看看与上次装的哪个价值高再存访，再看剩余的容量能否装其他物品(只能选择上一行的，因为是0-1背包，物品不能重复装)
                int preRowsValue = dp[i - 1][j];
                if (j >= it.weight) {
                    //j-it.weight 剩余容量
                    dp[i][j] = Integer.max(preRowsValue, it.value + dp[i - 1][j - it.weight]);
                } else {
                    //装不下就存访上一行能装下的
                    dp[i][j] = preRowsValue;
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[items.length - 1][total];
    }


}
