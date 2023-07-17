package com.myleetcode.a14others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author eniac555
 * @date 2023/7/5
 * @description: 有多少小于当前数字的数字
 */
public class A01array {
    /*
    给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    以数组形式返回答案。
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            if (!map.containsKey(result[i])) {
                map.put(result[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}
