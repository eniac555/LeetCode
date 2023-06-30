package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/30
 * @description: 编辑距离
 */
public class DP40 {
    /*
    1.dp[i][j] 表示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。

    2.  if (word1[i - 1] == word2[j - 1])
            不操作----dp[i][j] = dp[i - 1][j - 1];

        if (word1[i - 1] != word2[j - 1])
            增----word2添加一个元素，相当于word1删除一个元素，最终的操作数是一样

            删----操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
                        即 dp[i][j] = dp[i - 1][j] + 1;
                  操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
                        即 dp[i][j] = dp[i][j - 1] + 1;
            换----dp[i][j] = dp[i - 1][j - 1] + 1;
          综上，当 if (word1[i - 1] != word2[j - 1]) 时取最小的，
          即：dp[i][j] = min( dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1] ) + 1;

     3.初始化：根据递推公式，很明显需要初始化dp[i][0] 和 dp[0][j]
             dp[i][0]：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]----显然为 i
             同理dp[0][j]为 j

     4.dp[i][j]是依赖左方，上方和左上方元素---一定是从左到右从上到下去遍历
     */


    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;


        for (int i = 1; i < word1.length() + 1; i++) {
            char char1 = word1.charAt(i - 1);
            for (int j = 1; j < word2.length() + 1; j++) {
                char char2 = word2.charAt(j - 1);
                if (char1 == char2) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
