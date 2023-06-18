package com.myleetcode.a09greed;

import java.util.LinkedList;
import java.util.List;

/**
 * @author eniac555
 * @date 2023/6/17
 * @description:
 */
public class Greed14 {

    public List<Integer> partitionLabels(String S) {

        List<Integer> list = new LinkedList<>();//存结果，存的是每个区间元素个数

        int[] edge = new int[26];//存储每个字母最后出现的位置
        char[] chars = S.toCharArray();

        //找到每个字母最后出现的位置
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }

        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);//找到该字母最后出现的位置索引最大值
            if (i == idx) {//碰到该最大索引，就找到一个目标
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
