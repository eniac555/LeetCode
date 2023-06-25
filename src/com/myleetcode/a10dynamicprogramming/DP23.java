package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/25
 * @description: 打家劫舍---第二版
 */
public class DP23 {
    /*
    连成环了
    对于一个数组，成环的话主要有如下三种情况：
    情况一：考虑不包含首尾元素
    情况二：考虑包含首元素，不包含尾元素
    情况三：考虑包含尾元素，不包含首元素
    注意我这里用的是"考虑"，例如情况三，虽然是考虑包含尾元素，但不一定要选尾部元素！ 对于情况三，取nums[1] 和 nums[3]就是最大的。
    而情况二 和 情况三 都包含了情况一了，所以只考虑情况二和情况三就可以了。
    剩下就和上一题一样了
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {0, 1};
        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);//因为后面有 i+2 所以从长度为3的开始计算
        return Math.max(robSub(nums, 0, nums.length - 1), robSub(nums, 1, nums.length));
    }

    private static int robSub(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }



    //----------------------下面是别人写的------------------------------

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}
