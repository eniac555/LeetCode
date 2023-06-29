package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/29
 * @description: 不相交的线
 */
public class DP35 {
    /*
    直线不能相交，这就是说明在字符串A中 找到一个与字符串B相同的子序列，且这个子序列不能改变相对顺序，
    只要相对顺序不改变，链接相同数字的直线就不会相交。---求最多的直线，就是求最大的公共子序列---和上题一模一样
     */

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
