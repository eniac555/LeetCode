package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/29
 * @description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度----可以删除元素
 */
public class DP34 {

    /*
    1.dp[i][j]表示A数组下标[0, i-1]，和B数组下标[0, j-1]之间最长公共子序列的长度

    2.如果 numsA[i-1] == numsB[j-1]   dp[i][j] = dp[i-1][j-1] + 1
      否则 dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);

    3.初始化：根据上一题，这个肯定也是初始化为0

    4.遍历顺序：和上题一样2

     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j < text2.length() + 1; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }


}
