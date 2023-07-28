package com.myleetcode.a12graphsearch;


/**
 * @author eniac555
 * @date 2023/7/19
 * @description: 岛屿数量 —— 深度优先搜索
 */
public class Graph02 {
    /*
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    此外，你可以假设该网格的四条边均被水包围。
     */


    /*
    思路：遇到一个没有遍历过的节点陆地，计数器就加1，然后把该节点陆地所能遍历到(相邻)的陆地都标记上。
     */

    //方法1
    //为了统计岛屿数量同时不重复记录，每当我们搜索到一个岛后，就将这个岛 “淹没” —— 将这个岛所占的地方从 “1” 改为 “0”，
    //这样就不用担心后续会重复记录这个岛屿了。而 DFS 的过程就体现在 “淹没” 这一步中。
    public int numIslands(char[][] grid) {
        int result = 0;//记录找到的岛屿数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][i] == '1') {//找到“1”，res加一，同时淹没这个岛
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    //使用DFS“淹没”岛屿
    public void dfs(char[][] grid, int i, int j) {
        //搜索边界：索引越界或遍历到了"0"
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        //将这块土地标记为"0"
        grid[i][j] = '0';
        //根据"每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成"，对上下左右的相邻顶点进行dfs
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    //方法2
    boolean[][] visited;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands2(char[][] grid) {
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs2(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs2(char[][] grid, int i, int j) {
        if (visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int next_i = i + direction[k][0];
            int next_j = j + direction[k][1];
            if (next_i < 0 || next_i >= grid.length || next_j < 0 || next_j >= grid[0].length) continue;
            dfs2(grid, next_i, next_j);
        }
    }


}
