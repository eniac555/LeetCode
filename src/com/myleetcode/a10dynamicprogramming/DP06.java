package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/21
 * @description:
 */
public class DP06 {
    public int integerBreak(int n) {

        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];
    }


    public int integerBreak2(int n) {
        //arr[i]表示数字i拆分后的最大乘积
        int[] arr = new int[n + 1];
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i] = Math.max(arr[i], Math.max(j * (i - j), j * arr[i - j]));
            }
        }
        return arr[n];
    }
}
