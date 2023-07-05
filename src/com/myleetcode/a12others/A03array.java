package com.myleetcode.a12others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eniac555
 * @date 2023/7/5
 * @description: 独一无二的出现次数
 */
public class A03array {

    /*
    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
    如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     */
    public boolean uniqueOccurrences(int[] arr) {
        int[] result = new int[2001];//最多有2001个数字
        for (int i = 0; i < arr.length; i++) {
            result[arr[i] + 1000]++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                if (map.containsKey(result[i])) {
                    return false;
                } else {
                    map.put(result[i], i);
                }
            }
        }
        return true;
    }
}
