package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 零钱兑换--给定不同面额的硬币 coins 和一个总金额 amount。
 * 计算凑成总金额所需的最少硬币数。如果没有组合能组成，返回 -1 ---- 每种硬币的数量是无限
 */
public class DP18 {
    public static void main(String[] args) {

    }

    /*
    1.dp数组含义：dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
    2.递推公式：dp[j] = min( dp[j], dp[j-coins[i]+1 )
    3.初始化： dp[0] = 0---凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0; 其他金额根据递推公式算，应该初始化为最大值
    4.递推顺序：完全背包且求组合，先物品再背包

     */

    public int coinChange(int[] coins, int amount) {
        //创建dp数组
        int[] dp = new int[amount + 1];
        //初始化数组
        int maxValue = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = maxValue;
        }

        //遍历数组
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coin] != maxValue) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        //没有可行的组合
        if (dp[amount]==maxValue) return -1;

        return dp[amount];
    }

}
