package com.myleetcode.a12graphsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 岛屿的最大面积--广度搜索
 */
public class Graph04 {
    boolean[][] visited;
    int count;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    bfs(grid, i, j);
                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }

    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        count++;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int k = 0; k < 4; k++) {
                int next_x = x + direction[k][0];
                int next_y = y + direction[k][1];
                if (next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length) continue;
                if (!visited[next_x][next_y] && grid[next_x][next_y] == 1) {
                    queue.offer(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                    count++;
                }
            }
        }
    }

}
