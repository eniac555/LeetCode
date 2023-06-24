package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 组合总数---不同排列的组合数求和为目标值--求满足条件组合个数
 */
public class DP16 {

    public int combinationSum4(int[] nums, int target) {
        //创建dp数组
        int[] dp = new int[target+1];
        //初始化dp[0]
        dp[0] = 1;
        //遍历容器再遍历物品
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i>=nums[j]){
                    dp[i] = dp[i]+dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
