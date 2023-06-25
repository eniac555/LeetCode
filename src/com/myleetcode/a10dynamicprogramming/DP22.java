package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/25
 * @description: 打家劫舍---第一版
 */
public class DP22 {
    /*

    1.dp[j] 表示0-j号房间，最多盗窃金额为dp[j]
    2.递推公式：dp[j]取决于上两次，如果上一次不盗窃，则 dp[j] = dp[j-2] + value[j]，如果上一次进行盗窃，则 dp[j] = dp[j-1]
              所以：dp[j] = max( dp[j-2]+ value[j],  dp[j-1] )
    3.初始化：需要初始化0和1，从dp[i]的定义看，dp[0] = nums[0]，
            dp[1]就是nums[0]和nums[1]的最大值即：dp[1] = max(nums[0], nums[1]);
    4.遍历顺序：dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么一定是从前到后遍历

     */

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }


    //空间优化版
    public int rob2(int[] nums) {

        int len = nums.length;

        if (len == 0) return 0;
        else if (len == 1) return nums[0];
        else if (len == 2) return Math.max(nums[0], nums[1]);


        int[] result = new int[3]; //存放选择的结果
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < len; i++) {

            result[2] = Math.max(result[0] + nums[i], result[1]);

            result[0] = result[1];
            result[1] = result[2];
        }

        return result[2];
    }
}
