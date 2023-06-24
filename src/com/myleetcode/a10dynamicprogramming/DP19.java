package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description:
 */
public class DP19 {

    /*
    1.dp数组含义：dp[j]：和为 j 的完全平方数的最少数量为dp[j]
    2.递推公式：dp[j] = min( dp[j], dp[j-i*i] +1 )
    3.初始化： dp[0] = 0--- 其他根据递推公式算，应该初始化为最大值
    4.遍历顺序：实际上是求组合，先物体再背包----但是求最小，其实顺序无所谓
     */

    public int numSquares(int n) {
        // 创建数组
        int[] dp = new int[n + 1];
        // 初始化数组
        dp[0] = 0;
        int maxValue = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = maxValue;
        }

        // 遍历数组
        for (int i = 0; i * i <= n; i++) {//注意包含 等于
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != maxValue) {//
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }

        return dp[n];
    }
}
