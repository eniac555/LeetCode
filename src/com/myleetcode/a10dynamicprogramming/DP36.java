package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/29
 * @description: 最大子序和----给定整数数组 nums ，找到具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class DP36 {

    /*
    1.dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。

    2.dp[i]只有两个方向可以推出来：dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和nums[i]，
    即：从头开始计算当前连续子序列和一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);

    3.从递推公式可以看出来dp[i]是依赖于dp[i - 1]的状态，dp[0]就是递推公式的基础。  dp[0] = nums[0]

    4.递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。

     */


    // 动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    // 贪心算法---当局部和为负数时，以下一个点为起点，重新计算累加和
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum + num;
            result = Math.max(result, sum);
            if (sum <= 0) {
                sum = 0;
            }
        }

        return result;
    }
}
