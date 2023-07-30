package com.myleetcode.a12graphsearch;

import java.util.List;

/**
 * @author eniac555
 * @date 2023/7/30
 * @description: 钥匙和房间 -- 深搜
 */
public class Graph15 {

    /*
    要求：从零号房间开始，能不能走到最后一个房间
     */

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //标记是否访问到
        boolean[] visit = new boolean[rooms.size()];
        //执行深度搜索
        dfs(rooms, 0, visit);
        //检查并获取结果
        for (boolean b : visit) {
            if (!b) return false;
        }
        return true;
    }

    //处理当前访问的节点，当前访问的节点如果是 true ，说明是访问过的节点，那就终止本层递归，
    //如果不是true，我们就把它赋值为true，因为这是我们处理本层递归的节点。
    private void dfs(List<List<Integer>> rooms, int i, boolean[] visit) {
        //开始默认都是false
        if (visit[i]) return;

        visit[i] = true;
        for (Integer k : rooms.get(i)) {
            dfs(rooms, k, visit);
        }
    }



}
