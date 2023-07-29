package com.myleetcode.a12graphsearch;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 飞地的数量 -- 深搜
 */
public class Graph06 {

    /*
    要求：
    给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
    一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
    返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。

    思路：
    本题要求找到不靠边的陆地面积，那么我们只要从周边找到陆地然后 通过 dfs或者bfs 将周边靠陆地且相邻的陆地都变成海洋，
    然后再去重新遍历地图的时候，统计此时还剩下的陆地就可以了。

     */



    //====方法1====
    int count;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public int numEnclaves(int[][] grid) {
        //先遍历四条边，找到不满足要求的陆地，把其划为海洋（设置为0）
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs(grid, grid.length - 1, i);
        }

        count = 0;//把初始化阶段的count累加和清零
        //再遍历中间位置，统计满足条件的数量
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }


    private void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;
        count++;

        for (int k = 0; k < 4; k++) {
            int next_x = i + direction[k][0];
            int next_y = j + direction[k][1];
            if (next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length)
                continue;
            dfs(grid, next_x, next_y);
        }
    }



    //====方法2====，设置为0阶段不用统计数量，最后遍历一遍计数就行
    public int numEnclaves2(int[][] grid) {
        int result = 0;
        //先遍历四条边，找到不满足要求的陆地，把其划为海洋（设置为0）
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs2(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs2(grid, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == 1) dfs2(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs2(grid, grid.length - 1, i);
        }

        //再遍历中间位置，统计满足条件的数量
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) result++;
            }
        }
        return result;
    }


    private void dfs2(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return;
        grid[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int next_x = i + direction[k][0];
            int next_y = j + direction[k][1];
            if (next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length)
                continue;
            dfs2(grid, next_x, next_y);
        }
    }

}
