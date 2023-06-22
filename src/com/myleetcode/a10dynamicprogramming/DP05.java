package com.myleetcode.a10dynamicprogramming;

/**
 * @author eniac555
 * @date 2023/6/21
 * @description:
 */
public class DP05 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];

        //如果起点或者终点就有障碍
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        return arr[m - 1][n - 1];
    }

}
