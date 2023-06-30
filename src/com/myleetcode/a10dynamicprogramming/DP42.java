package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/30
 * @description: 最长回文子序列
 */
public class DP42 {
    /*
    1.dp[i][j]数组含义：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]

    2.递推：
           s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2
           s[i]与s[j]不相同，那么需要移动i或者j，这就有两种情况：dp[i][j] = dp[i + 1][j]或者dp[i][j] = dp[i][j - 1]，取最大

    3.初始化：首先要考虑当i 和j 相同的情况，从递推公式：dp[i][j] = dp[i + 1][j - 1] + 2;
            可以看出 递推公式是计算不到 i 和j相同时候的情况。
            所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。
            其他情况dp[i][j]初始为0就行，这样递推公式：dp[i][j] = max(dp[i+1][j], dp[i][j-1]) 中的dp[i][j]才不会被初始值覆盖。

    4.遍历顺序：根据递推公式，应当从下到上，从左到右
     */

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char char1 = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {//从i+1是因为等于i时已经初始化过了
                char char2 = s.charAt(j);
                if (char1 == char2) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][s.length() - 1];//从遍历方向看，也可以从dp数组定义来看
    }
}
