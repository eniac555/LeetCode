package com.myleetcode.a12graphsearch;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 岛屿的最大面积--深度搜索
 */
public class Graph05 {


    //深度搜索方法1
    int count;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid, i, j);
                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        count++;
        for (int k = 0; k < 4; k++) {
            int next_x = i + direction[k][0];
            int next_y = j + direction[k][1];
            if (next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length)
                continue;
            dfs(grid, next_x, next_y);
        }
    }


    //深度搜索方法2：使用 DFS 计算一个岛屿的面积，同时维护计算过的最大的岛屿面积。
    //同时，为了避免对岛屿重复计算，在 DFS 的时候对岛屿进行 “淹没” 操作，即将岛屿所占的地方置为 0。
    public int maxAreaOfIsland2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //每遇到一个岛屿就计算这个岛屿的面积同时”淹没“这个岛屿
                if (grid[i][j] == 1) {
                    //每次计算一个岛屿的面积都要与res比较，维护最大的岛屿面积作为最后的答案
                    res = Math.max(res, dfs2(grid, i, j));
                }
            }
        }
        return res;
    }

    public int dfs2(int[][] grid, int i, int j) {
        //搜索边界：i，j超过grid的范围或者当前元素为0，即当前所在的地方已经是海洋
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        //淹没土地，防止后续被重复计算
        grid[i][j] = 0;
        //递归的思路：要求当前土地(i,j)所在的岛屿的面积，则等于1加上下左右相邻的土地的总面积
        return 1 + dfs2(grid, i - 1, j) +
                dfs2(grid, i + 1, j) +
                dfs2(grid, i, j + 1) +
                dfs2(grid, i, j - 1);
    }


}
