package com.myleetcode.a10dynamicprogramming;

import java.util.List;

/**
 * @author eniac555
 * @date 2023/6/30
 * @description: 两个字符串的删除操作----单次只能操作一个字符串中的一个字母
 */
public class DP39 {
    /*
    1.dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。

    2.当word1[i - 1] 与 word2[j - 1]相同的时候，dp[i][j] = dp[i - 1][j - 1];
      当word1[i - 1] 与 word2[j - 1]不相同的时候，有三种情况：
         情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
         情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
         情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
      那最后当然是取最小值，所以当word1[i - 1] 与 word2[j - 1]不相同的时候，
      递推公式：dp[i][j] = min({dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1, dp[i][j - 1] + 1});

      但是，因为 dp[i][j - 1] + 1 = dp[i - 1][j - 1] + 2，
      所以递推公式可简化为：dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
      理解：当 同时删word1[i - 1]和word2[j - 1]，dp[i][j-1] 本来就不考虑 word2[j - 1]了，
           那么我再删 word1[i - 1]，是不是就达到两个元素都删除的效果，即 dp[i][j-1] + 1。

    3.初始化：dp[i][0] 和 dp[0][j]是一定要初始化
            dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i。
            dp[0][j]的话同理
     */

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));

            }
        }

        return dp[word1.length()][word2.length()];
    }
}
