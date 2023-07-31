package com.myleetcode.a13unionfind;

/**
 * @author eniac555
 * @date 2023/7/31
 * @description: 冗余连接
 */
public class UnionFind02 {

    /*
    树可以看成是一个连通且 无环 的 无向 图。
    给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。
    添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
    图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。

    请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。




    思路：
    从前向后遍历每一条边（因为优先让前面的边连上），边的两个节点如果不在同一个集合，就加入集合（即：同一个根节点）。
    节点A 和节点 B 不在同一个集合，那么就可以将两个 节点连在一起。
    （如果题目中说：如果有多个答案，则返回二维数组中最前出现的边。 那我们就要 从后向前 遍历每一条边了）
    如果边的两个节点已经出现在同一个集合里，说明着边的两个节点已经连在一起了，再加入这条边一定就出现环了。

     */

    int n;
    int[] root;

    //并查集初始化
    public UnionFind02() {
        n = 1005;//3 <= n <= 1000
        root = new int[n];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    // 并查集里寻根的过程
    public int find(int u) {
        if (u == root[u]) return u;
        root[u] = find(root[u]);
        return root[u];
    }


    // 将v->u 这条边加入并查集
    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        else root[v] = u;
    }

    // 判断 u 和 v是否找到同一个根----本题用不上
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    //题目中说，原本是一个无环连通图，所以加上一个边后最多只有一个环，所以应该是不用判断是不是数组中的最后一个元素
    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge : edges) {
            if (isSame(edge[0], edge[1])) return edge;
            else join(edge[0], edge[1]);
        }
        return null;
    }
}
