package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/23
 * @description: 分割等和子集
 */
public class DP10 {
    public static void main(String[] args) {
        int[] num = {1,5,11,5};
        System.out.println(canPartition(num));

    }
    public static boolean canPartition(int[] nums) {
        if (nums==null||nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {//遍历数组（物品）
            for (int j = target; j >= nums[i]; j--) {//逆序遍历背包
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) return true;
            }
            // if (dp[target] == target) return true;
            // 判断放在这里时间复杂度更低
        }
        return false;
    }
}
