package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----含手续费，可多次交易
 */
public class DP30 {
    /*
    单纯买卖，状态只有两种，持有和不持有
    1.dp[i][j]：在第i天持有或卖出股票，剩下的最大收益，
                dp[i][0] 表示第i天持有股票所剩最多现金。 dp[i][1] 表示第i天不持有股票所得最多现金

    2.递推公式：dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
              dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] - fee)

    3.初始化：dp[0][0] = -prices[0]    dp[0][1] = 0
     */

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}
