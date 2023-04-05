package com.myleetcode.a03hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入  只会对应一个  答案。但是，数组中同一个元素不能使用两遍。
 */
public class Hash04 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

    }


    //方法1：暴力解法
    //忽略了只有一组答案
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[10000];
        int[] newData;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target && query(result, i) && (i != j)) {
                    result[count] = i;
                    result[count + 1] = j;
                    count = count + 2;
                }
            }
        }
        newData = Arrays.copyOfRange(result, 0, count);
        return newData;
    }

    public static boolean query(int[] nums, int index) {
        for (int num : nums) {
            if (num == index) {
                return false;
            }
        }
        return true;
    }


    //方法2：Map
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //方法3：map
    public static int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }


    //方法4：暴力
    public int[] twoSum4(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
