package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/19
 * @description: 爬楼梯
 */
public class DP02 {
    /**
     * 从dp[i]的定义可以看出，dp[i] 可以有两个方向推出来。
     * 首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
     * 还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
     * 那么dp[i]就是 dp[i - 1]与dp[i - 2]之和！
     * 所以dp[i] = dp[i - 1] + dp[i - 2] 。
     * ----这不就是斐波那契数列
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
