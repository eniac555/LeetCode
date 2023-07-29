package com.myleetcode.a12graphsearch;

import java.util.*;

/**
 * @author eniac555
 * @date 2023/7/29
 * @description: 太平洋大西洋水流问题 -- 广搜
 */
public class Graph10 {
    /*
    要求：
    有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
    这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ，
    heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
    岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。
    水可以从海洋附近的任何单元格流入海洋。
    返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。

    思路：
    遍历每个点，然后看这个点 能不能同时到达太平洋和大西洋。至于遍历方式，可以用dfs，也可以用bfs -- 超时了

    优化：
    反过来想，从太平洋边上的节点 逆流而上，将遍历过的节点都标记上。
    从大西洋的边上节点 逆流而上，将遍历过的节点也标记上。
    然后两方都标记过的节点就是既可以流太平洋也可以流大西洋的节点。
     */


    // 四个位置
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * @param heights 题目给定的二维数组
     * @param queue   记录可以到达边界的节点
     * @param visited 记录这个位置可以到哪条河
     */
    public void bfs(int[][] heights, Queue<int[]> queue, boolean[][][] visited) {
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] current : position) {
                int row = curPos[0] + current[0];
                int col = curPos[1] + current[1];
                int sign = curPos[2];
                // 越界
                if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) continue;
                // 高度不合适或者已经被访问过了
                if (heights[row][col] < heights[curPos[0]][curPos[1]] || visited[row][col][sign]) continue;

                visited[row][col][sign] = true;
                queue.add(new int[]{row, col, sign});
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length;
        int colSize = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][][] visited = new boolean[rowSize][colSize][2];

        // 队列，保存的数据为 [行号, 列号, 标记]
        // 假设太平洋的标记为 1，大西洋为 0
        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            queue.add(new int[]{row, colSize - 1, 0});
            queue.add(new int[]{row, 0, 1});
        }
        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;
            queue.add(new int[]{rowSize - 1, col, 0});
            queue.add(new int[]{0, col, 1});
        }

        //队列里已经加了从四条边出发的节点
        bfs(heights, queue, visited);

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
