package com.myleetcode.a12graphsearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 被环绕的区域 -- 广度搜索
 */
public class Graph08 {
    /*
    要求：
    给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

    思路：
    1.从四个边界开始遍历，把无法被包围的标记出来，例如标记为A
    2.遍历一遍，把O标记为X，把A标记为O

     */

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        //左右两条边
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') bfs(board, i, board[0].length - 1);
        }
        //上下
        for (int i = 1; i < board[0].length - 1; i++) {//省去遍历四个角
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') bfs(board, board.length - 1, i);
        }
        //获取结果
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        board[i][j] = 'A';
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] ints : direction) {
                int next_x = x + ints[0];
                int next_y = y + ints[1];
                if (next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board[0].length
                        || board[next_x][next_y] != 'O')
                    continue;
                if (board[next_x][next_y] == 'O') {
                    board[next_x][next_y] = 'A';
                    queue.offer(new int[]{next_x, next_y});
                }
            }
        }
    }


}
