package com.myleetcode.a10dynamicprogramming;

import java.util.Arrays;

/**
 * @author eniac555
 * @date 2023/6/28
 * @description: 最长连续递增序列
 */
public class DP32 {

    /*
    1.dp[i]：以下标i为结尾的连续递增的子序列长度为dp[i]。
    2.dp[i] = dp[i - 1] + 1;
    3.以下标i为结尾的连续递增的子序列长度最少也应该是1，即就是nums[i]这一个元素。
    4.从递推公式上可以看出， dp[i + 1]依赖dp[i]，所以一定是从前向后遍历。
     */

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
