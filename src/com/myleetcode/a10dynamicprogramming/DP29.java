package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----含冷冻期
 */
public class DP29 {

    /*
    难在状态分析：
    状态1：持有股票状态--------dp[i][0]
    状态2：持续卖出股票状态-----dp[i][1]
    状态3：恰好当天卖出股票状态--dp[i][2]
    状态4：冷冻期-------------dp[i][3]

    1.dp[][]数组含义：dp[i][j]，第i天状态为j，所剩的最多现金为dp[i][j]。

    2.递推公式：
    dp[i][0] = max(dp[i-1][0], dp[i-1][1]-price[i], dp[i-1][3]-price[i])
    对应三种：上一天还是持有    上一天是持续卖出，恰好今天买   上一天是冷冻期，正好今天买

    dp[i][1] = max(dp[i-1][1], dp[i-1][3])

    dp[i][2] = dp[i-1][0] + price[i]

    dp[i][3] = dp[i-1][2]

    3.初始化：
    如果是持有股票状态（状态一）那么：dp[0][0] = -prices[0]，一定是当天买入股票
    dp[0][1]：第0天就持续持有股票，是一个非法状态，要根据哪里用到了他，按照递推公式往前推他如何初始化，最终是初始化为0
    dp[0][2] = 0，原理同上
    dp[0][3] = 0，原理同上
    */

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];

        }

        return Math.max(dp[length - 1][1], Math.max(dp[length - 1][2], dp[length - 1][3]));
    }
}
