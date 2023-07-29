package com.myleetcode.a12graphsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 太平洋大西洋水流问题 -- 深搜
 */
public class Graph11 {

    // 四个位置
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * @param heights 题目给定的二维数组
     * @param row     当前位置的行号
     * @param col     当前位置的列号
     * @param sign    记录是哪一条河，两条河中可以一个为 0，一个为 1
     * @param visited 记录这个位置可以到哪条河
     */
    public void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
        for (int[] current : position) {
            int curRow = row + current[0];
            int curCol = col + current[1];
            // 越界
            if (curRow < 0 || curRow >= heights.length || curCol < 0 || curCol >= heights[0].length)
                continue;
            // 高度不合适或者已经被访问过了
            if (heights[curRow][curCol] < heights[row][col] || visited[curRow][curCol][sign])
                continue;

            visited[curRow][curCol][sign] = true;
            dfs(heights, curRow, curCol, sign, visited);
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length, colSize = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
        // 假设太平洋的标记为 1，大西洋为 0
        boolean[][][] visited = new boolean[rowSize][colSize][2];

        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            dfs(heights, row, colSize - 1, 0, visited);
            dfs(heights, row, 0, 1, visited);
        }
        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;
            dfs(heights, rowSize - 1, col, 0, visited);
            dfs(heights, 0, col, 1, visited);
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if (visited[row][col][0] && visited[row][col][1])
                    ans.add(Arrays.asList(row, col));
            }
        }
        return ans;
    }
}
