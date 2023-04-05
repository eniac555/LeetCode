package com.myleetcode.a03hash;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * ------------------------------------------------------------
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Hash07 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums).size());
    }


    //多指针法，重点在于去重
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                //i表示三元组的第一个元素a，排序后第一个元素大于0，后面不可能加和为0
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //对a去重，注意是和前一个进行比较，和
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;//对c去重
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;//对b去重
                    }
                    left++;
                    right--;
                }

            }
        }
        return result;
    }
}
