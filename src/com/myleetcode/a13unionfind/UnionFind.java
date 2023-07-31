package com.myleetcode.a13unionfind;

/**
 * @author eniac555
 * @date 2023/7/31
 * @description: 并查集
 */
public class UnionFind {
    /*
    并查集功能：
    1.将两个元素添加到一个集合中
    2.判断两个元素在不在同一个集合中
     */
    int n;
    int[] root = new int[n + 5];

    //并查集初始化
    void init() {
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    //并查集寻根
    int find(int u) {
        if (u == root[u]) return u;
        else return root[u] = find(root[u]);
    }


    //判断u和v是否同根
    boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }


    //将 v --> u 这条边加入并查集
    void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        root[v] = u;
    }


    public UnionFind() {
    }

    public UnionFind(int n, int[] root) {
        this.n = n;
        this.root = root;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getRoot() {
        return root;
    }

    public void setRoot(int[] root) {
        this.root = root;
    }

    public String toString() {
        return "UnionFind{n = " + n + ", root = " + root + "}";
    }
}
