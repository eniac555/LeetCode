package com.myleetcode.a09greed;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author eniac555
 * @date 2023/6/11
 * @description:
 */
public class Greed11 {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            // a - b 是升序排列，故在a[0] == b[0]的条件下，会按照k值升序排列
            return b[0] - a[0];
            //b - a 是降序排列，在a[0] != b[0]的条件下会按照h值降序排列
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1], p);
            //LinkedList.add(index, value)，会将value插入到指定index中
        }

        return que.toArray(new int[people.length][]);
    }
}
