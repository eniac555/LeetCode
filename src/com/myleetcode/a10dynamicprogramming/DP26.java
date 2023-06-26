package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----买卖多次
 */
public class DP26 {

    //1.贪心算法
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = result + Math.max(0, prices[i] - prices[i - 1]);
        }

        return result;
    }


    //2.动态规划

    /*
    1.数组含义：dp[i][0] 表示第i天持有股票所得最多现金, dp[i][1] 表示第i天不持有股票所得最多现金

    2.递推公式：
    如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
    第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
    第i天买入股票，所得现金就是买入今天的股票后所得现金即：dp[i - 1][1]-prices[i]--------和前面的区别
    那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]-prices[i]);

    如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
    第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
    第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
    同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);

    3.数组初始化：dp[0][0] = -prices[0]    dp[0][1] = 0

     */


    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
