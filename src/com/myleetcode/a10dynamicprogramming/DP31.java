package com.myleetcode.a10dynamicprogramming;

import java.util.Arrays;

/**
 * @author eniac555
 * @date 2023/6/28
 * @description: 最长递增子序列
 */
public class DP31 {

    /*
    1.dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
    2.if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1)
    3.每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1
    4.dp[i] 是有0到i-1各个位置的最长递增子序列 推导而来，那么遍历i一定是从前向后遍历。
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }
}
