package com.myleetcode.a12graphsearch;

/**
 * @author eniac555
 * @date 2023/7/30
 * @description: 岛屿周长
 */
public class Graph16 {
    /*
    思路1：遍历每一个空格，遇到岛屿，计算其上下左右的情况，遇到水域或者出界的情况，就可以计算边了
    思路2：计算出总的岛屿数量，因为有一对相邻两个陆地，边的总数就减2，那么在计算出相邻岛屿的数量就可以了。
     */


    //思路1
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int next_x = i + position[k][0];
                        int next_y = j + position[k][1];
                        // 当前位置是陆地，并且从当前位置4个方向扩展的“新位置”是“水域” 或者 “新位置“越界，则会为周长贡献一条边
                        if (next_x < 0 || next_x >= grid.length
                                || next_y < 0 || next_y >= grid[0].length
                                || grid[next_x][next_y] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }


    //思路2
    public int islandPerimeter2(int[][] grid) {
        // 计算岛屿的周长
        // 方法二 : 遇到相邻的陆地总周长就-2
        int landSum = 0; // 陆地数量
        int cover = 0; // 相邻陆地数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    landSum++;
                    // 统计上面和左边的相邻陆地
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) cover++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) cover++;
                }
            }
        }
        return landSum * 4 - cover * 2;
    }


}
