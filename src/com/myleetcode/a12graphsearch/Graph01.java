package com.myleetcode.a12graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/7/19
 * @description: 所有可能的路径 -- 深度优先搜索
 */
public class Graph01 {

    /*
    给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
    graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
     */

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);//一开始肯定要把节点0加进去
        searchPath(graph, 0);
        return result;
    }

    private void searchPath(int[][] graph, int node) {//node表示当前遍历的节点编号
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        //遍历当前节点所有关联的节点，属于横向遍历
        for (int i = 0; i < graph[node].length; i++) {
            path.add(graph[node][i]);
            searchPath(graph, graph[node][i]);//属于往深度方向上遍历
            path.remove(path.size() - 1);
        }
    }
}
