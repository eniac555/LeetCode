package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/30
 * @description: 回文子串
 */
public class DP41 {

    /*

    1.dp[i][j]数组含义：区间[i, j]能否构成回文，布尔类型

    2.递推公式：
             如果s[i]==s[j]，分三种情况：如果i=j，肯定是回文---dp[i][j] = true
                                      如果j-1=1，也是回文---dp[i][j] = true
                                      如果j-i>1，判断dp[i+1][j-1]是否是回文，如果是---dp[i][j] = true
             如果s[i]！=s[j]，不用动，因为初始化为了false

     3.初始化：全部为false

     4.遍历顺序：dp[i][j]依赖于dp[i+1][j-1]，所以从下到上，从左到右

     */


    //动态规划法
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char char1 = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                char char2 = s.charAt(j);
                if (char1 == char2 && j - i <= 1) {//前两种情况
                    dp[i][j] = true;
                    count++;
                }
                if (char1 == char2 && j - i > 1 && dp[i + 1][j - 1]) {//第三种情况
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }


    //双指针法
    public int countSubstrings2(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}

