package com.myleetcode.a13unionfind;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author eniac555
 * @date 2023/7/31
 * @description: 是否存在有效路径
 */
public class UnionFind01 {
    /*

    题目要求：
    有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。
    图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。
    每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
    请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
    给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。


    并查集可以解决什么问题：主要就是集合问题，两个节点在不在一个集合，也可以将两个节点添加到一个集合中。


    思路：
    判断两点之间有没有路径，就是判断两个顶点是否在同一个集合里，
    那就可以直接把每条边加入到并查集，判断是否是同一个根

     */


    // 并查集解法
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind();
        unionFind.setN(200000);
        int[] root = new int[200005];
        unionFind.setRoot(root);
        unionFind.init();
        for (int[] edge : edges) {
            unionFind.join(edge[0], edge[1]);
        }
        return unionFind.isSame(source, destination);
    }


    //简化并查集解法
    private int[] p;

    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int[] e : edges) {
            p[find(e[0])] = find(e[1]);
        }
        return find(source) == find(destination);
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }


    // 广度优先
    public boolean validPath3(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == destination) {
                break;
            }
            for (int next : adj[vertex]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return visited[destination];
    }


    //深度优先
    public boolean validPath4(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }

    public boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int next : adj[source]) {
            if (!visited[next] && dfs(next, destination, adj, visited)) {
                return true;
            }
        }
        return false;
    }


}
