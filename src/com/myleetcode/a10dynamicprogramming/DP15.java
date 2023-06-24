package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 零钱兑换II
 */
public class DP15 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
        System.out.println(change2(amount, coins));
    }
    /*
    给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    tips:
    如果求 组合数 就是外层for循环遍历 物品，内层for遍历 背包。
    如果求 排列数 就是外层for遍历 背包，内层for循环遍历 物品。
     */


    //先遍历物品---本题的正确顺序
    public static int change(int amount, int[] coins) {
        //创建dp数组
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }


    //先遍历背包
    public static int change2(int amount, int[] coins) {
        //创建dp数组
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
