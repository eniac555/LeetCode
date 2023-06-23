package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/23
 * @description: 1和0的组合
 */
public class DP13 {
    /*
    dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
     */

    public int findMaxForm(String[] strs, int m, int n) {
        //1.创建dp数组
        int[][] dp = new int[m + 1][n + 1];
        //2.要不要把字符数组的每个元素里面有多少
        for (int i = 0; i < strs.length; i++) {//相当于开始遍历物品
            char[] str = strs[i].toCharArray();
            int zeroNum = 0;
            int oneNum = 0;
            for (int j = 0; j < str.length; j++) {
                if (str[j] == '0') zeroNum++;
                else oneNum++;
            }
            for (int k = m; k >= zeroNum; k--) {//遍历容器，只不过容器有两层的
                for (int q = n; q >= oneNum; q--) {
                    dp[k][q] = Math.max(dp[k][q], dp[k - zeroNum][q - oneNum] + 1);
                }
            }
        }
        return dp[m][n];

    }
}
