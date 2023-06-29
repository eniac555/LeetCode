package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/29
 * @description: 最长重复子数组----数组 A 和 B ，返回两个数组中公共长度最长的连续子数组的长度
 */
public class DP33 {

    /*

    1.dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
    定义dp[i][j]为 以下标i为结尾的A，和以下标j 为结尾的B，最长重复子数组长度。---也行！ 但实现起来就麻烦一点，需要单独处理初始化部分

    2.当A[i - 1] 和B[j - 1]相等的时候，dp[i][j] = dp[i - 1][j - 1] + 1;

    3.根据dp[i][j]的定义，dp[i][0] 和dp[0][j]其实都是没有意义的
    但dp[i][0] 和dp[0][j]需要初有始值，因为 为了方便递归公式dp[i][j] = dp[i - 1][j - 1] + 1;
    所以dp[i][0] 和dp[0][j]初始化为0。
    举个例子A[0]如果和B[0]相同的话，dp[1][1] = dp[0][0] + 1，只有dp[0][0]初始为0，正好符合递推公式逐步累加起来。

    4.外层for循环遍历A，内层for循环遍历B----反过来也行

     */


    // 二维数组法
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }



    // 一维滚动数组
    public int findLength2(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
        }

        return result;
    }


}
