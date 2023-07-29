package com.myleetcode.a12graphsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 飞地的数量 -- 广搜
 */
public class Graph07 {


    //====方法1====，不用标记数组
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public int numEnclaves(int[][] grid) {
        int result = 0;
        //先遍历四条边，找到不满足要求的陆地，把其划为海洋（设置为0）
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) bfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) bfs(grid, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            if (grid[0][i] == 1) bfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) bfs(grid, grid.length - 1, i);
        }

        //再遍历中间位置，统计满足条件的数量
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) result++;
            }
        }
        return result;
    }

    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int k = 0; k < 4; k++) {
                int next_x = x + direction[k][0];
                int next_y = y + direction[k][1];
                if (next_x < 0 || next_x >= grid.length || next_y < 0 || next_y >= grid[0].length || grid[next_x][next_y] == 0)
                    continue;
                if (grid[next_x][next_y] == 1) {
                    queue.offer(new int[]{next_x, next_y});
                    grid[next_x][next_y] = 0;
                }
            }
        }
    }


    //=====方法2====使用标记数组
    // 广度优先遍历，把可以通向边缘部分的 1 全部标记成 true
    public void bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] current : direction) {
                int row = curPos[0] + current[0], col = curPos[1] + current[1];
                // 下标越界直接跳过
                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
                    continue;
                // 当前位置不是 1 或者已经被访问了就直接跳过
                if (visited[row][col] || grid[row][col] == 0) continue;
                visited[row][col] = true;
                queue.add(new int[]{row, col});
            }
        }
    }

    public int numEnclaves2(int[][] grid) {
        int rowSize = grid.length, colSize = grid[0].length, ans = 0;    // ans 记录答案
        // 标记数组记录每个值为 1 的位置是否可以到达边界，可以为 true，反之为 false
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<int[]> queue = new ArrayDeque<>();
        // 搜索左侧边界和右侧边界查找 1 存入队列
        for (int row = 0; row < rowSize; row++) {
            if (grid[row][0] == 1) {
                visited[row][0] = true;
                queue.add(new int[]{row, 0});
            }
            if (grid[row][colSize - 1] == 1) {
                visited[row][colSize - 1] = true;
                queue.add(new int[]{row, colSize - 1});
            }
        }
        // 搜索上边界和下边界遍历，但是四个角不用遍历，因为上面已经遍历到了
        for (int col = 1; col < colSize - 1; col++) {
            if (grid[0][col] == 1) {
                visited[0][col] = true;
                queue.add(new int[]{0, col});
            }
            if (grid[rowSize - 1][col] == 1 && !visited[rowSize - 1][col]) {
                visited[rowSize - 1][col] = true;
                queue.add(new int[]{rowSize - 1, col});
            }
        }
        bfs(grid, queue, visited);        // 广度优先遍历
        // 查找没有标记过的 1，记录到 ans 中
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) ++ans;
            }
        }
        return ans;
    }
}
