package com.myleetcode.a10dynamicprogramming;

import java.util.Arrays;

/**
 * @author eniac555
 * @date 2023/6/28
 * @description: 最长连续递增序列
 */
public class DP32 {

    // 动态规划
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }


    // 贪心算法
    public static int findLengthOfLCIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1; // 连续子序列最少也是1
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) { // 连续记录
                count++;
            } else { // 不连续，count从头开始
                count = 1;
            }
            if (count > res) res = count;
        }
        return res;
    }
}
