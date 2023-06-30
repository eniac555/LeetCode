package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/30
 * @description: 不同的子序列
 */
public class DP38 {
    /*

    1.dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]

    2.递推公式：
        s[i - 1] 与 t[j - 1]相等：  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        ----例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
                    当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
        s[i - 1] 与 t[j - 1] 不相等：dp[i][j] = dp[i - 1][j]----只能删除S中的元素

     3.初始化：根据递推公式，dp[i][0] 和 dp[0][j] 一定要初始化
            dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
            那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
            再来看dp[0][j]，dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
            那么dp[0][j]一定都是0，s如论如何也变成不了t。
            最后就要看一个特殊位置了，即：dp[0][0] 应该是多少。
            dp[0][0]应该是1，空字符串s，可以删除0个元素，变成空字符串t。
     */

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            char char1 = s.charAt(i - 1);
            for (int j = 1; j < t.length() + 1; j++) {
                char char2 = t.charAt(j - 1);
                if (char1 == char2) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[s.length()][t.length()];
    }
}
