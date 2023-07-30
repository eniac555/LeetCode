package com.myleetcode.a12graphsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author eniac555
 * @date 2023/7/30
 * @description: 最大的人工岛
 */
public class Graph12 {
    /*
    要求：
    给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
    返回执行此操作后，grid 中最大的岛屿面积是多少？
    岛屿 由一组上、下、左、右四个方向相连的 1 形成。

    思路：
    暴力想法：遍历地图尝试 将每一个 0 改成1，然后去搜索地图中的最大的岛屿面积
    优化思路：第一步：一次遍历地图，得出各个岛屿的面积，并做编号记录。可以使用map记录，key为岛屿编号，value为岛屿面积
            第二步：在遍历地图，遍历0的方格（因为要将0变成1），并统计该1（由0变成的1）周边岛屿面积，
            将其相邻面积相加在一起，遍历所有 0 之后，就可以得出 选一个0变成1 之后的最大面积。

     */

    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

    /**
     * @param grid 矩阵数组
     * @param row  当前遍历的节点的行号
     * @param col  当前遍历的节点的列号
     * @param mark 当前区域的标记
     * @return 返回当前区域内 1 的数量
     */
    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;
        grid[row][col] = mark;
        for (int[] current : position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;  // 越界
            if (grid[curRow][curCol] == 1)
                ans += 1 + dfs(grid, curRow, curCol, mark);
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int size = grid.length;// n*n
        int mark = 2;
        Map<Integer, Integer> getSize = new HashMap<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 1) {
                    int areaSize = 1 + dfs(grid, row, col, mark);
                    getSize.put(mark++, areaSize);
                }
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // 当前位置如果不是 0 那么直接跳过，因为我们只能把 0 变成 1
                if (grid[row][col] != 0) continue;
                Set<Integer> hashSet = new HashSet<>();     // 防止同一个区域被重复计算
                // 计算从当前位置开始获取的 1 的数量，初始化 1 是因为把当前位置的 0 转换成了 1
                int curSize = 1;

                for (int[] current : position) {
                    int curRow = row + current[0];
                    int curCol = col + current[1];
                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;
                    int curMark = grid[curRow][curCol];     // 获取对应位置的标记
                    // 如果标记存在 hashSet 中说明该标记被记录过一次，如果不存在 getSize 中说明该标记是无效标记(此时 curMark = 0)
                    if (hashSet.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    hashSet.add(curMark);
                    curSize += getSize.get(curMark);
                }
                ans = Math.max(ans, curSize);
            }
        }

        // 当 ans == Integer.MIN_VALUE 说明矩阵数组中不存在 0，全都是有效区域，返回数组大小即可
        return ans == Integer.MIN_VALUE ? size * size : ans;
    }
}
