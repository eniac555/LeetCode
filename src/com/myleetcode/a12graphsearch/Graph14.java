package com.myleetcode.a12graphsearch;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author eniac555
 * @date 2023/7/30
 * @description: 钥匙和房间 -- 广搜
 */
public class Graph14 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        visit[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        //广度优先搜索
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer k : rooms.get(cur)) {
                if (visit[cur]) continue;
                visit[k] = true;
                queue.offer(k);
            }
        }

        //判断并获取结果
        for (boolean b : visit) {
            if (!b) return false;
        }
        return true;
    }
}
