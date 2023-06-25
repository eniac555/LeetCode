package com.myleetcode.a10dynamicprogramming;

import java.util.HashSet;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/6/24
 * @description: 单词拆分
 */
public class DP20 {

    /*
    1.dp数组含义：dp[i] 表示长度为i的字符串，如果dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
    2.递推公式： if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true
    3.数组初始化：从0开始计算，且 && 所以0必须是 true， 其他元素初始为false
    ----以上都没问题----


    4.遍历顺序：首先是完全背包---这个没问题
    然后这个题求得是排列数，所以外层遍历背包，内层遍历物品------不太理解，等我二刷吧......
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {//背包
            for (String word : wordDict) {//物品
                int length = word.length();
                if (i >= length && dp[i - length] && word.equals(s.substring(i - length, i))) {
                    dp[i] = true;
                    break;//跳出物品的循环，再去执行容量为 i+1 的背包
                }
            }
        }

        return dp[s.length()];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        // memo[i] 表示 s 中索引为 [0,  i - 1] 范围的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // [0, i - 1] 的字符串可被拆分，当前仅当任一子串 [0, j - 1] 及 [j, i - 1] 可被拆分
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }


    public boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
