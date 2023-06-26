package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----买卖一次
 */
public class DP25 {

    //1.暴力搜索肯定可以吧----超时了
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxValue = Math.max(maxValue, prices[j] - prices[i]);
            }
        }

        return maxValue;
    }


    //2.贪心算法总可以吧
    public int maxProfit2(int[] prices) {
        // 找到一个最小的购入点
        int low = Integer.MAX_VALUE;
        // res不断更新，直到数组循环完毕
        int res = 0;
        for (int price : prices) {
            low = Math.min(price, low);
            res = Math.max(price - low, res);
        }
        return res;
    }


    //3.动态规划

    /*
    1.数组含义：dp[i][0] 表示第i天持有股票所得最多现金, dp[i][1] 表示第i天不持有股票所得最多现金

    2.递推公式：
    如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
    第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
    第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
    那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], -prices[i]);

    如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
    第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
    第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
    同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);

    3.数组初始化：dp[0][0] = -prices[0]    dp[0][1] = 0

     */

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

}



