package com.myleetcode.a12graphsearch;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 被环绕的区域 -- 深度搜索
 */
public class Graph09 {

    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        //遍历左右两条边
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') dfs(board, i, board[0].length - 1);
        }
        //遍历上下两条边
        for (int i = 1; i < board[0].length - 1; i++) {//省去遍历四个角
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'A') return;
        board[i][j] = 'A';

        for (int[] ints : direction) {
            int next_x = i + ints[0];
            int next_y = j + ints[1];
            if (next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board[0].length
                    || board[next_x][next_y] != 'O')
                continue;
            if (board[next_x][next_y] == 'O') {
                dfs(board, next_x, next_y);
            }
        }

    }
}
