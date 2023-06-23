package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/23
 * @description: 目标和
 */
public class DP12 {
    /*
    假设加法的总和为x，那么减法对应的总和就是sum - x。所以我们要求的是 x - (sum - x) = target
    x = (target + sum) / 2   此时问题就转化为，装满容量为x的背包，有几种方法。
    这里的x，就是bagSize，也就是我们后面要求的背包容量。
     */

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target < 0 && target < -sum) return 0;//防止target过大
        if ((sum + target) % 2 != 0) return 0;
        int size = (sum + target) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];//dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[size];
    }

}
