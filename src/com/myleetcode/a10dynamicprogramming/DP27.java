package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----最多买卖两次
 */
public class DP27 {

    /*
    1.确定dp数组以及下标的含义
    一天一共就有五个状态，
    没有操作 （其实我们也可以不设置这个状态）
    第一次持有股票
    第一次不持有股票
    第二次持有股票
    第二次不持有股票
    dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金

    2.递推公式
    dp[i][0] = dp[i-1][0]
    dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);
    dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])
    dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
    dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

    3.初始化
    dp[0][0] = 0
    dp[0][1] = -price[0]
    dp[0][2] = 0   ----通过当天买入当天卖出理解更容易
    dp[0][3] = -price[0]
    dp[0][4] = 0

     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];//其他创建数组时默认就是0
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];//这个状态可以不用，因为一直是0
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][4]);//实际返回dp[len-1][4]就行
    }
}
