package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/19
 * @description:
 */
public class DP04 {
    /**
     * 1. 确定dp数组下标含义 dp[i][j] 到每一个坐标可能的路径种类
     * 2. 递推公式 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 初始化 dp[i][0]=1 dp[0][i]=1 初始化横竖就可
     * 4. 遍历顺序 一行一行遍历
     * 5. 推导结果
     */
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];

        //初始化，p[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[m - 1][n - 1];
    }
}
