package com.Algorithmic_thinking.knapsack;

/**
 * @author cgh
 * @create 2024/5/17
 * 完全背包问题一般是指：有N件物品和一个能背重量为W的背包，第i件物品的重量为weight[i],价值为value[i]。
 * 每件物品有无限个(也就是可以放入背包多次），求怎样可以使背包物品价值总量最大。
 * 与01背包的区别就是 完全背包的物品无限个，而01背包只能装一次；
 */
public class CompleteKnapsackProblem {
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

    /*
          0   0   1   2   3   4   5   6
          1   0   0   c   c   cc  cc  ccc
          2   0   0   c   s   cc  cs  ccc
          3   0   0   c   s   a   a   ac
       */
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "青铜", 2, 3),    // c
                new Item(2, "白银", 3, 4),    // s
                new Item(3, "黄金", 4, 7),    // a
        };
        System.out.println(select(items, 15));
        System.out.println(select2(items,15));
    }

    /**
     * @param items 物品种类
     * @param total 背包可以装的重量
     * @return 背包可以装下物品的最重重量
     */
    public static int select(Item[] items, int total) {
        // 还是dp 二维数组动态规划，物品作为行，背包总量作为列
        int[][] dp = new int[items.length + 1][total + 1];
        //初始化第一行,i为背包重量
        Item item0 = items[0];
        for (int j = 0; j <= total; j++) {
            //装得下
            if (j >= item0.weight) {
                dp[0][j] = item0.value + dp[0][j - item0.weight];
            }
            //装不下
            else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < items.length; i++) {
            //遍历物品
            Item itemI = items[i];
            for (int j = 1; j <= total; j++) {
                //装得下
                int preRowsValue = dp[i - 1][j];
                if (j >= itemI.weight) {
                    //装得下
                    dp[i][j] = Integer.max(preRowsValue, itemI.value + dp[i][j - itemI.weight]);
                } else {
                    //装不下
                    dp[i][j] = preRowsValue;
                }
            }
        }
        return dp[items.length - 1][total];
    }

    /**
     * 降维，一维数组处理
     *
     * @param items
     * @param total
     * @return
     */
    public static int select2(Item[] items, int total) {
        int[] dp = new int[total + 1];
        Item item0 = items[0];
        for (int i = 0; i < items.length; i++) {
            Item itemI = items[i];
            for (int j = 0; j <= total; j++) {
                if (j >= itemI.weight) {
                    dp[j] = Integer.max(dp[j], itemI.value + dp[j - itemI.weight]);
                }
            }
        }
        return dp[total];

    }
}
