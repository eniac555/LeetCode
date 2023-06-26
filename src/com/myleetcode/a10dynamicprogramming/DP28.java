package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/26
 * @description: 买股票的最佳时机----最多 买卖 K次
 */
public class DP28 {

    /*
    1.dp数组大小为  [len][2*k+1] 偶数次是卖出 ，奇数是买入

    2.递推公式：偶数次： dp[i][j] = max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j])  j 为偶数
              奇数次： dp[i][j] = max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j])  j 为奇数

    3.初始化：还是按照奇数偶数，奇数 -prices[0]   偶数：0
     */

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int[][] dp = new int[prices.length][2 * k + 1];

        for (int i = 1; i < dp[0].length; i += 2) {//遍历奇数位置，-prices[0]
            dp[0][i] = -prices[0];
        }

        // 笑死，被求二维数组的第二个维度长度难住了

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j % 2 == 0) {// 偶数
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
                } else {// 奇数
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                }
            }
        }

        return dp[prices.length - 1][2 * k];
    }
}
