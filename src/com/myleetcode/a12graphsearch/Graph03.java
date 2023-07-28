package com.myleetcode.a12graphsearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author eniac555
 * @date 2023/7/28
 * @description: 岛屿数量--广度搜索
 */
public class Graph03 {
    boolean[][] visited;
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    //将这片岛屿上的所有陆地都访问到
    public void bfs(char[][] grid, int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int m = cur[0];
            int n = cur[1];
            for (int i = 0; i < 4; i++) {
                int next_y = m + move[i][0];
                int next_x = n + move[i][1];
                if (next_x < 0 || next_y == grid.length || next_y < 0 || next_x == grid[0].length) continue;
                if (!visited[next_y][next_x] && grid[next_y][next_x] == '1') {
                    queue.offer(new int[]{next_y, next_x});
                    visited[next_y][next_x] = true; //只要加入队列就标记为访问
                }
            }
        }
    }
}
